package filter;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import plugins.Plugin;

public class PluginFilter implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		return isClass(name) && getPlugin(dir,name) != null;
	}
	
	public boolean isClass(String name){
		return name.endsWith(".class");
	}

	public Plugin getPlugin(File dir, String name) {
		try { 
			URLClassLoader loader = new URLClassLoader(new URL[]{new URL("file://"+dir.getAbsolutePath())});
			Class<?> c = loader.loadClass("plugins."+name.substring(0,name.length()-6));
			loader.close();
			if(Plugin.class.isAssignableFrom(c) && c.getConstructors().length > 0 && c.getConstructors()[0].getParameterCount() == 0)
				return (Plugin) c.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
