public class TableConverter implements Converter {
    @Override
    public void convertToEntity(Table table, Invoice invoiceBox) {
        for (Row row : table.getRows()) { // Iterate through each row in the table
            try {
                int orderId = row.getOrderId(); // Assuming first column is Order ID
                int goodId = row.getGoodId(); // Assuming second column is Good ID
                int quantity = row.getQuantity(); // Assuming third column is Quantity
                double unitPrice = row.getUnitPrice(); // Assuming fourth column is Unit Price
                InvoiceItem item = new InvoiceItem(goodId, quantity, unitPrice);
                invoiceBox.addInvoiceItem(item, orderId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
