public class InvoiceItem {
    private int goodId;
    private int quantity;
    private double unitPrice;

    public InvoiceItem(int goodId, int quantity, double unitPrice) {
        this.goodId = goodId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
