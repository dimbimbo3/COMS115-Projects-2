//Dan Imbimbo - COMS115
public class Payroll {
    private final int EMPLOYEES = 7;
    private final int[] EMPLOYEE_ID = {5658845, 4520125, 7895122,
                                8777541, 8451277, 1302850, 7580489};
    private int[] hours = new int[EMPLOYEES];
    private double[] payRate = new double[EMPLOYEES], wages = new double[EMPLOYEES];
    
    public void setHours(int index, int hrs){
        hours[index] = hrs;
    }
    public int getHours(int index){
        return hours[index];
    }
    
    public void setPayRate(int index, double rate){
        payRate[index] = rate;
    }
    public double getPayRate(int index){
        return payRate[index];
    }
    
    public double getWages(int index){
        wages[index] = getHours(index) * getPayRate(index);
        return wages[index];
    }
    
    public int getId(int index){
        return EMPLOYEE_ID[index];
    }
    
    public double getEmployeeGross(int id){
        double gross = -1;
        boolean valid = false;
        
        for(int i = 0; i < EMPLOYEE_ID.length; i++){
            if(id == EMPLOYEE_ID[i]){
                gross = getWages(i);
                valid = true;
            }
        }
        if(!valid)
            System.out.println("ERROR: Invalid ID");
        
        return gross;
    }
}
