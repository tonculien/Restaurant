import java.math.BigDecimal;

interface Payment {
    String paymentMethod();
    boolean pay(BigDecimal amount);
}

class Cash implements Payment {
    BigDecimal cost, amountTendered, changeDue, remaining;
    boolean process;

    public Cash(BigDecimal cost) {
        this.cost = cost;
    }

    public void applyCost(BigDecimal amount) {
        cost = amount;
    }

    public boolean pay(BigDecimal amount) {
        amountTendered = new BigDecimal(amount.toString());
        if (amount.compareTo(cost) >= 0) {
            changeDue = amount.subtract(cost);
            amount = amount.subtract(cost);
            remaining = new BigDecimal(0);
            process = true;
            return true;
        }
        else {
            remaining = cost.subtract(amount);
            changeDue = new BigDecimal(0);
            process = false;
            return false;
        }
    }

    public String paymentMethod() {
        return "cash";
    }

    public String toString() {
        return "CASH"
                + "\n\t" + "Amount Applied: " + cost
                + "\n\tCash Tendered: " + amountTendered
                + "\n\tChange Due: " + changeDue
                + "\n\tBalance Remaining: " + remaining;
    }
}

class Card implements Payment {
    BigDecimal cost, tip;

    public boolean pay(BigDecimal amount) {
        if (amount.compareTo(cost) == 0) return true;
        return false;
    }

    public boolean addTip(BigDecimal amount) {
        if (amount.compareTo(new BigDecimal(0)) <= 0) return false;
        tip = amount;
        return true;
    }

    public String paymentMethod() {
        return "card";
    }

    public String toString() {
        return "CARD"
                + "\n\tAmount Applied: " + cost
                + "\n\tTips: " + tip;
    }
}