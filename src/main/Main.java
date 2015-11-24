package main;

import javax.swing.Timer;

import window.PluginWindow;
import filter.PluginFinder;

public class Main {

	public static void main(String[] args) {
		PluginWindow window = PluginWindow.getInstance();
		PluginFinder finder = new PluginFinder("plugins");
		finder.addObserver(window.getBar());
		finder.actionPerformed(null);
		Timer t = new Timer(10000,finder);
		t.start();
	}

}
