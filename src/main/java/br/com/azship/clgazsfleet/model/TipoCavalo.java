package br.com.azship.clgazsfleet.model;

public enum TipoCavalo {

	TRUCADO(0), SIMPLES(1);

	private int code;

	private TipoCavalo(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}

	public static TipoCavalo getInstance(int code) {
		switch (code) {
		case 0:
			return TRUCADO;
		case 1:
			return SIMPLES;
		default:
			return null;
		}
	}

}
