package com.purserver.service;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.purserver.entity.AiTaoBao;
import com.purserver.entity.DiscountBao;
import com.purserver.entity.GoodsItem;
import com.purserver.server.AiTaobaoSearchServer;
import com.purserver.server.DiscountServer;
import com.purserver.server.GoodsDetailsServer;
import com.purserver.util.JsonParseList;

@Path("/GoodsService")
public class GoodsService {

	private GoodsDetailsServer goodsServer = new GoodsDetailsServer();
	private AiTaobaoSearchServer goodsSearch = new AiTaobaoSearchServer();
	private DiscountServer discountServer = new DiscountServer();

	@POST
	@Path("/getGoods")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<GoodsItem> getGoods(@FormParam("tagIds") String tagIds,
			@FormParam("pageSize") String pageSize,
			@FormParam("page") String page) {

		List<GoodsItem> lists = JsonParseList.getGoodsItem(goodsServer
				.getGoodsDetails(tagIds, Long.parseLong(pageSize),
						Long.parseLong(page)));
		return lists;

	}

	@POST
	@Path("/searchGoods")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<AiTaoBao> getGoodsSearch(@FormParam("keyword") String keyword,
			@FormParam("page_no") String page_no,
			@FormParam("page_size") String page_size,
			@FormParam("sort") String sort) {

		String aitaobao = goodsSearch.getGoodsSearch(keyword,
				Long.parseLong(page_no), Long.parseLong(page_size), sort);
		List<AiTaoBao> lists = JsonParseList.getAiTaoSearch(aitaobao);
		return lists;

	}
	
	@POST
	@Path("/searchDiscountGoods")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<DiscountBao> getDiscount(@FormParam("keyword") String keyword,
			@FormParam("page_no") String page_no,
			@FormParam("page_size") String page_size,
			@FormParam("sort") String sort) {
		String discount = discountServer.getDiscountSearch(keyword,
				Long.parseLong(page_no), Long.parseLong(page_size), sort);
		List<DiscountBao> lists = JsonParseList.getDiscountList(discount);
		return lists;
	}
}
