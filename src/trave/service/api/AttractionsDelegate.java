package trave.service.api;

import com.show.api.ShowApiRequest;
import javax.jws.WebParam;

@javax.jws.WebService(targetNamespace = "http://api.service.trave/", serviceName = "AttractionsService", portName = "AttractionsPort", wsdlLocation = "WEB-INF/wsdl/AttractionsService.wsdl")

public class AttractionsDelegate {

	trave.service.api.Attractions attractions = new trave.service.api.Attractions();

	public String getAttractionJson(@WebParam(name = "cityid") String cityid, @WebParam(name = "proid") String proid) {
		return attractions.getAttractionJson(cityid, proid);
	}

	public String getCityJson(@WebParam(name = "provinceid") String provinceid) {
		return attractions.getCityJson(provinceid);
	}

	public String getProvinceJson() {
		return attractions.getProvinceJson();
	}

}