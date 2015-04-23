package reservationapp;
import java.util.GregorianCalendar;
/**
 * <p>Project 13-1: Student Scores</p>
 * <ul>
 * <li>Professor: Tedd Sperling</li>
 * <li>Course: Introduction to JAVA - (22150)</li>
 * <li>Student: Paul Wilcox</li></ul>
 * <p>This program allows the user to calculate the cost of a hotel stay. It receives
 * as input the arrival and departure dates, and returns the cost for the stay
 * by multiplying the number of days in the reservation by the nightly rate.</p>
 * @author wilcoxp3
 */
public class ReservationApp 
{
    public static void main(String[] args) 
    {   
        //Print opening message
        System.out.println("Welcome to the Reservation Calculator");
        System.out.println();
        
        while (true)
        {
            //Prompt user to enter departure and arrival dates
            int arrivalMonth = Validation.getInt("Enter the arrival month (1-12): ", 1, 12);
            int arrivalDay = Validation.getInt("Enter the arrival day (1-31): ", 1, 31);
            int arrivalYear = Validation.getInt("Enter the arrival year: ", 0, 3000);
            System.out.println();
            
            int departureMonth = Validation.getInt("Enter the departure month (1-12): ", 1, 12);
            int departureDay = Validation.getInt("Enter the departure day (1-31): ", 1, 31);
            int departureYear = Validation.getInt("Enter the departure year: ", 0, 3000);
            System.out.println();
            
            //Create GregorianCalendar objects for the arrival and departure dates
            GregorianCalendar calendarArrival = new GregorianCalendar(arrivalYear, arrivalMonth - 1, arrivalDay);
            GregorianCalendar calendarDeparture = new GregorianCalendar(departureYear, departureMonth - 1, departureDay);
            
            //Create Reservation object passing the time in milliseconds for
            //arrival and departure to the constructor
            Reservation myReservation = new Reservation(calendarArrival.getTime(), calendarDeparture.getTime());
            
            //Print arrival, departure, hourly rate, and total cost to user.
            System.out.println(myReservation.toString());
            System.out.println();
            
            //Prompt user to calculate another reservation or quit.
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
