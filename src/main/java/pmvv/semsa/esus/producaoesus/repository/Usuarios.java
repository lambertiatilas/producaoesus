package pmvv.semsa.esus.producaoesus.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import pmvv.semsa.esus.producaoesus.model.Status;
import pmvv.semsa.esus.producaoesus.model.Usuario;

public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	public Usuario ativo(String cpf) {
		try {
			return manager.createQuery("from Usuario"
					+ " where cpf = :cpf"
					+ " and status = :status"
					+ " and grupo = :grupo"
				, Usuario.class)
				.setParameter("cpf", cpf)
				.setParameter("status", Status.ATIVO)
				.setParameter("grupo", new Long(1))
				.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}