#include <iostream>
#include <string>
using namespace std;

class MLA {
private:
    string name;
    string constituency;
    string party;

public:
    MLA(string name, string constituency, string party) {
        this->name = name;
        this->constituency = constituency;
        this->party = party;
    }

    string getName() {
        return name;
    }

    string getConstituency() {
        return constituency;
    }

    string getParty() {
        return party;
    }

    void setName(string name) {
        this->name = name;
    }

    void setParty(string party) {
        this->party = party;
    }

    void setConstituency(string constituency) {
        this->constituency = constituency;
    }

    virtual void display() {
        cout << "MLA\n" 
             << "Name: " << name << "\n"
             << "Constituency: " << constituency << "\n"
             << "Party: " << party << "\n";
    }
};

class ChiefMinister : public MLA {
public:
    ChiefMinister(string name, string constituency, string party)
        : MLA(name, constituency, party) {}

    void display() override {
        cout << "Chief Minister\n"
             << "Name: " << getName() << "\n"
             << "Constituency: " << getConstituency() << "\n"
             << "Party: " << getParty() << "\n";
    }
};

int main() {
    MLA mla1("Jit Arolkar", "Mandrem", "Maharashtrawadi Gomantak");
    MLA mla2("Pravin Arlekar", "Pernem", "BJP");
    ChiefMinister cm("Pramod Sawant", "Sanquelim", "BJP");

    int ch1, ch2, ch3;
    do {
        cout << "Select an option:\n1: The Legislature \n2: The Government \n3: Exit\n";
        cin >> ch1;

        switch (ch1) {
        case 1:
            do {
                cout << "Select an option:\n1: M.L.A \n2: Exit\n";
                cin >> ch2;
                switch (ch2) {
                case 1:
                    mla1.display();
                    mla2.display();
                    break;
                case 2:
                    cout << "********************Exiting********************\n";
                    break;
                default:
                    cout << "Please select a valid option.\n";
                }
            } while (ch2 != 2);
            break;

        case 2:
            do {
                cout << "Select an option:\n1: Chief Minister \n2: Exit\n";
                cin >> ch3;
                switch (ch3) {
                case 1:
                    cm.display();
                    break;
                case 2:
                    cout << "Exiting\n";
                    break;
                default:
                    cout << "Please select a valid option.\n";
                }
            } while (ch3 != 2);
            break;

        case 3:
            cout << "Exiting\n";
            break;

        default:
            cout << "Please select a valid option.\n";
        }
    } while (ch1 != 3);

    return 0;
}
