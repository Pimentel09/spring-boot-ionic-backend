package com.nelioalves.cursomc;

import java.util.Arrays;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.domain.Estado;
import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.repositories.CidadeRepository;
import com.nelioalves.cursomc.repositories.EstadoRepository;
import com.nelioalves.cursomc.repositories.ProdutoRepository;



@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}


	/*
	 * Acessar lista de contas: Utils.CONTA()
	 * 
	 * Criar 4 endpoints para:
	 * 	- Cadastrar produto (ProdutoController)
	 *  - Cadastrar cidade (CidadeController)
	 *  - Cadastrar estado (EstadoController)
	 *  - Cadastrar categoria (CategoriaController)
	 *  
	 */
		
	@Override
	public void run(String... args) throws Exception {
		
		
		Categoria cat1 = Categoria.builder()
				.nome("Informática")
				.build();
		
		Categoria cat2 = Categoria.builder()
				.nome("Escritório")
				.build();
		
		Produto p1 = Produto.builder()
				.nome("Computador")
				.preco(200.0)
				.categorias(Arrays.asList(cat1))
				.build();
		
		Produto p2 = Produto.builder()
				.nome("Mouse")
				.preco(20.0)
				.categorias(Arrays.asList(cat1,cat2))
				.build();
							
		Produto p3 = Produto.builder()
				.nome("Quadro")
				.preco(300.0)
				.categorias(Arrays.asList(cat1))
				.build();
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));	
		
		Estado est1 = Estado.builder()
				.nome("Minas Gerais")
				.build();
		
		Estado est2 = Estado.builder()
				.nome("São Paulo")
				.build();
		
		Cidade c1 = Cidade.builder()
				.nome("Uberlândia")
				.estado(est1)
				.build();
		
		Cidade c2 = Cidade.builder()
				.nome("São Paulo")
				.estado(est2)
				.build();
		
		Cidade c3 = Cidade.builder()
				.nome("Campinas")
				.estado(est2)
				.build();
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		
//		Categoria cat1 = new Categoria(1, "Informática");
//		Categoria cat2 = new Categoria(2, "Escritório");

//		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
//		cat2.getProdutos().addAll(Arrays.asList(p2));
		
//		p1.getCategorias().addAll(Arrays.asList(cat1));
//		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
//		p3.getCategorias().addAll(Arrays.asList(cat1));
				
		
		
		//Estado est1 = new Estado(null, "Minas Gerais");
		//Estado est2 = new Estado(null, "São Paulo");
		
		//Cidade cid1 = new Cidade(null, "Uberlândia", est1 );
//		Cidade cid2 = new Cidade(null, "São Paulo", est2);
//		Cidade cid3 = new Cidade(null, "Campinas", est2);
		
//		Estado est1 = Estado.builder()
//				.nome("Minas Gerais")
//				.build();
//		
//		Estado est2 = Estado.builder()
//				.nome("São Paulo")
//				.build();
//		
//		Cidade cid1 = Cidade.builder()
//				.nome("Uberlândia")
//				.estado(est1)
//				.build();
//		
//		Cidade cid2 = Cidade.builder()
//				.nome("São Paulo")
//				.estado(est2)
//				.build();
//		
//		Cidade cid3 = Cidade.builder()
//				.nome("Campinas")
//				.estado(est2)
//				.build();
		
		
//		est1.getCidades().addAll(Arrays.asList(cid1));
//		est2.getCidades().addAll(Arrays.asList(cid2,cid3));
//		
//		estadoRepository.saveAll(Arrays.asList(est1,est2));
//		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
		
		
	}

}

