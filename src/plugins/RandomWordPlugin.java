package plugins;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomWordPlugin implements Plugin {

	@Override
	public String transform(String text) {
		String retour="";
		List<String> s = Arrays.asList(text.split(" "));
		Collections.shuffle(s);
		for(String st : s){
			retour+=st+" ";
		}
		retour.trim();
		return retour;
	}

	@Override
	public String getName() {
		return "RandomWordPlugin";
	}

	@Override
	public String getDescription() {
		return "Does random shit";
	}

}
