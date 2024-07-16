public class Row {
    private int orderId;
    private int goodId;
    private int quantity;
    private double unitPrice;

    public Row(int orderId, int goodId, int quantity, double unitPrice) {
        this.orderId = orderId;
        this.goodId = goodId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getGoodId() {
        return goodId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
