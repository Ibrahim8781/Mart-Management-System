import org.w3c.dom.ls.LSOutput;

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

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
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
class ProductList {
    protected ArrayList<Product> allProductInMart;

    public ProductList() {
        allProductInMart = new ArrayList<>();
    }

    // aik product bnay ga constructor say with having all product details from manager
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

class Cart {
    private static final int MAX_ITEMS = 5;  // Maximum number of items in the cart
    private List<Product> cartItems;

    public Cart() {
        cartItems = new ArrayList<>();
    }

    public boolean addProductToCart(Product product) {
        if (cartItems.size() < MAX_ITEMS) {
            cartItems.add(product);
            return true;
        } else {
            System.out.println("Sorry, the cart is full. Cannot add more items.");
            return false;
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
                System.out.println("Product Removed Succesfully");
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
    private final int maxNumberOfItemInCart = 5;
    /*protected List <Product> productList;*/
    private Cart CustomerCart = new Cart();
    public Customer(String customerName, String customerCity) {
        this.customerName = customerName;
        this.customerCity = customerCity;
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


        Admin adminnew = new Admin("Steven " , "abcd1234" );

       while (true) {
           int choice;
           System.out.println(" Press 1 for Admin");
           System.out.println(" Press 2 for Customer");
           choice = scanner.nextInt();
           switch (choice){
               case 1:{ //mein for admin
                   boolean Safety=true;
                   while(Safety) {
                       System.out.println("Enter Admin Name");
                       String admin_name = scanner.nextLine();
                       System.out.println("Enter Admin Password");
                       String admin_password = scanner.nextLine();

                       if (Objects.equals(admin_name, adminnew.getAdminName()) && Objects.equals(admin_password, adminnew.getAdminPassword())){
                           Safety = false;
                       break;
                        }
                       else
                           Safety = true;
                   }
                   while (true) {
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
                           case 1:
                               String name ;
                               int price , index;
                               System.out.println("Enter product name");
                               name = scanner.nextLine();
                               System.out.println("Enter Product Price");
                               price= scanner.nextInt();
                               System.out.println("Enter Product Index");
                               index= scanner.nextInt();
                               Product abc = new Product(name , price , index);
                               productsForMart.addProduct(abc);
                               break;
                           case 2:
                               System.out.println("Enter Update product name");
                               name = scanner.nextLine();
                               System.out.println("Enter Updated Product Price");
                               price= scanner.nextInt();
                               System.out.println("Enter Product Index");
                               index= scanner.nextInt();

                               Product updatedProduct = new Product(name , price , index);
                               productsForMart.addProduct(updatedProduct);

                               break;
                           case 3:
                               System.out.println("Enter the index to remove Product");
                               int indexOfRemovingProduct = scanner.nextInt();

                               productsForMart.removeProduct(indexOfRemovingProduct);
                               break;
                           case 4:
                               System.out.println("Displaying Products");
                               productsForMart.showProducts();
                               break;
                           default:
                               System.out.println("Invalid choice");
                       }
                   }
               }
               case 2: { // main for customer
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

                               break;
                           case 3:
                               break;
                           case 4:
                               break;
                           case 5:
                               break;
                           case 6:
                               break;
                           default:
                               System.out.println("Invalid choice");
                       }
                   }
               }
               default:
                   System.out.println("Invalid Choice");
           }


       }




    }
}

