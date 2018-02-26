package trave.service.api;

import java.util.HashMap;

public class Weather {
	// 定义Web Service的命名空间
	static final String NAME_SPACE = "http://WebXml.com.cn/";
	// 定义Web Service提供服务的URL
	static final String SERVICE_URL = "http://ws.webxml.com.cn/WebServices/WeatherWebService.asmx";

	static final String methodName = "getWeatherbyCityName";

	static final String methodParameter = "theCityName";

	public static void main(String[] args) {
		System.out.println("ss" + getNowHumidityAndAirQuality("青岛"));

	}

	public static String getNowHumidityAndAirQuality(String city) {
		WebServiceClient ws = new WebServiceClient("http://WebXml.com.cn/", SERVICE_URL, "WeatherWebService",
				"WeatherWebServiceSoap12", methodName, "getWeatherbyCityNameResult");
		HashMap<String, String> inMsg = new HashMap<String, String>();
		inMsg.put(methodParameter, city);
		String ret = "";
		try {
			ret = ws.sendMessage(inMsg);
			System.out.println(ret.toString()); // 没有对结果做处理
		} catch (Exception e) {
			e.printStackTrace();
			return "湿度：61%;空气质量：中";
		}
		String[] _1 = null;
		try {
			String _0 = ret.split("\n")[0];
			_1 = _0.split("；|。");
			System.out.println("湿度：" + _1[2]);
			System.out.println("空气质量：" + _1[4]);
		} catch (IndexOutOfBoundsException ex) {
			return "湿度：61%;空气质量：中";
		}

		return _1[2] + ";" + _1[4];
	}

}
