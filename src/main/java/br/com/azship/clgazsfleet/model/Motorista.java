package br.com.azship.clgazsfleet.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Motorista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private Sexo sexo;
	private CategoriaCnh categoriaCnh;
	private String numeroCnh;
	private LocalDate expedicaoCnh;
	private LocalDate validadeCnh;

	public Motorista() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public CategoriaCnh getCategoriaCnh() {
		return categoriaCnh;
	}

	public void setCategoriaCnh(CategoriaCnh categoriaCnh) {
		this.categoriaCnh = categoriaCnh;
	}

	public String getNumeroCnh() {
		return numeroCnh;
	}

	public void setNumeroCnh(String numeroCnh) {
		this.numeroCnh = numeroCnh;
	}

	public LocalDate getExpedicaoCnh() {
		return expedicaoCnh;
	}

	public void setExpedicaoCnh(LocalDate expedicaoCnh) {
		this.expedicaoCnh = expedicaoCnh;
	}

	public LocalDate getValidadeCnh() {
		return validadeCnh;
	}

	public void setValidadeCnh(LocalDate validadeCnh) {
		this.validadeCnh = validadeCnh;
	}

}
