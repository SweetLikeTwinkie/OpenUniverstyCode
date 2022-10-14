/**
 * Matala 15 - This class represents a node in a linked list.
 * 
 *  @author Open University
 *  @version 06.05.2022
 */
public class IntNode extends Set
{
    private int _value; //
    private IntNode _next; //
    /**
     * 
     */
    public IntNode(int v, IntNode n)
    {
        _value = v; //
        _next = n; //
    }
    /**
     * 
     */    public int getValue() 
    {
        return _value; //
    }
    /**
     * 
     */
    public IntNode getNext() 
    {
        return _next; //
    }
    /**
     * 
     */
    public void setValue(int v) 
    {
        _value = v; //
    }
    /**
     * 
     */
    public void setNext(IntNode n) 
    {
        _next = n; //
    }
}