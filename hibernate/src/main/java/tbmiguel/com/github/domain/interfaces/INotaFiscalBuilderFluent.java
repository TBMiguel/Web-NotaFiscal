package tbmiguel.com.github.domain.interfaces;

import java.util.Date;
import java.util.List;

import tbmiguel.com.github.domain.Cliente;
import tbmiguel.com.github.domain.Emissor;
import tbmiguel.com.github.domain.NotaFiscalBuilderFluent;
import tbmiguel.com.github.domain.Produto;
import tbmiguel.com.github.types.Chave;
import tbmiguel.com.github.types.Numero;

public interface INotaFiscalBuilderFluent {
	
	public NotaFiscalBuilderFluent setDataEmissao(Date dataEmissao);
	public NotaFiscalBuilderFluent setNumero(Numero numero);
	public NotaFiscalBuilderFluent setChave(Chave chave);
	public NotaFiscalBuilderFluent setEmissor(Emissor emissor);
	public NotaFiscalBuilderFluent setCliente(Cliente cliente);
	public NotaFiscalBuilderFluent setListaProdutos(List<Produto> listaProdutos);
	
}
