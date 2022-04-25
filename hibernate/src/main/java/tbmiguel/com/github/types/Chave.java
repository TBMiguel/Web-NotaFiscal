package tbmiguel.com.github.types;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Chave")
public class Chave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "chave")
	private String chave;
	
	private final Integer TAMANHO_MAX_CHAVE = 44;
	
	public Chave(String chave) throws Exception {
		setChave(chave);
	}

	public String getChave() {
		return this.chave;
	}

	public void setChave(String chave) throws Exception {
		try {
			validaChave(chave);
			this.chave = chave;
		} catch (IOException e){
			e.printStackTrace();
		}
	}	
	
	public Boolean validaChave(String chave) throws Exception {
		if(chave.length() != TAMANHO_MAX_CHAVE) {
			throw new Exception("Erro: Chave deve ter 44 caracteres!");
		}
		return true;	
	}
	
	@Override
	public String toString() {
		return getChave();
	}
}
