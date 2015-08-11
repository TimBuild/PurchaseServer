package com.purserver.server;

import static com.purserver.global.Constants.APP_KEY;
import static com.purserver.global.Constants.SECRET;
import static com.purserver.global.Constants.URL;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.IselectItemsGetRequest;
import com.taobao.api.response.IselectItemsGetResponse;

public class GoodsDetailsServer {

	public String getGoodsDetails(String tagIds, Long pageSize, Long page) {
		TaobaoClient client = new DefaultTaobaoClient(URL, APP_KEY, SECRET);
		IselectItemsGetRequest req = new IselectItemsGetRequest();

		req.setTagIds(tagIds);
		req.setPageSize(pageSize);
		req.setPage(page);
		IselectItemsGetResponse response = null;
		try {
			response = client.execute(req);
			// System.out.println("result:"+response.getBody());

		} catch (ApiException e) {
			e.printStackTrace();
		}
		return response.getBody();
	}

}
