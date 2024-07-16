public interface InvoiceHelper {
    // Üç siparişteki malların toplam tutarının çıktısı
    public void calculateTotalInvoiceAmount();
    // Üç siparişteki bütün malların ortalama fiyatı
    public void calculateAverageOrderAmount();
    // Üç siparişteki bütün malların tek tek mal bazlı ortalama fiyatı
    public void calculateAverageAmountPerGood();
    // Tek tek mal bazlı, malların hangi siparişlerde kaç adet olduğu
    public void calculateQuantityPerOrder();
}
