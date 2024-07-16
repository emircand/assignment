package part1;
import java.util.HashMap;
import java.util.Map;

public class InvoiceHelperImpl implements InvoiceHelper {
    private Invoice invoice;
    private Map<Integer, Double> totalAmountPerGood = new HashMap<>();
    private Map<Integer, Integer> totalCountPerGood = new HashMap<>();


    InvoiceHelperImpl(Invoice invoice) {
        this.invoice = invoice;
    }
    
    // Üç siparişteki malların toplam tutarının çıktısı
    public void calculateTotalInvoiceAmount(){
        double totalAmount = 0;
        for (int orderId : invoice.getInvoiceBox().keySet()) {
            for (InvoiceItem item : invoice.getInvoiceBox().get(orderId)) {
                totalAmount += item.getQuantity() * item.getUnitPrice();
            }
        }
        System.out.println("Tüm siparişler toplam tutarı: " + totalAmount);
    }
    // Üç siparişteki bütün malların ortalama fiyatı
    public void calculateAverageOrderAmount(){
        for (int orderId : invoice.getInvoiceBox().keySet()) {
            double averageAmount = 0;
            double totalAmount = 0;
            for (InvoiceItem item : invoice.getInvoiceBox().get(orderId)) {
                totalAmount = item.getQuantity() * item.getUnitPrice();
            }
            averageAmount = totalAmount / invoice.getInvoiceBox().get(orderId).size();
            System.out.println("Sipariş No: " + orderId + " bütün malların ortalama fiyatı " + averageAmount);
        }
    }
    // Üç siparişteki bütün malların tek tek mal bazlı ortalama fiyatı
    public void calculateAverageAmountPerGood() {
        for (int orderId : invoice.getInvoiceBox().keySet()) {
            for (InvoiceItem item : invoice.getInvoiceBox().get(orderId)) {
                totalAmountPerGood.merge(item.getGoodId(), item.getQuantity() * item.getUnitPrice(), Double::sum);
                totalCountPerGood.merge(item.getGoodId(), item.getQuantity(), Integer::sum);
            }
        }
        System.out.println("Mal başına ortalama fiyat:");
        for (Map.Entry<Integer, Double> entry : totalAmountPerGood.entrySet()) {
            int goodId = entry.getKey();
            double totalAmount = entry.getValue();
            int totalCount = totalCountPerGood.get(goodId);
            double averageAmount = totalAmount / totalCount;
            System.out.println("Mal No: " + goodId + ", Ortalama fiyat: " + averageAmount);
        }
    }

    // Tek tek mal bazlı, malların hangi siparişlerde kaç adet olduğu
    public void calculateQuantityPerOrder() {
        // Temporary map to hold totals for each good across all orders
        Map<Integer, Map<Integer, Integer>> goodsInOrders = new HashMap<>();

        // Iterate through each order
        for (int orderId : invoice.getInvoiceBox().keySet()) {
            // Iterate through each item in the current order
            for (InvoiceItem item : invoice.getInvoiceBox().get(orderId)) {
                int goodId = item.getGoodId();
                int quantity = item.getQuantity();
                
                goodsInOrders.putIfAbsent(goodId, new HashMap<>());
                goodsInOrders.get(goodId).merge(orderId, quantity, Integer::sum);
            }
        }

        // Print the total quantity for each good across all orders
        System.out.println("Mal bazında, hangi siparişlerde kaç adet olduğu:");
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : goodsInOrders.entrySet()) {
            int goodId = entry.getKey();
            System.out.println("Mal No: " + goodId);
            for (Map.Entry<Integer, Integer> orderEntry : entry.getValue().entrySet()) {
                int orderId = orderEntry.getKey();
                int quantity = orderEntry.getValue();
                System.out.println("  Sipariş No: " + orderId + ", Adet: " + quantity);
            }
        }
    }
    
}
