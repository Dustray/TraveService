package trave.service.api;

import java.util.HashMap;

public class Weather {
	// ����Web Service�������ռ�
	static final String NAME_SPACE = "http://WebXml.com.cn/";
	// ����Web Service�ṩ�����URL
	static final String SERVICE_URL = "http://ws.webxml.com.cn/WebServices/WeatherWebService.asmx";

	static final String methodName = "getWeatherbyCityName";

	static final String methodParameter = "theCityName";

	public static void main(String[] args) {
		System.out.println("ss" + getNowHumidityAndAirQuality("�ൺ"));

	}

	public static String getNowHumidityAndAirQuality(String city) {
		WebServiceClient ws = new WebServiceClient("http://WebXml.com.cn/", SERVICE_URL, "WeatherWebService",
				"WeatherWebServiceSoap12", methodName, "getWeatherbyCityNameResult");
		HashMap<String, String> inMsg = new HashMap<String, String>();
		inMsg.put(methodParameter, city);
		String ret = "";
		try {
			ret = ws.sendMessage(inMsg);
			System.out.println(ret.toString()); // û�жԽ��������
		} catch (Exception e) {
			e.printStackTrace();
			return "ʪ�ȣ�61%;������������";
		}
		String[] _1 = null;
		try {
			String _0 = ret.split("\n")[0];
			_1 = _0.split("��|��");
			System.out.println("ʪ�ȣ�" + _1[2]);
			System.out.println("����������" + _1[4]);
		} catch (IndexOutOfBoundsException ex) {
			return "ʪ�ȣ�61%;������������";
		}

		return _1[2] + ";" + _1[4];
	}

}
