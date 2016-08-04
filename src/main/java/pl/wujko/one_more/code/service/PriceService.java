package pl.wujko.one_more.code.service;

import pl.wujko.one_more.code.constance.PanSize;
import pl.wujko.one_more.code.constance.PanType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Agata on 2016-08-03.
 */
public class PriceService
{
	private static Map<PanSize, Map<PanType, Integer>> priceMap = new HashMap<PanSize, Map<PanType, Integer>>(){{
		Map<PanType, Integer> noPan = new HashMap<PanType, Integer>();
		noPan.put(PanType.NO_PANE, 0);
		noPan.put(PanType.NORMAL, 0);
		noPan.put(PanType.AMERICAN, 0);
		put(PanSize.NO_PAN, noPan);

		Map<PanType, Integer> size32 = new HashMap<PanType, Integer>();
		size32.put(PanType.NO_PANE, 0);
		size32.put(PanType.NORMAL, 1490);
		size32.put(PanType.AMERICAN, 1490);
		put(PanSize.SIZE_32, size32);

		Map<PanType, Integer> size40 = new HashMap<PanType, Integer>();
		size40.put(PanType.NO_PANE, 0);
		size40.put(PanType.NORMAL, 2200);
		size40.put(PanType.AMERICAN, 2000);
		put(PanSize.SIZE_40, size40);
	}};

	private static Map<PanSize, Map<PanType, Integer>> discountPriceMap = priceMap;

	public int getPrice(PanSize size, PanType type)
	{
		return priceMap.get(size).get(type);
	}

	public int getDiscountPrice(PanSize size, PanType type)
	{
		return discountPriceMap.get(size).get(type);
	}
}
