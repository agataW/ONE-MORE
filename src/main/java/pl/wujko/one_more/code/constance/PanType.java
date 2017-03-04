package pl.wujko.one_more.code.constance;

/**
 * Created by Agata on 2016-02-22.
 */
public enum PanType
{
	NORMAL(0),
	AMERICAN(200),
	NO_PANE(0);
	
	int price;
	
	PanType(int price)
	{
		this.price = price;
	}
	
	public int getPrice()
	{
		return price;
	}
}
