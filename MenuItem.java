// Programmer: Evan Avery
// 'date'
// abstract superclass that define general attributes of a resturant's menu items

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
    
    public static ArrayList<MenuItem> loadMenu(String fileName) {
        // create ArrayList that holds MenuItem objects (Food/Drink)
        ArrayList<MenuItem> menu = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            // while the line currently being read is not null
            while((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                
                // text file example
                // FOOD,Volcano Roll,18.00,Sushi,spicy,false,true
                // DRINK,Lime Margarita,12.00,Margarita,true,false
                
                // read the category tag and shared parent instance variables
                String category = parts[0].trim();
                String name = parts[1].trim();
                BigDecimal cost = new BigDecimal(parts[2].trim());
                String type = parts[3].trim();
                
                // parse subclass-specific instance variables based on the category
                if (category.equalsIgnoreCase("FOOD")) {
                    String flavor = parts[4].trim();
                    boolean isVeg = Boolean.parseBoolean(parts[5].trim());
                    boolean aller = Boolean.parseBoolean(parts[6].trim());
                    menu.add(new Food(name, cost, type, flavor, isVeg, aller));
                    
                } else if (category.equalsIgnoreCase("DRINK")) {
                    boolean isAlco = Boolean.parseBoolean(parts[4].trim());
                    boolean isCaff = Boolean.parseBoolean(parts[5].trim());
                    menu.add(new Drink(name, cost, type, isAlco, isCaff));
                }
            }
        } catch (IOException e) {
            System.err.println("ERROR - reading menu has failed due to: " + e.getMessage());
        }
        return menu;
    }
}
