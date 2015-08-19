package com.purserver.util;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.purserver.entity.AiTaoBao;
import com.purserver.entity.GoodsItem;

public class GoodsItemJson {

	/**
	 * 综合排序
	 * 
	 * @param goodsItem
	 * @return
	 */
	public static List<GoodsItem> getGoodsItem(String goodsItem) {

		JSONObject jsonObject;
		List<GoodsItem> listGoods = new ArrayList<>();
		try {

			jsonObject = new JSONObject(goodsItem);
			JSONObject jsonObject2 = jsonObject
					.getJSONObject("iselect_items_get_response");
			JSONObject jsonObject3 = (JSONObject) jsonObject2.get("items");
			// System.out.println(jsonObject3.length());
			if (jsonObject3.length() != 0) {
				JSONArray jsonArray = jsonObject3.getJSONArray("i_select_item");

				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject items = (JSONObject) jsonArray.opt(i);

					GoodsItem goods = new GoodsItem();

					String discount_price = (String) items
							.get("discount_price");
					String open_iid = (String) items.get("open_iid");
					String pic_url = (String) items.get("pic_url");
					String pics = (String) items.get("pics");
					String price = (String) items.get("price");
					String properties_and_values = (String) items
							.get("properties_and_values");
					int shop_type = (int) items.get("shop_type");
					int tag_id = (int) items.get("tag_id");
					String title = (String) items.get("title");

					goods.setDiscount_price(discount_price);
					goods.setOpen_iid(open_iid);
					goods.setPic_url(pic_url);
					goods.setPics(pics);
					goods.setPrice(price);
					goods.setProperties_and_values(properties_and_values);
					goods.setShop_type(shop_type);
					goods.setTag_id(tag_id);
					goods.setTitle(title);

					listGoods.add(goods);

				}
				GoodsItem goods = new GoodsItem();
				listGoods.add(goods);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return listGoods;

	}

	/**
	 * 爱淘宝商品转换成json传给客户端,客户端取得数据记得要减一
	 * 
	 * @param aiTao
	 * @return
	 */
	public static List<AiTaoBao> getAiTaoSearch(String aiTao) {
		JSONObject jsonObject;
		List<AiTaoBao> listGoods = new ArrayList<>();

		try {
			jsonObject = new JSONObject(aiTao);
			JSONObject jsonObject2 = jsonObject
					.getJSONObject("atb_items_get_response");

			// System.out.println(jsonObject2.get("total_results").equals(0));
			if (!jsonObject2.get("total_results").equals(0)) {

				JSONObject jsonObject3 = (JSONObject) jsonObject2.get("items");
				if (jsonObject3.length() != 0) {
					JSONArray jsonArray = jsonObject3
							.getJSONArray("aitaobao_item");
					for (int i = 0; i < jsonArray.length(); i++) {
						JSONObject items = (JSONObject) jsonArray.opt(i);

						AiTaoBao good = new AiTaoBao();

						String open_iid = (String) items.get("open_iid");
						String pic_url = (String) items.get("pic_url");
						String title = (String) items.get("title");
						double price = (double) items.get("promotion_price");
						String shop_type = (String) items.get("shop_type");
						String nick = (String) items.get("nick");
						String commission_num = (String) items
								.get("commission_num");
						int seller_credit_score = (int) items
								.get("seller_credit_score");

						good.setOpen_iid(open_iid);
						good.setPic_url(pic_url);
						good.setTitle(title);
						good.setPrice(price);
						good.setNick(nick);
						good.setShop_type(shop_type);
						good.setCommission_num(commission_num);
						good.setSeller_credit_score(seller_credit_score);

						listGoods.add(good);
					}
					AiTaoBao good = new AiTaoBao();
					listGoods.add(good);
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return listGoods;

	}

}
