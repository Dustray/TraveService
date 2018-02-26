package trave.service.api;

import java.net.URL;  
import java.util.HashMap;  
import java.util.Map;  

import javax.xml.namespace.QName;  
import javax.xml.soap.MessageFactory;  
import javax.xml.soap.SOAPBody;  
import javax.xml.soap.SOAPBodyElement;  
import javax.xml.soap.SOAPConstants;  
import javax.xml.soap.SOAPEnvelope;  
//import javax.xml.soap.SOAPHeader;  
import javax.xml.soap.SOAPMessage;  
import javax.xml.ws.Dispatch;  
import javax.xml.ws.Service;  
import org.w3c.dom.Document;

import com.sun.xml.ws.client.BindingProviderProperties;
import com.sun.xml.ws.developer.JAXWSProperties;  
public class WebServiceClient {
	  String nameSpace = "";  
	    String wsdlUrl = "";  
	    String serviceName = "";  
	    String portName = "";  
	    String responseName = "";  
	    String elementName = "";  
	    int timeout = 20000;  
	  
	    /** 
	     *  
	     * @param nameSpace 
	     * @param wsdlUrl 
	     * @param serviceName 
	     * @param portName 
	     * @param elementName 
	     * @param responseName 
	     */  
	  
	    public WebServiceClient(String nameSpace, String wsdlUrl,  
	            String serviceName, String portName, String element,  
	            String responseName) {  
	        this.nameSpace = nameSpace;  
	        this.wsdlUrl = wsdlUrl;  
	        this.serviceName = serviceName;  
	        this.portName = portName;  
	        this.elementName = element;  
	        this.responseName = responseName;  
	    }  
	  
	    /** 
	     *  
	     * @param nameSpace 
	     * @param wsdlUrl 
	     * @param serviceName 
	     * @param portName 
	     * @param elementName 
	     * @param requestName 
	     * @param responseName 
	     * @param timeOut 
	     *            ���� 
	     */  
	  
	    public WebServiceClient(String nameSpace, String wsdlUrl,  
	            String serviceName, String portName, String element,  
	            String responseName, int timeOut) {  
	        this.nameSpace = nameSpace;  
	        this.wsdlUrl = wsdlUrl;  
	        this.serviceName = serviceName;  
	        this.portName = portName;  
	        this.elementName = element;  
	        this.responseName = responseName;  
	        this.timeout = timeOut;  
	    }  
	  
	    public String sendMessage(HashMap<String, String> inMsg) throws Exception {  
	        // ����URL����  
	        URL url = null;  
	        try {  
	            url = new URL(wsdlUrl);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return "����URL�����쳣";  
	        }  
	        // ��������(Service)  
	        QName sname = new QName(nameSpace, serviceName);  
	        Service service = Service.create(url, sname);  
	  
	        // ����Dispatch����  
	        Dispatch<SOAPMessage> dispatch = null;  
	        try {  
	            dispatch = service.createDispatch(new QName(nameSpace, portName),  
	                    SOAPMessage.class, Service.Mode.MESSAGE);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return "����Dispatch�����쳣";  
	        }  
	  
	        // ����SOAPMessage  
	        try {  
	            SOAPMessage msg = MessageFactory.newInstance(  
	                    SOAPConstants.SOAP_1_2_PROTOCOL).createMessage();  
	            msg.setProperty(SOAPMessage.CHARACTER_SET_ENCODING, "UTF-8");  
	  
	            SOAPEnvelope envelope = msg.getSOAPPart().getEnvelope();  
	  
	            // ����SOAPHeader(���Ǳ���)  
	            // SOAPHeader header = envelope.getHeader();  
	            // if (header == null)  
	            // header = envelope.addHeader();  
	            // QName hname = new QName(nameSpace, "username", "nn");  
	            // header.addHeaderElement(hname).setValue("huoyangege");  
	  
	            // ����SOAPBody  
	            SOAPBody body = envelope.getBody();  
	            QName ename = new QName(nameSpace, elementName, "q0");  
	            SOAPBodyElement ele = body.addBodyElement(ename);  
	            // ����BodyԪ�غ�ֵ  
	            for (Map.Entry<String, String> entry : inMsg.entrySet()) {  
	                ele.addChildElement(new QName(nameSpace, entry.getKey()))  
	                        .setValue(entry.getValue());  
	            }  
	  
	            // ��ʱ����  
	            dispatch.getRequestContext().put(  
	                    BindingProviderProperties.CONNECT_TIMEOUT, timeout);  
	            dispatch.getRequestContext().put(JAXWSProperties.CONNECT_TIMEOUT,  
	                    timeout);  
	  
	            // ͨ��Dispatch������Ϣ,�᷵����Ӧ��Ϣ  
	            SOAPMessage response = dispatch.invoke(msg);  
	  
	            // ��Ӧ��Ϣ����,����Ӧ����Ϣת��Ϊdoc����  
	            Document doc = response.getSOAPPart().getEnvelope().getBody()  
	                    .extractContentAsDocument();  
	            String ret = doc.getElementsByTagName(responseName).item(0)  
	                    .getTextContent();  
	            return ret;  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            throw e;  
	        }  
	    }  
}
