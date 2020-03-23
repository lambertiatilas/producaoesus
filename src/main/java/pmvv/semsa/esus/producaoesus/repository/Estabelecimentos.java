package pmvv.semsa.esus.producaoesus.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import pmvv.semsa.esus.producaoesus.model.Estabelecimento;

public class Estabelecimentos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Estabelecimento porId(Long id) {
		return manager.find(Estabelecimento.class, id);
	}
	
	public List<Estabelecimento> estabelecimentos() {
		return manager.createQuery("from Estabelecimento order by nome", Estabelecimento.class).getResultList();
	}
}