
package trave.service.api.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "main", namespace = "http://api.service.trave/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "main", namespace = "http://api.service.trave/")
public class Main {

    @XmlElement(name = "args", namespace = "", nillable = true)
    private String[] args;

    /**
     * 
     * @return
     *     returns String[]
     */
    public String[] getArgs() {
        return this.args;
    }

    /**
     * 
     * @param args
     *     the value for the args property
     */
    public void setArgs(String[] args) {
        this.args = args;
    }

}
