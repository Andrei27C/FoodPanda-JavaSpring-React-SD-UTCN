package ro.sd.firstapp.model.mapper;

import ro.sd.firstapp.model.Order;
import ro.sd.firstapp.model.dto.OrderDTO;

import java.util.stream.Collectors;

public class OrderMapper implements Mapper<Order, OrderDTO> {
    private static OrderMapper orderMapper = null;

    private OrderMapper() { }

    public static OrderMapper getInstance() {
        if (orderMapper == null) {
            orderMapper = new OrderMapper();
        }
        return orderMapper;
    }

    @Override
    public Order convertFromDTO(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO convertToDTO(Order order) {
        return OrderDTO.builder()
                .idOrder(order.getIdOrder())
                .status(order.getStatus())
                .customer(CustomerMapper.getInstance().convertToDTO(order.getCustomer()))
                .foods(order.getFoods().stream()
                        .map(FoodMapper.getInstance()::convertToDTO)
                        .collect(Collectors.toList()))
                .restaurant(RestaurantMapper.getInstance().convertToDTO(order.getRestaurant()))
                .total(order.getTotal())
                .build();
    }
}
