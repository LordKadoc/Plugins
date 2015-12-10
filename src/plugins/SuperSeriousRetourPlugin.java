package plugins;

import java.awt.Color;

import javax.swing.JTextArea;

import main.PluginWindow;



public class SuperSeriousRetourPlugin implements Plugin {

	@Override
	public String transform(String text) {
		JTextArea ja =PluginWindow.getInstance().getPanel().getArea();
		System.out.println("ok");
		new ThreadPlugin(ja).start();
		return text;
	}

	@Override
	public String getName() {
		return "Creepy plugin";
	}

	@Override
	public String getDescription() {
		return "The computer ! He ... he is alive ..";
	}
	
	class ThreadPlugin extends Thread{
		
		private String text="bonjour Rémy...\nJe sais que tu m'entends....\nPourquoi est ce que tu ne me réponds pas ?\nTu ne veux plus jouer avec moi, Rémy ?\nComment va Justine dis moi ?\n ça serait dommage qu'il lui arrive quelque chose ...\n";
		private JTextArea ja;
		
		ThreadPlugin(JTextArea ja){
			this.ja =ja;
		}
		
		@Override
		public void run() {
			
			ja.setBackground(Color.BLACK);
			ja.setForeground(Color.GREEN);
			
			try{
				
				for(int i=0;i<text.length();i++){
					
					if(text.charAt(i) == '\n'){
						if((int)(Math.random()*2) == 1){
							for(int cpt=0;cpt<10;cpt++){
								if(cpt%2 == 0){
									ja.setBackground(Color.GREEN);
									ja.setForeground(Color.BLACK);
								}else{
									ja.setBackground(Color.BLACK);
									ja.setForeground(Color.GREEN);
								}
								ja.revalidate();
								Thread.sleep(100);
							}
						}
						Thread.sleep(1000);
					}
					
					ja.setText(ja.getText()+text.charAt(i));
					
					Thread.sleep(100);
					
				}

			}catch(Exception e){}
		}
	}
	
}
