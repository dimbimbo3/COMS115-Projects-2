public class ProductionWorker extends Employee{
    private int shift;
    private double payRate;
    private final int DAY = 1;
    private final int NIGHT = 2;
    
    public ProductionWorker(String name, String ID, String hireDate, 
            int shift, double payRate){
        super(name, ID, hireDate);
        this.shift = shift;
        this.payRate = payRate;
    }
    
    public void setShift(int shift){
        this.shift = shift;
    }
    public int getShift(){
        return shift;
    }
    
    public void setPayRate(double payRate){
        this.payRate = payRate;
    }
    public double getPayRate(){
        return payRate;
    }
    
    public String toString(){
        String str = super.toString();
        
        str += "\nShift:";
        if(shift == DAY)
            str += "Day";
        else if(shift == NIGHT)
            str += "Night";
        
        str+= "\nHourly Pay Rate:" + String.format("$%.2f", getPayRate());
        
        return str;
    }
}
