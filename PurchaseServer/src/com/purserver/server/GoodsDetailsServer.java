package com.purserver.server;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.IselectItemsGetRequest;
import com.taobao.api.response.IselectItemsGetResponse;

public class GoodsDetailsServer {
	
	
	private static String URL = "http://gw.api.taobao.com/router/rest";
	private static String APP_KEY = "23199636";
	private static String SECRET = "00b4e6d619fca0c3a4c36309d8790093";
//	private static String SessionKey = "6100220166096965371b82476e271d8a6391f0b37cb8584505957550";
	
	
	public String getGoodsDetails(String tagIds,Long pageSize,Long page){
		TaobaoClient client = new DefaultTaobaoClient(URL, APP_KEY, SECRET);
		IselectItemsGetRequest req = new IselectItemsGetRequest();
		
		req.setTagIds(tagIds);
		req.setPageSize(pageSize);
		req.setPage(page);
		IselectItemsGetResponse response = null;
		try {
			response = client.execute(req);
//			System.out.println("result:"+response.getBody());
			
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return response.getBody();
	}
	
}
