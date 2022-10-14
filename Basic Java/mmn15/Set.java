/**
 * Matala 15 - This class lets you to store in a connected list a groups off odd number.
 * 
 *  @author Slava Tashlyk
 *  @version 06.05.2022
 */
public class Set
{
    private IntNode _head; // Variable that hold the first element of the node.
    private int _setsLength; // Variable that hold the length of the list.

    /**
     * Class Constructor.
     */
    public Set()
    {
        _head = null; // Set the first element of empty new set to null.
        _setsLength = 0; // Set the length to 0.
    }

    /**
     * Check if the Set is empty.
     * 
     *     Time Complexity: O(1).
     *     Memory Complexity: O(1).
     */
    public boolean isEmpty ()
    {
        if(_head == null) // Check if 
        {
            return true;
        }
        return false;
    }

    /**
     * Check if num value is a member of a group.
     * 
     *     @param num - number.
     *     @return True if the number is member, If not return false.
     * 
     *     Time Complexity: O(n).
     *     Memory Complexity: O(1).
     */
    public boolean isMember (int num)
    {
        IntNode pointer = _head; // Set pointer to the first element in the group.
        while (pointer != null) // Loop that run from first element to the last element that empty.
        {
            if (pointer.getValue() == num) // If pointer value equal to num.
            {
                return true; // Return True.
            }
            pointer = pointer.getNext(); // Move the pointer to the next element of the group.
        }
        return false; // Return False.
    }

    /**
     * Check if the two Sets equals to each other.
     * 
     *     @param other - Set to compare with.
     *     @return - True if equal, False if not.
     * 
     *     Time Complexity: O(n).
     *     Memory Complexity: O(1).
     */
    public boolean equals (Set other)
    {
        if (this.numOfElements() != other.numOfElements()) // If the amount of elements is not the same.
        {
            return false; // Return False.
        }
        IntNode pointer1 = this._head; // Set the first pointer as the first element of the group that the method works on.
        IntNode pointer2 = other._head; // Set the seocnd pointer as the first element of the input group.        
        while (pointer1 != null && pointer2 != null) // Loop that run over the elements of both groups.
        {
            if (pointer1.getValue() != pointer2.getValue()) // Check if the value of the elements equal to each other.
            {
                return false; // Return False.
            }
            pointer1 = pointer1.getNext(); // Move the pointer to the next element of the group.
            pointer2 = pointer2.getNext(); // Move the pointer to the next element of the input group.
        }
        return true; // Return True.
    }

    /**
     * Get the number of the elements of the Set.
     * 
     *     @return Number of the elements.
     * 
     *     Time Complexity: O(n). 
     *     Memory Complexity: O(1).
     */
    public int numOfElements ()
    {
        return _setsLength; // Return the amount of elements of the group.
    }

    /**
     * Check if input Set is sub group of Set.
     * 
     *    @param other - Set to check.
     *     @return True if other set is sub group of Set, False if not.
     * 
     *     Time Complexity: O(n). 
     *     Memory Complexity: O(1).
     */
    public boolean subSet (Set other)
    {
        if (this.numOfElements() < other.numOfElements()) // Check if the input group have more elements then the group that the method works on. 
        {
            return false; // Return False.
        }
        IntNode pointer1 = this._head; // Set the first pointer as the first element of the group that the method works on.
        IntNode pointer2 = other._head; // Set the seocnd pointer as the first element of the input group.  
        while (pointer1 != null && pointer2 != null) // Loop that run over the elements of both groups.
        {
            if (pointer1.getValue() > pointer2.getValue()) // If the value of the element greater then the value of the input group.
            {
                return false; // Return False.
            }
            if (pointer1.getValue() == pointer2.getValue()) // Check if the value of the elements equal to each other.
            {
                pointer1 = pointer1.getNext(); // Move the pointer to the next element of the group.
                pointer2 = pointer2.getNext(); // Move the pointer to the next element of the input group.
            }
            else // If the values not equal to each other.
            {
                pointer1 = pointer1.getNext(); // Move the pointer to the next element of the group.
            }
        }
        return pointer2 == null; // Return true if the pointer of the input group can reach the last element of the group.
    }

