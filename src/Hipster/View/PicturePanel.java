package Hipster.View;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PicturePanel extends JPanel
{
	private Image baseImage;
	private ImageIcon pictureSource;
	private int width;
	private int height;
	
	public PicturePanel(URL imagePath, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.pictureSource = new ImageIcon(imagePath);
	}
	
	protected void paintComponent(Graphics panelGraphics)
	{
		super.paintComponents(panelGraphics);
		baseImage = pictureSource.getImage();
		panelGraphics.drawImage(baseImage,0,0, width, height ,null);
	}
}
