package plugins;

import window.PluginWindow;
import fractalfactory.canvas.MainPanel;
import fractalfactory.tree.Tree;

public class GardeChampetreSimulator implements Plugin {

	@Override
	public String transform(String text) {
		PluginWindow.getInstance().setContentPane(new MainPanel(new Tree()));
		PluginWindow.getInstance().pack();
		PluginWindow.getInstance().setLocationRelativeTo(null);
		PluginWindow.getInstance().revalidate();
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
