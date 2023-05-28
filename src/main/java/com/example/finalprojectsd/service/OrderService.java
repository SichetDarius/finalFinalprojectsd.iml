package com.example.finalprojectsd.service;

import com.example.finalprojectsd.model.Order;
import com.example.finalprojectsd.model.Product;
import com.example.finalprojectsd.model.ProductOrder;
import com.example.finalprojectsd.model.User;
import com.example.finalprojectsd.model.iterator.Iterator;
import com.example.finalprojectsd.model.iterator.ProductOrder.ProductOrderContainer;
import com.example.finalprojectsd.repository.OrderRepository;
import com.example.finalprojectsd.repository.ProductOrderRepository;
import com.example.finalprojectsd.repository.ProductRepository;
import com.example.finalprojectsd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductOrderRepository productOrderRepository;

    public List<Order> getAllOrders(){
        List<Order> orders= new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return orders;
    }

    public Order getOrderById(long id) {
        Optional<Order> optional = orderRepository.findById(id);
        Order order = null;
        if (optional.isPresent()) {
            order = optional.get();
        } else {
            throw new RuntimeException("Order is not found by id");
        }
        return order;
    }

    public void saveOrder(Order order){
        //Optional<Product> product = product.findById(order.getId_order());
        //
        //if(show.get().getCantitate() < order.getQuantity()) {
        //    throw new RuntimeException("Quantity not enough");
        //}
        //product.get().setCantitate(product.get().getCantitate() - order.getQuantity());
        orderRepository.save(order);
    }



    public void finalizeOrder(long id){
        Order order = getOrderById(id);
        User user = order.getUser();
        int totalSum = 0;
        ProductOrderContainer productOrderContainer = new ProductOrderContainer(productOrderRepository.findAll().stream()
                .filter(or -> or.getOrder().getId_order() == id).collect(Collectors.toList()).toArray((ProductOrder[]::new)));
        Iterator<ProductOrder> iterator = productOrderContainer.getIterator();
        while(iterator.hasNext()){
            ProductOrder productOrder = iterator.next();
            totalSum += productOrder.getQuantity() * productOrder.getProduct().getPrice();
        }
        int discount = user.getNoOfOrders() * 2 / 100 * totalSum;
        user.setNoOfOrders(user.getNoOfOrders() + 1);
        user.setTotalSum(user.getTotalSum() + totalSum - discount);
        userRepository.save(user);
        orderRepository.deleteById(id);
    }

}


