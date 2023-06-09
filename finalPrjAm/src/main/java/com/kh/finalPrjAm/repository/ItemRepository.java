package com.kh.finalPrjAm.repository;

import com.kh.finalPrjAm.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


// JPARepository는 첫 번째에는 Entity 타입 클래스를 넣어주고, 두 번쨰 기본 키
// 기본적인 CRUD 및 페이징 처리를 위한 메소드는 정의 되어있음
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByItemNm(String itemNm);

    // or 조건 처리하기
    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

    List<Item> findByPriceLessThan(Integer price);

    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

    List<Item> findByPriceBetween(Integer min, Integer max);

    List<Item> findByItemNmContaining(String keyword);
    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail")String itemDetail);

}
