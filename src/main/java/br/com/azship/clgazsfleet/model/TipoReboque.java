package br.com.azship.clgazsfleet.model;

public enum TipoReboque {

	BAU(0), SIDER(1), GRADE_BAIXA(2), BAU_FRIGORIFICO(3), TANQUE(4);

	private int code;

	private TipoReboque(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}

	public static TipoReboque getInstance(int code) {
		switch (code) {
		case 0:
			return BAU;
		case 1:
			return SIDER;
		case 2:
			return GRADE_BAIXA;
		case 3:
			return BAU_FRIGORIFICO;
		case 4:
			return TANQUE;
		default:
			return null;
		}
	}

}
