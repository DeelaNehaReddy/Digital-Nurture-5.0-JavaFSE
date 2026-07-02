import java.util.Arrays;
import java.util.Comparator;

public class SearchTest {

    public static void main(String[] args) {

        Product[] products = {
                new Product(105, "Laptop", "Electronics"),
                new Product(101, "Mobile", "Electronics"),
                new Product(110, "Shoes", "Fashion"),
                new Product(103, "Watch", "Accessories"),
                new Product(108, "Headphones", "Electronics")
        };

        Product linearResult = LinearSearch.search(products, 103);

        System.out.println("Linear Search Result:");
        System.out.println(linearResult);

        Arrays.sort(products,
                Comparator.comparingInt(p -> p.productId));

        Product binaryResult = BinarySearch.search(products, 103);

        System.out.println("\nBinary Search Result:");
        System.out.println(binaryResult);
    }
}