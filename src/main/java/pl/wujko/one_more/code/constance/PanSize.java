package pl.wujko.one_more.code.constance;

/**
 * Created by Agata on 2016-02-22.
 */
public enum PanSize
{
	NO_PAN(0, 0),
	SIZE_32(1490, 1490),
	SIZE_35(2000, 2000),
	SIZE_40(2200, 2200);

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
