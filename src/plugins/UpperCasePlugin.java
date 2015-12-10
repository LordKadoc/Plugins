package plugins;

public class UpperCasePlugin implements Plugin {

	@Override
	public String transform(String text) {
		return text.toUpperCase();
	}

	@Override
	public String getName() {
		return "Upper case";
	}

	@Override
	public String getDescription() {
		return "Transform text to upper case.";
	}

}
