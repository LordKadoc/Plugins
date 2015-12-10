package main;

import javax.swing.JFrame;
import javax.swing.Timer;

import window.PluginBar;
import window.PluginPanel;

import filter.PluginFinder;


public class PluginWindow extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2419253037466297548L;
	
	private PluginBar bar;
	
	private PluginPanel panel;
	
	private PluginFinder finder;
	
	private static final PluginWindow instance = new PluginWindow();

	private PluginWindow(){
		
		this.bar = new PluginBar();
		this.panel = new PluginPanel();
		this.finder = new PluginFinder("dropins/plugins/");
		this.finder.addObserver(this.bar);
		this.finder.actionPerformed(null);
		
		this.setTitle("TP Plugins - Lucas Moura de Oliveira");
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
	
	public PluginFinder getFinder(){
		return finder;
	}
	
	public void initDefaultPanel() {
		this.setContentPane(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.revalidate();
	}
	
	public static void main(String[] args) {
		PluginWindow w = instance;
		Timer t = new Timer(10000,w.finder);
		t.start();
	}

}
