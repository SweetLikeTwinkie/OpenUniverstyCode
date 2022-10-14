/**
 * Matala 13 - Using a class to Represents a flights schedule. A Airport object is represented 
 * by the origin city.
 *
 * @author Slava Tashlyk
 * @version 12.04.2022
 */
public class Airport
{
    private Flight[] _flightsSchedule;
    private int _noOfFlights; // Represent the Flight[] index.
    private String _city;
    /**
     * Max flights in one flight schedule.
     */
    final int MAX_FLIGHTS = 200; //
    private final int MAX_HOUR = 23, MAX_MIN = 59; // Max hour and minute for compare and replace.
    /**
     * Constructor for an airport object. who gets the name of the city 
     * where the airport is located and initializes the features of 
     * the flight class so that the flight array will be at maximum size and 
     * the number of flights is 0.
     * @param city - The name of the city where the airport is located.
     */
    public Airport (String city)
    {
        _flightsSchedule = new Flight[MAX_FLIGHTS]; // Create a new flight object.
        _noOfFlights = 0; // Set the amount of flights in schedule to 0.
        _city = city;
    }

    /**
     * Add a flight to the flight Schedule.
     * If the number of flights exeeds the maximum capacity, no flights are added and 
     * false is returned. If the flight added seccessfully return ture.
     * If the origin or the destition not the same as the airport city return false.
     * @param f - The Flight to be added to this flights schedule.
     * @return - True if the flight added successfully to the flights schedule and False if not.
     */
    public boolean addFlight (Flight f)
    {
        if (_noOfFlights < MAX_FLIGHTS) // Check if amount of flights less then defined max flights.
        {
            if (f.getDestination().equals(_city) || f.getOrigin().equals(_city)) // Check if the origin or the departure city is the airport location
            {
                _flightsSchedule[_noOfFlights] = new Flight(f); // Add new flight to flights schedule.
                _noOfFlights++; // add +1 to amount of indexes in the array.
                return true;
            }
        }
        return false;
    }

    /**
     * Remove a flight from flight schedule.
     * @param f - The Flight.
     * @return - True if the flights removed seccesfully from the flights schedule and false if not.
     */
    public boolean removeFlight(Flight f)
    {
        boolean result = false; // Boolean flag.
        for (int i = 0; i < this._noOfFlights; i++) // Loop goes over all indexes of the array.
        {
            if (this._flightsSchedule[i].equals(f)) // Check if paramater equals to the content of the array.
            {
                if (i != this._noOfFlights - 1) // Check if concrate index is not the last index in the array.
                {
                    Flight tempFlight = new Flight(_flightsSchedule[i + 1]); // Create a temporary object to hold the next flight in schedule.
                    _flightsSchedule[i + 1] = _flightsSchedule[i]; // Change the content of the content that we move forward.
                    _flightsSchedule[i] = tempFlight; // replace the old position with the temporary object (move it backward).
                }
                else // Check if it the last object in the array.
                {
                    _flightsSchedule[i] = null; // Change the content to null.
                    _noOfFlights--; // Substract -1 from amount of indexes.
                    result = true; // Change the boolean flag.
                }
            }
        }
        return result; // Return the boolean flag True/False.
    }

    /**
     * Return the time of the first flight from the choosen origin city.
     * @param place - The Origin city.
     * @return The the time of the first flight form the origin.
     */
    public Time1 firstFlightFromOrigin (String place)
    {
        if (_flightsSchedule[0] != null) // Check if there any flights in the schedule.
        {
            Time1 firstFlightTime = new Time1(MAX_HOUR,MAX_MIN); // Create Time1 object to compare with and for replace with the first flight from choosen origin.
            for (int i = 0; i < _noOfFlights; i++) // Loop goes over all indexes of the array.
            {
                if(_flightsSchedule[i].getOrigin().equals(place) && _flightsSchedule[i].getDeparture().before(firstFlightTime))
                {
                    firstFlightTime = new Time1(_flightsSchedule[i].getDeparture()); // Create copy of object Time1.
                }
            }
            return firstFlightTime; // Return the flight departure time of the first flight from origin.
        }
        return null; // If there no flights in schedule return null.
    }

    /**
     * Return the amount full flights in the flights schedule.
     * @return The count of how many full flights in the schedule.
     */
    public int howManyFullFlights()
    {
        int count = 0; // Set count to 0.
        for (int i = 0; i < this._noOfFlights; i++) // Loop that goes over all indexes in the array.
        {
            if (_flightsSchedule[i].getIsFull() == true) // Check if the flight is full.
            {
                count ++; // Add + 1 to the count.
            }
        }
        return count; // Return the count.
    }

