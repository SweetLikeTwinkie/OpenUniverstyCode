/**
 * Matala 12 - Using a class to represents time - hours:minutes. Values must 
 * represent a proper time.
 * 
 * @author Slava Tashlyk
 * @version 28.03.2022
 */
public class Time2
{
    private int _minFromMid;
    final int MAX_HOURS = 24, MAX_MINUTES = 60;
    final int NUMBERS_WITHOUT_ZERO = 10;
    /**
     * Constructs a Time2 object. Construct a new time instance with the specified hour and minute. 
     * hour should be between 0-23, otherwise it should be set to 0. minute should be between 0-59, 
     * otherwise they should be set to 0.
     * 
     * @param h - Hour.
     * @param m - Minute.
     */
    public Time2(int h, int m)
    {
        if(isValid(h, m) == true)
        {
            _minFromMid = h * 60 + m;
        }
        else
        {
            _minFromMid = 0;
        }
    }
    /**
     * Copy constructor for Time2. Constructs a time with the same variables as another time.
     * @param other - The time object from which to construct the new time.
     */    
    public Time2 (Time2 other)
    {
        this(other.getHour(), other.getMinute());
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
        return _minFromMid / 60;
    }
    /**
     * Get the minute of the time.
     * @return the minute of the time.
     */
    public int getMinute()
    {
        return _minFromMid - getHour() * 60;
    }
    /**
     * Changes the hour of the time. If an illegal number is received hour 
     * will be unchanged.
     * @param num - The new hour
     */  
    public void setHour(int num)
    {
        if (isValid(num, getMinute()))
        {
            _minFromMid = num * 60 + getMinute();            
        }
    }
    /**
     * Changes the minute of the time. If an illegal number is received 
     * minute will be unchanged.
     * @param num - The new minute.
     */ 
    public void setMinute(int num)
    {
        if (isValid(getHour(), num))
        {
            _minFromMid = getHour() * 60 + num;              
        }
    }
    /**
     * Return the amount of minutes since midnight.
     * @return amount of minutes since midnight.
     */    
    public int minFromMidnight()
    {
        return _minFromMid;
    }
    /**
     * Check if the received time is equal to this time.
     * @param other - The time to be compared with this time.
     * @return True if the received time is equal to this time. 
     */  
    public boolean equals (Time2 other)
    {
        return _minFromMid == other._minFromMid;
    }
    /**
     * Check if this time is before a received time.
     * @param other - The time to check if this point is before.
     * @return True if this time is before other time.
     */
    public boolean before (Time2 other)
    {
        return _minFromMid < other._minFromMid;
    }
    /**
     * Check if this time is after a received time.
     * @param other - The time to check if this point is after.
     * @return True if this time is after other time.
     */  
    public boolean after (Time2 other)
    {
        return other.before(this);
    }
    /**
     * Calculates the difference (in minutes) between two times. 
     * Assumption: this time is after other time.
     * @param other - The time to check the difference to.
     * @return int difference in minutes.
     */   
    public int difference(Time2 other)
    {
        return this._minFromMid - other._minFromMid;
    }
    /**
     * Return a string representation of this time (HH:MM).
     * @return String representation of this time (HH:MM).
     */  
    public String toString()
    {  
        String timeToString = "";
        if (getHour() < NUMBERS_WITHOUT_ZERO)
        {
            timeToString += "0" + getHour();
        }
        else
        {
            timeToString += getHour();
        }
        timeToString += ':';
        if (getMinute() < NUMBERS_WITHOUT_ZERO)
        {
            timeToString += "0" + getMinute();
        }
        else
        {
            timeToString += getMinute();
        }
        return timeToString;
    }
    /**
     * Copy current object and add requested minutes to new object.
     * @param num - The minutes need to add.
     * @return new update Time2 object.
     */
    public Time2 addMinutes(int num)
    {
        Time2 updatedTime = new Time2(this);
        updatedTime._minFromMid += num;
        return updatedTime;
    }
}