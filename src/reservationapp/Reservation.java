package reservationapp;
import java.util.Date;
import java.text.DateFormat;
import java.text.NumberFormat;

public class Reservation
{
    private Date arrivalDate;
    private Date departureDate;
    private Double NIGHTLY_RATE = 115.00;
    
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
        int arrivalInMS = (int) arrivalDate.getTime();
        int departureInMS = (int) departureDate.getTime();
        int differenceInDays = (int) (departureInMS - arrivalInMS) / (1000 * 60 * 60 * 24);
        return differenceInDays;
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
