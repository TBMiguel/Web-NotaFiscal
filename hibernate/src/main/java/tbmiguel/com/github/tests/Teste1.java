package tbmiguel.com.github.tests;

import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;

import tbmiguel.com.github.domain.Cliente;
import tbmiguel.com.github.domain.Emissor;
import tbmiguel.com.github.domain.NotaFiscal;
import tbmiguel.com.github.domain.Produto;

public class Teste1 {

	public static void main(String[] args) {
		
		Emissor emissor = new Emissor("Empresa Teste", "10.222.222/0001-10");
		Cliente cliente = new Cliente("Cliente Teste", "123.456.789-00");
		
		Produto produto1 = new Produto("C123", "Produto Teste 1", "Descrição Produto Teste 1", 1, new BigDecimal(33.33));
		
		ArrayList<Produto> listaProdutos = new ArrayList<>();
		
		listaProdutos.add(produto1);
		
		NotaFiscal nf = new NotaFiscal(new Date(), "12345", "chave", emissor, cliente, listaProdutos);
		
		System.out.println(nf);
	}

}
