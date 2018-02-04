
package trave.service.api.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getAttractionJson", namespace = "http://api.service.trave/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAttractionJson", namespace = "http://api.service.trave/", propOrder = {
    "cityid",
    "proid"
})
public class GetAttractionJson {

    @XmlElement(name = "cityid", namespace = "")
    private String cityid;
    @XmlElement(name = "proid", namespace = "")
    private String proid;

    /**
     * 
     * @return
     *     returns String
     */
    public String getCityid() {
        return this.cityid;
    }

    /**
     * 
     * @param cityid
     *     the value for the cityid property
     */
    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getProid() {
        return this.proid;
    }

    /**
     * 
     * @param proid
     *     the value for the proid property
     */
    public void setProid(String proid) {
        this.proid = proid;
    }

}
