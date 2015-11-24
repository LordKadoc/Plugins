package window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import filter.PluginPool;
import plugins.Plugin;

public class PluginPanel extends JPanel implements KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1670880926788111875L;
		
	private JTextArea area;

	public PluginPanel(){
		this.setPreferredSize(new Dimension(500,500));
		this.setLayout(new BorderLayout());
		this.area = new JTextArea();
		this.area.addKeyListener(this);
		this.add(area,BorderLayout.CENTER);
	}
	
	public JTextArea getArea(){
		return area;
	}
	
	public void applyPlugin(Plugin plugin){
		this.area.setText(plugin.transform(area.getText()));
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Plugin p = PluginPool.getInstance().getCurrentPlugin();
		if(p==null)
			return;
		int caretPosition = area.getCaretPosition();
		area.setText(p.transform(area.getText()));
		area.setCaretPosition(caretPosition);
	}

}
