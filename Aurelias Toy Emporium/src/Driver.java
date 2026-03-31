import javax.swing.*;
import java.util.*;

public class Driver {
    private int toyNum = 0;
    private int totalAmount = 0;
    String recommendedSize;
    String nameToFind;
    int numInput;
    private ProductManual productManual;
    //A space has been opened up where only product manuals can be stored,and the name of the space is "productManual"//
    Scanner input = new Scanner(System.in);

    Driver(ProductManual pm) {
        this.productManual = pm;
        /*Transfer the current ProductManual object to the Driver class, where pm is the name of the parameter passed in.
        This object contains the latest toyList that has been added，so that it can ensure the Driver class can obtain a constantly updated toy list.*/
        Toy rabbit, pig, bear;
        selectToys();
        checkToyNum();
    }

    public Toy findToyByName() {
        List<Toy> toyList = productManual.getToyList();
        //Call the getToyList() method of the productManual object to get a list of toys and put it to the toyList variable.
        System.out.println("Enter the toy's name you want to purchase:");
        System.out.println("NOTE!!!The name(tn) is in the FIRST COLUMN of the menu");
        nameToFind = input.nextLine();
        for (Toy toy : toyList) {
            if (Objects.equals(toy.getName(), nameToFind)) {
                /*Use the utility method provided by Java called "Objects. equals()" to securely compare
                whether the name entered by the user matches the name in the Toy class object.*/
                System.out.println("Found: " + toy.getName() +
                        " | Size: " + toy.getSize() +
                        " | Type: " + toy.getAnimalType() +
                        " | Price: $" + toy.getPrice());
                //print out the information of the found toy.
                totalAmount += toy.getPrice();
                return toy;
            }
        }
        System.out.println("Toy '" + nameToFind + "' not found!");
        return null;
    }



    public void selectToys() {
        boolean validChoice = false;  // The sign to control the loop

        // Continue to circulate when validChoice=false.Check whether customer's answer(yes/no or else) meet the requirements
        while (!validChoice) {
            System.out.print("Do you have a desired one? (yes/no) : ");
            char userInput = input.next().charAt(0);
            input.nextLine();

            if ((userInput == 'y') || (userInput == 'Y')) {
                Toy foundToy = findToyByName();  // save the return toy

                if (foundToy != null) {  // If the name entered by the user matches the name in the Toy class object
                    System.out.println("You choose the " + foundToy.getSize() +
                            " " + foundToy.getAnimalType() + " toy. Its price is " + foundToy.getPrice());
                    toyNum++;
                    validChoice = true;  // Effective selection, exit loop
                } else {
                    System.out.println("No toy found. Please try again.");
                    /*Here we don't set validChoice as "true", so it will continue to circulate.
                    Specially, the programme will run selectToys() method again.
                     */
                }

            } else if ((userInput == 'n') || (userInput == 'N')) {
                System.out.println("We will recommend a toy that is suitable to you most");
                recommendToys();// Enter the recommendToys() method
                validChoice = true;  // Effective selection, exit loop
            } else {
                System.out.println("Invalid input! Please enter 'yes' or 'no'.");
                /*Here we don't set validChoice as "true", so it will continue to circulate.
                    Specially, the programme will run selectToys() method again.
                     */
            }
        }
    }

