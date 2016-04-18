package ihm.theme;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class ThemeLIPPS
{
	
	public static final Color BLUE = new Color(55, 135, 200);
	public static final Color BLUE_DARK = new Color(27, 80, 133);
	public static final Color ORANGE = new Color(232, 102, 10);
	public static final Color GREEN = new Color(71, 169, 51);
	public static final Color GREY_TEXT = new Color(105, 105, 105);
	public static final Color GREY_LIGHT = new Color(242, 242, 242);
	
	public static final String FONT_RALEWAY_THIN = getRalewayThin();
	public static final String FONT_RALEWAY_EXTRALIGHT = getRalewayExtraLight();
	public static final String FONT_RALEWAY_LIGHT = getRalewayLight();
	public static final String FONT_RALEWAY_REGULAR = getRalewayRegular();
	public static final String FONT_RALEWAY_MEDIUM = getRalewayMedium();
	public static final String FONT_RALEWAY_SEMIBOLD = getRalewaySemiBold();
	public static final String FONT_RALEWAY_BOLD = getRalewayBold();
	public static final String FONT_RALEWAY_EXTRABOLD = getRalewayExtraBold();
	public static final String FONT_RALEWAY_HEAVY = getRalewayHeavy();
	public static final String FONT_DEFAULT = "Century Gothic";
	

	
	
	
	
	
	private static String getRalewayThin()
	{
		try 
		{
		     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("ressources/Raleway-Thin.ttf")));
		} 
		catch (IOException|FontFormatException e) 
		{e.printStackTrace();}
		
		return "Raleway Thin";
	}




	private static String getRalewayExtraLight()
	{
		try 
		{
		     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("ressources/Raleway-ExtraLight.ttf")));
		     
		} 
		catch (IOException|FontFormatException e) 
		{e.printStackTrace();}
		
		return "Raleway ExtraLight";
	}


	private static String getRalewayLight()
	{
		try 
		{
		     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("ressources/Raleway-Light.ttf")));
		     
		} 
		catch (IOException|FontFormatException e) 
		{e.printStackTrace();}
		
		return "Raleway Light";
	}


	private static String getRalewayRegular()
	{
		try 
		{
		     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("ressources/Raleway-Regular.ttf")));
		     
		} 
		catch (IOException|FontFormatException e) 
		{e.printStackTrace();}
		
		return "Raleway Regular";
	}
	
	
	


	private static String getRalewayMedium()
	{
		
		try 
		{
		     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("ressources/Raleway-Medium.ttf")));
		} 
		catch (IOException|FontFormatException e) 
		{e.printStackTrace();}
		
		return "Raleway Medium";
	}


	
	
	private static String getRalewaySemiBold()
	{
		try 
		{
		     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("ressources/Raleway-SemiBold.ttf")));
		     
		} 
		catch (IOException|FontFormatException e) 
		{e.printStackTrace();}
		
		return "Raleway SemiBold";
	}
	



	private static String getRalewayBold()
	{
		try 
		{
		     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("ressources/Raleway-Bold.ttf")));
		     
		} 
		catch (IOException|FontFormatException e) 
		{e.printStackTrace();}
		
		return "Raleway Bold";
	}





	private static String getRalewayExtraBold()
	{
		try 
		{
		     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("ressources/Raleway-ExtraBold.ttf")));
		     
		} 
		catch (IOException|FontFormatException e) 
		{e.printStackTrace();}
		
		return "Raleway ExtraBold";
	}




	private static String getRalewayHeavy()
	{
		try 
		{
		     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("ressources/Raleway-Heavy.ttf")));
		} 
		catch (IOException|FontFormatException e) 
		{e.printStackTrace();}
		
		return "Raleway Heavy";
	}
	
}
