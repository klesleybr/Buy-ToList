package com.project.buy_to_list.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.buy_to_list.domain.buylist.BuyList;
import com.project.buy_to_list.domain.buylist.BuyListRequestDTO;
import com.project.buy_to_list.domain.buylist.BuyListResponseDTO;
import com.project.buy_to_list.domain.user.User;
import com.project.buy_to_list.repositories.BuyListRepository;
import com.project.buy_to_list.repositories.UserRepository;

@Service
public class BuyListService {
	
	@Autowired
	BuyListRepository buyListRepository;
	@Autowired
	UserRepository userRepository;
	
	public BuyList createBuyList(UUID userId, BuyListRequestDTO buyListData) {
		
		User user = this.userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("ERRO - Usuário não encontrado."));
		
		BuyList buyList = new BuyList(new Date(), buyListData.title(), buyListData.description(), buyListData.totalValue(),
				buyListData.isFinalized(), user);
		this.buyListRepository.save(buyList);
		
		return buyList;
		
	}
	
	public List<BuyListResponseDTO> getAllBuyLists(UUID userId) {
		
		List<BuyList> response = this.buyListRepository.findBuyListsByUser(userId);
		List<BuyListResponseDTO> buyLists = new ArrayList<>();
		
		for(BuyList element : response) {
			buyLists.add(new BuyListResponseDTO(element.getId(), element.getCreatedAt(), element.getTitle(), element.getDescription(), element.getTotalValue(),
					element.getIsFinalized()));
		}
		
		return buyLists;
		
	}
	
	public List<BuyListResponseDTO> getBuyListPages(UUID userId, int page, int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		Page<BuyList> response = this.buyListRepository.findBuyListsByUser(userId, pageable);
		
		return response.map(element -> new BuyListResponseDTO(element.getId(), element.getCreatedAt(), element.getTitle(), element.getDescription(),
				element.getTotalValue(), element.getIsFinalized())).stream().toList();
		
	}
	
	public BuyList editBuyList(UUID id, BuyListRequestDTO buyListData) {
		
		BuyList buyList = buyListRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ERRO - Lista não encontrada."));
		
		if(buyListData.title() != null)
			buyList.setTitle(buyListData.title());
		
		if(buyListData.description() != null)
			buyList.setDescription(buyListData.description());
		
		if(buyListData.totalValue() != null)
			buyList.setTotalValue(buyListData.totalValue());
		
		if(buyListData.isFinalized() != null)
			buyList.setIsFinalized(buyListData.isFinalized());
		
		buyListRepository.save(buyList);
		return buyList;
		
	}
	
	public BuyList deleteBuyList(UUID id) {
		
		BuyList buyList = this.buyListRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ERRO - Lista não encontrada"));
		this.buyListRepository.deleteById(id);
		
		return buyList;
		
	}

}
