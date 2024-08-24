import java.util.List;

public class NearestWarehouseSelectionStrategy implements WarehouseSelectionStrategy {


    @Override
    public Warehouse selectWareHouse(List<Warehouse> warehouseList) {
         return warehouseList.get(0);
         //for now returning the warehouse at index 0
    }
}
