import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

public class ProductCategory {
    int categoryId;
    String categoryName;
    List<Product> productList;
    double price;

    public ProductCategory() {
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public void removeProduct(int  count){
        for(int i=1;i<=productList.size();i++){
            productList.remove(0);
        }
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", productList=" + productList +
                ", price=" + price +
                '}';
    }
}
