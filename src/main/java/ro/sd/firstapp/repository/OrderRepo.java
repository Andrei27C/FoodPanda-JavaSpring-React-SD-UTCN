package ro.sd.firstapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sd.firstapp.model.Customer;
import ro.sd.firstapp.model.Order;
import ro.sd.firstapp.model.OrderStatus;
import ro.sd.firstapp.model.Restaurant;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

    Optional<List<Order>> findAllByCustomer(Customer customer);

    Optional<List<Order>> findAllByRestaurant(Restaurant restaurant);

}
