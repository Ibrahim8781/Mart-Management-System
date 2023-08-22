/*
Ibrahim Ahmad
Software Engineering
3rd Semester
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.exit;

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
        productListForAdmin.allProducts.add(abc);
    }

    public void removeProductAdmin(Product abc, ProductList productListForAdmin){
        productListForAdmin.allProducts.remove(abc);
    }

}
class ProductList {
    protected ArrayList<Product> allProducts;

    public ProductList() {
        allProducts = new ArrayList<>();
    }

    // aik product  ga constructor say with having all product details from manager
    protected void addProduct(Product abc) {
        allProducts.add(abc);
    }

    public void removeProduct(int abc){

        for (Product productForCounter: allProducts) {
            if(productForCounter.getProductIndex() == abc) {
                allProducts.remove(productForCounter);
                System.out.println("Product Removed Successfully");
                break;
            }
        }

    }


    void showProductsForMart(){
        System.out.println("Displaying all Products");
        for ( Product productForCounter : allProducts ) {
            System.out.println(" ID = " + productForCounter.getProductIndex() + " Name " + productForCounter.getProductName() + " Price " + productForCounter.getProductPrice() );
        }
    }

}

/*
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
*/
class Customer{
    private final String customerName;
    private final String customerCity;
//    private final int maxNumberOfItemInCart = 5;
    /*protected List <Product> productList;*/
    protected ProductList CustomerCart ;
    public Customer(String customerName, String customerCity) {
        this.customerName = customerName;
        this.customerCity = customerCity;
        CustomerCart = new ProductList();
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void addProductByCustomer(ProductList allProductsInMart , int indexOfProductToAdd){
        for ( Product productForCounter : allProductsInMart.allProducts ) {
            if(productForCounter.getProductIndex() == indexOfProductToAdd) {
                //this.CustomerCart.add(productForCounter);
                this.CustomerCart.allProducts.add(productForCounter);
                break;
            }
        }
    }

    public void removeProductByCustomer(int indexOfProductToRemove){
        for ( Product productForCounter : CustomerCart.allProducts ) {
            if(productForCounter.getProductIndex() == indexOfProductToRemove) {
                this.CustomerCart.allProducts.remove(productForCounter);
                break;
            }
        }
    }

    public void ProductDisplayOfCustomerCart(){
            System.out.println("Cart Contents:");
            for (Product product : CustomerCart.allProducts) {
                System.out.print("ID: " + product.getProductIndex());
                System.out.print(" Name: " + product.getProductName());
                System.out.print(" Price: $" + product.getProductPrice());
            }

    }
    public void generateBill(){
        double totalPrice = 0;
        for (Product product : CustomerCart.allProducts) {
            totalPrice = totalPrice + product.getProductPrice();
        }
        System.out.println("The total Bill of Your Cart is  Rs " + totalPrice + " /- " );
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
                               productsForMart.showProductsForMart();
                           }
                           case 5 -> exit(0);
                           default -> System.out.println("Invalid choice");
                       }
                   }
               }

               // case 2 not working properly
               case 2 -> { // main for customer

                   System.out.println("Enter Customer Name ");
                   String customer_name = scanner.nextLine();
/*
                   System.out.println("Enter Customer City ");
                   String customer_city = scanner.nextLine();
*/

                   Customer customer1 = new Customer(customer_name, "customer_city");

                   while (true) {
                       System.out.println("-------------------------");
                       System.out.println("          MENU ");
                       System.out.println("-------------------------\n");
                       System.out.println("1. Show Products");
                       System.out.println("2. Remove Product to Cart");
                       System.out.println("3. Add Product to Cart");
                       System.out.println("4. Show Product from Cart");
                       System.out.println("5. Generate Bill");
                       System.out.println("6. Exit");
                       System.out.print("Enter your choice: ");
                       int choice2 = scanner.nextInt();
                       scanner.nextLine(); // Consume newline

                       switch (choice2) {
                           case 1:
                               System.out.println("Displaying Products");
                               productsForMart.showProductsForMart();
                               break;
                           case 2:
                               //
                               System.out.println(" Displaying your cart contents down below ");
                               customer1.ProductDisplayOfCustomerCart();
                               System.out.println(" Enter the Index of Product You want to remove ");
                               int ProductChoiceToRemove = scanner.nextInt();
                               customer1.removeProductByCustomer(ProductChoiceToRemove);
                               break;
                           case 3:
                               System.out.println(" Displaying the Products in Mart");
                               productsForMart.showProductsForMart();
                               System.out.println(" Enter the index of product you want to add ");
                               int ProductIndexToAdd = scanner.nextInt();
                               customer1.addProductByCustomer(productsForMart, ProductIndexToAdd);
                               break;
                           case 4:
                               customer1.ProductDisplayOfCustomerCart();
                               break;
                           case 5:
                               customer1.generateBill();
                               break;
                           case 6:
                               System.out.println(" Exiting ...");
                               exit(0);
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

