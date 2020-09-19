package ir.ac.kntu;


import java.util.ArrayList;

public class Main {
    public static ScannerSingleton scannerSingleton= ScannerSingleton.getInstance();
    public static ArrayList<Customer> customers = new ArrayList<>();
    public static ArrayList<City> cities = new ArrayList<>();
    public static ArrayList<Postage> postages = new ArrayList<>();
    public static Date today = new Date(1399, 6, 29);

    public static void main(String[] args) throws CloneNotSupportedException {
        mainMenu();
    }

    private static void mainMenu() throws CloneNotSupportedException {
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
        System.out.println("10- filter and show air, land, sea shipments");
        System.out.println("11- filter and show shipments based on shipping and delivery status");
        System.out.println("12- filter and show shipments based on the customer\n");
        System.out.println("enter ur choice...");
    }

    private static void handleMainMenu() throws CloneNotSupportedException {
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
            case "3":
                String cityName;
                int x,y;
                System.out.println("enter name:");
                cityName = scannerSingleton.nextLine();
                System.out.println("enter X:");
                x = Integer.parseInt(scannerSingleton.nextLine());
                System.out.println("enter Y:");
                y = Integer.parseInt(scannerSingleton.nextLine());
                cities.add(new City(cityName, x, y));
                break;
            case "4":
                if (cities.isEmpty()){
                    clearScreen();
                    System.out.println("no cities , please add one first");
                    break;
                }
                System.out.println("cities are:");
                System.out.println(cities);
                System.out.println("enter the name of name u want to edit:");
                city = City.searchByName(cities, scannerSingleton.nextLine());
                if (city == null) {
                    clearScreen();
                    wrongInput();
                    break;
                }
                System.out.println("1-edit name , 2-edit X or Y");
                if (scannerSingleton.nextLine().equals("1")){
                    System.out.println("enter the name:");
                    city.setName(scannerSingleton.nextLine());
                } else {
                    System.out.println("enter the X and Y:");
                    city.setX(Integer.parseInt(scannerSingleton.nextLine()));
                    city.setY(Integer.parseInt(scannerSingleton.nextLine()));
                }
                break;
            case "5":
                String shipmentName;
                Customer sender,receiver;
                City origin,destination;
                double weight;
                Date deliveryTime,receiptTime;
                ShippingMethod shippingMethod = null;
                PostMethod postMethod;
                OrderStatus orderStatus;
                if (customers.isEmpty() || cities.isEmpty()) {
                    clearScreen();
                    System.out.println("no cities or customers , please add one first");
                    break;
                }
                System.out.println("enter the name of shipment:");
                shipmentName = scannerSingleton.nextLine();
                System.out.println("customers are : "+ customers);
                System.out.println("enter the name of sender :");
                sender = Customer.searchByName(customers, scannerSingleton.nextLine());
                if (sender == null){
                    clearScreen();
                    wrongInput();
                    break;
                }
                System.out.println("enter the name of receiver :");
                receiver = Customer.searchByName(customers, scannerSingleton.nextLine());
                if (receiver == null){
                    clearScreen();
                    wrongInput();
                    break;
                }

                System.out.println("cities are : "+ cities);
                System.out.println("enter the name of origin :");
                origin = City.searchByName(cities, scannerSingleton.nextLine());
                if (origin == null){
                    clearScreen();
                    wrongInput();
                    break;
                }
                System.out.println("enter the name of destination :");
                destination = City.searchByName(cities, scannerSingleton.nextLine());
                if (destination == null){
                    clearScreen();
                    wrongInput();
                    break;
                }

                System.out.println("enter the weight:");
                weight = Double.parseDouble(scannerSingleton.nextLine());
                System.out.println("enter the delivery time:");
                System.out.println("enter year");
                int year = Integer.parseInt(scannerSingleton.nextLine());
                System.out.println("enter month");
                int month = Integer.parseInt(scannerSingleton.nextLine());
                System.out.println("enter day");
                int day = Integer.parseInt(scannerSingleton.nextLine());
                deliveryTime = new Date(year, month, day);
                System.out.println("enter the receipt time:");
                System.out.println("enter year");
                year = Integer.parseInt(scannerSingleton.nextLine());
                System.out.println("enter month");
                month = Integer.parseInt(scannerSingleton.nextLine());
                System.out.println("enter day");
                day = Integer.parseInt(scannerSingleton.nextLine());
                receiptTime = new Date(year, month, day);
                if (City.dis(origin, destination) > 500){
                    System.out.println("enter shipping method : 1- Air 2- Sea");
                    if (scannerSingleton.nextLine().equals("1")) {
                        shippingMethod = ShippingMethod.AIR;
                    } else {
                        shippingMethod = ShippingMethod.SEA;
                    }
                } else {
                    System.out.println("enter shipping method : 1- Air 2- Sea 3- Land");
                    switch (scannerSingleton.nextLine()) {
                        case "1":
                            shippingMethod = ShippingMethod.AIR;
                            break;
                        case "2":
                            shippingMethod = ShippingMethod.SEA;
                            break;
                        case "3":
                            shippingMethod = ShippingMethod.LAND;
                            break;
                        default:
                            wrongInput();
                            break;
                    }
                }

                System.out.println("enter post method:1- Normal 2- custom");
                if (scannerSingleton.nextLine().equals("1")){
                    postMethod=PostMethod.NORMAL;
                } else{
                    postMethod = PostMethod.CUSTOM;
                }
                postages.add(new Postage(shipmentName, sender, receiver, origin,
                        destination, weight, deliveryTime,receiptTime ,
                        shippingMethod , postMethod));
                break;
            case "6":
                if (postages.isEmpty()){
                    System.out.println("no shipment , please create one first :)");
                    break;
                }
                for (Postage postage : postages) {
                    if (postage.getDeliveryTime().compareTo(today) <= 0
                            && postage.getOrderStatus().equals(OrderStatus.UNSENT)) {
                        postage.setOrderStatus(OrderStatus.UNARMED);
                    }
                }
                break;
            case "7":
                if (postages.isEmpty()) {
                    System.out.println("no shipment , please create one first :)");
                    break;
                }
                System.out.println("the shipments are : " + postages);
                System.out.println("enter the name of ur shipment: ");
                String postageName = scannerSingleton.nextLine();
                for (int i = 0; i < postages.size(); i++) {
                    if (postages.get(i).getName().equals(postageName)){
                        System.out.println(postages.get(i).getOrderStatus());
                        break;
                    }
                }
                break;
            case "8":
                System.out.println("enter the name of customer u want to search");
                System.out.println(Customer.searchByName(customers, scannerSingleton.nextLine()));
                break;
            case "9":
                System.out.println("1- origin ,2- destination");
                if (scannerSingleton.nextLine().equals("1")){
                    System.out.println("enter the name of origin");
                    city = City.searchByName(cities, scannerSingleton.nextLine());
                    System.out.println(Postage.searchByOrigin(postages, city));
                } else {
                    System.out.println("enter the name of destination");
                    city = City.searchByName(cities, scannerSingleton.nextLine());
                    System.out.println(Postage.searchByDestination(postages, city));
                }
                break;
            case "10":
                System.out.println("1- AIR ,2- SEA ,3- LAND");
                switch (scannerSingleton.nextLine()){
                    case "1":
                        System.out.println(Postage.searchByShippingMethod(postages
                                , ShippingMethod.AIR));
                        break;
                    case "2":
                        System.out.println(Postage.searchByShippingMethod(postages
                                , ShippingMethod.SEA));
                        break;
                    case "3":
                        System.out.println(Postage.searchByShippingMethod(postages
                                , ShippingMethod.LAND));
                        break;
                    default:
                        wrongInput();
                }
            case "11":
                System.out.println("1- UNSENT,2- UNARMED, 3- RECEIVED BY RECIPIENT,");
                switch (scannerSingleton.nextLine()){
                    case "1":
                        System.out.println(Postage.searchByOrderStatus(postages
                                , OrderStatus.UNSENT));
                        break;
                    case "2":
                        System.out.println(Postage.searchByOrderStatus(postages
                                , OrderStatus.UNARMED));
                        break;
                    case "3":
                        System.out.println(Postage.searchByOrderStatus(postages
                                , OrderStatus.RECEIVEDBYRECIPIENT));
                        break;
                    default:
                        wrongInput();
                }
                break;
            case "12":
                System.out.println("customers are : ");
                System.out.println(customers);
                System.out.println("enter the name of customer:");
                System.out.println(Postage.searchByCustomers(postages
                        , Customer.searchByName(customers,scannerSingleton.nextLine())));
            default:
                clearScreen();
                wrongInput();
                mainMenu();
        }
        mainMenu();
    }

    private static void clearScreen(){
        System.out.println(System.lineSeparator().repeat(50));
    }

    private static void wrongInput(){
        System.out.println("wrong inout :( , please try again :)");
    }
}
