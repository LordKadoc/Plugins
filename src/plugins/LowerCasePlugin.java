package plugins;

public class LowerCasePlugin implements Plugin {

	@Override
	public String transform(String text) {
		return text.toLowerCase();
	}

	@Override
	public String getName() {
		return "Lower case"; 
	}

	@Override
	public String getDescription() {
		return "Transform text to lower case.";
	}

}
