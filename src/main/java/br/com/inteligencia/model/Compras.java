package br.com.inteligencia.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Compras {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Cliente idCliente;
	
	@ManyToMany(targetEntity = Produto.class,fetch = FetchType.EAGER)
	private List<Produto> idProduto;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	public List<Produto> getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(List<Produto> idProduto) {
		this.idProduto = idProduto;
	}

	
	
	
	
	
	
	

}
