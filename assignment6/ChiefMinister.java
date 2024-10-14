package GLAjavadoc;
/**
 * Chief minister class
 */
public class ChiefMinister extends MLA{
/**
 * 
 * @param name is the name of the Chief Minister
 * @param constituency is the constituency of the Chief Minister
 * @param party is the party of the Chief Minister
 */
    public ChiefMinister(String name, String constituency, String party) {
        super(name, constituency, party);
    }

    @Override
    /**
     * represents the info of the chief minister in String format
     */
    public String toString(){
        return "Chief Minister " + "\n"+
        "Name=" + getName() + "\n"+
        "Constituency=" + getConstituency() + "\n"+
        "Party=" + getParty()+"\n";
    
    }

    
}