package br.com.seller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.seller.model.Seller;
import br.com.seller.service.SellerService;

@RestController
@RequestMapping("/sellers")
public class SellerController {

	@Autowired
	private SellerService service;

	@GetMapping
	public List<Seller> list() {
		return service.find();

	}

	@GetMapping("/{id}")
	public Seller listById(@PathVariable Long id)  {
		return service.findById(id);

	}

	@PostMapping
	public Seller create(@RequestBody Seller seller) {
		return service.save(seller);
	}

	@PutMapping("/{sellerId}")
	public ResponseEntity<Seller> edit(@RequestBody Seller seller, @PathVariable Long sellerId) {
		seller.setId(sellerId);
		return service.uptade(seller);

	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		service.deleteById(id);
	}

}
