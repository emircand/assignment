package part1;
public class TableConverter implements Converter {
    @Override
    public void convertToEntity(Table table, Invoice invoiceBox) {
        for (Row row : table.getRows()) {
            try {
                int orderId = row.getOrderId();
                int goodId = row.getGoodId();
                int quantity = row.getQuantity();
                double unitPrice = row.getUnitPrice();
                InvoiceItem item = new InvoiceItem(goodId, quantity, unitPrice);
                invoiceBox.addInvoiceItem(item, orderId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
