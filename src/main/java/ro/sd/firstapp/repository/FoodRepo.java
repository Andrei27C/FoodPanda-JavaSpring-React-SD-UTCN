package ro.sd.firstapp.repository;

import org.springframework.stereotype.Repository;
import ro.sd.firstapp.model.Food;
import ro.sd.firstapp.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


@Repository
public interface FoodRepo extends JpaRepository<Food, Long>{
    Optional<Food> findByNameAndRestaurant(String name, Restaurant restaurant);

    List<Food> findByRestaurant(Restaurant restaurant);

    List<Food> findAll();
}
