package SYSTEM.RESTAURANTORDERS.Repository;

import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByWaiter(User waiter);
    Optional<Order> findByTableNumberAndStatusNot(Integer tableNumber, OrderStatus status);
}

