package br.com.azship.clgazsfleet.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "motorista")
@SequenceGenerator(name = "motorista_id_gen", sequenceName = "motorista_id_seq", initialValue = 1, allocationSize = 1)
public class Motorista {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "motorista_id_gen")
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cpf")
	private String cpf;
	@Column(name = "data_nascimento", columnDefinition = "DATE")
	private LocalDate dataNascimento;
	@Column(name = "sexo")
	private Sexo sexo;
	@Column(name = "categoria_cnh")
	private CategoriaCnh categoriaCnh;
	@Column(name = "numero_cnh")
	private String numeroCnh;
	@Column(name = "expedicao_cnh", columnDefinition = "DATE")
	private LocalDate expedicaoCnh;
	@Column(name = "validade_cnh", columnDefinition = "DATE")
	private LocalDate validadeCnh;

	public Motorista() {
		super();
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Motorista [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", dataNascimento=");
		builder.append(dataNascimento);
		builder.append(", sexo=");
		builder.append(sexo);
		builder.append(", categoriaCnh=");
		builder.append(categoriaCnh);
		builder.append(", numeroCnh=");
		builder.append(numeroCnh);
		builder.append(", expedicaoCnh=");
		builder.append(expedicaoCnh);
		builder.append(", validadeCnh=");
		builder.append(validadeCnh);
		builder.append("]");
		return builder.toString();
	}

}
