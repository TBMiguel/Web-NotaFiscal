package tbmiguel.com.github.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import tbmiguel.com.github.types.Chave;
import tbmiguel.com.github.types.Numero;

@Entity
@Table(name = "Notafiscal")
public class NotaFiscal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_numero")
	private Numero numero;
	
	@Column(name = "dataemissao")
	private Date dataEmissao;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_Chave")
	private Chave chave;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_emissor")
	private Emissor emissor;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_produtos")
	private List<Produto> produtos = new ArrayList<>();

	public NotaFiscal(Date dataEmissao, Numero numero, Chave chave, Emissor emissor, Cliente cliente,
			List<Produto> produtos) {
		this.numero = numero;
		this.dataEmissao = dataEmissao;
		this.chave = chave;
		this.emissor = emissor;
		this.cliente = cliente;
		this.produtos = produtos;
	}

	public Numero getNumero() {
		return numero;
	}

	public void setNumero(Numero numero) {
		this.numero = numero;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Chave getChave() {
		return chave;
	}

	public void setChave(Chave chave) {
		this.chave = chave;
	}

	public Emissor getEmissor() {
		return emissor;
	}

	public void setEmissor(Emissor emissor) {
		this.emissor = emissor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("N�mero: " + getNumero() + "\n");
		sb.append("Data de Emiss�o: " + getDataEmissao() + "\n");
		sb.append("Chave: " + getChave() + "\n");
		sb.append("Emissor Nome: " + getEmissor().getNome() + "\n");
		sb.append("Produtos: " + getProdutos().toString() + "\n");
		return sb.toString();
	}

}
