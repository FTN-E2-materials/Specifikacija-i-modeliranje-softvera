package observer_pattern_implementation;

import observable.DataFeed;
import observable.WeatherPublisher;
import observers.CurrentWeather;
import observers.Forecast;
import observers.History;

public class Main {

	public static void main(String[] args) {
		
		WeatherPublisher wp = new WeatherPublisher();
		CurrentWeather cw = new CurrentWeather();
		Forecast fc = new Forecast();
		History hi = new History();
		
		wp.addObserver(cw);
		wp.addObserver(fc);
		wp.addObserver(hi);
		
		DataFeed dataFeed = new DataFeed(wp);
		
		System.out.println("Pulling data...\n");
		dataFeed.pullNewData(25.4, 11.0, 40);
		System.out.println("\n\nPulling data...\n");
		dataFeed.pullNewData(24.1, 9.3, 25);
		System.out.println("\n\nPulling data...\n");
		dataFeed.pullNewData(20.3, 15.0, 63);
	}

}
