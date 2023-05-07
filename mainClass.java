package shopping;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class mainClass {

    public static void main(String[] args) {
        
        ArrayList<Product> productList = new ArrayList<Product>(); // Array list that will hold all Product objects

        // Creation of Product objects (by reading from file)
        try {
            File foodFile = new File("/Users/erikskreslins/Desktop/codes/food_price_table.txt");
            Scanner sc = new Scanner(foodFile, "UTF-8");
            sc.nextLine(); // Skip first line
            while(sc.hasNextLine()) {
                Product singleProduct = createProduct(sc.nextLine());
                productList.add(singleProduct); // Each Product object is added to ArrayList holding all objects
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Such a file does not exist.");
        }

        // Creation of Purchase objects 
        Purchase c1 = new Purchase("Jonathan");
        Purchase c2 = new Purchase("Stuff");

        // Calling addItem method for both Purchase objects with various Products
        c1.addItem(productList.get(2), 3);
        c1.addItem(productList.get(7), 1);
        c1.addItem(productList.get(12), 5);
        c2.addItem(productList.get(4), 11);
        c2.addItem(productList.get(8), 2);
        c2.addItem(productList.get(16), 4);
        c2.addItem(productList.get(20), 5);

        // Printing the information of each purchase
        c1.getPurchaseSummary();
        c2.getPurchaseSummary();

        // Removes last item from arrayList, prints the new summary
        c2.removeLastItem();
        c2.getPurchaseSummary();

        // Removes the most expensive purchase from arrayList, prints the new summary
        c2.removeMostExpensive();
        c2.getPurchaseSummary();

        // Removes all items from arrayList, prints the new summary
        c2.removeAll();
        c2.getPurchaseSummary();
    }

    static Product createProduct(String line) { // Method that creates each single Product object
        line = line.replaceAll(",", ".");
        String[] words = line.split(" ");
        Product product = new Product(words[0], words[1], Double.parseDouble(words[2]));
        return product;
    }
}