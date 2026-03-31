import java.util.*;
//The asterisk * indicates that all classes under the java.util package are imported, including List.
public class ProductManual {
    Scanner input = new Scanner(System.in);
    //Used for input.
    private List<Toy> toyList = new ArrayList<>();
    //Initialize the list.



    public ProductManual() {
        initializeToyList();
    }



    private void initializeToyList() {
        Toy t1 = new Toy("t1", "small", "pig", 100);
        Toy t2 = new Toy("t2", "medium", "pig", 150);
        Toy t3 = new Toy("t3", "large", "pig", 200);
        Toy t4 = new Toy("t4", "small", "rabbit", 100);
        Toy t5 = new Toy("t5", "medium", "rabbit", 150);
        Toy t6 = new Toy("t6", "large", "rabbit", 200);
        Toy t7 = new Toy("t7", "small", "bear", 100);
        Toy t8 = new Toy("t8", "medium", "bear", 150);
        Toy t9 = new Toy("t9", "large", "bear", 200);
        //Create nine objects.
        toyList.add(t1);
        toyList.add(t2);
        toyList.add(t3);
        toyList.add(t4);
        toyList.add(t5);
        toyList.add(t6);
        toyList.add(t7);
        toyList.add(t8);
        toyList.add(t9);
        //Add the object to the list.
    }



    public static void main(String[] args) {
        ProductManual driver = new ProductManual();
        driver.start();
        //Call the non-static method start.
    }



    public void start() {
        System.out.println("Welcome to Aurelias Toy Emporium!");
        System.out.println("You have two modes.");
        System.out.println("1.Customer mode");
        System.out.println("2.Manager mode.");
        System.out.println("Please enter your choice.(1/2)");
        String option = input.nextLine();
        //User input.
        while (!option.equals("1") && !option.equals("2")) {
            System.out.println("Input error!Please enter 1 or 2!");
            option = input.nextLine();
        }
        //When the input is neither 1 nor 2, prompt an error and ask the customer to re-enter.
        if (option.equals("1")) {
            System.out.println("Here is our product manual...");
            printToyTable(toyList);
            new Driver(this);
        } //When 1 is entered, call the list and access the D1
        // river method as a customer.
        else {
            System.out.println("Enter manager login system....");
            ManagerLogin();
        }//When 2 is entered, access the store manager login system.
    }



    public List<Toy> getToyList() {
        return toyList;
    }
    // Make the toyList accessible from outside.


    public void printToyTable(List<Toy> toys) {
        System.out.println("------------------------");
        System.out.println("name\tsize\tanimalType\tprice");
        for (Toy toy : toyList) {
            System.out.println(toy);
        }
    }//Generate a table.



    public void ManagerLogin() {
        System.out.println("Please enter the store manager's ID number.");
        int ID = input.nextInt();
        //Read the input content.
        input.nextLine();
        //Clear the newline character.
        if (ID == 123456) {
            System.out.println("Please enter your password.");
            int password = input.nextInt();
            input.nextLine();
            if (password == 123456) {
                System.out.println("Enter the store manager management system.");
                management();
            } else {
                System.out.println("Password incorrect.");
                System.out.println("Please log in again.");
                System.out.println("You have two options.");
                System.out.println("1.Try again.");
                System.out.println("2.Exit.");
                System.out.println("Please enter (1/2).");
                String choose1 = input.nextLine();
                while (!choose1.equals("1") && !choose1.equals("2")) {
                    System.out.println("Input error!Please enter 1 or 2!");
                    choose1 = input.nextLine();
                }
                if (choose1.equals("2")) {
                    System.out.println("Enter the initial interface.");
                    start();
                } else {
                    System.out.println("Enter manager login system....");
                    ManagerLogin();
                }
            }/*
            It is used to determine whether the password is correct when the ID is valid. If correct,
             access the store manager management system; if incorrect, two options are provided.
             */
        } else {
            System.out.println("ID incorrect.");
            System.out.println("Please log in again.");
            System.out.println("You have two options.");
            System.out.println("1.Try again.");
            System.out.println("2.Exit.");
            System.out.println("Please enter (1/2).");
            String choose2 = input.nextLine();
            while (!choose2.equals("1") && !choose2.equals("2")) {
                System.out.println("Input error!Please enter 1 or 2!");
                choose2 = input.nextLine();
            }
            if (choose2.equals("2")) {
                System.out.println("Enter the initial interface.");
                start();
            } else {
                System.out.println("Enter manager login system....");
                ManagerLogin();
            }
        }//First, determine whether the ID is correct.
    }



