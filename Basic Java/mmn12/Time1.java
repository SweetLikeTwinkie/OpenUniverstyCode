/**
 * Matala 12 - Using a class to Represents time - hours:minutes. 
 * Coordinates cannot be negative.
 * 
 * @author Slava Tashlyk
 * @version 28.03.2022
 */
public class Time1
{
    private int _hour;
    private int _minute;
    final int DEFAULT_HOUR = 0, DEFAULT_MINUTE = 0;
    final int MAX_HOURS = 24, MAX_MINUTES = 60;
    final int NUMBERS_WITHOUT_ZERO = 10;
    /**
     * Constructs a Time1 object. Construct a new time instance with the specified 
     * hour and minute . hour should be between 0-23, otherwise it should be set to 0. 
     * minute should be between 0-59, otherwise it should be set to 0.
     * 
     * @param h - the hour of the time.
     * @param m - the minute of the time.
     */
    public Time1(int h, int m)
    {
        if(isValid(h, m) == true)
        {
            _hour = h;
            _minute = m;
        }
        else
        {
            _hour = DEFAULT_HOUR;
            _minute = DEFAULT_MINUTE;
        }
    }
    /**
     * Copy constructor for Time1. Construct a time with the same instance variables 
     * as another time.
     * @param other - The time object from which to construct the new time.
     */
    public Time1 (Time1 other)
    {
        this(other._hour, other._minute);
    }
    /**  
     * determines if the time is valid or not.
     * @param h - Hours (0-23).
     * @param m - Minutes (0-59).
     * @return True if the time is valid.
     */  
    private boolean isValid(int h, int m)
    {
        return h >= 0 && h < MAX_HOURS && m >= 0 && m < MAX_MINUTES;
    }
    /**
     * Get the hour of the time.
     * @return The hour of the time.
     */
    public int getHour()
    {
        return _hour;
    }
    /**
     * Get the minute of the time.
     * @return the minute of the time.
     */
    public int getMinute()
    {
        return _minute;
    }
    /**
     * Changes the hour of the time. If an illegal number is received hour 
     * will be unchanged.
     * @param num - The new hour
     */
    public void setHour(int num)
    {
        if (isValid(num, _minute))
        {
            _hour = num;            
        }
        else
        {
            _hour = _hour;
        }
    }
    /**
     * Changes the minute of the time. If an illegal number is received 
     * minute will be unchanged.
     * @param num - The new minute.
     */
    public void setMinute(int num)
    {
        if (isValid(_hour, num))
        {
            _minute = num;            
        }
        else
        {
            _minute = _minute;
        }    
    }
    /**
     * Return a string representation of this time (HH:MM).
     * @return String representation of this time (HH:MM).
     */
    public String toString()
    {  
        String timeToString = "";
        if (_hour < NUMBERS_WITHOUT_ZERO)
        {
            timeToString += "0" + _hour;
        }
        else
        {
            timeToString += _hour;
        }
        timeToString += ':';
        if (_minute < NUMBERS_WITHOUT_ZERO)
        {
            timeToString += "0" + _minute;
        }
        else
        {
            timeToString += _minute;
        }
        return timeToString;
    }
    /**
     * Return the amount of minutes since midnight.
     * @return amount of minutes since midnight.
     */
    public int minFromMidnight()
    {
        return this._hour * 60 + this._minute;
    }
    /**
     * Check if the received time is equal to this time.
     * @param other - The time to be compared with this time.
     * @return True if the received time is equal to this time. 
     */
    public boolean equals (Time1 other)
    {
        return _hour == other._hour && _minute == other._minute;
    }
    /**
     * Check if this time is before a received time.
     * @param other - The time to check if this point is before.
     * @return True if this time is before other time
     */
    public boolean before (Time1 other)
    {
        if (_hour < other._hour)
        {
            return true;
        }
        if (_hour == other._hour) 
        {
            if (_minute < other._minute)
            {
                return true;
            }
        }
        return false;
    }
    /**
     * Check if this time is after a received time.
     * @param other - The time to check if this point is after.
     * @return True if this time is after other time.
     */
    public boolean after (Time1 other)
    {
        return other.before(this);
    }
    /**
     * Calculates the difference (in minutes) between two times. 
     * Assumption: this time is after other time.
     * @param other - The time to check the difference to.
     * @return int difference in minutes.
     */
    public int difference(Time1 other)
    {
        return this._hour * 60 + this._minute - (other._hour * 60 + other._minute); 
    }
    /**
     * Copy current object and add requested minutes to new object.
     * @param num - The minutes need to add.
     * @return new update Time1 object.
     */
    public Time1 addMinutes(int num)
    {
        Time1 updatedTime = new Time1(this._hour,this._minute);
        updatedTime._minute += num;
        updatedTime._hour += updatedTime._minute / 60;
        updatedTime._hour %= 24;
        if (updatedTime._hour < 0)
        {
            updatedTime._hour += 24;
        }
        updatedTime._minute %= 60;
        return updatedTime;
    }
}