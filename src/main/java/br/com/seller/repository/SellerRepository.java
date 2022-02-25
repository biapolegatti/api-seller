package br.com.seller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.seller.model.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{
	
		

}
