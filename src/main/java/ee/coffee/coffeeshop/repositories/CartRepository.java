package ee.coffee.coffeeshop.repositories;

import ee.coffee.coffeeshop.entity.Cart;
import ee.coffee.coffeeshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository     // доступ к данным
public interface CartRepository extends JpaRepository<Cart, Integer> {

    // запрос из базы данных
    @Query(nativeQuery = true, value = "SELECT * FROM cart WHERE user_id = :user_id AND cart_products = :product_id")
    static Cart getByQuantityAndUser_idAndProduct_id(@Param(value = "user_id") Integer userId, @Param(value = "product_id") Integer products) {
        return null;
    }

    @Query(nativeQuery = true, value = "SELECT * FROM cart WHERE user_id = :user_id")
    List<Cart> getListByUserId(@Param(value = "user_id") Long userId);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM cart WHERE user_id = :user_id")
    void deleteByUserId(@Param(value = "user_id") User userId);
}


