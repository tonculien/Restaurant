// Programmer: Eric Avery
// 'date'
// subclass that defines specific attributes of a resturant's drinks

import java.math.BigDecimal;

public class Drink extends MenuItem {
    // instance variables
    private boolean isAlcoholic;
    private boolean isCaffeinated;
    
    // explicit constructor
    public Drink(String pName, BigDecimal pCost, String pType, 
            boolean pIsAlcoholic, boolean pIsCaffeinated) {
        super(pName, pCost, pType);
        isAlcoholic = pIsAlcoholic;
        isCaffeinated = pIsCaffeinated;
    }
    
    // get method for isAlcoholic
    public boolean getIsAlcoholic() {
        return isAlcoholic;
    }
    
    // get method for isCaffeinated
    public boolean getIsCaffeinated() {
        return isCaffeinated;
    }
    
    // set method for isAlcoholic
    public void setIsAlcoholic(boolean pIsAlcoholic) {
        isAlcoholic = pIsAlcoholic;
    }
    
    // set method for isCaffeinated
    public void setIsCaffeinated(boolean pIsCaffeinated) {
        isCaffeinated = pIsCaffeinated;
    }
    
    @Override
    public String toString() {
        return String.format("%s: %s\n%s: %s",
                "Alcoholic?", isAlcoholic,
                "Caffeinated?", isCaffeinated) + super.toString();
    }    
}
