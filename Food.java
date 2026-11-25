// Programmer: Evan Avery
// 'date'
// subclass that defines specific attributes of a resturant's food

import java.math.BigDecimal;

public class Food extends MenuItem {
    // instance variables
    private String flavor;
    private boolean isVegetarian;
    private boolean allergyRisk;
    
    // explicit constructor
    public Food(String pName, BigDecimal pCost, String pType, String pFlavor, 
            boolean pIsVegetarian, boolean pAllergyRisk) {
        super(pName, pCost, pType);
        flavor = pFlavor;
        isVegetarian = pIsVegetarian;
        allergyRisk = pAllergyRisk;
    }
    
    // get method for flavor
    public String getFlavor() {
        return flavor;
    }
    
    // get method for isVegetarian
    public boolean getIsVegetarian() {
        return isVegetarian;
    }
    
    // get method for allergyRisk
    public boolean getAllergyRisk() {
        return allergyRisk;
    }
    
    // set method for flavor
    public void setFlavor(String pFlavor) {
        flavor = pFlavor;
    }
    
    // set method for isVegetarian
    public void setIsVegetarian(boolean pIsVegetarian) {
        isVegetarian = pIsVegetarian;
    }
    
    // set method for allergyRisk
    public void setAllergyRisk(boolean pAllergyRisk) {
        allergyRisk = pAllergyRisk;
    }
    
    @Override
    public String toString() {
        return String.format("%s: %s\n%s: %s\n%s: %s",
                "Flavor", flavor,
                "Vegetarian?", isVegetarian,
                "Allergy Risk?", allergyRisk) + super.toString();
    }
}
