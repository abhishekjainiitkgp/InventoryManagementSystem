import java.util.Map;

public class Order {
    //int orderId;
    User user;
    Address deliveryAddress;
    Map<Integer, Integer> mCategoryIdvsCount;
    Warehouse warehouse;
    Invoice invoice;
    Payment payment;
    OrderStatus orderStatus;

    public Order(User user, Warehouse warehouse) {
        this.user = user;
        this.warehouse = warehouse;
        this.mCategoryIdvsCount=user.getUserCart().getCartItems();
        invoice=new Invoice();
        invoice.generateInvoice(this);
    }

    public void generateInvoice(){
        invoice.generateInvoice(this);
    }

    public boolean makePayment(PaymentMode paymentMode){
        payment= new Payment(paymentMode);
        return payment.makePayment();
    }

    public void checkout(){
        //1. update inventory
        warehouse.removeItemsFromInventory(mCategoryIdvsCount);
        //2. make Payment;
        boolean isPaymentSuccess=makePayment(new UPIPaymentMode());

        //3. make cart empty
        if(isPaymentSuccess){
            user.getUserCart().emptyCart();
            System.out.println("Order placed");
        }else{
            warehouse.addItemToInventory(mCategoryIdvsCount);
        }
    }
}
