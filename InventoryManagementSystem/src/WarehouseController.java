import java.util.ArrayList;
import java.util.List;

public class WarehouseController {
    List<Warehouse> warehouseList;
    WarehouseSelectionStrategy warehouseSelectionStrategy;

    public WarehouseController(WarehouseSelectionStrategy warehouseSelectionStrategy) {
        this.warehouseList=new ArrayList<>();
        this.warehouseSelectionStrategy = warehouseSelectionStrategy;
    }

    public WarehouseController( List<Warehouse> warehouseList) {
        this.warehouseList=warehouseList;
    }

    //add Warehouse;
    public void addWarehouse(Warehouse warehouse){
        warehouseList.add(warehouse);
    }
    //remove Warehouse;
    public void removeWarehouse(Warehouse warehouse){
        warehouseList.remove(warehouse);
    }

    //selectWarehouse;
    //dynamic
    public Warehouse selectWarehouse(WarehouseSelectionStrategy warehouseSelectionStrategy){
        this.warehouseSelectionStrategy=warehouseSelectionStrategy;
        return warehouseSelectionStrategy.selectWareHouse(warehouseList);
    }
}
