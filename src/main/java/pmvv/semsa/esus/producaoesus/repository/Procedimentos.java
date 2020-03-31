package pmvv.semsa.esus.producaoesus.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import pmvv.semsa.esus.producaoesus.model.Estabelecimento;
import pmvv.semsa.esus.producaoesus.model.ProcedimentoAdministrativo;
import pmvv.semsa.esus.producaoesus.util.date.DateUtil;

public class Procedimentos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<ProcedimentoAdministrativo> procedimentosAdministrativos(Date dataInicio, Estabelecimento estabelecimento) {
		return manager.createQuery("select procedimentoAdministrativo from ProcedimentoAdministrativo procedimentoAdministrativo"
				+ " inner join procedimentoAdministrativo.atendimentoProfissional atendimentoProfissional"
				+ " inner join atendimentoProfissional.lotacao lotacao"
				+ " where atendimentoProfissional.dataFim is not null"
				+ " and (atendimentoProfissional.dataInicio between :dataInicio1 and :dataInicio2)"
				+ " and lotacao.estabelecimento = :estabelecimento"
			, ProcedimentoAdministrativo.class)
			.setParameter("dataInicio1", dataInicio)
			.setParameter("dataInicio2", DateUtil.maisUmDia(dataInicio))
			.setParameter("estabelecimento", estabelecimento)
			.getResultList();
	}
}