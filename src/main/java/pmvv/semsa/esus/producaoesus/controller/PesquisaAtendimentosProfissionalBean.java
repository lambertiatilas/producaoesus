package pmvv.semsa.esus.producaoesus.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pmvv.semsa.esus.producaoesus.model.Estabelecimento;
import pmvv.semsa.esus.producaoesus.model.ProcedimentoAdministrativo;
import pmvv.semsa.esus.producaoesus.repository.Procedimentos;
import pmvv.semsa.esus.producaoesus.repository.Estabelecimentos;
import pmvv.semsa.esus.producaoesus.repository.filter.AtendimentoProfissionalFilter;

@Named
@ViewScoped
public class PesquisaAtendimentosProfissionalBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Estabelecimentos estabelecimentos;
	private List<Estabelecimento> listaEstabelecimentos = new ArrayList<>();
	@Inject
	private Procedimentos procedimentos;
	private AtendimentoProfissionalFilter filtro;
	private List<ProcedimentoAdministrativo> procedimentosAdministrativosFiltrados;

	public List<ProcedimentoAdministrativo> getProcedimentosAdministrativosFiltrados() {
		return procedimentosAdministrativosFiltrados;
	}

	public AtendimentoProfissionalFilter getFiltro() {
		return filtro;
	}
	
	public List<Estabelecimento> getListaEstabelecimentos() {
		return listaEstabelecimentos;
	}
	
	public void inicializar() {
		filtro = new AtendimentoProfissionalFilter();
		listaEstabelecimentos = estabelecimentos.estabelecimentos();
	}
	
	public void pesquisar() {
		procedimentosAdministrativosFiltrados = procedimentos.procedimentosAdministrativos(filtro.getVigencia(), filtro.getEstabelecimento());
	}
}