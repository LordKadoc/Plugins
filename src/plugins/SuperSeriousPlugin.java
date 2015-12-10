package plugins;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.PluginWindow;



public class SuperSeriousPlugin implements Plugin {

	@Override
	public String transform(String text) {
		JPanel gifpanel = new JPanel(new GridLayout(2,3));
		PluginWindow.getInstance().getPanel().removeAll();
		PluginWindow.getInstance().getPanel().add(gifpanel, BorderLayout.CENTER);
		
		/*gifpanel.add(new JLabel(new ImageIcon("allhailthehypnotoad.gif")));
		
		gifpanel.add(new JLabel(new ImageIcon("allhailthehypnotoad.gif")));
		gifpanel.add(new JLabel(new ImageIcon("allhailthehypnotoad.gif")));
		
		gifpanel.add(new JLabel(new ImageIcon("allhailthehypnotoad.gif")));
		gifpanel.add(new JLabel(new ImageIcon("allhailthehypnotoad.gif")));*/
		
		gifpanel.add(new JLabel(new ImageIcon("nyancat.gif")));
		gifpanel.add(new JLabel(new ImageIcon("travolta.gif")));
		gifpanel.add(new JLabel(new ImageIcon("dramatic.gif")));
		gifpanel.add(new JLabel(new ImageIcon("mask.gif")));
		gifpanel.add(new JLabel(new ImageIcon("go-bwah.gif")));
		gifpanel.add(new JLabel(new ImageIcon("snoop.gif")));
		
		gifpanel.setBackground(Color.BLACK);
		
		PluginWindow.getInstance().setSize(1200,700);
		PluginWindow.getInstance().setLocationRelativeTo(null);
		PluginWindow.getInstance().revalidate();
		return text;
	}

	@Override
	public String getName() {
		return "Multi gif party";
	}

	@Override
	public String getDescription() {
		return "Famous gifs of the Internet";
	}
	
}
