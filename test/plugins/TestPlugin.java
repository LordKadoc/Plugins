package plugins;

import org.junit.Before;
import org.junit.Test;

public abstract class TestPlugin {

	protected Plugin plugin;
	
	@Before
	public abstract void initPlugin();
	
	@Test
	public abstract void testTransform();

}
