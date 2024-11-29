import java.util.ArrayList;

public class ProductManager {
    private ArrayList<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(String productName) {
        products.removeIf(product -> product.getName().equals(productName));
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}