    /**
     * Count how much flights arrive or departure between place parameter and airport city
     * @param place - Name of city.
     * @return The amount of how much flights arrive or departure between place parameter and airport city.
     */
    public int howManyFlightsBetween (String place)
    {
        int count = 0; // // Set count to 0.
        for (int i = 0; i < this._noOfFlights; i++) // Loop that goes over all indexes in the array.
        {
            // Check if origin place and airport city equal to origin and deparutre in flights schedule.
            if(_flightsSchedule[i].getOrigin().equals(_city) && _flightsSchedule[i].getDestination().equals(place) ||
                    _flightsSchedule[i].getOrigin().equals(place) && _flightsSchedule[i].getDestination().equals(_city))
            {
                count++; // Add + 1 to the count.
            }
        }
        return count;
    }

    /**
     * calculate how much the same destination appear in the flight schedule.
     * @return The string of the most popular Destination flight.
     */
    public String mostPopularDestination()
    {
        if (this._flightsSchedule[0] != null) // Check if there any flights in the schedule.
        {
            int count; // Flag to make next iteration..
            int max = 0; // Count how much the Destionation appear in the schedule as the departure. 
            String str = new String(""); // String for the flight representation.
            for (int i = 0; i < _noOfFlights; i++) // Loop that goes over all indexes in the array.
            {
                count = 1; // Set the count to 1 for next checks.
                for (int j = 0; j < _noOfFlights; j++) // Loop that goes over all indexes in the array.
                {
                    if (i == j) // If the loops at the same indexes of flight arrays.
                    {
                        continue; // countine the second loop.
                    }
                    // If the destination of the first loop same as destination of the second loop. 
                    if (_flightsSchedule[i].getDestination().equals(_flightsSchedule[j].getDestination()))
                    {
                        count += 1; // Add to count +1.
                    }
                    else // If not.
                    {
                        count = 0; // Set count to 0.
                    }
                }
                if (count > max) // If the city found one time and more.
                {
                    max = count; // Set max with count of how much the destination appear in the schedule.
                    str = new String(_flightsSchedule[i].getDestination()); // Change the String to the post popular destination.
                }
            }
            return new String(str); // Return the most popular desitiantion of the flights schedule.
        }
        return null; // If there no flights in schedule return null.
    }

    /**
     * Return The string of the most expensive ticket. If no flights in the flights 
     * schedule return null.
     * @return The string of the most expensive ticket
     */
    public Flight mostExpensiveTicket()
    {
        if (_flightsSchedule[0] != null) // Check if there any flights in the schedule.
        {
            Flight f = new Flight(_flightsSchedule[0]); // Create a copy of the object.
            int max = f.getPrice(); // Create a var that hold the ticket price.
            for (int i = 1; i < _noOfFlights; i++) // Loop that goes over all indexes in the array.
                if (_flightsSchedule[i].getPrice() > max) // Check if concrate flight more expensive then max.
                {
                    f = new Flight(_flightsSchedule[i]); // Save the flight for next comparison.
                    max = f.getPrice(); // Save the price for next comparison.
                }
            return new Flight(f); // return the most expenisve flight.
        }
        return null;
    }

    /**
     * Colculate the flight with max flight duration
     * @return The flight with max flight duration.
     */
    private Flight maxDuration (Flight a, Flight b)
    {
        if (a.getFlightDuration() > b.getFlightDuration()) // Compare flight duration beetween 2 flights.
        {
            return new Flight(a); // Return flight a.
        }
        else
            return new Flight(b); // Return flight b.
    }

    /**
     * Return the longest flight in the schedule. if there no flights in the schedule return null.
     * @return The String of the longest flight in the schedule. or null if there no flights in the schedule.
     */
    public Flight longestFlight()
    {
        if (_flightsSchedule[0] != null) // Check if there any flights in the schedule. 
        {
            Flight maxFlight = new Flight(_flightsSchedule[0]); // Create a copy of a flight;
            for (int i = 1; i < _noOfFlights && _flightsSchedule[i] != null; i++) // Loop that goes over all indexes of the array.
            {
                maxFlight = new Flight(maxDuration(_flightsSchedule[i], maxFlight)); // Find the longest flight in the array.
            }
            return new Flight(maxFlight); // Return the copy of the longest flight.
        }
        return null;
    }

    /**
     * Return a string representation of flight schedule. In format:
     * "The flights for airport [city] today are: "
     * @return String representation of flight schedule.
     */
    public String toString()
    {
        String scheduleInfo = "The flights for airport " + _city + " today are:\n"; // String format.
        if (_noOfFlights != 0) // Check if there any flights in the schedule.
        {
            for (int i = 0; i < _noOfFlights; i++) // Loop goes over all indexes of the array.
            {
                scheduleInfo += _flightsSchedule[i]; // Add the content of the object to the string.
                scheduleInfo += "\n"; // Skip to next line.
            }
        }
        else
            return null; // If there no flights in schedule return null.
        return scheduleInfo; // Return the full String.
    }
}    