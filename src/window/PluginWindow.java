package window;

import javax.swing.JFrame;

public class PluginWindow extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2419253037466297548L;
	
	private PluginBar bar;
	
	private PluginPanel panel;
	
	private static final PluginWindow instance = new PluginWindow();

	private PluginWindow(){
		
		this.bar = new PluginBar();
		this.panel = new PluginPanel();
		
		this.setTitle("TP Plugins");
		this.setJMenuBar(bar);
		this.setContentPane(panel);
		this.setResizable(true);
		this.setVisible(true);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	public static PluginWindow getInstance(){
		return instance;
	}
	
	public PluginBar getBar(){
		return bar;
	}
	
	public PluginPanel getPanel(){
		return panel;
	}

}