    public void management() {
        System.out.println("You can add or modify the items in the following product section.");
        printToyTable(toyList);
        //Display the project manual.
        System.out.println("1.add       2.delete");
        System.out.println("enter(1/2)");
        String choose = input.nextLine();
        //Read the input content.
        while (!choose.equals("1") && !choose.equals("2")) {
            System.out.println("Input error!Please enter 1 or 2!");
            choose = input.nextLine();
        }//When the input is neither 1 nor 2, prompt an error and ask the store manager to re-enter.
        if (choose.equals("1")) {
            add();
            //When 1 is entered, access the add method.
        } else {
           delete();
        }//When 2 is entered, access the delete method.
    }




    public void add(){
        System.out.println("Please enter the name of the toy that you want to add:");
        System.out.println("Please MAKE SURE that you haven't used the name on any of your current toys.");
        System.out.println("We recommend you to use formats like 'tn', n= a certain number");
        String name = input.nextLine();
        System.out.println("size:");
        String size = input.nextLine();
        System.out.println("animalType:");
        String animalType = input.nextLine();
        System.out.println("price:");
        int price = input.nextInt();
        //Enter the name, size, animal type, and price of the product you want to add in sequence.
        input.nextLine();
        //Clear the newline character.
        Toy a = new Toy(name, size, animalType, price);
        //Add an object in the Toy class.
        toyList.add(a);
        //Add the newly added object to the list.
        printToyTable(toyList);
        //Display the project manual.
        System.out.println("Note: If you have added a wrong toy,you need to delete it by yourself!");
        System.out.println("You have options.");
        System.out.println("1.Continue adding.");
        System.out.println("2.Delete.");
        System.out.println("3.Exit.");
        System.out.println("Please enter (1/2/3)");
        String choose = input.nextLine();
        while (!choose.equals("1") && !choose.equals("2")&&!choose.equals("3")) {
            System.out.println("Input error!Please enter 1 or 2 or 3!");
            choose = input.nextLine();
        }//When the input is neither 1, nor 2, nor 3, prompt an error and ask the store manager to re-enter.

        if (choose.equals("1")) {
            add();
        } //When 1 is entered, access the add method.
        else if(choose.equals("2")) {
            delete();
        }//When 2 is entered, access the delete method.
        else{
            start();
        }//When 3 is entered, access the start method.
    }




    public void delete(){
        System.out.println("Please enter the name of the toy that you want to delete:");
        String delete = input.nextLine();
        //Enter the name of the product you want to delete.
        boolean find = false;
        //Define a boolean variable named found and initialize it to false.
        int location=0;
        //Define an integer variable named location and initialize it to 0.
        for (int i = 0; i < toyList.size(); i++) {
            Toy now = toyList.get(i);
            if (now.getName().equals(delete)) {
                location = i;
                find = true;
                break;
            }
        }/*
        Iterate through the name of each object in the list. When the name matching delete is found, record
        location as i, set the boolean value of found to true, and stop the iteration.
        */
        if (find) {
            toyList.remove(location);
            printToyTable(toyList);
        } //If the boolean value of found is true, delete the object at the corresponding position in toyList.
        else {
            System.out.println("The target name was not found.");
            System.out.println("Please enter again.");
        }//If the boolean value of found is false, ask the store manager to re-enter.
        System.out.println("You have options.");
        System.out.println("1.Delete.");
        System.out.println("2.Add.");
        System.out.println("3.Exit.");
        System.out.println("Please enter (1/2/3)");
        String choose = input.nextLine();
        while (!choose.equals("1") && !choose.equals("2")&&!choose.equals("3")) {
            System.out.println("Input error!Please enter 1 or 2 or 3!");
            choose = input.nextLine();
        }
        if (choose.equals("1")) {
            delete();
        } else if(choose.equals("2")) {
            add();
        }else{
            start();
        }//Choose.
    }
}
