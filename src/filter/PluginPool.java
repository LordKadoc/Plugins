package filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import plugins.Plugin;

public class PluginPool {
	
	private final static PluginPool instance = new PluginPool();
	
	private Map<String,Plugin> plugins;
	
	private PluginPool(){
		this.plugins = new HashMap<String,Plugin>();
	}
	
	public static PluginPool getInstance(){
		return instance;
	}
	
	public void updatePool(List<Plugin> newList){
		plugins.clear();
		for(Plugin p : newList){
			plugins.put(p.getName(), p);
		}
	}
	
	public List<String> getPlugins(){
		List<String> list = new ArrayList<String>();
		for(String s : plugins.keySet())
			list.add(s);
		return list;
	}
	
	public Plugin getPlugin(String name){
		return plugins.get(name);
	}

}
