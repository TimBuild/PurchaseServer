package com.purserver.util;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.purserver.entity.GoodsItem;

public class GoodsItemJson {

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
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return listGoods;

	}
}
