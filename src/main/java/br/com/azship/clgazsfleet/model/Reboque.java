package br.com.azship.clgazsfleet.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Reboque extends Veiculo {

	@Column(name = "tipo_reboque")
	private TipoReboque tipoReboque;

	public Reboque() {
		super();
	}

	public TipoReboque getTipoReboque() {
		return tipoReboque;
	}

	public void setTipoReboque(TipoReboque tipoReboque) {
		this.tipoReboque = tipoReboque;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reboque [tipoReboque=");
		builder.append(tipoReboque);
		builder.append(", [");
		builder.append(super.toString());
		builder.append("]]");
		return builder.toString();
	}

}
