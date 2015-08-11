package com.purserver.service;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.purserver.entity.AiTaoBao;
import com.purserver.entity.GoodsItem;
import com.purserver.server.GoodsDetailsServer;
import com.purserver.server.GoodsSearchServer;
import com.purserver.util.GoodsItemJson;

@Path("/GoodsService")
public class GoodsService {

	private GoodsDetailsServer goodsServer = new GoodsDetailsServer();
	private GoodsSearchServer goodsSearch = new GoodsSearchServer();

	@POST
	@Path("/getGoods")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<GoodsItem> getGoods(@FormParam("tagIds") String tagIds,
			@FormParam("pageSize") String pageSize,
			@FormParam("page") String page) {

		List<GoodsItem> lists = GoodsItemJson.getGoodsItem(goodsServer
				.getGoodsDetails(tagIds, Long.parseLong(pageSize),
						Long.parseLong(page)));
		return lists;

	}

	@POST
	@Path("/searchGoods")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<AiTaoBao> getGoods(@FormParam("page_no") String page_no,
			@FormParam("page_size") String page_size) {

		List<AiTaoBao> lists = GoodsItemJson.getAiTaoSearch(goodsSearch
				.getGoodsSearch(Long.parseLong(page_no),
						Long.parseLong(page_size)));
		return lists;

	}
}
