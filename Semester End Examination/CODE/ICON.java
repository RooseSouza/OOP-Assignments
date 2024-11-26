/**
 * ICON class which extends from the base class FIRE
 */
public class ICON extends FIRE {
    private int tutorials;

    /**
     * Constructor to create FIRE object
     * @param date is the date
     * @param tutorials is the number of tutorials
     * @param workshops is the number of workshops
     * @param papers is thenumber of papers
     * @param posters is the number of posters
     */
    public ICON(String date, int tutorials, int workshops, int papers, int posters){
        super(date, workshops, papers, posters);
        this.tutorials = tutorials;
    }

    /**
     * getter for tutorials
     * @return the number of tutorials
     */
    public int getTutorials(){
        return tutorials;
    }

    /**
     * setter for tutorials
     * @param tutorials
     */
    public void setTutorials(int tutorials){
        this.tutorials = tutorials;
    }

    /**
     * Method to return a String
     */
    @Override
    public String toString(){
        if(getWorkshops() == 0){
            
            return "ICON conference scheduled on "+getDate()+". \n"+ 
            "Schedule: \n" +
            "Inaugurations: from 8am to 8:30am. \n" +
            "************* 1 hour break *************\n" +
            tutorials+ " Tutorials from 9:30am to 10am" + "\n" +
            "************* 1 hour break *************\n" +
            getPapers()+ " Paper Presentations from 11am to 2pm (3 hours)\n" +
            "************* 1 hour break *************\n" +
            getPosters()+ " Poster Presentations from 3pm to 4pm " +"\n";

        }else{

            return "ICON conference scheduled on "+getDate()+". \n"+ 
            "Schedule: \n" +
            "Inaugurations: from 8am to 8:30am. \n" +
            "************* 1 hour break *************\n" +
            tutorials+ " Tutorials from 9:30am to 10am" + "\n" +
            "************* 1 hour break *************\n" +
            getWorkshops()+ " Workshops from 11am to 12am" + "\n" +
            "************* 1 hour break *************\n" +
            getPapers()+ " Paper Presentations from 1am to 4pm (3 hours)\n" +
            "************* 1 hour break *************\n" +
            getPosters()+ " Poster Presentations from 5pm to 6pm " +"\n";

        }
        
    }
    
}
