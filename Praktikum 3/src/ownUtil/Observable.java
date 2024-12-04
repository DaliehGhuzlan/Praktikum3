package ownUtil;

public interface Observable {
	void adObserver(Observer obs);
	void removeObserver(Observer obs);
	void notifyObserver();
}
