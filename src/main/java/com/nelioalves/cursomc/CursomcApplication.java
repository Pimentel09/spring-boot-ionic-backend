package com.nelioalves.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.domain.Endereco;
import com.nelioalves.cursomc.domain.Estado;
import com.nelioalves.cursomc.domain.Pagamento;
import com.nelioalves.cursomc.domain.PagamentoComBoleto;
import com.nelioalves.cursomc.domain.PagamentoComCartao;
import com.nelioalves.cursomc.domain.Pedido;
import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.domain.enums.EstadoPagamento;
import com.nelioalves.cursomc.domain.enums.TipoCliente;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.repositories.CidadeRepository;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.repositories.EnderecoRepository;
import com.nelioalves.cursomc.repositories.EstadoRepository;
import com.nelioalves.cursomc.repositories.PagamentoRepository;
import com.nelioalves.cursomc.repositories.PedidoRepository;
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
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired 
	private PagamentoRepository pagamentoRepository; 
	
	
	
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
		
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1,c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "250", "sala 303", "Centro", "04039777", cli1,c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:32"), cli1, e2);
		
		
		
		Pagamento pagto1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
				
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));  
		
		
		
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

