package plugins;

public class LowerCasePlugin implements Plugin {

	@Override
	public String transform(String text) {
		return text.toLowerCase();
	}

	@Override
	public String getName() {
		return "LowerCase Plugin v1.0";
	}

	@Override
	public String getDescription() {
		return "Transform text to lower case.";
	}

}
