public class Employee {
    private String name;
    private String ID;
    private String hireDate;
    
    public Employee(String name, String ID, String hireDate){
        this.name = name;
        this.ID = ID;
        this.hireDate = hireDate;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    public void setID(String ID){
        this.ID = ID;
    }
    public String getID(){
        return ID;
    }
    
    public void setHireDate(String hireDate){
        this.hireDate = hireDate;
    }
    public String getHireDate(){
        return hireDate;
    }
    
    public String toString(){
        String str;
        
        str = "Employee Name:" + getName();
        str += "\nID Number:" + getID();
        str += "\nHire Date:" + getHireDate();
        
        return str;
    }
}
