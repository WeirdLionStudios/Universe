package wls.trek.universe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import wls.trek.universe.objects.Body;
import wls.trek.universe.objects.Universe;

public class UniverseGraphics extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public static final int FRAME_WIDTH=1024;
	public static final int FRAME_HEIGHT=768;
	
	int width=Toolkit.getDefaultToolkit().getScreenSize().width;
	int height=Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public JFrame frame;
	
	public UniverseGraphics(){
		
		frame=new JFrame("UNIVERSE - VERSION 0.1");
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocation((width-FRAME_WIDTH)/2,(height-FRAME_HEIGHT)/2);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		
	}
	
	@Override
	protected void paintComponent(Graphics g){
		
		//draw background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		
		//draw objects
		for(Body body : Universe.bodies){
			body.renderBody(g);
			body.velocity.renderVector(g);
		}
		
		repaint();
	}

}
