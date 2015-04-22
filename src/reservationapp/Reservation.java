package reservationapp;
import java.util.Date;
import java.text.DateFormat;
import java.text.NumberFormat;

public class Reservation
{
    private Date arrivalDate;
    private Date departureDate;
    private final double NIGHTLY_RATE = 115.00;
    
    public Reservation(Date arrivalDate, Date departureDate)
    {
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
    }
    
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
    
    public int getNumOfNights()
    {
        long arrivalInMS = arrivalDate.getTime();
        long departureInMS = departureDate.getTime();
        long differenceInDays = (departureInMS - arrivalInMS) / (1000 * 60 * 60 * 24);
        int intDifference = (int) differenceInDays;
        return intDifference;
    }
    public double getTotalPrice()
    {
        return NIGHTLY_RATE * this.getNumOfNights();
    }
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