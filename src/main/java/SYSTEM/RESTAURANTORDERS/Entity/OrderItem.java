package SYSTEM.RESTAURANTORDERS.Entity;
import org.springframework.data.annotation.Id;
import javax.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @javax.persistence.Id
    @Column(name = "order_item_id", nullable = false)
    private Long orderItem_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

        public Long getOrderItem_id() {
        return orderItem_id;
        }

    public void setOrderItem_id(Long orderItem_id) {
        this.orderItem_id = orderItem_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
