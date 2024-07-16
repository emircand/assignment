package part1;
public class Main {
    public static void main(String[] args) {
        Table table = new Table();
        TableGenerator.generate(table);
        Invoice invoiceBox = new Invoice();
        InvoiceHelper invoiceHelper = new InvoiceHelperImpl(invoiceBox);
        TableConverter tableConverter = new TableConverter();
        tableConverter.convertToEntity(table, invoiceBox);
        System.out.println("--------\nÜç siparişteki malların toplam tutarının çıktısı");
        invoiceHelper.calculateTotalInvoiceAmount();
        System.out.println("--------\nÜç siparişteki bütün malların ortalama fiyatı");
        invoiceHelper.calculateAverageOrderAmount();
        System.out.println("--------\nÜç siparişteki bütün malların tek tek mal bazlı ortalama fiyatı");
        invoiceHelper.calculateAverageAmountPerGood();
        System.out.println("--------\nTek tek mal bazlı, malların hangi siparişlerde kaç adet olduğu");
        invoiceHelper.calculateQuantityPerOrder();

    }
}
