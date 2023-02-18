package SYSTEM.RESTAURANTORDERS.Repository;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findAllByOrder(Order order);
    Optional<OrderItem> findByOrderAndDish(Order order, Dish dish);

}
