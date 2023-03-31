package com.devsuperior.dscommerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;

@Service 
public class ProductService { 
	//DEPENDE DO REPOSITORY
	//AQUI ONDE É IMPLEMENTADO AS BUSCAS NO BANCO DE DADOS
	//O SERVICE RETORNA UM DTO PARA OS CONTROLADORES
	
	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {
		
		/*Buscou no banco de dados, o produto que tem o id e retornou para a 
		variável result*/
		Optional<Product> result = repository.findById(id); 
		/*variável product recebe o result, pegou o produto */
		Product product = result.get();
		/*converter o product para DTO */
		ProductDTO dto = new ProductDTO(product);
		return dto;
	}
	
	
	
}
