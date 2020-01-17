package br.com.azship.clgazsfleet.model;

public enum TipoVeiculo {

	TRUCADO(0), SIMPLES(1), BAU(2), SIDER(3), GRADE_BAIXA(4), BAU_FRIGORIFICO(5), TANQUE(6);

	private int code;

	private TipoVeiculo(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}

	public static TipoVeiculo getInstance(int code) {
		switch (code) {
		case 0:
			return TRUCADO;
		case 1:
			return SIMPLES;
		case 2:
			return BAU;
		case 3:
			return SIDER;
		case 4:
			return GRADE_BAIXA;
		case 5:
			return BAU_FRIGORIFICO;
		case 6:
			return TANQUE;
		default:
			return null;
		}
	}

}
