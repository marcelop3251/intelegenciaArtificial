package br.com.inteligencia.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.inteligencia.model.Compras;
import br.com.inteligencia.model.Produto;
import weka.associations.Apriori;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

@Service
public class ImportacaoService {

	@PersistenceContext
	private EntityManager entityManager;
	
	private Instances instances ;

	public List<String> processarDados() throws Exception, Exception{
		 
		
	
		Apriori ap = new Apriori();
		ap.setNumRules(20);
		ap.buildAssociations(instances);
		System.out.println(ap.toString());
		
		String retiraCaracteres = ap.toString().replaceAll("<", " ").replaceAll(">", " ");
		String[] strings = retiraCaracteres.split("\n");
		List<String> lista = extracted(strings);
		return lista ;
		
	}


	private List<String> extracted(String[] strings) {
		List<String> lista = new ArrayList<>();
		for(int i =0; i < strings.length ; i++){
			lista.add(strings[i]);
		}
		return lista;
	}
	
	

	public List<String> criarArquivoImportacaoAtributos() throws Exception {
		// obtendo os atributos

		List<Produto> listProdutos = entityManager.createQuery("select p from Produto p", Produto.class)
				.getResultList();

		int quantidadeDeProduto = listProdutos.size();
		FastVector fvWekaAttributes = new FastVector(quantidadeDeProduto);
		for (Produto p : listProdutos) {			
			FastVector atributoNominal  = new  FastVector(2);
			
			atributoNominal.addElement("sim");
			atributoNominal.addElement("nao");
			Attribute atributo = new Attribute(p.getNome(),atributoNominal);
			fvWekaAttributes.addElement(atributo);
		}
		

		// obtendo as transa��es e seus atributos
		List<Compras> listCompras = entityManager.createQuery("select c from Compras c", Compras.class).getResultList();
		
		/*
		 * Esse construtor recebe o 
		 * relation,os atributos, e quantidade de instancias
		 */
		 instances = new Instances("mercado", fvWekaAttributes, listCompras.size());
		
		//para cada compra verifica quais os produtos foram comprados		
		for (Compras c : listCompras) {
			Instance instance = new DenseInstance(quantidadeDeProduto);
			int contador = 0;
			for (Produto p : listProdutos) {
				//inicialmente o produto recebe o valor n�o
				String valor ="nao";
				//obtem a lista de produtos da compra
				for (Produto cp : c.getIdProduto()) {
					//compara se o produto do banco existe na compra
					if (p.getId() == cp.getId()) {
						//se existir ent�o o produto foi comprado
						valor = "sim";
					}

				}
				
				instance.setValue((Attribute)fvWekaAttributes.elementAt(contador), valor);
				contador++;
			}
			instances.add(instance);
		}
		
		System.out.println(instances);
		
		
		return extracted(instances.toString().split("\n"));
		

	}

}
