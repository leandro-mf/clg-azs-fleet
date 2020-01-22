package br.com.azship.clgazsfleet.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Cavalo extends Veiculo {

	@Column(name = "tipo_cavalo")
	private TipoCavalo tipoCavalo;

	public Cavalo() {
		super();
	}

	public TipoCavalo getTipoCavalo() {
		return tipoCavalo;
	}

	public void setTipoCavalo(TipoCavalo tipoCavalo) {
		this.tipoCavalo = tipoCavalo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cavalo [tipoCavalo=");
		builder.append(tipoCavalo);
		builder.append(", [");
		builder.append(super.toString());
		builder.append("]]");
		return builder.toString();
	}

}
