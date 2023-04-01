package com.devsuperior.dscommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.services.ProductService;

@RestController 
@RequestMapping(value = "/products")
public class ProductController {
	//CONTROLADOR REST, DEPENDE DO SERVICE QUE RETORNA UM DTO.
	
	@Autowired
	private ProductService service;
	
	@GetMapping(value = "/{id}")
	public ProductDTO findById(@PathVariable Long id) {
	
		ProductDTO dto = service.findById(id);
		
	return dto;
		
	}
	
	@GetMapping
	public Page<ProductDTO> findAll(Pageable pageable) {
	
		return service.findAll(pageable);
		
	}
	
	@PostMapping
	public ProductDTO insert(@RequestBody ProductDTO dto) {
	
		dto= service.insert(dto);
		return dto;
		
	}
	
	//configuração do Endpoint para responder na rota "products" pelo método GET via API

}
