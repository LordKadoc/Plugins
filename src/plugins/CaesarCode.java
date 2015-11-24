package plugins;

public class CaesarCode implements Plugin {

	@Override
	public String transform(String text) {
		String r="";
		for(int i=0;i<text.length();i++){
			r+=caesar(text.charAt(i));
		}
		return r;
	}
	
	private char caesar(char c){
		if(c == 'z')
			return 'a';
		else if(c == 'Z')
			return 'A';
		else if(Character.isAlphabetic(c))	
			return (char)(c+1);
		else 
			return c;
	}

	@Override
	public String getName() {
		return "Caesar Code Plugin";
	}

	@Override
	public String getDescription() {
		return "Returns an encrypted text with a caesar1 code";
	}

}
