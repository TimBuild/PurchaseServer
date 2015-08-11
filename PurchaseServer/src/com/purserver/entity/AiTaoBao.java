package com.purserver.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AiTaoBao {

	private String open_iid;// ������Ʒid
	private String pic_url;// ͼƬurl
	private String title;// ��Ʒ����
	private Double price;// ��Ʒ�۸�
	private String nick;// �����ǳ�
	private String shop_type;// ��������BΪ��è��CΪ����

	private String commission_num;// �ۼƳɽ���
	private Integer seller_credit_score;// �������õȼ�

	public AiTaoBao() {
		super();
	}

	public AiTaoBao(String open_iid, String pic_url, String title,
			Double price, String nick, String shop_type, String commission_num,
			Integer seller_credit_score) {
		super();
		this.open_iid = open_iid;
		this.pic_url = pic_url;
		this.title = title;
		this.price = price;
		this.nick = nick;
		this.shop_type = shop_type;
		this.commission_num = commission_num;
		this.seller_credit_score = seller_credit_score;
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

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getShop_type() {
		return shop_type;
	}

	public void setShop_type(String shop_type) {
		this.shop_type = shop_type;
	}

	public String getCommission_num() {
		return commission_num;
	}

	public void setCommission_num(String commission_num) {
		this.commission_num = commission_num;
	}

	public Integer getSeller_credit_score() {
		return seller_credit_score;
	}

	public void setSeller_credit_score(Integer seller_credit_score) {
		this.seller_credit_score = seller_credit_score;
	}

	@Override
	public String toString() {
		return "AiTaoBao [open_iid=" + open_iid + ", pic_url=" + pic_url
				+ ", title=" + title + ", price=" + price + ", nick=" + nick
				+ ", shop_type=" + shop_type + ", commission_num="
				+ commission_num + ", seller_credit_score="
				+ seller_credit_score + "]";
	}

}
