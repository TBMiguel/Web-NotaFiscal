package tbmiguel.com.github.types;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Numero")
public class Numero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "numero")
	private String Numero;
	
	private final Integer TAMANHO_MAX_CHAVE = 9;

	public Numero(String numero) throws Exception {
		setNumero(numero);
	}
	
	public String getNumero() {
		return Numero;
	}

	public void setNumero(String numero) throws Exception {
		try {
			validaNumero(numero);
			this.Numero = numero;
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public Boolean validaNumero(String numero) throws Exception {  // Valida campo número
		if(numero.length() != TAMANHO_MAX_CHAVE) {
			throw new Exception("Erro: Campo número deve ter 9 caracteres!");
		} else {
			try {
		        Integer.parseInt(numero); //tenta coverter em número
		        return true;
		    } catch (Exception e) {
		    	throw new Exception("Erro: Campo número não deve conter letras!");
		    }
		}
	}
	
	@Override
	public String toString() {
		return getNumero();
	}
}
