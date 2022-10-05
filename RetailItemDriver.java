//Dan Imbimbo - COMS115
import java.util.Scanner;

public class RetailItemDriver {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        RetailItem item = new RetailItem();
        
        int units;
        double price;
        String description;
        
        System.out.print("Enter description for the item: ");
        description = keyboard.nextLine();
        item.setDescription(description);
            
        System.out.print("Enter the number of units for the item: ");
        units = keyboard.nextInt();
        keyboard.nextLine();//consume newline
        item.setUnits(units);
            
        System.out.print("Enter the price for the item: ");
        price = keyboard.nextDouble();
        keyboard.nextLine();//consume newline
        item.setPrice(price);
        
        System.out.println(item);
        
        RetailItem item2 = new RetailItem(item);//Copy values of item to item2
        
        if(item.equals(item2))
            System.out.println("Item 1 and Item 2 are equal.");
        else
            System.out.println("Item 1 and Item 2 are not equal.");
    }
}
/*
Enter description for the item: Shirt
Enter the number of units for the item: 20
Enter the price for the item: 8.75
Description: Shirt	Units On Hand: 20	Price: $8.75	Inventory Value: $175.00
Item 1 and Item 2 are equal.
*/