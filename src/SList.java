import java.util.Iterator;

/**
 * Schnittstelle zum Zaehlen von Vorkommen
 * von vergleichbaren Elementen
 */
public interface SList <T> extends Iterable<T>
{
    /**
     * Hinzufuegen eines T.
     * Falls schon vorhanden wird Anzahl Vorkommen um eins erhÃ¶ht
     * Falls noch nicht vorhanden wird Anzahl Vorkommen auf eins gesetzt.
     * @param t hinzuzufuegendes T
     */
    void add(T t);

    /**
     * Wie haeufig kommt ein T vor.
     * @param t zu suchendes T
     * @return Anzahl der Vorkommen von t, 0 wenn nicht vorhanden
     */
    int count(T t);

    /**
     * Entfernen aller Vorkommen eines T.
     * @param t Zu entfernendes T
     * @return true gdw t kam vorher vor
     */
    boolean remove(T t);

    /**
     * Summe der Anzahl der Vorkommen aller T berechnen.
     * @return Summe der Anzahl der Vorkommen aller T
     */
    int noOccurences();

    /**
     * Anzahl der unterschiedlichen T berechnen.
     * @return Anzahl der unterschiedlichen T
     */
    int noWords();

    /**
     * Iterator ueber alle vorkommenden T zurueckgeben
     * @return
     */
    Iterator<T> iterator();
}
