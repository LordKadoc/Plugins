package window;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import plugins.Plugin;

public class PluginPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1670880926788111875L;
		
	private JTextArea area;

	public PluginPanel(){
		this.setPreferredSize(new Dimension(500,500));
		this.setLayout(new BorderLayout());
		this.area = new JTextArea();
		this.add(area,BorderLayout.CENTER);
	}
	
	public JTextArea getArea(){
		return area;
	}
	
	public void applyPlugin(Plugin plugin){
		this.area.setText(plugin.transform(area.getText()));
	}

}
