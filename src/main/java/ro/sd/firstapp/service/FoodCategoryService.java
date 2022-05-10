package ro.sd.firstapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.firstapp.model.FoodCategory;
import ro.sd.firstapp.repository.FoodCategoryRepository;

import java.util.List;

/**
 * Service used to handle the FoodCategory model
 */
@Service
public class FoodCategoryService{

    @Autowired
    private FoodCategoryRepository foodCategoryRepository;

    /**
     * Retrieves all food categories.
     * @return A list containing all retrieved food categories.
     */
    public List<FoodCategory> findAll() {
        List<FoodCategory> foods = foodCategoryRepository.findAll();
        for (FoodCategory foodCat :
                foods) {
            System.out.println(foodCat);
        }
        return foods;
    }
}