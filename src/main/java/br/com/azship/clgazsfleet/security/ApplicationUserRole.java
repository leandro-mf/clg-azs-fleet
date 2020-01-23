package br.com.azship.clgazsfleet.security;

import static br.com.azship.clgazsfleet.security.ApplicationUserPermission.MOTORISTA_READ;
import static br.com.azship.clgazsfleet.security.ApplicationUserPermission.MOTORISTA_WRITE;
import static br.com.azship.clgazsfleet.security.ApplicationUserPermission.VEICULO_READ;
import static br.com.azship.clgazsfleet.security.ApplicationUserPermission.VEICULO_WRITE;
import static br.com.azship.clgazsfleet.security.ApplicationUserPermission.CAVALO_READ;
import static br.com.azship.clgazsfleet.security.ApplicationUserPermission.CAVALO_WRITE;
import static br.com.azship.clgazsfleet.security.ApplicationUserPermission.REBOQUE_READ;
import static br.com.azship.clgazsfleet.security.ApplicationUserPermission.REBOQUE_WRITE;
import static br.com.azship.clgazsfleet.security.ApplicationUserPermission.VIAGEM_READ;
import static br.com.azship.clgazsfleet.security.ApplicationUserPermission.VIAGEM_WRITE;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;

public enum ApplicationUserRole {

	ADMIN(Sets.newHashSet(MOTORISTA_READ, MOTORISTA_WRITE, VEICULO_READ, VEICULO_WRITE, CAVALO_READ, CAVALO_WRITE,
			REBOQUE_READ, REBOQUE_WRITE, VIAGEM_READ, VIAGEM_WRITE)),
	USER(Sets.newHashSet(MOTORISTA_READ, VEICULO_READ, CAVALO_READ, REBOQUE_READ, VIAGEM_READ));

	private final Set<ApplicationUserPermission> permissions;

	private ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
		this.permissions = permissions;
	}

	public Set<ApplicationUserPermission> getPermissions() {
		return permissions;
	}

	public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
		Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
				.map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());
		permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
		return permissions;
	}

}
