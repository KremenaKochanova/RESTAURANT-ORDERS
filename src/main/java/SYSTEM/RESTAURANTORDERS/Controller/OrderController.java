package SYSTEM.RESTAURANTORDERS.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getActiveOrders() {
        List<OrderDto> activeOrders = orderService.getActiveOrders();
        return ResponseEntity.ok(activeOrders);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long orderId) {
        OrderDto order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderCreateRequest request) {
        OrderDto order = orderService.createOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @PostMapping("/{orderId}/items")
    public ResponseEntity<OrderDto> addItemToOrder(@PathVariable OrderCreateRequest request) {
        OrderDto order = orderService.addItemOrder(request);
        return ResponseEntity.status(HttpStatus.ADD).body(order);
    }
}