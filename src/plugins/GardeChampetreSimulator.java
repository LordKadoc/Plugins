package plugins;

import main.PluginWindow;
import fractalfactory.canvas.MainPanel;
import fractalfactory.tree.Tree;

public class GardeChampetreSimulator implements Plugin {

	@Override
	public String transform(String text) {
		
		MainPanel treePanel = new MainPanel(new Tree());
		PluginWindow w = PluginWindow.getInstance();
		
		w.getContentPane().removeAll();
		w.getContentPane().setPreferredSize(treePanel.getPreferredSize());
		w.pack();
		w.setLocationRelativeTo(null);
		w.revalidate();
		w.getContentPane().add(treePanel);
		
		return text;
	}

	@Override
	public String getName() {
		return "Plugin génération arbres";
	}

	@Override
	public String getDescription() {
		return "des arbres !!!";
	}

}
