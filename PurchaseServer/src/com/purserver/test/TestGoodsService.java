package com.purserver.test;

import org.junit.Test;

import com.purserver.server.DiscountServer;
import com.purserver.server.GoodsDetailsServer;
import com.purserver.server.AiTaobaoSearchServer;
import com.purserver.util.JsonParseList;

public class TestGoodsService {

	@Test
	public void test() {
		GoodsDetailsServer goodsDetailsServer = new GoodsDetailsServer();
		System.out.println(JsonParseList.getGoodsItem(goodsDetailsServer.getGoodsDetails("4035",Long.parseLong("20"),Long.parseLong("0"))));
	}
	
	@Test
	public void test1(){
		AiTaobaoSearchServer goodsSearchServer = new AiTaobaoSearchServer();
		System.out.println("test1:"+JsonParseList.getAiTaoSearch(goodsSearchServer.getGoodsSearch("衬衫",1L,10L,"commissionNum_desc")));
	}
	
	@Test
	public void test2(){
		DiscountServer discountServer = new DiscountServer();
//		System.out.println("test2:"+discountServer.getDiscountSearch("女装", 1L, 20L, "volume_desc"));
		
		String discount = discountServer.getDiscountSearch("女装", 1L, 20L, "volume_desc");
		System.out.println(JsonParseList.getDiscountList(discount).size());
				
	}

}
