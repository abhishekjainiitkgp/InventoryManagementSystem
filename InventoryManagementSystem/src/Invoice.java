public class Invoice {
    double totalPrice;
    double tax;
    double totalFinalPrice;

    public void generateInvoice(Order order){
        //will compute total price based on the order item, static for this problem scope
        totalPrice=200;
        tax=20;
        totalFinalPrice=220;
    }
}
