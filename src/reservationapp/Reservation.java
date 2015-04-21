package reservationapp;
import java.util.Date;
import java.text.DateFormat;
import java.util.GregorianCalendar;

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
        
    }
}
