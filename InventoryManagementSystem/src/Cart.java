import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Integer, Integer> mCategoryIdvsCount;

    public Cart() {
        this.mCategoryIdvsCount = new HashMap<>();
    }

    //addItem
    public void addItemToCart(int productCategoryId, int count){
        //System.out.println(productCategoryId);
        if (mCategoryIdvsCount.containsKey(productCategoryId)) {
            int countInCart=mCategoryIdvsCount.get(productCategoryId);
            countInCart+=count;
            mCategoryIdvsCount.put(productCategoryId,countInCart);
        }
        else
        {
            mCategoryIdvsCount.put(productCategoryId,count);
        }
    }

    //removeItem
    public void removeItemsFromCart(int productCategoryId, int count){
        if(mCategoryIdvsCount.containsKey(productCategoryId)){
            int countInCart=mCategoryIdvsCount.get(productCategoryId);
            if(countInCart-count<=0)
                mCategoryIdvsCount.remove(productCategoryId);
            else
                mCategoryIdvsCount.put(productCategoryId,countInCart-count);
        }
    }

    //empty cart
    public void emptyCart(){
        mCategoryIdvsCount=new HashMap<>();
    }

    //view cart
    public Map<Integer, Integer> getCartItems(){
        return mCategoryIdvsCount;
    }
}
