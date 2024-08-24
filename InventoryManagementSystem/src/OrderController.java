import java.util.ArrayList;
import java.util.List;

public class OrderController {
    List<Order> orderList;

    public OrderController() {
        this.orderList=new ArrayList<>();
    }

    //create new order
    public Order createNewOrder(User user, Warehouse warehouse){
        Order order=new Order(user, warehouse);
        orderList.add(order);
        return order;
    }
}
