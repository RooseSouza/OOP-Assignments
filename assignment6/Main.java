//author: Roosevelt Desouza
//Rollno: 2436
//Title: Goa Legislative Assembly OOP concepts
//Start Date: 15 july 2024
//Modified Date: 15 july 2024
//Descrition: To go through the Goa Legislative Assembly website and find OOP concepts and implement them in java
package GLAjavadoc;
import java.util.Scanner;

/**
  * creats MLA objects and  Chief Minister object and provides a menu for selecting options using a switch case.
  * is used to see the info of the MLAs or Chief Minister
  */
public class Main{
    /**
     * Main class
     * @param args command line arguments
     */
 
    public static void main(String[] args) {
        MLA mla1 = new MLA("Jit Arolkar", "Mandrem", "Maharashtrawadi Gomantak");
        MLA mla2 = new MLA("Pravin Arlekar", "Pernem","BJP");
        ChiefMinister cm = new ChiefMinister("Pramod Sawant", "Sanquelim", "BJP");
    
        Scanner obj = new Scanner(System.in);

        int ch1;
        do {
            System.out.println("Select an option:\n1: The Legislature \n2: The Government \n3: Exit");

            ch1 = obj.nextInt();
            switch (ch1) {
                case 1:
                    int ch2;
                    do {
                        System.out.println("Select an option:\n1: M.L.A \n2: Exit");
                        ch2 = obj.nextInt();
                        switch (ch2) {
                            case 1:
                                System.out.println(mla1);
                                System.out.println(mla2);
                                break;
                            case 2:
                                System.out.println("********************Exiting********************");
                                break;
                            default:
                                System.out.println("Please select a valid option.");
                        }
                    } while (ch2 != 2);
                    break;

                case 2:
                    int ch3;
                    do {
                        System.out.println("Select an option:\n1: Chief Minister \n2: Exit");
                        ch3 = obj.nextInt();
                        switch (ch3) {
                            case 1:
                                System.out.println(cm);
                                break;
                            case 2:
                                System.out.println("Exiting");
                                break;
                            default:
                                System.out.println("Please select a valid option.");
                        }
                    } while (ch3 != 2);
                    break;

                case 3:
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("Please select a valid option.");
            }
        } while (ch1 != 3);

        obj.close();
    }
}