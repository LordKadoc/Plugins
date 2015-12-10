package plugins;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.PluginWindow;



public class SuperSeriousPlugin3TheEyeOfTheTiger implements Plugin{

	@Override
	public String transform(String text) {
		JPanel gifpanel = new JPanel(new GridLayout(4,4));
		PluginWindow.getInstance().getPanel().removeAll();
		PluginWindow.getInstance().getPanel().add(gifpanel, BorderLayout.CENTER);
		
		gifpanel.setBackground(Color.BLACK);
		
		new ThreadPlugin(gifpanel).start();
		
		PluginWindow.getInstance().setSize(1200,700);
		PluginWindow.getInstance().setLocationRelativeTo(null);
		PluginWindow.getInstance().revalidate();
		return text;
	}

	@Override
	public String getName() {
		return "MLG Frog";
	}

	@Override
	public String getDescription() {
		return "Frog spawning randomly on the screen";
	}
	
	class ThreadPlugin extends Thread{
		
		private int lastX = 0, lastY = 0;
		
		private JPanel gifpanel;
		
		private JPanel[][] panels;
		
		ThreadPlugin(JPanel panel){
			this.gifpanel = panel;
			this.panels = new JPanel[4][4];
			this.putPanel();
		}
		
		@Override
		public void run() {
			
			int x, y;
			
			try{
				
				while(true){
						
					x = (int)(Math.random()*4);
					y = (int)(Math.random()*4);
				
					panels[lastX][lastY].removeAll();
					panels[lastX][lastY].repaint();
					
					
					if(Math.random()*100 > 99){
						panels[x][y].add(new JLabel(new ImageIcon("travolta.gif")));
						gifpanel.revalidate();
						Thread.sleep(1000);
					}
					
					panels[x][y].add(new JLabel(new ImageIcon("mlg.gif")));
					gifpanel.revalidate();
					
					Thread.sleep(500);
					
					lastX = x;
					lastY = y;
					
				}

			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public void putPanel(){
			JPanel panel;
			for(int i=0;i<panels.length;i++){
				for(int j=0;j<panels[0].length;j++){
					panel = new JPanel();
					panel.setBackground(Color.black);
					panels[i][j] = panel;
					gifpanel.add(panels[i][j]);
				}
			}
		}
	}	

}
