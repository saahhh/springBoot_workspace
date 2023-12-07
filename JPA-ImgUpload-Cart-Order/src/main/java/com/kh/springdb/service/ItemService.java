package com.kh.springdb.service;

import com.kh.springdb.model.vo.Item;
import com.kh.springdb.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.util.List;
import java.util.UUID;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;
    // 상품 등록
    public void saveItem(Item item, MultipartFile imgFile) throws Exception {
    	if(imgFile != null) {
        String oriImgName = imgFile.getOriginalFilename();
        String imgName = "";

        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files/";

        UUID uuid = UUID.randomUUID(); //랜덤으로 숫자를 줘서 중복이 되는 이름이 없도록 해주는 것
        String savedFileName = uuid + oriImgName; // 파일명 -> imgName

        imgName = savedFileName;

        File saveFile = new File(projectPath, imgName);
        imgFile.transferTo(saveFile);
        item.setImgName(imgName);
        item.setImgPath("/files/" + imgName);
        itemRepository.save(item);
    	}
    }

    // 상품 개별 불러오기
    public Item itemView(Integer id) {
        return itemRepository.findById(id).get();
    }

    // 상품 리스트 불러오기
    public List<Item> allItemView() {
        return itemRepository.findAll();
    }

    // 상품 리스트 페이지용 불러오기
    public Page<Item> allItemViewPage(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }

    // 상품 수정
    @Transactional
    public void itemModify(Item item, Integer id, MultipartFile imgFile) throws Exception {

        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files/";
        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + imgFile.getOriginalFilename();
        File saveFile = new File(projectPath, fileName);
        imgFile.transferTo(saveFile);

        Item update = itemRepository.findItemById(id);
        update.setName(item.getName());
        update.setText(item.getText());
        update.setPrice(item.getPrice());
        update.setStock(item.getStock());
        update.setIsSoldout(item.getIsSoldout());
        update.setImgName(fileName);
        update.setImgPath("/files/"+fileName);
        itemRepository.save(update);
    }

    
    // 상품 검색
    public Page<Item> itemSearchList(String searchKeyword, Pageable pageable) {

        return itemRepository.findByNameContaining(searchKeyword, pageable);
    }

}

/*
public class ItemService {
	
	private ItemRepository itemRepository;
	
		
	//상품을 추가하고 삭제하고 수정하는 기능
	public void saveItem(Item item, MultipartFile imgFile) throws Exception {
		
		//상품을 등록할 때 상품명과 저장될 파일명의 경로 생성
		//이미지 파일 정보에 대해서 추출
		String oriImgName = imgFile.getOriginalFilename(); //업로드된 이미지 파일의 원본 파일명을 가져옴
		String imgName = "";
		//업로드된 이미지 파일의 원본 파일명을 가져옴
		
		String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files/"; //업로드된 이미지 파일 경로를 설정
		//System.getProperty("user.dir") :
		//System.getProperty() : 작업하고 있는 폴더 위치
		//"user.dir" : 현재 작업하고 있는 사용자 디렉토리 폴더를 나타냄
		//user.dir 은 C:/Users/user1/springBoot-workspace/JPA-ImgUpload-Cart-Order 위치와 동일하다
		
		//새로운 파일명을 생성해주기 위해 UUID
		//UUID uuid = UUID.randomUUID();
		
		
		String savedFileName = "_" + oriImgName; // 파일명 -> imgName
		//String saveFileName = "khShop_" + originPhotoName;
		//saveFileName으로 만약에 판매자가 사진1을 올리면 내 폴더 안에는 'khShop_사진1'로 저장이 된다.
		
		//빈 값에다가 한번 더 재정의로 넣어줌
		imgName = savedFileName;
		
		//import java.io.File;
		//파일을 저장하기 위해 우리가 작성해놓은 파일을 작성하기 위한 공간이 비어있는 File 객체를 가지고 옴
		//						파일을저장할경로, 파일명
		File saveFile = new File(projectPath, imgName);
        imgFile.transferTo(saveFile);
        item.setImgName(imgName);
        item.setImgPath("/files/" + imgName);
        itemRepository.save(item);
		
		//만약에 이름을 변경해서 저장하고 싶지 않다면
		// originPhotoName으로 저장해도 됨
		//판매자 컴퓨터에 있는 이미지 이름으로 그대로 업로드 됨
		//File saveFile = new File(photoPath, originphotoName);
			
		
		//업로드된 이미지 파일을 지정된 경로에 저장하기 위해 설정
		//transferTo : 서버에 특정 경로에 저장할 수 있도록 해주는 메서드
		/*
        photoFile.transferTo(saveFile);
		item.setPhotoName(photoName);
		item.setPhotoPath("/img/" + photoName);
				
		//DB에 저장할 수 있도록 save
		itemRepository.save(item);
		* /
	}
	
	//상품 읽기 find를 사용해서 개별 읽기
	public Item itemView(Integer id) {
		return itemRepository.findById(id).get(); //Optional을 사용하지 않고 get()을 사용
	}
	// findById를 사용해서 Id에 해당하는 값을 가져오고
	// get()을 이용해서 상품 Item의 객체를 반환한다
	
	
	//모든 상품 가지고오기 List
	public List<Item> allItemView() {
		return itemRepository.findAll();
	}
	
	// 상품 리스트 페이지용 불러오기
    public Page<Item> allItemViewPage(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }
    
 // 상품 수정
    @Transactional
    public void itemModify(Item item, Integer id, MultipartFile imgFile) throws Exception {

        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files/";
        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + imgFile.getOriginalFilename();
        File saveFile = new File(projectPath, fileName);
        imgFile.transferTo(saveFile);

        Item update = itemRepository.findItemById(id);
        update.setName(item.getName());
        update.setText(item.getText());
        update.setPrice(item.getPrice());
        update.setStock(item.getStock());
        update.setIsSoldout(item.getIsSoldout());
        update.setImgName(fileName);
        update.setImgPath("/files/"+fileName);
        itemRepository.save(update);
    }

    
    // 상품 삭제
   

    // 상품 검색
    public Page<Item> itemSearchList(String searchKeyword, Pageable pageable) {

        return itemRepository.findByNameContaining(searchKeyword, pageable);
	}
}
*/