    /**
     * Adds new number to Set.
     * 
     *     @param x - number.
     *     
     *     Time Complexity: O(n). 
     *     Memory Complexity: O(1).
     */
    public void addToSet (int x)
    {
        if (x % 2 == 1 && x > 0) // Check if the input number is odd.
        {
            IntNode pointer = _head; // Set the pointer to the first element of the group.
            if (this.isEmpty()) // Check if the group that the element added to is empty.
            {
                _head = new IntNode(x, null); // Define at the first node of set with input as the first element.
                _setsLength++; // Add 1+ to group length var.
                return; // Function end.
            }
            if (_head.getValue() > x) // If the first element greater then input element.
            {
                _head = new IntNode(x, _head); // Define at the first node of the set a input number as the first element and the first element as the second
                _setsLength++; // Add 1+ to group length var.
                return; // Function end.
            }
            while (pointer.getNext() != null) // Loop that run from first element to the last element that empty.
            {
                if (pointer.getValue() == x) // If the value of the element equal to input number.
                {
                    return; // Function end.
                }
                if (pointer.getNext().getValue() > x) // Check if the value of the next element greater then input number.
                {
                    IntNode temp = new IntNode(x, pointer.getNext()); // Create a temp node that hold the input with the next element.
                    pointer.setNext(temp); // Add to the pointer the temp node.
                    _setsLength++; // Add 1+ to group length var.
                    return; // Function end.
                }
                pointer = pointer.getNext(); // Move the pointer to the next element.
            }
            if (pointer.getValue() != x) // If the pointer value not equal to the input number.
            {
                pointer.setNext(new IntNode(x, null)); // Set to the pointer new node with input element.
                _setsLength++; // Add 1+ to group length var.
            }
        }
    }

    /**
     * Removes number from Set.
     *     
     *     @param x - Input number.
     * 
     *     Time Complexity: O(n). 
     *     Memory Complexity: O(1).
     */
    public void removeFromSet (int x)
    {
        IntNode pointer = _head; // Set pointer to the first element in the group.
        IntNode next = pointer.getNext(); // Set next as the next element from pointer.        
        if (!isMember(x)) // Check if the input number a member of Set.
        {
            return; // If not end the function.
        }
        if (pointer.getValue() == x) // If the value of the pointer equal to the input number.
        {
            _head = _head.getNext(); // Set the next element as the first element.
            _setsLength--; // -1 to group length.
            return; // End the function.
        }
        while (pointer != null && next != null)    // Loop that run till 
        {
            if (next.getValue() == x) // If the next element value equal to input number.
            {
                pointer.setNext(next.getNext()); // Set the next with the his next element.
                _setsLength--; // -1 to group length.
                return; // End function.
            }
            pointer = pointer.getNext(); // Move the pointer to the next element.
            next = next.getNext(); // Move the next element pointer to his next element.
        }
    }

    /**
     * Get String representation of Set.
     * 
     *     @return String representation.
     * 
     *     Time Complexity: O(n). 
     *     Memory Complexity: O(n).
     */
    public String toString()
    {
        String string = new String("{"); // Define new string with "{" as as the first part of the string.
        IntNode pointer = _head; // Set the first element of the group as pointer.
        while (pointer != null) // Loop that run till the last element of the group.
        {
            if (pointer.getNext() == null) // Check if the next element is empty.
            {
                string += pointer.getValue(); // Add to the string the value of pointer (In this case is the first value of element of the group).
            }
            else // If the next element not empty.
            {
                string += pointer.getValue() + ","; // Add to the string the value of pointer and comma after it.
            }
            pointer = pointer.getNext(); // Move to the next element.
        }
        string += "}"; // Add the last part of the String.
        return new String(string); // Return the full string.
    }