    //My design philosophy of the recommendToys() method is to recommend a toy size that is suitable for the customer based on their age and frequency of taking out.
    // If the input external frequency is "often", if the input age is below 12, recommend the small size, and if it is above 12, recommend the medium size;
    // If the external frequency is "seldom", if the input age is below 18, medium size is recommended, and above 18, large size is recommended.
    public void recommendToys() {
        System.out.println("Please enter the age of the toy owner (Please ENTER AN INTEGER!!, or the programme won't continue to run):");
        int age = input.nextInt();
        input.nextLine();

        //Check whether customer inputs the required "frequency"
        boolean validInputFrequency = false;
        char EnterYourFrequencyOfTakingOutChar;
        while (!validInputFrequency) {
            System.out.print("Enter your frequency of taking out(often/seldom): ");
            EnterYourFrequencyOfTakingOutChar = input.next().charAt(0);
            input.nextLine();
            if (EnterYourFrequencyOfTakingOutChar == 'o') {
                askAge1(age);
                validInputFrequency = true;
            } else if (EnterYourFrequencyOfTakingOutChar == 's') {
                askAge2(age);
                validInputFrequency = true;
            } else System.out.println("Invalid input! Please make sure you have entered 'often' or 'seldom'!!");
        }
        boolean validInputSatisfactory = false;
        char satisfactoryChar;
        while (!validInputSatisfactory) {
            System.out.println("Do you want to continue shopping(yes/no)?:");
            satisfactoryChar = input.next().charAt(0);
            input.nextLine();
            if ((satisfactoryChar == 'y') || (satisfactoryChar == 'Y')) {
                Toy foundToy = findToyByName();
                if (foundToy != null) {
                    System.out.println("You choose the " + foundToy.getSize() +
                            " " + foundToy.getAnimalType() + " toy. Its price is "+foundToy.getPrice());
                    toyNum++;
                    validInputSatisfactory = true;
                } else {
                    System.out.println("No toy found. Please try again.");
                }
            } else if ((satisfactoryChar == 'n') || (satisfactoryChar == 'N')) {
                System.out.println("Sorry for not being able to help you, welcome to visit again next time!");
                System.exit(0);//Exit the entire programme
            } else {
                System.out.println("Invalid input! Please enter 'yes' or 'no'.");
            }
        }
    }
    public void askAge1(int answer) {
        if (answer <= 12) {
            System.out.println("We recommend you to take a small size toy.");
            recommendedSize = "small";
        } else {
            System.out.println("We recommend you to take the medium size toy.");
            recommendedSize = "medium";
        }
    }
    public void askAge2(int answer) {
        if (answer <= 18) {
            System.out.println("We recommend you to take a medium size toy.");
            recommendedSize = "medium";
        } else {
            System.out.println("We recommend you to take the large size toy.");
            recommendedSize = "large";
        }
    }





    public void checkToyNum() {
        System.out.println("We have a lottery activity now. The rules are as follows:");
        System.out.println("If you purchase two or more items, assuming the total number of purchases is n, you will ultimately receive n-1 chances to win the lottery.");
        boolean validInput = false;
        char addMoreToysChar;
        while (!validInput) {
            System.out.println("Do you want to add more toys(yes/no) :");
            addMoreToysChar = input.next().charAt(0);
            input.nextLine();
            if (addMoreToysChar == 'Y' || addMoreToysChar == 'y') {
                addMoreToys(addMoreToysChar);
                validInput = true;
            } else if (addMoreToysChar == 'N' || addMoreToysChar == 'n') {
                System.out.println("Your total consumption amount is: $" + totalAmount );
                System.out.println("Looking forward to your next visit!");
                validInput = true;
            } else {
                System.out.println("Invalid input! Please enter 'yes' or 'no'.");
            }
        }
    }

    public void addMoreToys(char answer) {
        boolean inputValid = false;
        while (!inputValid) {
            if ((answer == 'Y') || (answer == 'y')) {
                boolean found = false;
                while (!found) {
                    Toy foundToy = findToyByName();
                    if (foundToy != null) {
                        System.out.println("You add the " + foundToy.getSize() +
                                " " + foundToy.getAnimalType() + " toy. Its price is " + foundToy.getPrice());
                        toyNum++;
                        found = true;
                    } else {
                        System.out.println("No toy found. Please try again.");
                    }
                }
                System.out.println("You currently have selected a total of " + toyNum + " items");
                System.out.println("Your current total consumption amount is: $" + totalAmount);

                boolean validResponse = false;
                while (!validResponse) {
                    System.out.println("Do you want to add more toys(y/n) :");
                    char newAnswer = input.next().charAt(0);
                    input.nextLine();
                    if (newAnswer == 'Y' || newAnswer == 'y' || newAnswer == 'N' || newAnswer == 'n') {
                        answer = newAnswer;
                        validResponse = true;
                    } else {
                        System.out.println("Invalid input! Please enter 'y' for yes or 'n' for no.");
                    }
                }
            } else if ((answer == 'N') || (answer == 'n')) {
                System.out.println("Your total consumption amount is: $" + totalAmount);
                System.out.println("The total number of toys you purchased is: " + toyNum);
                System.out.println("You have a total of " + (toyNum - 1) + " chances to participate in the lottery.");
                //Here we use a small if-else structure to judge which prompt we should show to the customer based on the number of toys he/she buys.
                if (toyNum > 2) {
                    System.out.println("Please enter a different number each time, otherwise the lottery will be invalid.");
                    System.out.println("This is your first attempt:");
                } else {
                    System.out.println("This is your first attempt:");
                }
                lotto();
                inputValid = true;
            } else {
                System.out.println("Invalid input! Please enter 'y' for yes or 'n' for no.");
                System.out.println("Do you want to add more toys(y/n) :");
                answer = input.next().charAt(0);
                input.nextLine();
            }
        }
    }


