package observers;

import observable.DataFeed;

public class CurrentWeather implements Observer {
	
	private double temperature;
	private double windSpeed;
	private int humidity;

	@Override
	public void update(Object o) {
		if (o instanceof DataFeed) {
			DataFeed df = (DataFeed) o;
			setTemperature(df.getLastTemperature());
			setWindSpeed(df.getLastWindSpeed());
			setHumidity(df.getLastHumidity());
			printData();
		}
	}

	public void printData() {
		System.out.println("~~~ Current Weather Data ~~~");
		System.out.println("\tTemperature: " + temperature + "*C\n\tWind Speed: " + windSpeed + " km/h\n\tHumidity: " + humidity + "%");
	}

	// Getters and Setters
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}	
}
