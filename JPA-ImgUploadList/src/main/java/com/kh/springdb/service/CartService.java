package com.kh.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.springdb.model.Cart;
import com.kh.springdb.model.CartItem;
import com.kh.springdb.model.Item;
import com.kh.springdb.model.Order;
import com.kh.springdb.repository.CartItemRepository;
import com.kh.springdb.repository.CartRepository;
import com.kh.springdb.repository.ItemRepository;
import com.kh.springdb.repository.OrderRepository;

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
  
  @Autowired
  private OrderRepository orderRepository;

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
	
	//결제하기
	@Transactional
	public void checkout(Long cartId) {
		//주문할 아이템 정보를 찾기 위해 cart Entity 정보를 가지고 옴
		Cart cart = cartRepository.findById(cartId).orElse(null);
		
		//Cart - 어떤 유저가 장바구니에 물건을 담았는지
		//(비회원으로 cart_id를 임의로 1로 주고 실행중인 것)
		//user와 cart를 연결해주는 역할을 함
		
		//CartItem - 장바구니에 어떤 아이템이 담겼는지 
		//Cart와 Item을 연결해놓은 역할을 함
		
		//카트가 null 값이 아닐 때
		if(cart != null) {
			//Order 객체를 가지고 온것임
			//builder() : Order에다가 cart를 더해준다
			//build() : build() = Order + cart의 결과를 가지고 있는 것
			Order order = Order.builder().cart(cart).build();
			
			//결제 이후 문제가 생길 것을 대비해서 DB안에도 주문한 사람과 주문 날짜와 같은 주문 내역을 저장할 예정
			orderRepository.save(order);
			
			//delete와 clear 두 가지 방법
			//clear는 결제 후 장바구니 비우기
			cart.getCartItems().clear();
			cartRepository.save(cart);
			
			
		}
		
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
