package br.com.azship.clgazsfleet.model;

public enum Sexo {

	MASCULINO(0), FEMININO(1);

	private int code;

	private Sexo(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}

	public static Sexo getInstance(int code) {
		switch (code) {
		case 0:
			return MASCULINO;
		case 1:
			return FEMININO;
		default:
			return null;
		}
	}

}
