package br.com.inteligencia.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import br.com.inteligencia.model.Cliente;

@Service
public class CadastroUsuario {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void cadastroUsuario(){		
		
		String nomes[] = new String[10];
		nomes[0] = "Marcelo";
		nomes[1] = "Esladiane";
		nomes[2] = "Stella";
		nomes[3] = "Rubens";
		nomes[4] = "Luiza";
		nomes[5] = "Cleiton";
		nomes[6] = "Monica";
		nomes[7] = "Lucas";
		nomes[8] = "Leonardo";
		nomes[9] = "Josivaldo";
		
		
		for(int i = 0; i< 10; i++){
			Cliente cliente = new Cliente();
			cliente.setNome(nomes[i]);
			entityManager.persist(cliente);
			
		}
		entityManager.flush();
		entityManager.clear();
	}
}
