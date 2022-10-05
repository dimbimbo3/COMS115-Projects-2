//Dan Imbimbo - COMS115
public class PayrollDriver {
    public static void main(String[] args) {
        Payroll payroll = new Payroll();
        
        payroll.setHours(0, 15);
        System.out.println("Hours: " + payroll.getHours(0));
        
        payroll.setPayRate(0, 8.50);
        System.out.println("Pay Rate: " + payroll.getPayRate(0));
        
        System.out.println("Gross Pay: " + payroll.getWages(0));
        
        System.out.println("Employee " + payroll.getId(0) + " Gross: " + payroll.getEmployeeGross(payroll.getId(0)));
    }
    
}
/*
Hours: 15
Pay Rate: 8.5
Gross Pay: 127.5
Employee 5658845 Gross: 127.5
*/