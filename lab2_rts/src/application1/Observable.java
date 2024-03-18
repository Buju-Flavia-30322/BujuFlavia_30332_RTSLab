package application1;

// interface for objects so they are observed
public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(int id, int value);
}
