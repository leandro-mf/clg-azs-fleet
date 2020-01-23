package br.com.azship.clgazsfleet.security;

import static br.com.azship.clgazsfleet.security.ApplicationUserPermission.MOTORISTA_WRITE;
import static br.com.azship.clgazsfleet.security.ApplicationUserPermission.VEICULO_WRITE;
import static br.com.azship.clgazsfleet.security.ApplicationUserPermission.CAVALO_WRITE;
import static br.com.azship.clgazsfleet.security.ApplicationUserPermission.REBOQUE_WRITE;
import static br.com.azship.clgazsfleet.security.ApplicationUserPermission.VIAGEM_WRITE;

import static br.com.azship.clgazsfleet.security.ApplicationUserRole.ADMIN;
import static br.com.azship.clgazsfleet.security.ApplicationUserRole.USER;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;

	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/").hasAnyRole(ADMIN.name(), USER.name())
		.antMatchers(HttpMethod.GET, "/api/**").hasAnyRole(ADMIN.name(), USER.name())
		.antMatchers(HttpMethod.POST, "/**/motoristas/**").hasAuthority(MOTORISTA_WRITE.getPermission())
		.antMatchers(HttpMethod.PUT, "/**/motoristas/**").hasAuthority(MOTORISTA_WRITE.getPermission())
		.antMatchers(HttpMethod.DELETE, "/**/motoristas/**").hasAuthority(MOTORISTA_WRITE.getPermission())
		.antMatchers(HttpMethod.POST, "/**/veiculos/**").hasAuthority(VEICULO_WRITE.getPermission())
		.antMatchers(HttpMethod.PUT, "/**/veiculos/**").hasAuthority(VEICULO_WRITE.getPermission())
		.antMatchers(HttpMethod.DELETE, "/**/veiculos/**").hasAuthority(VEICULO_WRITE.getPermission())
		.antMatchers(HttpMethod.POST, "/**/cavalos/**").hasAuthority(CAVALO_WRITE.getPermission())
		.antMatchers(HttpMethod.PUT, "/**/cavalos/**").hasAuthority(CAVALO_WRITE.getPermission())
		.antMatchers(HttpMethod.DELETE, "/**/cavalos/**").hasAuthority(CAVALO_WRITE.getPermission())
		.antMatchers(HttpMethod.POST, "/**/reboques/**").hasAuthority(REBOQUE_WRITE.getPermission())
		.antMatchers(HttpMethod.PUT, "/**/reboques/**").hasAuthority(REBOQUE_WRITE.getPermission())
		.antMatchers(HttpMethod.DELETE, "/**/reboques/**").hasAuthority(REBOQUE_WRITE.getPermission())
		.antMatchers(HttpMethod.POST, "/**/viagens/**").hasAuthority(VIAGEM_WRITE.getPermission())
		.antMatchers(HttpMethod.PUT, "/**/viagens/**").hasAuthority(VIAGEM_WRITE.getPermission())
		.antMatchers(HttpMethod.DELETE, "/**/viagens/**").hasAuthority(VIAGEM_WRITE.getPermission())
		.anyRequest().authenticated().and().httpBasic();
	}

	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails admin = User.builder()
				.username("admin").password(passwordEncoder.encode("admin123"))
				.roles(ADMIN.name()).authorities(ADMIN.getGrantedAuthorities())
				.build();
		UserDetails user = User.builder().username("user").password(passwordEncoder.encode("user123"))
				.roles(USER.name()).authorities(USER.getGrantedAuthorities())
				.build();
		return new InMemoryUserDetailsManager(admin, user);
	}

}
