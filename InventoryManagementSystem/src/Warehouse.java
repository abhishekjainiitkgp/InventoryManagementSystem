import java.util.Map;

public class Warehouse {
    Inventory inventory;
    Address address;

    public void removeItemsFromInventory(Map<Integer, Integer> mProductCategoryvsCount){
        inventory.removeItems(mProductCategoryvsCount);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void addItemToInventory(Map<Integer, Integer> mProductCategoryvsCount){
        //it will update the items in inventory based upon product category;
    }

}
