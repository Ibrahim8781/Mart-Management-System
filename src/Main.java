
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

// product list , mat management classes
// attributes for mart management system
// name address id number item in cart max item, Item in cart(arraylist) ,  price After Purchase(arraylist)
// getter setter for name id
class Product{
    private String productName ;
    private int productPrice;
    private int productIndex;

    public String getProductName() {
        return productName;
    }


    public int getProductPrice() {
        return productPrice;
    }


    public int getProductIndex() {
        return productIndex;
    }

    public void setProductIndex(int productIndex) {
        this.productIndex = productIndex;
    }

    public Product(String productName, int productPrice, int productIndex) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productIndex = productIndex;
    }
}
class Admin {

    private final String adminName;
    private final String adminPassword;

    public Admin(String a, String b){
        this.adminName = a;
        this.adminPassword = b;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void addProductAdmin(Product abc, ProductList productListForAdmin){
        productListForAdmin.allProductInMart.add(abc);
    }

    public void removeProductAdmin(Product abc, ProductList productListForAdmin){
        productListForAdmin.allProductInMart.remove(abc);
    }

}
class ProductList {
    protected ArrayList<Product> allProductInMart;

    public ProductList() {
        allProductInMart = new ArrayList<>();
    }

    // aik product  ga constructor say with having all product details from manager
    protected void addProduct(Product abc) {
        allProductInMart.add(abc);
    }

    public void removeProduct(int abc){

        for (Product productForCounter: allProductInMart) {
            if(productForCounter.getProductIndex() == abc) {
                allProductInMart.remove(productForCounter);
                System.out.println("Product Removed Successfully");
                break;
            }
        }

    }


    void showProducts(){
        System.out.println("Displaying all Products");
        for ( Product productForCounter : allProductInMart ) {
            System.out.println(" ID = " + productForCounter.getProductIndex() + " Name " + productForCounter.getProductName() + " Price " + productForCounter.getProductPrice() );
        }
    }

}

class Cart {
//    private static final int MAX_ITEMS = 5;  // Maximum number of items in the cart
    private List<Product> cartItems;

    public Cart() {
        cartItems = new ArrayList<>();
    }

    public void addToCart(int index , ProductList abc){
        for ( Product productForCounter : abc.allProductInMart ) {
            if(productForCounter.getProductIndex() == index) {
                this.cartItems.add(productForCounter);
                break;
            }
        }
    }
    public void displayCartContents() {
        System.out.println("Cart Contents:");
        for (Product product : cartItems) {
            System.out.println("Name: " + product.getProductName());
            System.out.println("Price: $" + product.getProductPrice());
            System.out.println("Index: " + product.getProductIndex());
            System.out.println("---------------------------");
        }
    }

    public void removeProduct(int index){
        for (Product product : cartItems) {
            if(product.getProductIndex() == index){
                cartItems.remove(product);
                System.out.println("Product Removed Successfully");
            }
        }

    }

    public void generateBill(){
        double totalPrice = 0;
        for (Product product : cartItems) {
            totalPrice = totalPrice + product.getProductPrice();
        }
        System.out.println("The total Bill of Your Cart is  Rs " + totalPrice + " /- " );
    }

    // Add methods to calculate the total cost, remove products, etc.
}
class Customer{
    private final String customerName;
    private final String customerCity;
//    private final int maxNumberOfItemInCart = 5;
    /*protected List <Product> productList;*/
    protected Cart CustomerCart ;
    public Customer(String customerName, String customerCity) {
        this.customerName = customerName;
        this.customerCity = customerCity;
        CustomerCart = new Cart();
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerCity() {
        return customerCity;
    }

}



public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ProductList productsForMart = new ProductList();

        productsForMart.addProduct(new Product("Product 1", 100, 1));
        productsForMart.addProduct(new Product("Product 2", 200, 2));
        productsForMart.addProduct(new Product("Product 3", 150, 3));
        productsForMart.addProduct(new Product("Product 4", 300, 4));
        productsForMart.addProduct(new Product("Product 5", 250, 5));


        Admin admin1 = new Admin("Steven " , "abcd1234" );

