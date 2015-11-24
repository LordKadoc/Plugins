package plugins;

public class UpperCasePlugin implements Plugin {

	@Override
	public String transform(String text) {
		return text.toUpperCase();
	}

	@Override
	public String getName() {
		return "UpperCase Plugin v1.0";
	}

	@Override
	public String getDescription() {
		return "Transform text to upper case.";
	}

}