    public int[] arr() {
        int[] group = new int[17];
        //Initialize an array of length 17.
        Random random = new Random();
        //Used to generate random numbers.
        for (int i = 0; i < 17; ) {
            int j = 0;
            int num = random.nextInt(100) + 1;
            for (; j < i; j++) {
                if (num == group[j]) {
                    break;
                }
            }
            if (j == i) {
                group[i] = num;
                i++;
            }
        }//Generating an array containing 17 non-repeating integers between 1 and 100.
        return group;
    }
    public void lotto() {
        int[] group = arr();
        //Call the method arr and get the array generated by it.
        int[] firstPrize = new int[2];
        for (int i = 0; i < 2; i++) {
            firstPrize[i] = group[i];
        }
        int[] secondPrize = new int[5];
        for (int i = 0; i < 5; i++) {
            secondPrize[i] = group[i + 2];
        }
        int[] thirdPrize = new int[10];
        for (int i = 0; i < 10; i++) {
            thirdPrize[i] = group[i + 7];
        }
        for (int t = toyNum-1; t > 0; t--) {
            ensureValidNumberInput();
            boolean win=false;
            //Use a boolean value to determine whether to continue judging which prize has been won.
            for (int i = 0; i < 2; i++) {
                if (numInput == firstPrize[i]) {
                    System.out.println("Congratulations! You have won the first prize.");
                    win=true;
                    break;
                }
            }
            /*Once a prize is won, the loop stops, the boolean value is set to true, and the same applies to the
            following cases.*/
            if(!win){
                for (int i = 0; i < 5; i++) {
                    if (numInput == secondPrize[i]) {
                        System.out.println("Congratulations! You have won the second prize.");
                        win=true;
                        break;
                    }
                }
            }
            if(!win){
                for (int i = 0; i < 10; i++) {
                    if (numInput == thirdPrize[i]) {
                        System.out.println("Congratulations! You have won the third prize.");
                        win=true;
                        break;
                    }
                }
            }
            if(!win) {
                System.out.println("You have won a participation award.");
            }
            if(t-1>0){
                System.out.println("You still have "+(t-1)+" chance(s) to win.");
            }
            //Use a conditional statement to inform (the user) of the remaining number of the lottery draws.
        }
        System.out.println("Looking forward to your next visit! Wish you a happy life!");
    }

    public void ensureValidNumberInput() {
        boolean validInputNumber = false;
        while (!validInputNumber) {
            System.out.println("Please enter an INTEGER between 1 and 100:");
            try {
                numInput = input.nextInt();  // Try to read integers
                //If the reading is successful -> check the range
                if (numInput >= 1 && numInput <= 100) {
                    validInputNumber = true;
                } else {
                    System.out.println("Invalid input! Please enter an integer between 1 and 100!");
                    System.out.println("You entered: " + numInput);
                }
                //If reading fails(user inputs text) -> prompt the incorrect message
            } catch (InputMismatchException e) { //Processing input type error
                System.out.println("Invalid input! You must enter an INTEGER, not text or decimals.");
            } finally {
                input.nextLine();/*Regardless of whether there is an error, it will be executed here.
                                   Commonly used for cleaning resources (closing files, clearing buffers, etc.)*/
            }
        }
    }
}





