package SYSTEM.RESTAURANTORDERS.Repository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    List<User> findAllByRole(UserRole role);

}
