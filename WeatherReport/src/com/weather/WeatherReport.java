package com.weather;

import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

public class WeatherReport {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String countryName = args[0];
		
		GlobalWeather gw = new GlobalWeather();
		
		GlobalWeatherSoap gws = gw.getGlobalWeatherSoap();
		
		String d = gws.getWeather("Jaipur", countryName);
		
		System.out.println("Cities are : "+d);
		
	}

}
