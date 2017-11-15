package br.com.inteligencia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.inteligencia.model.Cliente;
import br.com.inteligencia.model.Compras;
import br.com.inteligencia.model.Produto;

@Service
public class CadastrarCompras {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private CadastroUsuario cadastroUsuario;
	
	@Autowired
	private CadastroProdutos cadastroProduto;
	
	Random randon = new Random(1);
	
	@Transactional
	public void cadastro(){
		
		List<Cliente> cliente = entityManager.createQuery("select c from Cliente c", Cliente.class).getResultList();
		
		if(cliente == null || cliente.size() == 0){
			cadastroUsuario.cadastroUsuario();
			 cliente = entityManager.createQuery("select c from Cliente c", Cliente.class).getResultList();
		}
		
		List<Produto> produto = entityManager.createQuery("select p from Produto p",Produto.class).getResultList();
		
		if(produto == null || produto.size() == 0){
			cadastroProduto.cadastroProdutos();		
			produto = entityManager.createQuery("select p from Produto p",Produto.class).getResultList();
		}
		
		for(int i = 0; i < cliente.size(); i++){
			List<Produto> produtoSelecionado = selecionarProdutos(produto);
			
			Compras compra = new Compras();
			
			compra.setIdCliente(cliente.get(i));
			compra.setIdProduto(produtoSelecionado);
			
			entityManager.persist(compra);
		}
		
	}


	private List<Produto> selecionarProdutos(List<Produto> produto) {
		
		
		
		int total =  randon.nextInt(produto.size());
		List<Produto> produtoAleatorio = new ArrayList<>();
		for(int i =0; i < total; i++){
			produtoAleatorio.add(produto.get(randon.nextInt(produto.size())));
		}
		
		
		return produtoAleatorio;
	}
	
	
	
	
	
}
