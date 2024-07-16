import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Invoice {
    private HashMap<Integer, List<InvoiceItem>> invoiceBox;

    public Invoice() {
        invoiceBox = new HashMap<>();
    }

    public HashMap<Integer, List<InvoiceItem>> getInvoiceBox() {
        return invoiceBox;
    }

    public void setInvoiceBox(HashMap<Integer, List<InvoiceItem>> invoiceBox) {
        this.invoiceBox = invoiceBox;
    }

    public void addInvoiceItem(InvoiceItem invoiceItem, int orderId) {
        if (invoiceBox.containsKey(orderId)) {
            List<InvoiceItem> invoiceItems = invoiceBox.get(orderId);
            boolean found = false;
            for (InvoiceItem item : invoiceItems) {
                if (item.getGoodId() == invoiceItem.getGoodId()) {
                    item.setQuantity(item.getQuantity() + invoiceItem.getQuantity());
                    found = true;
                    break;
                }
            }
            if (!found) {
                invoiceItems.add(invoiceItem);
            }
        } else {
            List<InvoiceItem> invoiceItems = new ArrayList<>();
            invoiceItems.add(invoiceItem);
            invoiceBox.put(orderId, invoiceItems);
        }
    }
}
