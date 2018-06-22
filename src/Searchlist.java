import java.util.Iterator;

public class Searchlist<T extends Comparable<T>> implements SList<T>
{
    private Node start;         // definiert den Head-Knoten der Liste

    @Override
    public void add(T object) {
        //Ueberpruefe ob ein Knoten bereits vorhanden ist oder nicht
        if (start == null)
        {
            start = new Node(object);       // falls ja wird ein neuer Knoten erzeugt
        } else
            {
            Node curr = start;                              // ansonsten: current node (aktueller Knoten) entspricht dem Start

            if (curr.value.compareTo(object) == 0)          // Falls values einander entsprechen
            {
                curr.counter++;                             // wird counter hochgzaehlt
                return;                                     // und die Funktion verlassen
            } else if (curr.value.compareTo(object) > 0)    // Falls value gr0eßer als 0 ist
            {
                Node newNode = new Node(object);            // wird ein neuer Knoten erstellt
                newNode.next = curr;                        // neues Element verweist nun auf das aktuelle Element
                start = newNode;
                return;
            }

            while (curr.next != null)
            {
                if (curr.next.value.compareTo(object) == 0)
                {
                    curr.next.counter++;
                    return;
                } else if (curr.next.value.compareTo(object) > 0)
                {
                    Node newNode = new Node(object);
                    newNode.next = curr.next;
                    curr.next = newNode;
                    return;
                }
                curr = curr.next;
            }
            curr.next(new Node((object)));              // Neue Referenz auf den letzten Knoten
        }
    }

    @Override
    public int count(T comparable)
    {
        Node curr = start;                                  // aktueller Knoten wird start-node zugewiesen
        while (curr != null)                                // solange ein Knoten vorhanden ist
        {
            if (curr.value.compareTo(comparable) == 0)
            {
                return curr.getCount();                     // Gibt Anzahl der Knoten wieder, falls vorhanden
            }
            curr = curr.next;                               //
        }
        return 0;
    }

    @Override
    public boolean remove(T comparable)
    {
        Node curr = start;
        if (curr.value.compareTo(comparable) == 0)
        {
            start = curr.next;
            return true;
        }

        while (curr.next != null)
        {
            if (curr.next.value.compareTo(comparable) == 0)
            {
                if (curr.next.next != null)
                {
                    curr.next = curr.next.next;
                    return true;
                } else {
                    curr.next = null;
                    return true;
                }
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public int noOccurences()
    {
        Node curr = start;
        int occurences = 0;

        while (curr != null)
        {
            occurences += curr.getCount();
            curr = curr.next;
        }
        return occurences;
    }

    @Override
    public int noWords()
    {
        int amountOfWords = 0;
        Node curr;

        if (start != null)
        {
            curr = start;
            amountOfWords++;

            while (curr.next != null)
            {
                amountOfWords++;
                curr = curr.next;
            }
        }
        return amountOfWords;
    }


    @Override
    public Iterator<T> iterator()
    {
       return new Iterator<T>()
       {
           Node currNode = start;
           @Override
           public boolean hasNext()
           {
               if (currNode != null)
               {
                   return true;
               } else {
                   return false;
               }
           }

           @Override
           public T next()
           {
               T value = currNode.value;
               currNode = currNode.next;
               return value;
           }
       };
    }

     /*Node Iterator = start;
        for (int i = 0; i < n; i++)
        {
           if (Iterator.hasNext())
            {
                Iterator = Iterator.next;
            } else
            {
                return null;
            }
        }
        return (java.util.Iterator<T>) Iterator;
        */

    //Innere Knoten-Klasse
    private class Node {
        private T value;
        private Node next;
        private int counter;

        //Konstruktor
        private Node(T value)
        {
            this.value = value;  //Typ der Klasse gesetzt auf ueberlieferten Typ
            counter = 1;
        }

        private void next (Node next)
        {
            this.next = next;
        }

        private T getValue()
        {
            return value;
        }

        private int getCount()
        {
            return counter;
        }

        // Hat Knoten einen Nachfolger / naechsten Knoten
       /* private boolean hasNext()
        {
            if (this.next == null)
            {
                return false;
            } else {
                return true;
            }
        }*/

    }

}
