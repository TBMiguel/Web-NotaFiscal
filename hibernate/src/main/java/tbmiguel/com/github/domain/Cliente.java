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
@Table(name = "clientes")
public class Cliente {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_nome")
	private Name nome;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_CNPJ")
	private CNPJ CNPJ;

	public Cliente(Name nome, CNPJ CNPJ) {
		this.nome = nome;
		this.CNPJ = CNPJ;
	}

	public Name getNome() {
		return nome;
	}

	public void setNome(Name nome) {
		this.nome = nome;
	}

	public CNPJ getDocumento() {
		return CNPJ;
	}

	public void setDocumento(CNPJ CNPJ) {
		this.CNPJ = CNPJ;
	}
	
}
