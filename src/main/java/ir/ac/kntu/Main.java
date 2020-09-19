package ir.ac.kntu;


import java.util.ArrayList;

public class Main {
    public static ScannerSingleton scannerSingleton= ScannerSingleton.getInstance();
    public static ArrayList<Customer> customers = new ArrayList<>();
    public static ArrayList<City> cities = new ArrayList<>();
    public static ArrayList<Postage> postages = new ArrayList<>();
    public static Date today = new Date(1399, 6, 29);

    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        displayMainMenu();
        handleMainMenu();
    }

    private static void displayMainMenu() {
        System.out.println("1- define the customer");
        System.out.println("2- edit the customer");
        System.out.println("3- define the city");
        System.out.println("4- edit the city");
        System.out.println("5- define the shipment");
        System.out.println("6- send the shipment");
        System.out.println("7- track the order");
        System.out.println("8- Customer search");
        System.out.println("9- search shipments by origin");
        System.out.println("10- search shipments by destination");
        System.out.println("11- filter and show air, land, sea shipments");
        System.out.println("12- filter and show shipments based on shipping and delivery status");
        System.out.println("13- filter and show shipments based on the customer\n");
        System.out.println("enter ur choice...");
    }

    private static void handleMainMenu() {
        String choice = scannerSingleton.nextLine();
        clearScreen();
        Customer customer = new Customer("none", "none");
        City city = new City("none", 0, 0);
//        if ( (choice.compareTo("1") < 0 || choice.compareTo("9") > 0)
//                && (choice.compareTo("10") < 0 || choice.compareTo("13") > 0)){
//            wrongInput();
//        }
        switch (choice){
            case "1":
                String customerName;
                String nationalCode;
                System.out.println("enter name:");
                customerName = scannerSingleton.nextLine();
                System.out.println("enter national code:");
                nationalCode = scannerSingleton.nextLine();
                customers.add(new Customer(customerName, nationalCode));
                break;
            case "2":
                if (customers.isEmpty()){
                    clearScreen();
                    System.out.println("no customers , please add one first");
                }
                System.out.println("customers are:");
                System.out.println(customers);
                System.out.println("enter the name of customer u want to edit:");
                customer = Customer.searchByName(customers, scannerSingleton.nextLine());
                if (customer == null) {
                    clearScreen();
                    wrongInput();
                    break;
                }
                System.out.println("1-edit name , 2-edit national code");
                if (scannerSingleton.nextLine().equals("1")){
                    System.out.println("enter the name:");
                    customer.setName(scannerSingleton.nextLine());
                } else {
                    System.out.println("enter the national code:");
                    customer.setNationalCode(scannerSingleton.nextLine());
                }
                break;
        }
    }

    private static void clearScreen(){
        System.out.println(System.lineSeparator().repeat(50));
    }

    private static void wrongInput(){
        System.out.println("wrong inout :( , please try again :)");
    }
}
