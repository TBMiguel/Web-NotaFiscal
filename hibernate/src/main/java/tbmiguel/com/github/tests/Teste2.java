package tbmiguel.com.github.tests;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tbmiguel.com.github.domain.Cliente;
import tbmiguel.com.github.domain.Emissor;
import tbmiguel.com.github.domain.NotaFiscal;
import tbmiguel.com.github.domain.NotaFiscalBuilder;
import tbmiguel.com.github.domain.Produto;
import tbmiguel.com.github.types.CNPJ;
import tbmiguel.com.github.types.Chave;
import tbmiguel.com.github.types.Name;
import tbmiguel.com.github.types.Numero;

public class Teste2 {

	public static void main(String[] args) throws Exception {
		Emissor emissor = new Emissor(new Name("Empresa Teste"), new CNPJ("10.222.222/0001-10"));
		Cliente cliente = new Cliente(new Name("Cliente Teste"), new CNPJ("123.456.789-00"));
		
		Produto produto1 = new Produto("C123", "Produto Teste 1", "Descrição Produto Teste 1", 1, new BigDecimal(33.33));
		Produto produto2 = new Produto("D321", "Produto Teste 2", "Descrição Produto Teste 2", 2, new BigDecimal(32.00));
		
		List<Produto> listaProdutos = new ArrayList<>();
		
		listaProdutos.add(produto1);
		listaProdutos.add(produto2);
		
		NotaFiscalBuilder nfBuilder = new NotaFiscalBuilder();
		
		nfBuilder.setDataEmissao(new Date());
		nfBuilder.setNumero(new Numero("123456789"));
		nfBuilder.setChave(new Chave("12345678101112131415161718192021222324252627"));		
		nfBuilder.setEmissor(emissor);
		nfBuilder.setCliente(cliente);
		nfBuilder.setListaProdutos(listaProdutos);
		NotaFiscal nf = nfBuilder.gera();
		
		System.out.println(nf);

	}

}
