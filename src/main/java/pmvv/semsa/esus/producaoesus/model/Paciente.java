package pmvv.semsa.esus.producaoesus.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cidadao")
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String cns;
	private String nome;
	private Date dataNascimento;
	private RacaCor racaCor;
	private Municipio municipio;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "co_seq_cidadao")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "nu_cns")
	public String getCns() {
		return cns;
	}

	public void setCns(String cns) {
		this.cns = cns;
	}

	@Column(name = "no_cidadao")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "dt_nascimento")
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@ManyToOne
	@JoinColumn(name = "co_raca_cor")
	public RacaCor getRacaCor() {
		return racaCor;
	}

	public void setRacaCor(RacaCor racaCor) {
		this.racaCor = racaCor;
	}

	@ManyToOne
	@JoinColumn(name = "co_localidade")
	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
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
		Paciente other = (Paciente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}