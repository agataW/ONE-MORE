package pl.wujko.one_more.thread;

import pl.wujko.one_more.bean.BeanHelper;
import pl.wujko.one_more.frontend.controller.CartListController;

/**
 * Created by Agata on 2016-11-25.
 */
public class TimerThread extends Thread
{
	private CartListController cartListController;

	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				sleep(10000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			getCartListController().updateTimers();
		}
	}

	private CartListController getCartListController()
	{
		if (cartListController == null)
		{
			cartListController = (CartListController) BeanHelper.getBean("cartListController");
		}
		return cartListController;
	}
}
