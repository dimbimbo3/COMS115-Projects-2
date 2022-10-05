//Dan Imbimbo - COMS115
import java.util.Scanner;

public class CashRegisterDriver {
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        RetailItem item = new RetailItem();
        
        double price;
        int quantity;
        
        System.out.print("Enter the price for the item: ");
        price = keyboard.nextDouble();
        keyboard.nextLine();//consume newline
        item.setPrice(price);
        
        System.out.print("Enter the quantity of items: ");
        quantity = keyboard.nextInt();
        keyboard.nextLine();//consume newline
        
        CashRegister register = new CashRegister(quantity, item);
        
        System.out.println(register);
    }
}
/*
Enter the price for the item: 12.95
Enter the quantity of items: 10
Subtotal: $129.50
Sales Tax: $7.77
Total: $137.27
*/