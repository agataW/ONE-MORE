package pl.wujko.one_more.code.constance;

/**
 * Created by Agata on 2016-02-22.
 */
public enum PanSize
{
	NO_PAN(0, 0),
	NORMAL(1490, 1190),
	SIZE_35(1590, 1450);

	private int price;

	private int priceWithDiscount;

	PanSize(int price, int discount)
	{
		this.price = price;
		this.priceWithDiscount = discount;
	}

	public int getPrice()
	{
		return price;
	}

	public int getPriceWithDiscount()
	{
		return priceWithDiscount;
	}
}
