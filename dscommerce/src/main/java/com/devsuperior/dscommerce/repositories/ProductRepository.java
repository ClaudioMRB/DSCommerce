package com.devsuperior.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dscommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	//CAMADA DE ACESSO A DADOS
	//criado componente do sistema que terá varias operações com o banco de dados de produto
	
	

}
