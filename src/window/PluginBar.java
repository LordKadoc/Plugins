package window;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import plugins.Plugin;
import filter.PluginPool;

public class PluginBar extends JMenuBar implements Observer, ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2484237357342928069L;
	
	private PluginPool pool;
	
	private JMenu menuPlugin;
	
	public PluginBar(){
		pool = PluginPool.getInstance();
		menuPlugin =  new JMenu("Plugins");	
		add(menuPlugin);
	}
	
	public void addPlugin(String texte, String tooltip, boolean setcurrent){
		JMenuItem item = new JMenuItem(texte);
		item.setToolTipText(tooltip);
		item.addActionListener(this);
		if(setcurrent)
			item.setForeground(Color.BLACK);
		else
			item.setForeground(Color.GRAY);
		menuPlugin.add(item);
	}

	@Override
	public void update(Observable o, Object arg) {
		menuPlugin.removeAll();
		boolean updateCurrent = pool.getCurrentPlugin() != null;
		for(String s : pool.getPlugins()){
			if(updateCurrent && s.equals(pool.getCurrentPlugin().getName())){
				addPlugin(s, pool.getPlugin(s).getDescription(), true);
			}else{
				addPlugin(s, pool.getPlugin(s).getDescription(), false);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem)e.getSource();
		String pname = item.getText();
		setForeground(item);
		Plugin p = pool.getPlugin(pname);
		if(p != null){
			PluginWindow.getInstance().getPanel().applyPlugin(p);
			pool.setCurrentPlugin(pname);
		}else{
			Logger l = Logger.getLogger(PluginBar.class.getName());
			l.log(Level.SEVERE, "Plugin " + pname + " not found");
		}
	}
	
	public void setForeground(JMenuItem item){
		for(int i = 0;i < menuPlugin.getItemCount();i++){
			menuPlugin.getItem(i).setForeground(Color.GRAY);;
		}
		item.setForeground(Color.BLACK);
	}

}
