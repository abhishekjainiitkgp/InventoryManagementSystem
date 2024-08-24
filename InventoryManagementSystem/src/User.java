import java.util.ArrayList;
import java.util.List;

public class User {
    int userId;
    String name;
    Cart cart;
    List<Integer> orderIdList;
    Address address;

    public User() {
        this.cart = new Cart();
        this.orderIdList = new ArrayList<>();
    }

    public Cart getUserCart(){
        return this.cart;
    }
}
