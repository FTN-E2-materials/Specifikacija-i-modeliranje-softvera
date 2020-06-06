package observable;

import java.util.ArrayList;

import observers.Observer;

public class WeatherPublisher implements Observable {
	
	private ArrayList<Observer>observers = new ArrayList<Observer>();
	
	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers(DataFeed dataFeed) {
		for(Observer obs : observers) {
			obs.update(dataFeed);
		}
	}
}
