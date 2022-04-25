package tbmiguel.com.github.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import tbmiguel.com.github.domain.interfaces.INotaFiscalBuilderFluent;
import tbmiguel.com.github.types.Chave;
import tbmiguel.com.github.types.Numero;

public class NotaFiscalBuilderFluent implements INotaFiscalBuilderFluent{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "dataemissao")
	private Date dataEmissao;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_numero")
	private Numero numero;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_chave")
	private Chave chave;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_emissor")
	private Emissor emissor;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_produtos")
	private List<Produto> listaProdutos;

	@Override
	public NotaFiscalBuilderFluent setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;		
		return this;
	}

	@Override
	public NotaFiscalBuilderFluent setNumero(Numero numero) {
		this.numero = numero;
		return this;
		
	}

	@Override
	public NotaFiscalBuilderFluent setChave(Chave chave) {
		this.chave = chave;
		return this;
	}

	@Override
	public NotaFiscalBuilderFluent setEmissor(Emissor emissor) {
		this.emissor = emissor;
		return this;
	}

	@Override
	public NotaFiscalBuilderFluent setCliente(Cliente cliente) {
		this.cliente = cliente;	
		return this;
	}

	@Override
	public NotaFiscalBuilderFluent setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
		return this;
	}
	
	public NotaFiscal gera() {
		return new NotaFiscal(this.dataEmissao, this.numero, this.chave, this.emissor, this.cliente, this.listaProdutos);
	}
	
	public static NotaFiscalBuilderFluent builder() {
		return new NotaFiscalBuilderFluent();
	}
}
