import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class
 */
public class main {
    /**
     * Main constructor to display Menu
     * @param args
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int ch;

        ICON i1 = new ICON("14 December 2024", 2, 1, 6, 10);
        ICON i2 = new ICON("15 December 2024", 2, 0, 6, 10);
        ICON i3 = new ICON("16 December 2024", 2, 0, 6, 10);
        ICON i4 = new ICON("17 December 2024", 2, 0, 6, 10);

        FIRE f1 = new FIRE("15 December 2024", 1, 6, 5);
        FIRE f2 = new FIRE("16 December 2024", 0, 6, 5);
        FIRE f3 = new FIRE("17 December 2024", 1, 6, 5);
        FIRE f4 = new FIRE("18 December 2024", 0, 0, 5);
        try{
            do{

                print("Menu to display the schedule of the upcoming conferences hosted by Discipline of Conputer Sciences and Technology.");
                print("Please choose one option: (1, 2, 3)");
                print("1. Display schedule of ICON conference\n2. Display schedule of FIRE conference.\n3. Exit program.");

                ch = s.nextInt();
                    switch (ch) {
                        case 1: 
                                System.out.println(i1);
                                System.out.println(i2);
                                System.out.println(i3);
                                System.out.println(i4);
                            break;

                        case 2:
                                
                                System.out.println(f1);
                                System.out.println(f2);
                                System.out.println(f3);
                                System.out.println(f4);
                            
                            break;

                        case 3:
                                print("Exiting...");
                            
                            break;
                        default:
                            print("Please enter 1, 2 or 3.");
                    }

            }while(ch != 3);

        }catch(InputMismatchException e){
            System.err.println("Invalid Input: "+e.toString());
        }
    }


    /**
     * Method to print a string
     * @param a is the string that is printed
     */
    public static void print(String a){
        System.err.println(a);
    }
}


