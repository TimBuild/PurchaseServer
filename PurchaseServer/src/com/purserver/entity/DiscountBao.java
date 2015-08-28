package com.purserver.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DiscountBao {
	private String open_iid;// ������Ʒid
	private String pic_url;// ͼƬurl
	private String title;// ��Ʒ����
	private Double price;// ��Ʒ�۸�
	private Double coupon_price;// ��Ʒ�ۿۼ۸�
	private String shop_type;// ��������BΪ��è��CΪ����
	private String nick;// ��������

	public DiscountBao() {
		super();
	}

	public DiscountBao(String open_iid, String pic_url, String title,
			Double price, Double coupon_price, String shop_type, String nick) {
		super();
		this.open_iid = open_iid;
		this.pic_url = pic_url;
		this.title = title;
		this.price = price;
		this.coupon_price = coupon_price;
		this.shop_type = shop_type;
		this.nick = nick;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getOpen_iid() {
		return open_iid;
	}

	public void setOpen_iid(String open_iid) {
		this.open_iid = open_iid;
	}

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getCoupon_price() {
		return coupon_price;
	}

	public void setCoupon_price(Double coupon_price) {
		this.coupon_price = coupon_price;
	}

	public String getShop_type() {
		return shop_type;
	}

	public void setShop_type(String shop_type) {
		this.shop_type = shop_type;
	}

	@Override
	public String toString() {
		return "DiscountBao [open_iid=" + open_iid + ", pic_url=" + pic_url
				+ ", title=" + title + ", price=" + price + ", coupon_price="
				+ coupon_price + ", shop_type=" + shop_type + ", nick=" + nick
				+ "]";
	}

}
