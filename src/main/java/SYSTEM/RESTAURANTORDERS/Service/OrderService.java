package SYSTEM.RESTAURANTORDERS.Service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final TableRepository tableRepository;

    public OrderService(OrderRepository orderRepository, TableRepository tableRepository) {
        this.orderRepository = orderRepository;
        this.tableRepository = tableRepository;
    }

    public Order createOrder(Order order) {
        Table table = tableRepository.findById(order.getTable().getId())
                .orElseThrow(() -> new EntityNotFoundException("Table not found"));

        if (table.getStatus() != TableStatus.FREE) {
            throw new TableNotFreeException("Table is not free");
        }

        order.setTable(table);
        order.setStatus(OrderStatus.ACTIVE);
        return orderRepository.save(order);
    }

    public Order addMenuItem(Long orderId, MenuItem menuItem) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));

        order.addMenuItem(menuItem);
        return orderRepository.save(order);
    }

    public Order removeMenuItem(Long orderId, MenuItem menuItem) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));

        order.removeMenuItem(menuItem);
        return orderRepository.save(order);
    }

    public Order changeOrderStatus(Long orderId, OrderStatus status) {
        Order order = orderRepository

