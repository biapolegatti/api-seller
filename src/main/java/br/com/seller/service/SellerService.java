package br.com.seller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.seller.exception.ResourceNotFoundException;
import br.com.seller.model.entity.Seller;
import br.com.seller.repository.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repository;

	public Page<Seller> find(Pageable pageable) {

		return repository.findAll(pageable);
	}

	public Seller findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Seller not found"));
	}

//	private static String cepUrl = "viacep.com.br/ws/01001000/json/";

	public Seller save(Seller seller) {
		return repository.save(seller);
	}

	public ResponseEntity<Seller> uptade(Seller seller) {
		if (!repository.existsById(seller.getId())) {
			return ResponseEntity.notFound().build();
		}

		seller = repository.save(seller);
		return ResponseEntity.ok(seller);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}