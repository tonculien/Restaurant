import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private List <MenuItem> itemList = new ArrayList<>();
    private int table_number;

    public Table(int number) {
        table_number = number;
    }

    public void order(List<MenuItem> orderList) {
        itemList = orderList;
    }

    public List<MenuItem> getOrderList() {
        return itemList;
    }

    public BigDecimal cost() {
        BigDecimal total = new BigDecimal(0);
        for (MenuItem item: itemList) {
            total.add(item.getCost());
        }
        return total;
    }

    @Override
    public String toString() {
        String str = "";
        for (MenuItem item: itemList) {
            str += item + "\n";
        }
        return "Table number: " + table_number + "\n" + str;
    }
}
