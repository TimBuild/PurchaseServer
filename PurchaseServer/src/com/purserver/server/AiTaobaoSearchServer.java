package com.purserver.server;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AtbItemsGetRequest;
import com.taobao.api.response.AtbItemsGetResponse;

import static com.purserver.global.Constants.APP_KEY;
import static com.purserver.global.Constants.SECRET;
import static com.purserver.global.Constants.URL;

public class AiTaobaoSearchServer {

	public String getGoodsSearch(String keyword,Long page_no, Long page_size,String sort) {
		TaobaoClient client = new DefaultTaobaoClient(URL, APP_KEY, SECRET);
		AtbItemsGetRequest req = new AtbItemsGetRequest();
//		req.setCid(50012482L);
//		req.setEndPrice("10000");
		req.setKeyword(keyword);
		req.setFields("nick,shop_type,open_iid,title,pic_url,promotion_price,seller_credit_score,commission_num");
		req.setPageNo(page_no);
		req.setPageSize(page_size);
		req.setSort(sort);
		req.setStartCredit("1crown");
		AtbItemsGetResponse response = null;
		try {
			response = client.execute(req);
		} catch (ApiException e) {
			e.printStackTrace();
		}
//		System.out.println("---->" + response.getBody());
		return response.getBody();

	}
}
