package window;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

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
	
	public void addPlugin(String texte, String tooltip, int keystroke){
		JMenuItem item = new JMenuItem(texte);
		item.setToolTipText(tooltip);
		item.addActionListener(this);
		if(keystroke < 12)
			item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1+keystroke,0));
		menuPlugin.add(item);
	}

	@Override
	public void update(Observable o, Object arg) {
		menuPlugin.removeAll();
		String s;
		for(int i=0; i< pool.getPlugins().size(); i++){
			s = pool.getPlugins().get(i);
			addPlugin(s, pool.getPlugin(s).getDescription(), i);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem)e.getSource();
		String pname = item.getText();
		Plugin p = pool.getPlugin(pname);
		if(p != null){
			PluginWindow.getInstance().getPanel().applyPlugin(p);
		}else{
			Logger l = Logger.getLogger(PluginBar.class.getName());
			l.log(Level.SEVERE, "Plugin " + pname + " not found");
		}
	}

}