    /**
     * Gets the intersection of a given Set with the current Set.
     * 
     *     @param other The set to get intersection with.
     * 
     *     Time Complexity: O(n). 
     *     Memory Complexity: O(n).
     */
    public Set intersection (Set other)
    {
        IntNode pointerToThis = this._head; // Define a pointer for the first element of the group.
        IntNode pointerToOther = other._head; // Define a pointer for the first element of input group.
        Set intersection = new Set(); // Create Set for intersection.
        IntNode pointerToIntersection = intersection._head; // Define a pointer for the first element of intersection group.        
        while (pointerToThis != null && pointerToOther != null) // Loop that run till the last element if the groups.
        {
            if (pointerToThis.getValue() == pointerToOther.getValue()) // Compare the values of the group (Check if they equal to each other).
            {
                if (intersection.isEmpty()) // If intersection group is empty.
                {
                    // Add to the intersection node pointer value of node pointer.
                    pointerToIntersection = intersection.addToInterUnionDiff(pointerToThis.getValue());
                }
                else // if not empty.
                {
                    // Add to the intersection node pointer value of node pointer.
                    pointerToIntersection = intersection.addToInterUnionDiff(pointerToIntersection, pointerToThis.getValue());        
                }
                intersection._setsLength++; // Add 1+ to intersection length.
                pointerToThis = pointerToThis.getNext(); // Move to next node.
                pointerToOther = pointerToOther.getNext(); // Move to next node.
            }
            else // If the values not equal to each other.
            {
                if (pointerToThis.getValue() > pointerToOther.getValue()) // Check if value of the node greater then the input node.
                {
                    pointerToOther = pointerToOther.getNext(); // Move to next node.
                }

                else // If value of the node less then the input node.
                {
                    pointerToThis = pointerToThis.getNext(); // Move to next node.        
                }         
            }
        }
        return intersection; // Retrun intersection Set.
    }

    /**
     * Gets the union of a given Set object with the current Set object
     * 
     *  @param other The set to get union with.
     *  
     *  Time Complexity: O(n). 
     *  Memory Complexity: O(n).
     */
    public Set union(Set other) 
    {
        if (other == null) // Check if the inout is empty.
        {
            return null; // Return null(Empty).
        }
        IntNode pointerThis = this._head; // Set to the first Node.
        IntNode pointerOther = other._head; // Set to the first Node.
        Set unionSet = new Set(); // Create new set for hold the result.
        IntNode pointerUnion = unionSet._head; // Set to the first Node.
        while (pointerThis != null && pointerOther != null) // Loop that run over the elements of both groups.
        {
            if (pointerThis.getValue() == pointerOther.getValue()) // If the values of the nodes equals to each other.
            {
                if (unionSet.isEmpty()) // Check if union Set is empty.
                {
                    pointerUnion = unionSet.addToInterUnionDiff(pointerThis.getValue()); // Create and Add to union Set node value.
                }
                else // If not empty.
                {
                    pointerUnion = unionSet.addToInterUnionDiff(pointerUnion, pointerThis.getValue()); // Add to union Set node value.
                }
                pointerThis = pointerThis.getNext(); // Move to the next node.
                pointerOther = pointerOther.getNext(); // Move to the next node.
            }
            else // If the values of the nodes not equals to each other.
            {
                if (pointerThis.getValue() > pointerOther.getValue()) // If the value of the node greater then the input node.
                {
                    if (unionSet.isEmpty()) // Check if union Set is empty.
                    {
                        pointerUnion = unionSet.addToInterUnionDiff(pointerOther.getValue()); // Create and Add to union Set input node value.
                    }
                    else // If not empty.
                    { 
                        pointerUnion = unionSet.addToInterUnionDiff(pointerUnion, pointerOther.getValue()); // Add to union Set input node value.
                    }
                    pointerOther = pointerOther.getNext(); // Move to the next node.
                }
                else // If the value of the node less then the input node.
                {
                    if (unionSet.isEmpty()) // Check if union Set is empty.
                    {
                        pointerUnion = unionSet.addToInterUnionDiff(pointerThis.getValue()); // Create and Add to union Set node value.
                    }
                    else // If not empty.
                    {
                        pointerUnion = unionSet.addToInterUnionDiff(pointerUnion, pointerThis.getValue()); // Add to union Set node value.
                    }
                    pointerThis = pointerThis.getNext(); // Move to the next node.
                }
            }
            unionSet._setsLength++; // Add 1+ to union Set length.
        }
        while (pointerThis != null) // Check if the node is empty.
        {
            if (unionSet.isEmpty()) // Check if union Set is empty.
            {
                pointerUnion = unionSet.addToInterUnionDiff(pointerThis.getValue()); // Create and Add to union Set node value.
            }
            else // If not empty.
            {
                pointerUnion = unionSet.addToInterUnionDiff(pointerUnion, pointerThis.getValue()); // Add to union Set node value.
            }
            pointerThis = pointerThis.getNext(); // Move to the next node.
            unionSet._setsLength++; // Add 1+ to union Set length.
        }
        while (pointerOther != null) // Check if the input node is empty.
        {
            if (unionSet.isEmpty()) // Check if union Set is empty.
            {
                pointerUnion = unionSet.addToInterUnionDiff(pointerOther.getValue()); // Create and Add to union Set input node value.
            }
            else // If not empty.
            {
                pointerUnion = unionSet.addToInterUnionDiff(pointerUnion, pointerOther.getValue()); // Add to union Set input node value.
            }
            pointerOther = pointerOther.getNext(); // Move to the next node.
            unionSet._setsLength++; // Add 1+ to union Set length.
        }
        return unionSet; // Return the result.
    }

