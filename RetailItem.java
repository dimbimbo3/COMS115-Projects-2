//Dan Imbimbo - COMS115
public class RetailItem {
    private String description;
    private int units;
    private double price;
    
    public RetailItem(String description, int units, double price){
        this.description = description;
        this.units = units;
        this.price = price;
    }
    public RetailItem(){
        description = "";
        units = 0;
        price = 0;
    }
    
    //Copy constructor
    public RetailItem(RetailItem item2){
        description = item2.getDescription();
        units = item2.getUnits();
        price = item2.getPrice();
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
    
    public void setUnits(int units){
        this.units = units;
    }
    public int getUnits(){
        return units;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    
    public double getInventoryValue(){
        double totalCost;
        
        totalCost = units * price;
        
        return totalCost;
    }
    
    public String toString(){
        String str = String.format("Description: " + description + "\tUnits On Hand: " +
                    units + "\tPrice: $%.2f" + "\tInventory Value: $%.2f", price, getInventoryValue());
        
        return str;
    }
    
    public boolean equals(RetailItem item2){
        boolean status;
        
        if(description.equals(item2.getDescription()) && units == item2.getUnits() &&
                price == item2.getPrice() )
            status = true;
        else
            status = false;
        
        return status;
    }
}
