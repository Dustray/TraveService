package trave.service.api;

import java.util.HashMap;
import javax.jws.WebParam;

@javax.jws.WebService(targetNamespace = "http://api.service.trave/", serviceName = "WeatherService", portName = "WeatherPort", wsdlLocation = "WEB-INF/wsdl/WeatherService.wsdl")

public class WeatherDelegate {

	trave.service.api.Weather weather = new trave.service.api.Weather();

	public void main(@WebParam(name = "args") String[] args) {
		weather.main(args);
	}

	public String getNowHumidityAndAirQuality(@WebParam(name = "city") String city) {
		return weather.getNowHumidityAndAirQuality(city);
	}

}