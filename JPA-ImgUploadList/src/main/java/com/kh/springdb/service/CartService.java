package com.kh.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.springdb.model.Cart;
import com.kh.springdb.model.CartItem;
import com.kh.springdb.model.Item;
import com.kh.springdb.repository.CartItemRepository;
import com.kh.springdb.repository.CartRepository;
import com.kh.springdb.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {
  @Autowired
  private CartItemRepository cartItemRepository;

  @Autowired
  private ItemRepository itemRepository;

  @Autowired
  private CartRepository cartRepository;

  public List<CartItem> findCartItemByCartId(int cartId) {
      return cartItemRepository.findCartItemByItemId(cartId);
  }

  public List<CartItem> findByItemId(int itemId) {
      return cartItemRepository.findByItemId(itemId);
  }

  public Cart getCartById(Long cartId) {
      return cartRepository.findById(cartId).orElse(null);
  }

	@Transactional
	public void addCart(Long cartId, Item newItem, int amount) {
	    // 현재 담긴 장바구니가 없을 때 장바구니 생성해주는 코드
	    Cart cart = cartRepository.findById(cartId).orElseGet(() -> {
	        Cart newCart = new Cart();
	        return cartRepository.save(newCart);
	    });

	    // 장바구니에 해당 아이템이 이미 담겨져 있는지 확인
	    CartItem cartItem = cartItemRepository.findByCartIdAndItemId(cartId, newItem.getId());

	    if (cartItem == null) {
	        // 장바구니에 해당 아이템이 없으면 새로운 CartItem 생성
	        cartItem = new CartItem();
	        cartItem.setCart(cart);
	        cartItem.setItem(newItem);
	        cartItem.setCount(amount);
	    } else {
	        // 장바구니에 해당 아이템이 이미 담겨져 있으면 수량 증가
	        cartItem.addCount(amount);
	    }

	    // 생성 또는 업데이트된 CartItem을 저장
	    cartItemRepository.save(cartItem);
	 
	}
	
}


/*
public class CartService {
	
	@Autowired
	private CartItemRepository cartItemRepository;
	private ItemRepository itemRepository;
	private CartRepository cartRepository;
	

	public List<CartItem> findCartItemByCartId(int cartId) {
		return cartItemRepository.findCartItemByItemId(cartId);		
	}
		
	//findByItemId
	public List<CartItem> findByItemBy(int itemId){
		return cartItemRepository.findByItemId(itemId);
	}
	
	@Transactional
	public void addCart(Long cartId, Item newItem, int amount) {
		
		//유저 정보 찾기
		
		//현재 담긴 장바구니가 없을 때 장바구니 생성해주는 코드
		Cart cart = cartRepository.findById(cartId).orElseGet(() -> {
			Cart newCart = new Cart();
			return cartRepository.save(newCart);
		});
		
		//Item item = itemRepository.findById(newItem).orElseThrow(() -> new Exception());
		CartItem cartItemNoId = cartItemRepository.findByCartIdAndItemId(cartId, amount);
		
		//카트아이템에서 Id값이 없을 때 추가해주는 CartItem이기때문에 
		if(cartItemNoId == null) {
		cartItemNoId = new CartItem();
		cartItemNoId.setCart(cart);
		cartItemNoId.setItem(newItem);
		}
		
		
		
		Item item = itemRepository.findItemById(newItem.getId());
		//item에 id를 가지고 내가 담고자하는 아이템의 정보를 가지고 옴
		
		CartItem cartItem = cartItemRepository.findCartItemById(amount);
		//장바구니에 어떤 아이템이 담겨져 있는가
				
		//만약에 장바구니에 상품이 존재하지 않는다면 카트에 상품을 생성한 다음 상품 추가
		
		//장바구니에 상품이 존재한다면 수량만 증가
		CartItem cartUpdate = cartItem;
		cartUpdate.setItem(item);
		cartUpdate.setCount(amount);
		cartUpdate.setCount(cartUpdate.getCount());
		cartItemRepository.save(cartUpdate);
		//return
		
		//카트에 상품 총 갯수 증가를 카트 안에도 넣어줄 예정
	}	
}
*/
