import java.util.Scanner;

public class PasswordVerifierDriver {
    public static void main(String[] args){
        PasswordVerifier password1 = new PasswordVerifier();
        Scanner keyboard = new Scanner(System.in);
        
        do{
            System.out.print("Please enter a password..."
                    + "\n(The Password must be 6 characters long & contain at least one uppercase letter,"
                    + "\none lowercase letter, and one digit):");
            password1.setPassword(keyboard.nextLine());
            
            if(password1.isValid())
                System.out.println("\nValid password entered.");
            else
                System.out.println("Invalid password entered!\n");
        }while(!password1.isValid());
        
        
    }
}
