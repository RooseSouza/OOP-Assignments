// Author: Roosevelt Desouza
// Rollno: 2436
// Title: Goa Legislative Assembly OOP concepts
// Start Date: 15 July 2024
// Modified Date: 15 July 2024
// Description: To go through the Goa Legislative Assembly website and find OOP concepts and implement them in C#

using System;

class MLA
{
    // Private members for encapsulation
    private string name;
    private string constituency;
    private string party;

    // Constructor
    public MLA(string name, string constituency, string party)
    {
        this.name = name;
        this.constituency = constituency;
        this.party = party;
    }

    // Copy Constructor
    public MLA(MLA other)
    {
        this.name = other.name;
        this.constituency = other.constituency;
        this.party = other.party;
    }

    // Public methods to get the private data
    public string GetName() { return name; }
    public string GetConstituency() { return constituency; }
    public string GetParty() { return party; }

    // Public methods to set the private data
    public void SetName(string name) { this.name = name; }
    public void SetConstituency(string constituency) { this.constituency = constituency; }
    public void SetParty(string party) { this.party = party; }

    // Overriding the ToString method
    public override string ToString()
    {
        return $"MLA\nName: {name}\nConstituency: {constituency}\nParty: {party}\n";
    }
}

// Derived class using single inheritance
class ChiefMinister : MLA
{
    // Constructor calling base class constructor
    public ChiefMinister(string name, string constituency, string party) : base(name, constituency, party) {}

    // Copy Constructor
    public ChiefMinister(ChiefMinister other) : base(other) {}

    // Overriding ToString method
    public override string ToString()
    {
        return $"Chief Minister\nName: {GetName()}\nConstituency: {GetConstituency()}\nParty: {GetParty()}\n";
    }
}

class Program
{
    static void Main(string[] args)
    {
        // Creating MLA and Chief Minister objects
        MLA mla1 = new MLA("Jit Arolkar", "Mandrem", "Maharashtrawadi Gomantak");
        MLA mla2 = new MLA("Pravin Arlekar", "Pernem", "BJP");
        ChiefMinister cm = new ChiefMinister("Pramod Sawant", "Sanquelim", "BJP");

        // Copy constructor usage
        MLA copiedMLA = new MLA(mla1);

        int ch1;
        do
        {
            Console.WriteLine("Select an option:\n1: The Legislature \n2: The Government \n3: Exit");
            ch1 = int.Parse(Console.ReadLine());

            switch (ch1)
            {
                case 1:
                    int ch2;
                    do
                    {
                        Console.WriteLine("Select an option:\n1: M.L.A \n2: Exit");
                        ch2 = int.Parse(Console.ReadLine());
                        switch (ch2)
                        {
                            case 1:
                                Console.WriteLine(mla1);
                                Console.WriteLine(mla2);
                                Console.WriteLine("Copied MLA Details:");
                                Console.WriteLine(copiedMLA); // Using the copied MLA object
                                break;
                            case 2:
                                Console.WriteLine("********************Exiting********************");
                                break;
                            default:
                                Console.WriteLine("Please select a valid option.");
                                break;
                        }
                    } while (ch2 != 2);
                    break;

                case 2:
                    int ch3;
                    do
                    {
                        Console.WriteLine("Select an option:\n1: Chief Minister \n2: Exit");
                        ch3 = int.Parse(Console.ReadLine());
                        switch (ch3)
                        {
                            case 1:
                                Console.WriteLine(cm);
                                break;
                            case 2:
                                Console.WriteLine("Exiting");
                                break;
                            default:
                                Console.WriteLine("Please select a valid option.");
                                break;
                        }
                    } while (ch3 != 2);
                    break;

                case 3:
                    Console.WriteLine("Exiting");
                    break;

                default:
                    Console.WriteLine("Please select a valid option.");
                    break;
            }
        } while (ch1 != 3);
    }
}
