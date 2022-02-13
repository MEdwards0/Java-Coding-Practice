import uk.gov.dwp.training.animals.Animal;
import uk.gov.dwp.training.animals.Cat;
import uk.gov.dwp.training.animals.Dog;
import uk.gov.dwp.training.animals.SmallDog;

import java.util.*;

public class Application {

    // ensure the user returns an integer using any argument given.
    static int validateInputInt(Object argument) {

        int integer = 0;

        boolean loop = false;

        try {
            // Check if this number can be a valid integer.
            integer = Integer.parseInt((String) argument);

            // Check the value of the number
            if (integer > 10000 || integer < 1) {
                System.out.println("Please limit the number to be between 0 and 10001");
                loop = true;
            }
        } catch (Exception e) {
            System.out.println("Please enter a number");
            loop = true;
        }

        Scanner sc = new Scanner(System.in);

        while (loop) {

            try {
                argument = sc.nextLine();
                integer = Integer.parseInt((String) argument);

                if (integer < 10001 && integer > 0 ) {
                    loop = false;
                } else {
                    System.out.println("Please limit the number to be between 0 and 10001");
                }

            } catch (Exception e) {
                System.out.println("Please enter a number.");
            }

        }

        return integer;
    }

    // If the program has no arguments to use or less than 2 arguments, get the user to input the arguments.
    static int[] requestArray() {

        Scanner sc = new Scanner(System.in);

        String firstUserResponse;
        int userResponse = 0;

        System.out.println("How many numbers would you like to use? Limit is 10.");

        // Get the user input as a string, then check if the input is a number, if not then ask until it is.

        while (userResponse < 2 || userResponse > 10) { // Program needs within 2 - 10 numbers to function correctly.
            firstUserResponse = sc.nextLine();
            userResponse = validateInputInt(firstUserResponse);
            if (userResponse < 2) {
                System.out.println("Array Request: Please enter a number higher than 1");
            } else if (userResponse > 10) {
                System.out.println("Only 10 numbers allowed maximum.");
            }
        }

        int[] numberArray = new int[userResponse];

        for (int i = 0; i < userResponse; i++) {
            System.out.println("Please enter a number for entry " + i);
            numberArray[i] = validateInputInt(sc.nextLine());
        }

        Arrays.sort(numberArray);
        System.out.println("First number is " + numberArray[0]);
        System.out.println("Last number is " + numberArray[numberArray.length - 1]);


        return numberArray;
    }

    // Offer the user functions of the program and return a number of 1 - 5 for the switch in main.
    static int requestFunction() {

        // Display options to the user

        System.out.println("What would you like to do? Please input a number:");
        System.out.println("1 - Add the range of numbers from lowest to highest.");
        System.out.println("2 - Multiply all numbers between lowest and highest.");
        System.out.println("3 - Divide all numbers between lowest and highest ");
        System.out.println("4 - Subtract all numbers between lowest and highest.");
        System.out.println("5 - Get range of all individual numbers lowest to highest.");

        Scanner sc2 = new Scanner(System.in);

        // Validate entry & tease the user

        int userRequest = 0;
        int programFrustration = 1;

        while (userRequest < 1 || userRequest > 5) {

            if (sc2.hasNextInt()) {
                userRequest = sc2.nextInt();
                if (userRequest < 1 || userRequest > 5) {

                 switch (programFrustration) {
                     case 1:
                            System.out.println("Wrong input, please try between 1 to 5.");
                            programFrustration++;
                            break;
                     case 2:
                            System.out.println("Oopsie, still not between 1 to 5.");
                            programFrustration++;
                            break;
                     case 3:
                            System.out.println("You should know what a number is.." +
                                " Press a key that looks like 1 2 3 4 or 5.");
                            programFrustration++;
                            break;
                     case 4:
                            System.out.println("I get it. You're just messing with me. You're a clown.");
                            programFrustration++;
                            break;
                     case 5:
                            System.out.println("Please stop.");
                            programFrustration++;
                            break;
                     case 6:
                            System.out.println("LKAHFGLLGH098[[;][{})(7680968sfgkjhocv<>.`~~.  <--- That's you. " +
                                "I'm not playing with you anymore");
                            programFrustration++;
                            break;
                     default:
                         System.out.println("Using number 1: add range function.");
                         return 1;
                }
            }
        } else {
            switch (programFrustration) {
                case 1:
                    System.out.println("That's not a number. Please try 1 to 5.");
                    programFrustration++;
                    sc2.next();
                    break;
                case 2:
                    System.out.println("Still not a number. Please look at the keyboard.");
                    programFrustration++;
                    sc2.next();
                    break;
                case 3:
                    System.out.println("Do you need help? Try a number 1 to 5.");
                    programFrustration++;
                    sc2.next();
                    break;
                case 4:
                    System.out.println("I get it. You're just messing with me. You're a clown.");
                    programFrustration++;
                    sc2.next();
                    break;
                case 5:
                    System.out.println("Please stop.");
                    programFrustration++;
                    sc2.next();
                    break;
                case 6:
                    System.out.println("LKAHFGLLGH098[[;][{})(7680968sfgkjhocv<>.`~~.  <--- That's you. " +
                            "I'm not playing with you anymore");
                    programFrustration++;
                    sc2.next();
                    break;
                default:
                    System.out.println("Using number 1: add range function.");
                    return 1;
            }

         }
        }
        return userRequest;
    }

