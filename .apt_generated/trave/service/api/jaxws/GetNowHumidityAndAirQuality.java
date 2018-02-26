
package trave.service.api.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getNowHumidityAndAirQuality", namespace = "http://api.service.trave/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getNowHumidityAndAirQuality", namespace = "http://api.service.trave/")
public class GetNowHumidityAndAirQuality {

    @XmlElement(name = "city", namespace = "")
    private String city;

    /**
     * 
     * @return
     *     returns String
     */
    public String getCity() {
        return this.city;
    }

    /**
     * 
     * @param city
     *     the value for the city property
     */
    public void setCity(String city) {
        this.city = city;
    }

}
