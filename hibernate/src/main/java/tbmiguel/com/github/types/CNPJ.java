package tbmiguel.com.github.types;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CPNJ")
public class CNPJ {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "CNPJ")
	private String CNPJ;
	
	public CNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getCNPJ() {
		return CNPJ;
	}
	
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	
	
	@Override
	public String toString() {
		return getCNPJ();
	}
	
}
