package filter;

import java.io.File;
import java.io.FilenameFilter;

import plugins.Plugin;

public class PluginFilter implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(".class") && getPlugin(name) != null;
	}

	public Plugin getPlugin(String name) {
		try {
			Class<?> c = Class.forName("plugins."+name.substring(0,name.length()-6));
			if(Plugin.class.isAssignableFrom(c) && c.getConstructors()[0].getParameterCount() == 0)
				return (Plugin) c.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {}
		return null;
	}

}