    // Convert an array of string elements to an array of integers. Takes String array and returns new int array.
    static int[] convertStringArrayToInt(String[] array) {
        int arrayMax = array.length - 1;
        int[] convertedArray = new int[array.length];

        for(int i = 0; i <= arrayMax; i++) {
            convertedArray[i] = Integer.parseInt(array[i]);
        }

        Arrays.sort(convertedArray);
        return convertedArray;
    }

    // Add numbers between lowest and highest number in the array.
    static void addRange(int[] array) {

        int addResult = 0;
        String calc = " ";

        for (int i = array[0]; i <= array[array.length - 1]; i++) {
            addResult += i;
            //System.out.println("addResult is : " + addResult);

            if (i == array[array.length - 1]) {
                calc += i;
            } else {
                calc +=  i + " + ";
            }
        }

        System.out.println(calc);
        System.out.println(addResult);
    }

    // Multiply numbers between lowest and highest number in the array.
    static void multiplyRange(int[] array) {

        int timesResult = 1;
        String calc = " ";

        for (int i = array[0]; i <= array[array.length - 1]; i++) {
            timesResult *= i;
            //System.out.println("timesResult is : " + timesResult);

            if (i == array[array.length - 1]) {
                calc += i ;
            } else {
                calc +=  i + " * ";
            }
        }

        System.out.println(calc);
        System.out.println(timesResult);
    }

    // Divide numbers between lowest and highest number in the array. Ask user if they want to sort highest to lowest.
    static void divideRange(int[] array) {
        float divideResult = 0;
        String calc = " ";
        String response = " ";
        int[] divideArray = new int[array.length];

        Scanner sc3 = new Scanner(System.in);

            System.out.println("Would you like to sort highest to lowest?");
            System.out.println("Y or y for yes. Anything else for no.");

            response = sc3.nextLine();

            // IF user wants to sort highest to lowest, take argument array and flip it by taking individual elements
            // and pushing them to the array that the end result uses. Otherwise, just use the sorted array given.

            if (response.equals("Y") || response.equals("y")) {

                for (int i = 0; i <= array.length - 1; i++) {
                    divideArray[i] = array[array.length - 1 - i];
                }

                for (int i = divideArray[0]; i >= divideArray[divideArray.length -1]; i--) {

                    if (i == divideArray[0]) {
                        divideResult = i;
                    } else {
                        divideResult = divideResult / i;
                    }

                    if (i == divideArray[divideArray.length - 1]) {
                        calc += i;
                    } else {
                        calc +=  i + " ÷ ";
                    }

                }
            } else {
                divideArray = array;

                for (int i = divideArray[0]; i <= divideArray[divideArray.length - 1]; i++) {

                    if (i == divideArray[0]) {
                        divideResult = i;
                    } else {
                        divideResult = divideResult / i;
                    }

                    if (i == divideArray[divideArray.length - 1]) {
                        calc += i;
                    } else {
                        calc +=  i + " ÷ ";
                    }
                }
            }

        System.out.println(calc);
        System.out.println(divideResult);

    }

    // Subtract numbers between highest and lowest number in the array.
    static void subtractRange(int[] array) {

        int minusResult = 0;
        int[] minusArray = new int[array.length];
        String calc = " ";

        for (int i = 0; i <= array.length - 1; i++) {
            minusArray[i] = array[array.length - 1 - i];
        }

        for (int i = minusArray[0]; i >= minusArray[minusArray.length - 1]; i--) {

            if (i == minusArray[0]) {
                minusResult = minusArray[0];
            } else {
                minusResult = minusResult - i;
            }
            if (i == minusArray[minusArray.length - 1]) {
                calc += i;
            } else {
                calc +=  i + " - ";
            }
        }

        System.out.println(calc);
        System.out.println(minusResult);
    }