    /**
     * Gets the difference of a given Set object with the current Set object
     * 
     *     @param other The set to get difference with
     * 
     *     Time Complexity: O(n). 
     *     Memory Complexity: O(n).
     */
    public Set difference (Set other)
    {
        IntNode pointerThis = this._head; // Set to the first Node.
        IntNode pointerOther = other._head; // Set to the first Node.
        Set differenceSet = new Set(); // Create new set for hold the result.
        IntNode pointerDiff = differenceSet._head; // Set to the first Node.
        while (pointerThis != null && pointerOther != null) // Loop that run over the elements of both groups.
        {
            if (pointerThis.getValue() == pointerOther.getValue()) // If the values of the nodes equals to each other.
            {
                pointerThis = pointerThis.getNext(); // Move to the next node.
                pointerOther = pointerOther.getNext(); // Move to the next node.
            }
            else // If the values of the nodes not equals to each other.
            {
                if (pointerThis.getValue() > pointerOther.getValue()) // If the value of the node greater then the input node.
                {
                    pointerOther = pointerOther.getNext(); // Move to the next node.
                }
                else // If the value of the node less then the input node.
                {
                    if (differenceSet.isEmpty()) // Check if difference Set is empty.
                    {
                        pointerDiff = differenceSet.addToInterUnionDiff(pointerThis.getValue()); // Create and Add to difference Set node value.
                    }
                    else  // If not empty.
                    {
                        pointerDiff = differenceSet.addToInterUnionDiff(pointerDiff, pointerThis.getValue()); // Add to difference Set node value.
                    }
                    pointerThis = pointerThis.getNext(); // Move to the next node.
                    differenceSet._setsLength++; // Add 1+ to difference Set length.
                }
            }
        }
        while (pointerThis != null) // Check if the input node is empty.
        {
            if (differenceSet.isEmpty()) // Check if difference Set is empty.
            {
                pointerDiff = differenceSet.addToInterUnionDiff(pointerThis.getValue()); // Create and Add to difference Set node value.
            }
            else // If not empty.
            {
                pointerDiff = differenceSet.addToInterUnionDiff(pointerDiff, pointerThis.getValue()); // Add to difference Set node value.
            }
            pointerThis = pointerThis.getNext(); // Move to the next node.
        }
        return differenceSet; // Return difference Set.
    }

    /**
     * This method adds a new Node to a non-empty Set, with a number that has been given 
     *     as a parameter.
     * 
     *     @param pointer An IntNode object to add a new node after it.
     *     @param num The number you want to add to the Set.
     *     @return The Node of the number that has been added to the set.
     */
    private IntNode addToInterUnionDiff(IntNode pointer, int num)
    {
        pointer.setNext(new IntNode(num, null)); // Add to the next node num.
        return pointer.getNext(); // Retrun the next pointer.
    }

    /**
     * This method adds a new Node to the Set object it's Sent from, the Set object 
     *     has to be an empty Set, with a number that has been given as a parameter.
     * 
     *     @param num The number you want to add to the set.
     *     @return The first Node of the Set.
     */
    private IntNode addToInterUnionDiff(int num)
    {
        if (this.isEmpty()) // Check if the Set is empty.
        {
            this._head = new IntNode(num, null); // Create new node num and next element as null.
        }
        return this._head; // Retrun the first object.
    } 
}