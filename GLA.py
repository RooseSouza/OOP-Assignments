class MLA:
    def __init__(self, name, constituency, party):
        self.name = name
        self.constituency = constituency
        self.party = party

    def __str__(self):
        return f"MLA\nName: {self.name}\nConstituency: {self.constituency}\nParty: {self.party}"

class ChiefMinister(MLA):
    def __init__(self, name, constituency, party):
        super().__init__(name, constituency, party)

    def __str__(self):
        return f"Chief Minister\nName: {self.name}\nConstituency: {self.constituency}\nParty: {self.party}"

def main():
    mla1 = MLA("Jit Arolkar", "Mandrem", "Maharashtrawadi Gomantak")
    mla2 = MLA("Pravin Arlekar", "Pernem", "BJP")
    cm = ChiefMinister("Pramod Sawant", "Sanquelim", "BJP")

    while True:
        print("Select an option:\n1: The Legislature \n2: The Government \n3: Exit")
        choice = int(input())

        if choice == 1:
            while True:
                print("Select an option:\n1: M.L.A \n2: Exit")
                ch2 = int(input())
                if ch2 == 1:
                    print(mla1)
                    print(mla2)
                elif ch2 == 2:
                    print("********************Exiting********************")
                    break
                else:
                    print("Please select a valid option.")

        elif choice == 2:
            while True:
                print("Select an option:\n1: Chief Minister \n2: Exit")
                ch3 = int(input())
                if ch3 == 1:
                    print(cm)
                elif ch3 == 2:
                    print("Exiting")
                    break
                else:
                    print("Please select a valid option.")

        elif choice == 3:
            print("Exiting")
            break

        else:
            print("Please select a valid option.")

if __name__ == "__main__":
    main()
