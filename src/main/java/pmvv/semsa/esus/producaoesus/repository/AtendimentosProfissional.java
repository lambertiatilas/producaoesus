package pmvv.semsa.esus.producaoesus.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import pmvv.semsa.esus.producaoesus.model.AtendimentoProfissional;

public class AtendimentosProfissional implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<AtendimentoProfissional> procedimentosAdministrativos() {
		return manager.createQuery("from AtendimentoProfissional atendimentoProfissional"
			, AtendimentoProfissional.class)
			.getResultList();
	}
	
	/*public List<AtendimentoProfissional> procedimentosAdministrativos(Date dataInicio, Estabelecimento estabelecimento) {
		return manager.createQuery("select atendimentoProfissional from ProcedimentoAdministrativo procedimentoAdministrativo"
				+ " inner join procedimentoAdministrativo.atendimentoProfissional atendimentoProfissional"
				+ " inner join atendimentoProfissional.lotacao lotacao"
				+ " inner join lotacao.profissional profissional"
				+ " inner join lotacao.estabelecimento estabelecimento"
				+ " inner join lotacao.especialidade especialidade"
				+ " inner join atendimentoProfissional.atendimento atendimento"
				+ " inner join atendimento.prontuario prontuario"
				+ " inner join prontuario.paciente paciente"
				+ " inner join paciente.localidade localidade"
				+ " inner join paciente.sexo sexo"
				+ " inner procedimentoAdministrativo.procedimento procedimento"
				+ " inner paciente.raca raca"
				+ " where atendimentoProfissional.dataFim is not null"
				+ " and atendimentoProfissional.dataInicio = :dataInicio"
				+ " and lotacao.estabelecimento = :estabelecimento"
			, AtendimentoProfissional.class)
			.setParameter("dataInicio", dataInicio)
			.setParameter("estabelecimento", estabelecimento)
			.getResultList();
	}*/
}