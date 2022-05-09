package ro.sd.firstapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sd.firstapp.model.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Integer> {
}
