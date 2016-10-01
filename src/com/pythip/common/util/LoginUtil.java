package com.pythip.common.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Random;

public class LoginUtil {
	/**
	 * 生成验证图片
	 * **/
	public static BufferedImage getValidCodeImage(String code){
		int width = 52;
		int height = 38;
		BufferedImage bufferImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics g = bufferImage.createGraphics();
		g.setColor(new Color(93,202,27));
		g.fillRect(0, 0, width, height);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setPaint(new Color(255,255,255));
		int fontSize = 16;
		Font font = new Font("微软雅黑",Font.PLAIN,fontSize);
		g2d.setFont(font);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); 
		int strWidth = g2d.getFontMetrics().stringWidth(code);
		g2d.drawString(code, (width -  strWidth)/2, fontSize/2 + height/2);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
		g2d.drawString(code, (width -  strWidth)/2, fontSize/2 + height/2);
		g2d.drawString(code, (width -  strWidth)/2, fontSize/2 + height/2);
		g2d.dispose();
		g.dispose();
		return bufferImage;
	}
	/**
	 * 生成包含大写字母，小写字母，数字的随机数
	 * 0-9 48-57
	 * a-z 97-122
	 * A-Z 65-90
	 * **/
	public static String getRandomCode(int number){
		Random r = new Random();
		String str = "";
		for(int x = 0;x<number;x++){
			/**10+26+26**/
			int num = r.nextInt(62);
			/**大写字母10-35**/
			if(num >= 10 && num < 36){
				str += (char)((65-10)+num);
			/**小写字母36-61**/
			}else if(num >= 36){
				str += (char)((97-36)+num);
			}else{
				str += num;
			}
		}
		return str;
	}	
}
