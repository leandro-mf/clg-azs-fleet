package br.com.azship.clgazsfleet.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "veiculo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "categoria_veiculo", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
@SequenceGenerator(name = "veiculo_id_gen", sequenceName = "veiculo_id_seq", initialValue = 1, allocationSize = 1)
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veiculo_id_gen")
	@Column(name = "id")
	private Long id;
	@Column(name = "placa")
	private String placa;
	@Column(name = "cidade")
	private String cidade;
	@Column(name = "estado")
	private String estado;
	@Column(name = "renavam")
	private String renavam;
	@Column(name = "chassi")
	private String chassi;
	@Column(name = "fabricante")
	private String fabricante;
	@Column(name = "modelo")
	private String modelo;
	@Column(name = "ano_fabricacao", columnDefinition = "DATE")
	private LocalDate anoFabricacao;

	public Veiculo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public LocalDate getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(LocalDate anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Veiculo [id=");
		builder.append(id);
		builder.append(", placa=");
		builder.append(placa);
		builder.append(", cidade=");
		builder.append(cidade);
		builder.append(", estado=");
		builder.append(estado);
		builder.append(", renavam=");
		builder.append(renavam);
		builder.append(", chassi=");
		builder.append(chassi);
		builder.append(", fabricante=");
		builder.append(fabricante);
		builder.append(", modelo=");
		builder.append(modelo);
		builder.append(", anoFabricacao=");
		builder.append(anoFabricacao);
		builder.append("]");
		return builder.toString();
	}

}
