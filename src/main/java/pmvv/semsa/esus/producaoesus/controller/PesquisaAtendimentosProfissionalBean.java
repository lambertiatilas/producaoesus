package pmvv.semsa.esus.producaoesus.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pmvv.semsa.esus.producaoesus.model.AtendimentoProfissional;
import pmvv.semsa.esus.producaoesus.model.Estabelecimento;
import pmvv.semsa.esus.producaoesus.repository.AtendimentosProfissional;
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
	private AtendimentosProfissional atendimentosProfissional;
	private AtendimentoProfissionalFilter filtro;
	private List<AtendimentoProfissional> atendimentosProfissionalFiltrados;
	
	public List<AtendimentoProfissional> getAtendimentosProfissionalFiltrados() {
		return atendimentosProfissionalFiltrados;
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
		atendimentosProfissionalFiltrados = atendimentosProfissional.procedimentosAdministrativos();
	}
}