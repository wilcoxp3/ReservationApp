package reservationapp;
import java.util.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
/**
 * The Reservation class allows for the storage and calculation of hotel reservation
 * information. It contains fields for storing the arrival and departure date and
 * constants for the nightly room rate and the number of milliseconds in
 * a day. The constructor sets the arrival and departure dates. There are also
 * getters and setters for each field. It contains methods for calculating
 * the number of nights in the reservation and calculating the total price of the
 * reservation. This class also overrides the toString() method to return all the
 * reservation information in a readable format.
 * @author wilcoxp3
 */
public class Reservation
{
    //Date variables for arrival and departure dates
    private Date arrivalDate;
    private Date departureDate;
    
    //Constants for the nightly room rate and number of milliseconds in a day.
    private final double NIGHTLY_RATE = 115.00;
    private final long MS_PER_DAY = 1000 * 60 * 60 * 24;
    
    //Constructor for setting arrival and departure dates
    public Reservation(Date arrivalDate, Date departureDate)
    {
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
    }
    
    //Getters and setters for all fields
    public void setArrivalDate(Date arrivalDate)
    {
        this.arrivalDate = arrivalDate;
    }
    
    public Date getArrivalDate()
    {
        return arrivalDate;
    }
    
    public void setDepartureDate(Date departureDate)
    {
        this.departureDate = departureDate;
    }
    
    public Date getDepartureDate()
    {
        return departureDate;
    }
    
    //Gets the number of nights in the reservation.
    public int getNumOfNights()
    {
        long arrivalInMS = arrivalDate.getTime();
        long departureInMS = departureDate.getTime();
        long differenceInDays = (departureInMS - arrivalInMS) / (MS_PER_DAY);
        int intDifference = (int) differenceInDays;
        return intDifference;
    }
    
    //Calculates the total cost of the reservation
    public double getTotalPrice()
    {
        return NIGHTLY_RATE * this.getNumOfNights();
    }
    
    //Overrides toString to present all relevant reservation information in a
    //format readable to the user.
    @Override
    public String toString()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        DateFormat displayDate = DateFormat.getDateInstance(DateFormat.FULL);
        return "Arrival Date: " + displayDate.format(arrivalDate) + 
                "\nDeparture Date: " + displayDate.format(departureDate) +
                "\nPrice: " + currency.format(NIGHTLY_RATE) + " per night" +
                "\nTotal price: " + currency.format(this.getTotalPrice()) +
                " for " + this.getNumOfNights() + " nights";
    }
}