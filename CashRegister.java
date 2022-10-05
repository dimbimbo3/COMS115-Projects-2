//Dan Imbimbo - COMS115
public class CashRegister {
    private int quantity;
    private RetailItem item;
    
    public CashRegister(int quantity, RetailItem item2){
        this.quantity = quantity;
        item = new RetailItem(item2);
    }
    
    public double getSubtotal(){
        return (quantity * item.getPrice());
    }
    
    public double getTax(){
        final double TAX_RATE = 0.06;
        
        return (TAX_RATE * getSubtotal());
    }
    
    public double getTotal(){
        return (getSubtotal() + getTax());
    }
    
    public String toString(){
        String str = String.format("Subtotal: $%.2f" + "\nSales Tax: $%.2f" + "\nTotal: $%.2f",
                                    getSubtotal(), getTax(), getTotal());
        
        return str;
    }
}
