import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main mainObj= new Main();

        List<Warehouse> warehouseList=new ArrayList<>();
        warehouseList.add(mainObj.addWarehouseAndItsInventory());
        List<User> userList=new ArrayList<>();
        userList.add(mainObj.createUser());

        ProductDeliverySystem productDeliverySystem= new ProductDeliverySystem(userList, warehouseList);

        mainObj.runDeliveryFlow(productDeliverySystem,1);
    }

    private Warehouse addWarehouseAndItsInventory(){
        Warehouse warehouse=new Warehouse();
        Inventory inventory=new Inventory();
        inventory.addProductCategory(1, "Peppsii Large Cold Drink", 100);
        inventory.addProductCategory(4, "Doovee small Soap", 50);

        Product product1=new Product(1, "Peepsii");
        //System.out.println(product1);
        Product product2=new Product(2, "Peepsii");
        //System.out.println(product2);
        Product product3=new Product(3, "Doovee");
        //System.out.println(product3);
        inventory.addProduct(product1, 1);
        inventory.addProduct(product2, 1);
        inventory.addProduct(product3, 4);

        warehouse.inventory=inventory;
        return warehouse;
    }

    private User createUser(){
        User user=new User();
        user.userId=1;
        user.name="AJ";
        user.address= new Address(123456, "city", "state");
        return user;
    }

    public void runDeliveryFlow(ProductDeliverySystem productDeliverySystem, int userId){
        User user=productDeliverySystem.getUser(userId);
        Warehouse warehouse=productDeliverySystem.getWarehouse(new NearestWarehouseSelectionStrategy());
        Inventory inventory= productDeliverySystem.getInventory(warehouse);
        //System.out.println(inventory);
        ProductCategory productCategoryToOrder=null;
        for(ProductCategory productCategory: inventory.productCategoryList){
            if(productCategory.categoryName.equals("Doovee small Soap")){
                productCategoryToOrder=productCategory;
            }
        }
        //System.out.println(productCategoryToOrder.categoryId);
        productDeliverySystem.addProductToCart(user, productCategoryToOrder,2);

        Order order = productDeliverySystem.createNewOrder(user, warehouse);

        productDeliverySystem.checkout(order);

    }
}
