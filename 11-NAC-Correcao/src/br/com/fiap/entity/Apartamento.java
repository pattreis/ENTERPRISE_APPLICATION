package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="NAC_APARTAMENTO")
@SequenceGenerator(name="apartamento", sequenceName="SQ_NAC_APARTAMENTO", allocationSize = 1)
public class Apartamento {

	@Id
	@Column(name="CD_APARTAMENTO")
	private int codio;
	
	@Column(name="DS_ENDERECO", nullable = false, length = 100)
	private String endereco;
	
	@Column(name="DS_DETALHES", length = 100)
	private String detalhes;	
	
	@Lob
	private byte[] foto;
	
	@OneToMany(mappedBy="apartamento")
	private List<Locacao> locacoes;
	
	public Apartamento(String endereco, String detalhes, byte[] foto) {
		super();
		this.endereco = endereco;
		this.detalhes = detalhes;
		this.foto = foto;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	
}
