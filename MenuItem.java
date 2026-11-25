// Programmer: Evan Avery
// 'date'
// abstract superclass that define general attributes of a resturant's menu items

// BigDecimal is used to store accurate prices
import java.math.BigDecimal;

public abstract class MenuItem {
    // instance variables
    private String name;
    private BigDecimal cost;
    private String type;
    
    // explicit constructor
    public MenuItem(String pName, BigDecimal pCost, String pType) {
        // checks that cost is a positive number
        if (pCost == null || pCost.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Cost cannot be null or negative.");
        }
        name = pName;
        cost = pCost;
        type = pType;
    }
    
    // get method for name
    public String getName() {
        return name;
    }
    
    // get method for cost
    public BigDecimal getCost() {
        return cost;
    }
    
    // get method for type
    public String getType() {
        return type;
    }
    
    // set method for name
    public void setName(String pName) {
        name = pName;
    }
    
    // set method for cost
    public void setCost(BigDecimal pCost) {
        if (pCost == null || pCost.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Cost cannot be null or negative.");
        }
        cost = pCost;
    }
    
    // set method for type
    public void setType(String pType) {
        type = pType;
    }
    
    // displays variables and their values
    @Override
    public String toString() {
        return String.format("\n%s: %s\n%s: %s\n%s: %s",
                "Name", name,
                "Cost", cost,
                "Type", type);
    }
}
