package br.com.azship.clgazsfleet.model;

public enum CategoriaCnh {

	C(0), D(1), E(2);

	private int code;

	private CategoriaCnh(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}

	public static CategoriaCnh getInstance(int code) {
		switch (code) {
		case 0:
			return C;
		case 1:
			return D;
		case 2:
			return E;
		default:
			return null;
		}
	}

}
