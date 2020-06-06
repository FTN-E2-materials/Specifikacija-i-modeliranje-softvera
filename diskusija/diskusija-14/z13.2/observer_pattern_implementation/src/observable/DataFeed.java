package observable;

public class DataFeed {
	private double lastTemperature;
	private double lastWindSpeed;
	private int lastHumidity;
	
	private WeatherPublisher weatherPublisher;
	
	public DataFeed(WeatherPublisher wp) {
		this.weatherPublisher = wp;
	}
	
	public void pullNewData(double newTemperature, double newWindSpeed, int newHumidity) {
		setLastHumidity(newHumidity);
		setLastTemperature(newTemperature);
		setLastWindSpeed(newWindSpeed);
		weatherPublisher.notifyObservers(this);
	}
	
	// Getters and Setters
	public double getLastTemperature() {
		return lastTemperature;
	}
	public void setLastTemperature(double lastTemperature) {
		this.lastTemperature = lastTemperature;
	}
	public double getLastWindSpeed() {
		return lastWindSpeed;
	}
	public void setLastWindSpeed(double lastWindSpeed) {
		this.lastWindSpeed = lastWindSpeed;
	}
	public int getLastHumidity() {
		return lastHumidity;
	}
	public void setLastHumidity(int lastHumidity) {
		this.lastHumidity = lastHumidity;
	}
}