       while (true) {
           int choice;
           System.out.println(" Press 1 for Admin");
           System.out.println(" Press 2 for Customer");
           choice = scanner.nextInt();
           boolean Safety = true;
           switch (choice) {
               case 1 -> { //mein for admin

                       System.out.println("Enter Admin Name");
                       String admin_name = scanner.next();

                       System.out.println("Enter Admin Password");
                       String admin_password = scanner.next();
                       /*if ((Objects.equals(admin_name, admin1.getAdminName())) && (Objects.equals(admin_password, admin1.getAdminPassword())) ){
                           break;
                       } else {
                           System.out.println(" Invalid Credentials ");
                           //break;
                       }*/

                   boolean boolForAdminMenu = true;
                   while (boolForAdminMenu) {
                       System.out.println("-------------------------");
                       System.out.println("          MENU ");
                       System.out.println("-------------------------\n");
                       System.out.println("1. Add Product");
                       System.out.println("2. Edit Product");
                       System.out.println("3. Delete Product");
                       System.out.println("4. Display Product");
                       System.out.println("5. Exit");
                       System.out.print("Enter your choice: ");
                       int choice2 = scanner.nextInt();
                       scanner.nextLine(); // Consume newline

                       switch (choice2) {
                           case 1 -> {
                               System.out.println("Enter product name");
                               String name = scanner.nextLine();
                               System.out.println("Enter Product Price");
                               int price = scanner.nextInt();
                               System.out.println("Enter Product Index");
                               int index = scanner.nextInt();
                               Product abc = new Product(name, price, index);
                               productsForMart.addProduct(abc);
                           }
                           case 2 -> {
                               System.out.println("Enter Update product name");
                               String name = scanner.nextLine();
                               System.out.println("Enter Updated Product Price");
                               int price = scanner.nextInt();
                               System.out.println("Enter Product Index");
                               int index = scanner.nextInt();
                               Product updatedProduct = new Product(name, price, index);
                               productsForMart.addProduct(updatedProduct);
                           }
                           case 3 -> {
                               System.out.println("Enter the index to remove Product");
                               int indexOfRemovingProduct = scanner.nextInt();
                               productsForMart.removeProduct(indexOfRemovingProduct);
                           }
                           case 4 -> {
                               System.out.println("Displaying Products");
                               productsForMart.showProducts();
                           }
                           case 5 -> boolForAdminMenu = false;
                           default -> System.out.println("Invalid choice");
                       }
                   }
               }
               case 2 -> { // main for customer

                   System.out.println("Enter Customer Name ");
                   String customer_name = scanner.nextLine();
                   System.out.println("Enter Customer City ");
                   String customer_city = scanner.nextLine();

                   Customer customer1 = new Customer(customer_name, customer_city);

                   while (true) {
                       System.out.println("-------------------------");
                       System.out.println("          MENU ");
                       System.out.println("-------------------------\n");
                       System.out.println("1. Show Products");
                       System.out.println("2. Add Product to Cart");
                       System.out.println("3. Delete Product from Cart");
                       System.out.println("4. Show Product from Cart");
                       System.out.println("5. Generate Bill");
                       System.out.println("6. Exit");
                       System.out.print("Enter your choice: ");
                       int choice2 = scanner.nextInt();
                       scanner.nextLine(); // Consume newline

                       switch (choice2) {
                           case 1:
                               System.out.println("Displaying Products");
                               productsForMart.showProducts();
                               break;
                           case 2:
                               //
                               System.out.println(" Displaying your cart contents down below ");
                               customer1.CustomerCart.displayCartContents();
                               System.out.println(" Enter the Index of Product You want to remove ");
                               int ProductChoiceToRemove = scanner.nextInt();
                               customer1.CustomerCart.removeProduct(ProductChoiceToRemove);
                               break;
                           case 3:
                               System.out.println(" Enter the index of product you want to add ");
                               int Product1 = scanner.nextInt();
                               customer1.CustomerCart.addToCart(Product1, productsForMart);
                               break;
                           case 4:
                               customer1.CustomerCart.displayCartContents();
                               break;
                           case 5:
                               customer1.CustomerCart.generateBill();
                               break;
                           case 6:
                               System.out.println(" Exiting ...");
                               break;
                           default:
                               System.out.println("Invalid choice");
                       }
                   }
               }
               default -> System.out.println("Invalid Choice");
           }


       }




    }
}

