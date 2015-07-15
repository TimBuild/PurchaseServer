package com.purserver.test;

import org.junit.Test;

import com.purserver.server.GoodsDetailsServer;
import com.purserver.util.GoodsItemJson;

public class TestGoodsService {

	@Test
	public void test() {
		GoodsDetailsServer goodsDetailsServer = new GoodsDetailsServer();
		System.out.println(GoodsItemJson.getGoodsItem(goodsDetailsServer.getGoodsDetails("3212",Long.parseLong("20"),Long.parseLong("0"))));
	}

}
