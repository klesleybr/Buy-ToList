package com.project.buy_to_list.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.buy_to_list.domain.buylist.BuyList;
import com.project.buy_to_list.domain.buylist.BuyListRequestDTO;
import com.project.buy_to_list.domain.buylist.BuyListResponseDTO;
import com.project.buy_to_list.service.BuyListService;

@RestController
@RequestMapping("/buy-tolist/api/buy-list")
public class BuyListController {
	
	@Autowired
	BuyListService buyListService;
	
	@PostMapping("/create-buy-list")
	public ResponseEntity<BuyList> createBuyList(
				@RequestParam String title,
				@RequestParam(required = false) String description,				
				@RequestParam(value = "user_id") UUID userId
			) {
		
		BuyListRequestDTO buyListRequest = new BuyListRequestDTO(title, description, new BigDecimal("0.00"), false);
		BuyList buyList = buyListService.createBuyList(userId, buyListRequest);
		return ResponseEntity.ok(buyList);
		
	}
	
	@GetMapping("/all-buy-lists")
	public ResponseEntity<List<BuyListResponseDTO>> getAllBuyLists(@RequestParam(value = "user_id") UUID userId) {
		
		List<BuyListResponseDTO> buyLists = this.buyListService.getAllBuyLists(userId);
		return ResponseEntity.ok(buyLists);
		
	}
	
	@GetMapping("/all-buy-lists-pgs")
	public ResponseEntity<List<BuyListResponseDTO>> getAllBuyListPages(
				@RequestParam(value = "user_id") UUID userId,
				@RequestParam int page,
				@RequestParam int size
			) {
		
		List<BuyListResponseDTO> buyLists = this.buyListService.getBuyListPages(userId, page, size);
		return ResponseEntity.ok(buyLists);
		
	}
	
	@PatchMapping("/edit-buy-list")
	public ResponseEntity<BuyList> editBuyList(
				@RequestParam UUID id,
				@RequestParam(required = false) String title,
				@RequestParam(required = false) String description,
				@RequestParam(value = "total_value", required = false) String totalValue,
				@RequestParam(value = "is_finalized", required = false) Boolean isFinalized
			) {
		
		BuyList buyList = new BuyList();
		
		if(totalValue == null) {
			BuyListRequestDTO buyListRequest = new BuyListRequestDTO(title, description, null, isFinalized);
			buyList = this.buyListService.editBuyList(id, buyListRequest);
		} else {
			BuyListRequestDTO buyListRequest = new BuyListRequestDTO(title, description, new BigDecimal(totalValue), isFinalized);
			buyList = this.buyListService.editBuyList(id, buyListRequest);
		}		
				
		return ResponseEntity.ok(buyList);
		
	}
	
	@DeleteMapping("/delete-buy-list")
	public ResponseEntity<BuyList> deleteBuyList(@RequestParam UUID id) {
		
		BuyList buyList = this.buyListService.deleteBuyList(id);
		return ResponseEntity.ok(buyList);
		
	}

}
