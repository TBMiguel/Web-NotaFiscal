package tbmiguel.com.github.domain;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import tbmiguel.com.github.types.CNPJ;
import tbmiguel.com.github.types.Name;

@Entity
@Table(name = "emissores")
public class Emissor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_nome")
	private Name nome;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_CNPJ")
	private CNPJ cnpj;

	public Emissor(Name nome, CNPJ cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
	}

	public Name getNome() {
		return nome;
	}

	public void setNome(Name nome) {
		this.nome = nome;
	}

	public CNPJ getCnpj() {
		return cnpj;
	}

	public void setCnpj(CNPJ cnpj) {
		this.cnpj = cnpj;
	}

}
