package shopping;

import java.util.ArrayList;

public class Purchase {
    
    String clientName;
    private ArrayList<PurchaseItem> itemList = new ArrayList<PurchaseItem>();

    Purchase(String clientName) {
        this.clientName = clientName;
    }

    // Method that takes Product object & count, creates PurchaseItem object and adds it to ItemList
    void addItem(Product product, int count) {
        PurchaseItem temp = new PurchaseItem(product, count);
        this.itemList.add(temp);
    }
    // Method that calculates the total purchase price for a client, total item count, and returns the full purchase information
    void getPurchaseSummary() {
        double totalPrice = 0;
        int itemCount = 0;
        for (PurchaseItem item : itemList) {
            double tempPrice = item.count*item.product.price;
            totalPrice += tempPrice;
            itemCount += item.count;
        }
        System.out.println(this.clientName+" bought "+itemCount+" items "+"for the total price of "+totalPrice+"€"+((itemCount>0) ? ":" : "."));
        for (PurchaseItem item : itemList) {
            System.out.println("  - "+item.count+" "+item.product.name.toLowerCase()+((item.count>1) ? "s" : "")+" for "+item.count*item.product.price+"€");
        }
        System.out.println();
    }
    // Method that removes the last item from itemList
    void removeLastItem() {
        if (itemList.size()>1) {
            this.itemList.remove(itemList.size()-1);
        }
    }
    // Method that removes the most expensive part of purchase (item count * price)
    void removeMostExpensive() {
        double highestPrice = 0;
        int index = 0;
        for (int i=0; i<itemList.size(); i++) {
            double price = itemList.get(i).count*itemList.get(i).product.price;
            if (price>highestPrice) {
                highestPrice = price;
                index = i;
            }
        }
        this.itemList.remove(index); 
    }
    // Method that removes all items from itemList
    void removeAll() {
        this.itemList.clear();
    }
}
