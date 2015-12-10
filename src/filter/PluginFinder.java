package filter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import plugins.Plugin;

public class PluginFinder extends Observable implements ActionListener{
	
	private PluginFilter filter;
	
	private File directory;
	
	public PluginFinder(String pathname) {
		this.filter = new PluginFilter();
		this.directory = new File(pathname);
	}
	
	public File[] listPlugins(){
		return directory.listFiles(filter);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		List<Plugin> plugins = new ArrayList<Plugin>();
		for(File f : listPlugins()){
			plugins.add(filter.getPlugin(directory, f.getName()));
		}
		
		PluginPool.getInstance().updatePool(plugins);
		notifyObservers();
	}
	
	@Override
	public void notifyObservers(){
		this.setChanged();
		super.notifyObservers();
	}

	public void setDirectory(File selectedFile) {
		this.directory = selectedFile;
	}
	

}
