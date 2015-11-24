package plugins;

public interface Plugin {

	public String transform(String text);

	public String getName();
	
	public String getDescription();
	
}
