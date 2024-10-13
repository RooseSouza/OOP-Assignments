//author: Roosevelt Desouza
//Rollno: 2436
//Title: Goa Legislative Assembly OOP concepts
//Start Date: 15 July 2024
//Modified Date: 15 July 2024
//Description: To go through the Goa Legislative Assembly website and find OOP concepts and implement them in Java

import java.util.Scanner;

/**
 * The MLA class represents a Member of the Legislative Assembly (MLA).
 * It includes details such as name, constituency, and party.
 */
class MLA {
    private String name;
    private String constituency;
    private String party;

    /**
     * Constructor to initialize MLA object.
     *
     * @param name         the name of the MLA
     * @param constituency the constituency of the MLA
     * @param party        the party the MLA belongs to
     */
    public MLA(String name, String constituency, String party) {
        this.name = name;
        this.constituency = constituency;
        this.party = party;
    }

    /**
     * Gets the name of the MLA.
     *
     * @return the name of the MLA
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the constituency of the MLA.
     *
     * @return the constituency of the MLA
     */
    public String getConstituency() {
        return constituency;
    }

    /**
     * Gets the party of the MLA.
     *
     * @return the party of the MLA
     */
    public String getParty() {
        return party;
    }

    /**
     * Sets the name of the MLA.
     *
     * @param name the new name of the MLA
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the party of the MLA.
     *
     * @param party the new party of the MLA
     */
    public void setParty(String party) {
        this.party = party;
    }

    /**
     * Sets the constituency of the MLA.
     *
     * @param constituency the new constituency of the MLA
     */
    public void setConstituency(String constituency) {
        this.constituency = constituency;
    }

    /**
     * Returns a string representation of the MLA object.
     *
     * @return the details of the MLA
     */
    @Override
    public String toString() {
        return "MLA " + "\n" +
               "Name=" + name + "\n" +
               "Constituency=" + constituency + "\n" +
               "Party=" + party + "\n";
    }
}

/**
 * The ChiefMinister class is a subclass of MLA representing the Chief Minister.
 */
class ChiefMinister extends MLA {

    /**
     * Constructor to initialize ChiefMinister object.
     *
     * @param name         the name of the Chief Minister
     * @param constituency the constituency of the Chief Minister
     * @param party        the party the Chief Minister belongs to
     */
    public ChiefMinister(String name, String constituency, String party) {
        super(name, constituency, party);
    }

    /**
     * Returns a string representation of the Chief Minister object.
     *
     * @return the details of the Chief Minister
     */
    @Override
    public String toString() {
        return "Chief Minister " + "\n" +
               "Name=" + getName() + "\n" +
               "Constituency=" + getConstituency() + "\n" +
               "Party=" + getParty() + "\n";
    }
}

/**
 * The Main class to run the program.
 * It displays options to view MLA and Chief Minister details.
 */
public class javadoc {
    public static void main(String[] args) {
        MLA mla1 = new MLA("Jit Arolkar", "Mandrem", "Maharashtrawadi Gomantak");
        MLA mla2 = new MLA("Pravin Arlekar", "Pernem", "BJP");
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

        obj.close(); // Close the Scanner object to prevent resource leak
    }
}
