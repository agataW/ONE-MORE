package pl.wujko.one_more.frontend;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Agata on 2015-06-30.
 */
public class GUIConstants
{
	public static final String FRAME_TITLE = "One-More Kalkulator";
	
	public static final Color MAIN_PANEL_BACKGROUND = new Color(30, 30, 30);
	
	public static final Font DEFAULT_FONT = new Font("Tahoma", Font.BOLD, 18);
	
	public static final Font TIMER_FONT = new Font("Tahoma", Font.PLAIN, 16);
	
	public static final Color BUTTON_FONT_COLOR = new Color(200, 200, 200);
	
	public static class Image
	{
		public static final ImageIcon CLOCK_RED = getImage("img/icons/clock_red_32.png");
		
		public static final ImageIcon CLOCK_GREY = getImage("img/icons/clock_grey_32.png");
		
		public static final ImageIcon TRASH = getImage("img/icons/trash_black_24.png");
		
		public static final ImageIcon EDIT = getImage("img/icons/gear_black_24.png");
		
		public static ImageIcon getImage(String imageSource)
		{
			try
			{
				BufferedImage bufferedImage = ImageIO.read(GUIConstants.class.getClassLoader().getResourceAsStream(imageSource));
				return new ImageIcon(bufferedImage.getScaledInstance(-1, -1, java.awt.Image.SCALE_SMOOTH));
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			return null;
		}
	}
	
	public static class WorkSpace
	{
		public static final Color PANEL_BACKGROUND = OmColor.GRAY_DARK;
		
		public static final Border BORDER = BorderFactory.createLineBorder(OmColor.RED, 2);
		
		public static final Border BORDER_BLACK = BorderFactory.createLineBorder(OmColor.BLACK, 2);
		
		public static final Color BUTTON_SELECTED = OmColor.GREEN;
		
		public static final Color BUTTON_DISABLE = OmColor.GRAY_LIGHT;
	}
	
	public static class Cart
	{
		public static final Color HEADER_PANEL_BACKGROUND = OmColor.GRAY;
		
		public static final Border BORDER_RED_2 = BorderFactory.createLineBorder(OmColor.RED, 2);
		
		public static final Border BORDER_GRAY_DARK_2 = BorderFactory.createLineBorder(OmColor.GRAY_DARK, 2);
		
	}
	
	public static class CartEntry
	{
		public static final Color PANEL_BACKGROUND = OmColor.GRAY_LIGHT;
	}
	
	public static class ConfirmDelete
	{
		public static final Color LABEL_FOREGROUND = new Color(200, 200, 200);
		
		public static final Color BUTTONS_BACKGROUND = new Color(200, 200, 200);
	}
	
	public static class PanSizeColour
	{
		public static final Color BACKGROUND_40 = OmColor.PURPLE;
	}
	
	public static class Additions
	{
		public static final Color FONT_COLOUR = OmColor.BLACK;
		public static final Color BACKGROUND_COLOR = OmColor.BLUE;
	}
	
	private static class OmColor
	{
		public static final Color BLACK = Color.BLACK;
		public static final Color BLUE =  new Color(56, 166, 255);
		public static final Color GRAY = new Color(140, 140, 140);
		public static final Color GRAY_LIGHT = new Color(160, 160, 160);
		public static final Color GRAY_DARK = new Color(30, 30, 30);
		public static final Color PURPLE = new Color(73, 79, 255);
		public static final Color RED = new Color(216, 0, 39);
		public static final Color GREEN = new Color(74, 255, 41);
	}
}