package com.kh.springdb.service;

import java.util.List;

import com.kh.springdb.model.vo.Item;
import com.kh.springdb.repository.ItemRepository;

public class ItemService {
	
	private ItemRepository itemRepository;
	
	//상품을 추가하고 삭제하고 수정하는 기능
	public void addItem(Item item) {
		itemRepository.save(item);
	}
	
	//상품 읽기 fing를 사용해서 개별 읽기
	public Item getItemById(Integer id) {
		return itemRepository.findById(id).get();
	}
	
	//모든 상품 가지고오기 List
	public List<Item> allItemList() {
		return itemRepository.findAll();
	}
}
