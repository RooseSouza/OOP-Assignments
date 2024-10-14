import java.util.Scanner;

// Single Inheritance (Person -> MLA)
class Person {
    private String name;

    // Constructor
    public Person(String name) {
        this.name = name;
    }

    // Copy Constructor
    public Person(Person p) {
        this.name = p.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return "Person: " + name;
    }
}

// Hierarchical Inheritance (Person -> MLA, Person -> Governor)
class Governor extends Person {
    private String state;

    // Constructor
    public Governor(String name, String state) {
        super(name); // Call to Person's constructor
        this.state = state;
    }

    // Copy Constructor
    public Governor(Governor g) {
        super(g); // Call Person's copy constructor
        this.state = g.state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String getDescription() {
        return "Governor\nName: " + getName() + "\nState: " + state;
    }
}

// Single Inheritance: MLA extends Person
class MLA extends Person {
    private String constituency;
    private String party;

    // Constructor
    public MLA(String name, String constituency, String party) {
        super(name);  // Calling the constructor of the base class (Person)
        this.constituency = constituency;
        this.party = party;
    }

    // Copy Constructor
    public MLA(MLA m) {
        super(m);  // Call Person's copy constructor
        this.constituency = m.constituency;
        this.party = m.party;
    }

    public String getConstituency() {
        return constituency;
    }

    public void setConstituency(String constituency) {
        this.constituency = constituency;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    @Override
    public String getDescription() {
        return "MLA\nName: " + getName() + "\nConstituency: " + constituency + "\nParty: " + party;
    }
}

// Multilevel Inheritance: ChiefMinister -> MLA -> Person
class ChiefMinister extends MLA {
    private int termYears;

    // Constructor
    public ChiefMinister(String name, String constituency, String party, int termYears) {
        super(name, constituency, party);  // Calling the constructor of MLA
        this.termYears = termYears;
    }

    // Copy Constructor
    public ChiefMinister(ChiefMinister cm) {
        super(cm);  // Call MLA's copy constructor
        this.termYears = cm.termYears;
    }

    public int getTermYears() {
        return termYears;
    }

    public void setTermYears(int termYears) {
        this.termYears = termYears;
    }

    @Override
    public String getDescription() {
        return "Chief Minister\nName: " + getName() + "\nConstituency: " + getConstituency() +
               "\nParty: " + getParty() + "\nTerm Years: " + termYears;
    }
}

// Interface: Demonstrating Multiple Inheritance (via interface in Java)
interface Minister {
    String getPortfolio();
    String getDescription();
}

// Multiple Inheritance (via Interface): DeputyChiefMinister -> MLA, implements Minister
class DeputyChiefMinister extends MLA implements Minister {
    private String portfolio;

    // Constructor
    public DeputyChiefMinister(String name, String constituency, String party, String portfolio) {
        super(name, constituency, party);  // Calling MLA constructor
        this.portfolio = portfolio;
    }

    // Copy Constructor
    public DeputyChiefMinister(DeputyChiefMinister dcm) {
        super(dcm);  // Call MLA's copy constructor
        this.portfolio = dcm.portfolio;
    }

    @Override
    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public String getDescription() {
        return "Deputy Chief Minister\nName: " + getName() +
               "\nConstituency: " + getConstituency() +
               "\nParty: " + getParty() +
               "\nPortfolio: " + portfolio;
    }
}

// Hybrid Inheritance (Combining Hierarchical and Multilevel)
public class GLA_oop_concepts {
    public static void main(String[] args) {
        // Creating objects using constructors
        MLA mla1 = new MLA("Jit Arolkar", "Mandrem", "Maharashtrawadi Gomantak");
        ChiefMinister cm = new ChiefMinister("Pramod Sawant", "Sanquelim", "BJP", 5);
        DeputyChiefMinister dcm = new DeputyChiefMinister("Manohar Ajgaonkar", "Salcete", "BJP", "Tourism");
        Governor gov = new Governor("PS Sreedharan Pillai", "Goa");

        // Demonstrating copy constructors
        MLA mlaCopy = new MLA(mla1); // Copy of MLA
        ChiefMinister cmCopy = new ChiefMinister(cm); // Copy of Chief Minister
        DeputyChiefMinister dcmCopy = new DeputyChiefMinister(dcm); // Copy of Deputy Chief Minister
        Governor govCopy = new Governor(gov); // Copy of Governor

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Select an option:\n1: The Legislature \n2: The Government \n3: Governor \n4: Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleMLASelection(scanner, mla1);
                    System.out.println("MLA Copy:\n" + mlaCopy.getDescription());
                    break;

                case 2:
                    handleGovernmentSelection(scanner, cm, dcm);
                    System.out.println("Chief Minister Copy:\n" + cmCopy.getDescription());
                    System.out.println("Deputy Chief Minister Copy:\n" + dcmCopy.getDescription());
                    break;

                case 3:
                    System.out.println(gov.getDescription());
                    System.out.println("Governor Copy:\n" + govCopy.getDescription());
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Please select a valid option.");
            }
        } while (choice != 4);

        scanner.close(); // Close the scanner to prevent resource leak
    }

    // This method handles MLA options and displays their details
    private static void handleMLASelection(Scanner scanner, MLA mla) {
        System.out.println(mla.getDescription());
    }

    // This method handles Government options (Chief Minister, Deputy CM) and displays their details
    private static void handleGovernmentSelection(Scanner scanner, ChiefMinister cm, DeputyChiefMinister dcm) {
        int subChoice;
        do {
            System.out.println("Select an option:\n1: Chief Minister \n2: Deputy Chief Minister \n3: Exit");
            subChoice = scanner.nextInt();

            switch (subChoice) {
                case 1:
                    System.out.println(cm.getDescription());
                    break;

                case 2:
                    System.out.println(dcm.getDescription());
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Please select a valid option.");
            }
        } while (subChoice != 3);
    }
}
