public class PasswordVerifier {
    private String password;
    private final int REQUIRED_LEN = 6;
    
    public PasswordVerifier(){
        password = "";
    }
    
    public PasswordVerifier(String password){
        this.password = password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    
    public boolean isValid(){
        boolean valid = true;
        
        if(password.length() < REQUIRED_LEN)
            valid = false;
        else if(!checkCaseAndDigit())
            valid = false;
        
        return valid;
    }
    
    private boolean checkCaseAndDigit(){
        boolean valid = false;
        boolean upper = false;
        boolean lower = false;
        boolean digit = false;
        
        for(int i = 0; i < password.length() && (!upper || !lower || !digit); i++){
            if(!upper && Character.isUpperCase(password.charAt(i)))
                upper = true;
            else if(!lower && Character.isLowerCase(password.charAt(i)))
                lower = true;
            else if(!digit && Character.isDigit(password.charAt(i)))
                digit = true;
        }
        
        if(upper && lower && digit)
            valid = true;
        
        return valid;
    }
}
