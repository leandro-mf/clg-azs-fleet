package br.com.azship.clgazsfleet.model;

public enum StatusViagem {

	CRIADA(0), INICIADA(1), FINALIZADA(2);

	private int code;

	private StatusViagem(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}

	public static StatusViagem getInstance(int code) {
		switch (code) {
		case 0:
			return CRIADA;
		case 1:
			return INICIADA;
		case 2:
			return FINALIZADA;
		default:
			return null;
		}
	}

}
