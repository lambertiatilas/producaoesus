package pmvv.semsa.esus.producaoesus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_evolucao_odonto")
public class EvolucaoOdonto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private AtendimentoProfissional AtendimentoProfissional;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "co_seq_evolucao_odonto")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "co_atend_prof_odonto")
	public AtendimentoProfissional getAtendimentoProfissional() {
		return AtendimentoProfissional;
	}

	public void setAtendimentoProfissional(AtendimentoProfissional atendimentoProfissional) {
		AtendimentoProfissional = atendimentoProfissional;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EvolucaoOdonto other = (EvolucaoOdonto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}