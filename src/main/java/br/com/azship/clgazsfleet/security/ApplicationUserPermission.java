package br.com.azship.clgazsfleet.security;

public enum ApplicationUserPermission {

	MOTORISTA_READ("motorista:read"),
	MOTORISTA_WRITE("motorista:write"),
	VEICULO_READ("veiculo:read"),
	VEICULO_WRITE("veiculo:write"),
	CAVALO_READ("cavalo:read"),
	CAVALO_WRITE("cavalo:write"),
	REBOQUE_READ("reboque:read"),
	REBOQUE_WRITE("reboque:write"),
	VIAGEM_READ("viagem:read"),
	VIAGEM_WRITE("viagem:write");
	
	private final String permission;
	
	private ApplicationUserPermission(String permission) {
		this.permission = permission;
	}
	
	public String getPermission() {
		return permission;
	}
	
}
