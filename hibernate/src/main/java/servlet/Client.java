package servlet;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.utils.JpaUtils;
import tbmiguel.com.github.domain.Cliente;
import tbmiguel.com.github.domain.Emissor;
import tbmiguel.com.github.domain.NotaFiscalBuilderFluent;
import tbmiguel.com.github.domain.Produto;
import tbmiguel.com.github.types.CNPJ;
import tbmiguel.com.github.types.Chave;
import tbmiguel.com.github.types.Name;
import tbmiguel.com.github.types.Numero;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/cliente"}
)

public class Client extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        
        out.println("<html>");
        out.println("<form action='http://localhost:8080/cliente' method='POST'>");
        out.println(String.format("<h1>Cadastro de Cliente</h1>"));
        out.println("Nome: <input type='text' name='nome'>");
        out.println("CNPJ: <input type='text' name='CNPJ'>");
        out.println(String.format("<h1>Cadastro de Emissor</h1>"));
        out.println("Nome: <input type='text' name='nomeEmissor'>");
        out.println("CNPJ: <input type='text' name='CNPJEmissor'>");
        out.println("<input type='submit' value='Enviar'>");
        out.println("</form>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String CNPJ = req.getParameter("CNPJ");
        String nomeEmissor = req.getParameter("nomeEmissor");
        String CNPJEmissor = req.getParameter("CNPJEmissor");
        
        PrintWriter out = resp.getWriter();
        out.println(String.format("<h1>Cliente: %s </h1>", nome));
        out.println(String.format("<h1>CNPJ: %s </h1>", CNPJ));
        out.println(String.format("<h1>Emissor: %s </h1>", nomeEmissor));
        out.println(String.format("<h1>CNPJ: %s </h1>", CNPJEmissor));
    }
}
