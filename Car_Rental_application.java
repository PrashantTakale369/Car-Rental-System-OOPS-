
import java.util.ArrayList;


// all Car information is here
    class Car {

        // init the which types you want

        private String carId;
        private String Car_Model;
        private String Car_Brand;
        private double Base_Prizze;
        private boolean Is_Availabel;
        private String Car_Conditon;

        // Here we are craeting the  parameterized constructor bcz we are are 
        // calling all the method by cerating the object of the clasa

        // data filling main work doing this constructor
        
        public void car(String carId , String Car_Model , String Car_Brand , boolean Is_Availabel , double Base_Prizze){

            // we are assinging the all the methods to the particular opertions;

            this.carId = carId;
            this.Car_Model = Car_Model;
            this.Car_Brand = Car_Brand;
            this.Base_Prizze = Base_Prizze;
            this.Car_Conditon = Car_Conditon;
            this.Is_Availabel = true;

        }
        public String getCsr_Condition(){
            return Car_Conditon;
        }

        public String getcarId(){
            return carId;
        }
        
        public String getCar_Model(){
            return Car_Model;
        }

        public String getCar_Brand(){
            return Car_Brand;
        }

        public boolean getIs_Availabel(){
            return Is_Availabel;
        }

        public void rent(){
            Is_Availabel =  false;
        }

        public void Return_Car(){
            Is_Availabel =  true;
        }

        public double CalculatePrize(int rentealDays){
            return Base_Prizze * rentealDays;
        }
    }


// Customer All information

    class Customer {

        private  String name;
        private  String ID;
        private  int Cont_No;
        private  String Adress;

        public void Customer(String name , String Id , int Cont_No , String Adress){

            // all methos are assing int he constructor
            this.name = name;
            this.ID  = Id;
            this.Cont_No = Cont_No;
            this.Adress = Adress;
        }

        public String getname(){
            return name;
        } 

        public String getID(){
            return ID;
        }

        public int getCont_No(){
            return getCont_No();
        }

        public String getAdress(){
            return Adress;
       }   
    }

// All inforamation about the Rental car which custober which car wants

    class Rental {

        private Car car;
        private Customer custromer;
        private int day;

        public Rental(Car car , Customer customer , int day){

            this.car = car;
            this.custromer = customer;
            this.day =day;
        }

        public Car getcar(){
            return car;
        }

        public Customer getcustomer(){
            return custromer;

        }

        public int getday(){
            return day;
        }
    }

// All Information aboutr the car systeam and here you give the recipt of the car

    class Car_Rental_Systeam {

        // delearing the list 

        private ArrayList<Car> cars;
        private ArrayList<Customer> customerss1;
        private ArrayList<Rental> renatl1;

        // we are creatig arraylist for each class to store the objects there bcz we can use esaily any were

        public void rentmycar(){

            // blank array list creating 

            cars = new ArrayList<>();
            customerss1 = new ArrayList<>();
            renatl1 = new ArrayList<>();
        }
        

        // add the renatl dadt Cars data in the linked list 
        // (Car) class may say (car) obj ka dta (cars) name kay list may dala

        public void addcars(Car car){
            cars.add(car);
        }

        public void addCustomer(Customer customer ){
            customerss1.add(customer);
        }

        // banda car rent karnay aya hai : - 

        public void carrental(Car car , Customer customer , int day){

            if(car.getIs_Availabel()){
                car.rent();
                renatl1.add(new Rental(car ,customer ,day));
            }else{

                System.out.println("Car Is Not Avialabel For Rent :) " );
            }     
        }


        // banda car return karnay aya hai : - 


        public void returnCar(Car car) {
            car.returnCar();
            Rental rentalToRemove = null;
            for (Rental rental : rentals) {
                if (rental.getCar() == car) {
                    rentalToRemove = rental;
                    break;
                }
            }
            if (rentalToRemove != null) {
                rentals.remove(rentalToRemove);
    
            } else {
                System.out.println("Car was not rented.");
            }
        }
    
        public void menu() {
            Scanner scanner = new Scanner(System.in);
    
            while (true) {
                System.out.println("===== Car Rental System =====");
                System.out.println("1. Rent a Car");
                System.out.println("2. Return a Car");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
    
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
    
                if (choice == 1) {
                    System.out.println("\n== Rent a Car ==\n");
                    System.out.print("Enter your name: ");
                    String customerName = scanner.nextLine();
    
                    System.out.println("\nAvailable Cars:");
                    for (Car car : cars) {
                        if (car.isAvailable()) {
                            System.out.println(car.getCarId() + " - " + car.getBrand() + " " + car.getModel());
                        }
                    }
    
                    System.out.print("\nEnter the car ID you want to rent: ");
                    String carId = scanner.nextLine();
    
                    System.out.print("Enter the number of days for rental: ");
                    int rentalDays = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
    
                    Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
                    addCustomer(newCustomer);
    
                    Car selectedCar = null;
                    for (Car car : cars) {
                        if (car.getCarId().equals(carId) && car.isAvailable()) {
                            selectedCar = car;
                            break;
                        }
                    }
    
                    if (selectedCar != null) {
                        double totalPrice = selectedCar.calculatePrice(rentalDays);
                        System.out.println("\n== Rental Information ==\n");
                        System.out.println("Customer ID: " + newCustomer.getCustomerId());
                        System.out.println("Customer Name: " + newCustomer.getName());
                        System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
                        System.out.println("Rental Days: " + rentalDays);
                        System.out.printf("Total Price: $%.2f%n", totalPrice);
    
                        System.out.print("\nConfirm rental (Y/N): ");
                        String confirm = scanner.nextLine();
    
                        if (confirm.equalsIgnoreCase("Y")) {
                            rentCar(selectedCar, newCustomer, rentalDays);
                            System.out.println("\nCar rented successfully.");
                        } else {
                            System.out.println("\nRental canceled.");
                        }
                    } else {
                        System.out.println("\nInvalid car selection or car not available for rent.");
                    }
                } else if (choice == 2) {
                    System.out.println("\n== Return a Car ==\n");
                    System.out.print("Enter the car ID you want to return: ");
                    String carId = scanner.nextLine();
    
                    Car carToReturn = null;
                    for (Car car : cars) {
                        if (car.getCarId().equals(carId) && !car.isAvailable()) {
                            carToReturn = car;
                            break;
                        }
                    }
    
                    if (carToReturn != null) {
                        Customer customer = null;
                        for (Rental rental : rentals) {
                            if (rental.getCar() == carToReturn) {
                                customer = rental.getCustomer();
                                break;
                            }
                        }
    
                        if (customer != null) {
                            returnCar(carToReturn);
                            System.out.println("Car returned successfully by " + customer.getName());
                        } else {
                            System.out.println("Car was not rented or rental information is missing.");
                        }
                    } else {
                        System.out.println("Invalid car ID or car is not rented.");
                    }
                } else if (choice == 3) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
    
            System.out.println("\nThank you for using the Car Rental System!");
        }
    
    }

public class Car_Rental_application {
     

    public static void main(String[] args) {

        CarRentalSystem rentalSystem = new CarRentalSystem();

        Car car1 = new Car("C001", "Toyota", "Camry", 60.0); // Different base price per day for each car
        Car car2 = new Car("C002", "Honda", "Accord", 70.0);
        Car car3 = new Car("C003", "Mahindra", "Thar", 150.0);
        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);

        rentalSystem.menu();
    }
}

        
    }
}