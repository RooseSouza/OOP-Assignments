/**
 * FIRE class which extends from the base class conference
 */
public class FIRE extends conference{
    private int workshops, papers, posters;

    /**
     * Constructor to create FIRE object
     * @param date is the date
     * @param workshops is the number of workshops
     * @param papers is the number of papers
     * @param posters is the number of papers
     */
    public FIRE(String date, int workshops, int papers, int posters){
        super(date);
        this.workshops = workshops;
        this.papers = papers;
        this.posters = posters;

    }

    /**
     * getter for workshops
     * @return the number of workshops
     */
    public int getWorkshops(){
        return workshops;
    }

    /**
     * getter for papers
     * @return the number of papers
     */
    public int getPapers(){
        return papers;
    }

    /**
     * getter for posters
     * @return the number of posters
     */
    public int getPosters(){
        return posters;
    }

    /**
     * setter for workshops
     * @param workshops
     */
    public void setWorkshops(int workshops){
        this.workshops = workshops;
    }

    /**
     * setter for workshops
     * @param workshops
     */
    public void setPapers(int papers){
        this.papers = papers;
    }

    /**
     * setter for workshops
     * @param workshops
     */
    public void setPosters(int posters){
        this.posters = posters;
    }

    /**
     * Method to return a String
     */
    @Override
    public String toString(){
        if(getWorkshops() == 0){

            return "FIRE conference scheduled on "+getDate()+". \n"+ 
            "Schedule: \n" +
            "Inaugurations: from 8am to 8:30am. \n" +
            "************* 1 hour break *************\n" +
            getPapers()+ " Paper Presentations from 9:30am to 12:30pm (3 hours)\n" +
            "************* 1 hour break *************\n" +
            getPosters()+ " Poster Presentations from 1:30pm to 2:30pm " +"\n";

        }else if (getWorkshops() == 0 && getPapers() == 0){

            return "FIRE conference scheduled on "+getDate()+". \n"+ 
            "Schedule: \n" +
            "Inaugurations: from 8am to 8:30am. \n" +
            "************* 1 hour break *************\n" +
            getPosters()+ " Poster Presentations from 9:30pm to 10:30pm " +"\n";

        }else {
            
            return "FIRE conference scheduled on "+getDate()+". \n"+ 
            "Schedule: \n" +
            "Inaugurations: from 8am to 8:30am. \n" +
            "************* 1 hour break *************\n" +
            getWorkshops()+ " Workshops from 9:30am to 10am" + "\n" +
            "************* 1 hour break *************\n" +
            getPapers()+ " Paper Presentations from 11am to 2pm (3 hours)\n" +
            "************* 1 hour break *************\n" +
            getPosters()+ " Poster Presentations from 3pm to 4pm " +"\n";
        }
        
        
    }
}