    // Add numbers between each element in the array and return total. Loops until the whole array is complete.
    static void addWholeRange(int [] array) {

        int addResult = 0, lowNum = 0, highNum = 0;
        String calc = " ";

        for (int i = 0; i < array.length - 1; i++) {

            lowNum = array[i];
            highNum = array[i+1];

            for (int j = lowNum; j <= highNum; j++) {
                addResult += j;

                if (j == highNum) {
                    calc += j;
                    System.out.println(calc);
                    System.out.println(addResult);
                    addResult = 0;
                    calc = " ";
                } else {
                    calc +=  j + " + ";
                }
            }
        }
    }

    // Find duplicated array entries and remove them.
    static int[] removeDuplicateEntries(int[] array) {

        int[] copy = new int[array.length];
        boolean found = false;

        // get unique numbers and put them in copy array

        for (int i = 0; i < array.length; i++) {
            found = false;
            for (int j = 0; j < copy.length; j++) {

                if (array[i] == copy[j]) {
                    found = true;
                }

                if (j == copy.length - 1 && !found) {
                    copy[i] = array[i];
                }
            }

        }

        // get number of zeros in copy array.
        int zeroCounter = 0;

        for (int j : copy) {

            if (j == 0) {
                zeroCounter++;
            }

        }

        Arrays.sort(copy);

        // Use zeroes found in the copy array to determine real length of the new array

        int[] returnArray = new int[copy.length - zeroCounter];
        int indexPlacement = 0;

        // Skip the zeroes and place numbers found in the old array to the new one

        for (int i = zeroCounter; i < copy.length; i++) {
            returnArray[indexPlacement] = copy[i];
            indexPlacement++;
        }

        // Final check to make sure the length of the returnArray is not < 2

        if (returnArray.length < 2) {
            System.out.println("Please use a variety of different values.");
            array = requestArray();
            returnArray = removeDuplicateEntries(array);
        }

        // Return the unique array.
       // System.out.println("Returned array is: " + Arrays.toString(returnArray));
        Arrays.sort(returnArray);
        return returnArray;

    }

    // main program.
    public static void main(String[] args) {
        int[] array;
        boolean useArray = true;

        // Check if there are enough elements in array and sort them. If not, then request them.

        if (args.length < 2 || args.length > 10) {


            String arrayElements = args.length > 10  ? "Too many elements in the array.\n" :
                    args.length < 2 ? "Too few elements in the array.\n" : "";
            System.out.println(arrayElements);

            array = requestArray();

            // Scan the array for duplicate entries, removing them and returning a new array.

            array = removeDuplicateEntries(array);

        } else {
            array = convertStringArrayToInt(args);

            // Iterate over the array to see if any values fall outside usable range. If so, request new array.

            for (int i = 0; i <= array.length - 1; i++) {

                if (array[i] > 10000 || array[i] < 0) {
                    System.out.println("A value is outside the limit of 0 and 10000. Please input new numbers...");
                    array = requestArray();
                }

            }

            // Scan the array for duplicate entries, removing them and returning a new array.

            array = removeDuplicateEntries(array);
        }

        // input handler - validation and request. requestFunction() returns a number depending on user input.

        switch (requestFunction()) {
            case 1:
                addRange(array);
                break;
            case 2:
                multiplyRange(array);
                break;
            case 3:
                divideRange(array);
                break;
            case 4:
                subtractRange(array);
                break;
            case 5:
                addWholeRange(array);
                break;
            default:
                System.out.println("How did you get here?");
                break;

        }

        Dog fido = new Dog("collie", "fido");
        Dog rover = new Dog("lab", "rover");

        System.out.println(fido.getName());
        System.out.println(fido.getBreed());

        System.out.println(rover.getName());
        System.out.println(rover.getBreed());

        fido.speak();
        rover.speak();

        List<Animal> animals = new ArrayList<>();
        animals.add(fido);
        animals.add(rover);
        animals.add(new Cat());
        animals.add(new SmallDog("Barry"));

        SmallDog small = new SmallDog("Fred");

        System.out.println(small.getBreed());

        // Look up forEach syntax! I'm pretty sure that JS has this too.

        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            animal.speak();
        }


       // animals.forEach(animal -> {
         //   animal.speak();
       // });


    }


}


/*

- look up enhanced for loops and collections (week 2 slides)
- use lists and collections instead of arrays and things.

 */

