package tbmiguel.com.github.domain.interfaces;

import java.util.Date;
import java.util.List;

import tbmiguel.com.github.domain.Cliente;
import tbmiguel.com.github.domain.Emissor;
import tbmiguel.com.github.domain.Produto;
import tbmiguel.com.github.types.Chave;
import tbmiguel.com.github.types.Numero;

public interface INotaFiscalBuilder {

	public void setDataEmissao(Date dataEmissao);
	public void setNumero(Numero numero);
	public void setChave(Chave chave);
	public void setEmissor(Emissor emissor);
	public void setCliente(Cliente cliente);
	public void setListaProdutos(List<Produto> listaProdutos);
	
}
