/**
 * abstract class conference (Base class)
 */
public abstract class conference {
    private String date;

    /**
     * Constructor to create conference object
     * @param date is the date
     */
    public conference(String date){
        this.date = date;
    }

    /**
     * getter for date
     * @return the date 
     */
    public String getDate(){
        return date;
    }

    /**
     * setter for date
     * @param date
     */
    public void setDate(String date){
        this.date = date;
    }

    /**
     * Abstract method toString
     */
    @Override
    public abstract String toString();

}