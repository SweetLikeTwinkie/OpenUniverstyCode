/**
 * Matala 12 - Using a class to Represents a flight. A Flight object is represented 
 * by the flight's origin, destination,d eparture time, flight duration, number of passengers,
 * if it is full and the price.
 * 
 * @author Slava Tashlyk
 * @version 28.03.2022
 */
public class Flight
{
    private String _origin;
    private String _destination;
    private Time1 _departure;
    private int _flightDuration;
    private int _noOfPassengers;
    private boolean _isfull;
    private int _price;
    final int MAX_CAPACITY = 250;
    /**
     * Constructor for a Flight object. If the number of passengers exceeds the maximum capacity the number of 
     * passengers will be set to the maxmum capacity If the number of passengers is negative the number of 
     * passengers will be set to zero. If the flight duration is negative the flight duration will be set 
     * to zero. If the price is negative the price will be set to zero.
     * 
     * @param origin - The city the flight leaves from.
     * @param destination - The city the flight lands at.
     * @param departureHour - The departure hour.
     * @param departureMinute - The departure Minute.
     * @param flightDuration - The duration time in minutes.
     * @param noOfPass - The number of passengers.
     * @param price - The price.
     */
    public Flight (String origin, String destination, int departureHour, int departureMinute, int flightDuration, int noOfPassengers, int price)
    {
        _origin = origin;
        _destination = destination;
        _departure = new Time1(departureHour,departureMinute);
        if (flightDuration < 0)
        {
            _flightDuration = 0;
        }
        else 
        {
            _flightDuration = flightDuration;
        }
        if (noOfPassengers < MAX_CAPACITY)
        {
            _noOfPassengers = noOfPassengers;
        }
        else if (noOfPassengers < 0)
        {
            _noOfPassengers = 0;
            _isfull = false;
        }
        else
        {
            _noOfPassengers = MAX_CAPACITY;
            _isfull = true;
        }
        if (price < 0)
        {
            _price = 0;
        }
        else
        {
            _price = price;
        }
    }
    /**
     * Copy Constructor.
     * @param other to be copied.
     */
    public Flight (Flight other)
    {
        _origin = other._origin;
        _destination = other._destination;
        _departure = other._departure;
        _flightDuration = other._flightDuration;
        _noOfPassengers = other._noOfPassengers;
        _isfull = other._isfull;
        _price = other._price;
    }
    /**
     * Gets the flight origin.
     * @return the flight origin.
     */ 
    public String getOrigin() 
    {
        return _origin;
    }
    /**
     * Gets the flight destination.
     * @return The flight destination.
     */
    public String getDestination()
    {
        return _destination;
    }
    /**
     * Get the departure time.
     * @return The departure time (HH:MM format).
     */
    public Time1 getDeparture()
    {
        return _departure;
    }
    /**
     * Get the flight duration time.
     * @return The flight duration time.
     */
    public int getFlightDuration()
    {
        return _flightDuration;
    }
    /**
     * Get the number of the passangers on the flight.
     * @return The number of passangers.
     */

    public int getNoOfPassengers()
    {
        return _noOfPassengers;
    }
    /**
     * Check if the flight is full or not.
     * @return True if the flight is full.
     */
    public boolean getIsFull()
    {
        return _isfull;
    }
    /**
     * Check the price of the flight.
     * @return The price.
     */
    public int getPrice()
    {
        return _price;
    }
    /**
     * Changes the flight's destination.
     * @param dest - The flight's new destination.
     */
    public void setDestination(String dest)
    {
        _destination = dest;
    }
    /**
     * Changes the flight's origin.
     * @param origin - The flight's new origin
     */
    public void setOrigin(String origin)
    {
        _origin = origin;
    }
    /**
     * Changes the flight's departure time.
     * @param departureTime - The flight's new departure time.
     */
    public void setDeparture(Time1 departureTime)
    {
        _departure = departureTime;
    }
    /**
     * Changes the flight's duration time. If the parameter is negative 
     * the duration time will remain unchanged.
     * @param durTimeMinutes - The flight's new duration time.
     */
    public void setFlightDuration(int durTimeMinutes)
    {
        if (durTimeMinutes >= 0)
        {
            _flightDuration = durTimeMinutes;
        }
    }
    /**
     * Changes the number of passengers. If the parameter is negative or 
     * larger than the maximum capacity the number of passengers will 
     * remain unchanged.
     * @param noOfPass - The new number of passengers.
     */
    public void setNoOfPassengers(int noOfPass)
    {
        if (noOfPass < MAX_CAPACITY)
        {
            _noOfPassengers = noOfPass;
            _isfull = false;
        }
        else if (noOfPass == MAX_CAPACITY)
        {
            _noOfPassengers = noOfPass;
            _isfull = true;
        }
    }
    /**
     * Changes the flight price. If the parameter is negative the price 
     * will remain unchanged.
     * @param price - The new price.
     */
    public void setPrice(int price)
    {	
        if (price >= 0)
        {
            _price = price;
        }
    }
    /**
     * Check if the received flight is equal to this flight. Flights are considered 
     * equal if the origin, destination and departure times are the same.
     * @param  other - The flight to be compared with this flight.
     * @return True if the received flight is equal to this flight.
     */ 
    public boolean equals(Flight other)
    {
        return this == other;
    }
    /**
     * Get the arrival time of the flight.
     * @return The arrival time of this flight (HH:MM format).
     */
    public Time1 getArrivalTime()
    {
        return _departure.addMinutes(_flightDuration);
    }
    /**
     * Add passengers to this flight. If the number of passengers exceeds he maximum 
     * capacity, no passengers are added and else is returned. If the flight becomes 
     * full, the boolean attribute describing whether the flight if full becomes true.
     * @param num - The number of passengers to be added to this flight.
     * @return True if the passengers were added to the flight.
     */
    public boolean addPassengers(int num)
    {
        if(_noOfPassengers + num < MAX_CAPACITY)
        {
            _noOfPassengers += num;
            return true;
        }
        else if(_noOfPassengers + num == MAX_CAPACITY)
        {
            _noOfPassengers += num;
            _isfull = true;
            return true;        	
        }
        return false;
    }
    /**
     * Check if this flight is cheaper than another flight.
     * @param other - The flight whose price is to be compared with this flight's price.
     * @return True if this flight is cheaper than the received flight.
     */
    public boolean isCheaper(Flight other)
    {
        return _price < other._price;
    }
    /**
     * Calculate the total price of the flight.
     * @return The total price of the flight.
     */
    public int totalPrice()
    {
        return _noOfPassengers * _price;
    }
    /**
     * Check if this flight lands before another flight. Note - the flights 
     * may land on different days, the method checks which flight lands first.
     * @param other - The flight whose arrival time to be compared with this 
     * flight's arrival time.
     * @return True if this flight arrives before the received flight.
     */
    public boolean landsEarlier(Flight other)
    {
        return getArrivalTime().before(other.getArrivalTime());
    }
    /**
     * Return a string representation of this flight in this format:
     * "Flight from London to Paris departs at 09:24.Flight is full."
     * @return String representation of this flight.
     */
    public String toString()
    {
        String flightInfo = "Flight from " + _origin + " to " + _destination + " departs at " + _departure + ".";
        if (_isfull == true)
        {
            flightInfo += " Flight is full.";
        }
        else
        {
            flightInfo += " Flight is not full.";
        }
        return flightInfo;
    }
}
