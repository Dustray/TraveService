package trave.service.api;

import com.show.api.ShowApiRequest;

public class Attractions {
	private static String appid = "55963";// 要替换成自己的
	private static String secret = "792fc4adf3284ee09e7f6fc5a4397a89";// 要替换成自己的

	public String getAttractionJson(String cityid, String proid) {

		String res = new ShowApiRequest("http://route.showapi.com/268-1", appid, secret).addTextPara("keyword", "")
				.addTextPara("proId", proid).addTextPara("cityId", cityid).addTextPara("areaId", "")
				.addTextPara("page", "").get();

		//System.out.println("get: " + cityid + "L" + proid + "\n" + res);
		return res;
	}
	
	public String getCityJson(String provinceid){
		String res = new ShowApiRequest("http://route.showapi.com/268-3", appid, secret)
                .addTextPara("proId", provinceid)
                .post();
		System.out.println("get: " + provinceid +"\n" + res);
		return res;
	}
	
	public String getProvinceJson(){
		final String res = new ShowApiRequest("http://route.showapi.com/268-2", appid, secret)
                .post();
		System.out.println("get: \n" + res);
		return res;
	}
	
}
