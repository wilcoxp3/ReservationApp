package reservationapp;
import java.util.GregorianCalendar;
public class ReservationApp 
{
    public static void main(String[] args) 
    {
        System.out.println("Welcome to the Reservation Calculator");
        System.out.println();
        
        while (true)
        {
            int arrivalMonth = Validation.getInt("Enter the arrival month (1-12): ", 1, 12);
            int arrivalDay = Validation.getInt("Enter the arrival day (1-31): ", 1, 31);
            int arrivalYear = Validation.getInt("Enter the arrival year: ", 0, 3000);
            System.out.println();
            
            int departureMonth = Validation.getInt("Enter the departure month (1-12): ", 1, 12);
            int departureDay = Validation.getInt("Enter the departure day (1-31): ", 1, 31);
            int departureYear = Validation.getInt("Enter the departure year: ", 0, 3000);
            System.out.println();
            
            GregorianCalendar calendarArrival = new GregorianCalendar(arrivalYear, arrivalMonth - 1, arrivalDay);
            GregorianCalendar calendarDeparture = new GregorianCalendar(departureYear, departureMonth - 1, departureDay);
            
            
            Reservation myReservation = new Reservation(calendarArrival.getTime(), calendarDeparture.getTime());
            
            System.out.println(myReservation.toString());
            System.out.println();
            
            if (!Validation.getContinue("Another reservation? (y/n): "))
            {
                System.out.println("Thank you for using the Reservation Calculator.");
                break;
            }
            System.out.println();
        }
        System.out.println("DONE");
    }
}
