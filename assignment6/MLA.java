package GLAjavadoc;
/**
 * MLA class
 */
public class MLA {
    private String name;
    private String constituency;
    private String party;

    /**
     * @param name is the name of the MLA
     * @param constituency is the constituency of the MLA
     * @param party is the party of the MLA
    */
    public MLA(String name, String constituency, String party){
        this.name = name;
        this.constituency = constituency;
        this.party = party;
    }

    /**
     * gets the name
     */
    public String getName(){
        return name;
    }
    
    /**
     * gets the constituency
     */
    public String getConstituency(){
        return constituency;
    }
    
    /**
     * gets the party
     */
    public String getParty(){
        return party;
    }

    /**
     * sets the name
     */
    public void setName(String name){
        this.name = name;
    }
   
    /**
     * sets the party
     */
    public void setParty(String party){
        this.party = party;
    }
    
    /**
     * sets the constituency
     */
    public void setConstituency(String constituency){
        this.constituency = constituency;
    }

    @Override
    /**
     * represents the MLA info in string format
     */
    public String toString(){
        return "MLA " + "\n"+
        "Name=" + name + "\n"+
        "Constituency=" + constituency + "\n"+
        "Party=" + party+ "\n";
    
    }

}