import javax.print.attribute.standard.PrinterMessageFromOperator;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {
    List<ProductCategory> productCategoryList;

    public Inventory() {
        this.productCategoryList=new ArrayList<>();
    }
    //add new category
    public void addProductCategory(int productCategoryId, String name, int price){
        //System.out.println("Prod category= "+ productCategoryId);
        ProductCategory productCategory=new ProductCategory();
        productCategory.price=price;
        productCategory.categoryName=name;
        productCategory.price=price;
        productCategory.categoryId=productCategoryId;
        productCategoryList.add(productCategory);
    }
    //add product to particular category
    public void  addProduct(Product product, int productCategoryId){

        //System.out.println(productCategoryId);
        ProductCategory productCategoryObject=null;
        for(ProductCategory productCategory:productCategoryList){
            if(productCategory.categoryId==productCategoryId){
                productCategoryObject=productCategory;
                break;
            }
        }
        if(productCategoryObject!=null){
            productCategoryObject.addProduct(product);
        }
        else {
            System.out.println("productCategory not found");
        }
    }
    public void removeItems(Map<Integer, Integer> mProductCategoryvsCount){
        for(Map.Entry<Integer, Integer> entry : mProductCategoryvsCount.entrySet()){
            ProductCategory category=getProductCategoryFromId(entry.getKey());
            category.removeProduct(entry.getValue());
        }
    }

    private ProductCategory getProductCategoryFromId(int productCategoryId){
        for(ProductCategory productCategory:productCategoryList){
            if(productCategory.categoryId==productCategoryId){
                return productCategory;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "productCategoryList=" + productCategoryList +
                '}';
    }
}
