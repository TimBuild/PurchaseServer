package com.purserver.server;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AtbItemsCouponGetRequest;
import com.taobao.api.response.AtbItemsCouponGetResponse;

import static com.purserver.global.Constants.APP_KEY;
import static com.purserver.global.Constants.SECRET;
import static com.purserver.global.Constants.URL;

public class DiscountServer {
	
	public String getDiscountSearch(String keyword,Long page_no,Long page_size,String sort){
		TaobaoClient client=new DefaultTaobaoClient(URL, APP_KEY, SECRET);
		AtbItemsCouponGetRequest req=new AtbItemsCouponGetRequest();
		req.setCouponType(1L);
		req.setFields("open_iid,title,pic_url,nick,shop_type,coupon_price,price");
		req.setKeyword(keyword);
		req.setPageNo(page_no);
		req.setPageSize(page_size);
		req.setSort(sort);
		AtbItemsCouponGetResponse response = null;
		try {
			response = client.execute(req);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return response.getBody();
	}
}
