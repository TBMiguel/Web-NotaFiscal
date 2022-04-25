package hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import tbmiguel.com.github.domain.Cliente;
import tbmiguel.com.github.domain.Emissor;
import tbmiguel.com.github.domain.NotaFiscalBuilderFluent;
import tbmiguel.com.github.domain.Produto;
import tbmiguel.com.github.types.CNPJ;
import tbmiguel.com.github.types.Chave;
import tbmiguel.com.github.types.Name;
import tbmiguel.com.github.types.Numero;
import hibernate.utils.JpaUtils;

public class App {

	public static void main(String[] args) {
		
		Emissor emissor = new Emissor(new Name("Empresa Teste"), new CNPJ("10.222.222/0001-10"));
		Cliente cliente = new Cliente(new Name("Cliente Teste"), new CNPJ("123.456.789-00"));		
		Produto produto1 = new Produto("C123", "Produto Teste 1", "Descrição Produto Teste 1", 1, new BigDecimal(33.33));		
		List<Produto> listaProdutos = new ArrayList<>();		
		listaProdutos.add(produto1);
				
		
		EntityManager em = JpaUtils.getEntityManager();
		
		em.getTransaction().begin(); // mode edição
		em.persist(emissor); // gravar o objeto
		em.persist(cliente); // gravar o objeto
		em.persist(produto1); // gravar o objeto
		em.getTransaction().commit();
				
		em.getTransaction().begin(); // mode edição
		try {
			em.persist(
					NotaFiscalBuilderFluent.builder()
					.setDataEmissao(new Date())
					.setNumero(new Numero("123456789"))
					.setChave(new Chave("12345678101112131415161718192021222324252627"))
					.setEmissor(emissor)
					.setCliente(cliente)
					.setListaProdutos(listaProdutos)
					.gera()
					);
		} catch (Exception e) {
			e.printStackTrace();
		} // gravar o objeto
		em.getTransaction().commit();
		
		
		
	}

}
