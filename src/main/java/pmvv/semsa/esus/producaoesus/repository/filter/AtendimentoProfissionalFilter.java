package pmvv.semsa.esus.producaoesus.repository.filter;

import java.util.Date;

import pmvv.semsa.esus.producaoesus.model.Estabelecimento;

public class AtendimentoProfissionalFilter {

	private Date vigencia;
	private Estabelecimento estabelecimento;

	public Date getVigencia() {
		return vigencia;
	}

	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
}