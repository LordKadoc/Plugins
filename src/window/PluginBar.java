package window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import main.PluginWindow;

import filter.PluginPool;

public class PluginBar extends JMenuBar implements Observer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2484237357342928069L;
	
	private PluginPool pool;
	
	private JMenu menuPlugin, menuFile;
	
	private JMenuItem switchFile;
	
	public PluginBar(){
		pool = PluginPool.getInstance();
		
		menuPlugin =  new JMenu("Plugins");	
		menuFile = new JMenu("File");
		
		add(menuPlugin);
		add(menuFile);
		
		switchFile = new JMenuItem("Switch folder");
		switchFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fc.showOpenDialog(PluginWindow.getInstance());
				PluginWindow.getInstance().getFinder().setDirectory(fc.getSelectedFile());
			}
		});
		menuFile.add(switchFile);
		
	}
	
	public void addPlugin(final String texte, String tooltip, int keystroke){
		JMenuItem item = new JMenuItem(texte);
		item.setToolTipText(tooltip);
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PluginWindow.getInstance().getPanel().applyPlugin(pool.getPlugin(texte));
			}
		});
		if(keystroke < 12)
			item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1+keystroke,0));
		menuPlugin.add(item);
	}
	

	@Override
	public void update(Observable o, Object arg) {
		menuPlugin.removeAll();
		String s;
		for(int i=0; i< pool.getPluginNames().size(); i++){
			s = pool.getPluginNames().get(i);
			addPlugin(s, pool.getPlugin(s).getDescription(), i);
		}
	}

}
