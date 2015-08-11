package com.purserver.test;

import org.junit.Test;

import com.purserver.server.GoodsDetailsServer;
import com.purserver.server.GoodsSearchServer;
import com.purserver.util.GoodsItemJson;

public class TestGoodsService {

	@Test
	public void test() {
		GoodsDetailsServer goodsDetailsServer = new GoodsDetailsServer();
		System.out.println(GoodsItemJson.getGoodsItem(goodsDetailsServer.getGoodsDetails("4035",Long.parseLong("20"),Long.parseLong("0"))));
	}
	
	@Test
	public void test1(){
		GoodsSearchServer goodsSearchServer = new GoodsSearchServer();
//		System.out.println("test1:"+GoodsItemJson.getAiTaoSearch(goodsSearchServer.getGoodsSearch()));
	}

}
