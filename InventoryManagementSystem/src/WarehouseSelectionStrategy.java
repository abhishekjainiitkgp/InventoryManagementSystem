import java.util.List;

public interface WarehouseSelectionStrategy {
    Warehouse selectWareHouse(List<Warehouse> warehouseList);
}
