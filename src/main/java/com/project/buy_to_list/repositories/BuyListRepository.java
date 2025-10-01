package com.project.buy_to_list.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.buy_to_list.domain.buylist.BuyList;

public interface BuyListRepository extends JpaRepository<BuyList, UUID> {
	
	@Query("SELECT b FROM BuyList AS b WHERE user.id = :userId")
	public List<BuyList> findBuyListsByUser(@Param("userId") UUID userId);
	
	@Query("SELECT b FROM BuyList AS b WHERE user.id = :userId")
	public Page<BuyList> findBuyListsByUser(@Param("userId") UUID userId, Pageable pageable);

}
