
package trave.service.api.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getCityJson", namespace = "http://api.service.trave/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCityJson", namespace = "http://api.service.trave/")
public class GetCityJson {

    @XmlElement(name = "provinceid", namespace = "")
    private String provinceid;

    /**
     * 
     * @return
     *     returns String
     */
    public String getProvinceid() {
        return this.provinceid;
    }

    /**
     * 
     * @param provinceid
     *     the value for the provinceid property
     */
    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }

}
