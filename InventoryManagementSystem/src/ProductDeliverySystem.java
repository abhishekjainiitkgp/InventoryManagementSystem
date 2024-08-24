import java.util.List;

public class ProductDeliverySystem {
    UserController userController;
    WarehouseController warehouseController;
    OrderController orderController;

    public ProductDeliverySystem(List<User> userList, List<Warehouse> warehouseList) {
        userController=new UserController(userList);
        warehouseController= new WarehouseController(warehouseList);
        orderController= new OrderController();
    }

    public User getUser(int id){
        return userController.getUserById(id);
    }

    public Warehouse getWarehouse(WarehouseSelectionStrategy warehouseSelectionStrategy){
        return warehouseController.selectWarehouse(warehouseSelectionStrategy);
    }

    public Inventory getInventory(Warehouse warehouse){
        return warehouse.getInventory();
    }

    public void addProductToCart(User user, ProductCategory productCategory, int count){
        Cart cart=user.getUserCart();
        cart.addItemToCart(productCategory.categoryId, count);
    }

    public void checkout(Order order){
        order.checkout();
    }

    public Order createNewOrder(User user, Warehouse warehouse){
        return orderController.createNewOrder(user,warehouse);
    }
}
