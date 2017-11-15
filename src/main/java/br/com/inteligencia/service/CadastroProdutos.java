package br.com.inteligencia.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.inteligencia.model.Cliente;
import br.com.inteligencia.model.Produto;

@Service
public class CadastroProdutos {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public void cadastroProdutos(){
		
		
		String nomes[] = new String[10];
		nomes[0] = "Arroz";
		nomes[1] = "Feijao";
		nomes[2] = "Macarrao";
		nomes[3] = "Leite";
		nomes[4] = "Pao";
		nomes[5] = "Manteiga";
		nomes[6] = "Achocolatado";
		nomes[7] = "Milho";
		nomes[8] = "Ervilha";
		nomes[9] = "Palmito";
		
		
		for(int i = 0; i< 10; i++){
			Produto produto = new Produto();
			produto.setNome(nomes[i]);
			entityManager.persist(produto);
		}
		entityManager.flush();
		entityManager.clear();
		
		
		
		
		
		
	}
}
