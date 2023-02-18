package SYSTEM.RESTAURANTORDERS.Repository;

import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    List<Dish> findAllByType(DishType type);
    Optional<Dish> findByName(String name);

}
