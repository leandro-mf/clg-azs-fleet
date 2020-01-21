package br.com.azship.clgazsfleet.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "viagem")
@SequenceGenerator(name = "viagem_id_gen", sequenceName = "viagem_id_seq", initialValue = 1, allocationSize = 1)
public class Viagem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "viagem_id_gen")
	@Column(name = "id")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "veiculo_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Veiculo veiculo;
	@ManyToOne
	@JoinColumn(name = "motorista_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Motorista motorista;
	@Column(name = "data_inicio", columnDefinition = "DATE")
	private LocalDate dataInicio;
	@Column(name = "data_fim", columnDefinition = "DATE")
	private LocalDate dataFim;
	@Column(name = "produto_transportado")
	private String produtoTransportado;
	@Column(name = "valor_frete")
	private Double valorFrete;
	@Column(name = "status_viagem")
	private StatusViagem statusViagem;

	public Viagem() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public String getProdutoTransportado() {
		return produtoTransportado;
	}

	public void setProdutoTransportado(String produtoTransportado) {
		this.produtoTransportado = produtoTransportado;
	}

	public Double getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}

	public StatusViagem getStatusViagem() {
		return statusViagem;
	}

	public void setStatusViagem(StatusViagem statusViagem) {
		this.statusViagem = statusViagem;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Viagem [id=");
		builder.append(id);
		builder.append(", veiculo=");
		builder.append(veiculo);
		builder.append(", motorista=");
		builder.append(motorista);
		builder.append(", dataInicio=");
		builder.append(dataInicio);
		builder.append(", dataFim=");
		builder.append(dataFim);
		builder.append(", produtoTransportado=");
		builder.append(produtoTransportado);
		builder.append(", valorFrete=");
		builder.append(valorFrete);
		builder.append("]");
		return builder.toString();
	}

}
