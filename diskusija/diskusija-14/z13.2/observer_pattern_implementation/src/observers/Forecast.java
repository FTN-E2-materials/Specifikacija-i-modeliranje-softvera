package observers;

import java.util.ArrayList;

import observable.DataFeed;

public class Forecast implements Observer {

	private ArrayList<Double> weatherData = new ArrayList<Double>();

	@Override
	public void update(Object o) {
		if (o instanceof DataFeed) {
			DataFeed df = (DataFeed) o;
			ArrayList<Double> newForecast = new ArrayList<Double>();

			newForecast.add((Double) df.getLastTemperature());
			newForecast.add((Double) df.getLastTemperature());
			newForecast.add((Double) df.getLastTemperature());
			newForecast.add((Double) df.getLastTemperature());
			newForecast.add((Double) df.getLastTemperature());
			newForecast.add((Double) df.getLastTemperature());
			newForecast.add((Double) df.getLastTemperature());

			weatherData = newForecast;

			calculateForecast();
		}

	}

	// Banalna kalkulacija
	public void calculateForecast() {
		System.out.println("~~~ Forecast for the following 7 days ~~~");
		for (int i = 0; i < weatherData.size(); i++) {
			System.out.println("\tDay " + (i+1) + " -> Temperature: " + Math.round(weatherData.get(i) + generateRandomForecast()) + "*C");
		}
	}

	private double generateRandomForecast() {
		return Math.random() * 5;
	}
}
