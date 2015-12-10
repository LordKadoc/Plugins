package filter;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPluginFilter {
	
	private PluginFilter filter;

	@Before
	public void init(){
		filter = new PluginFilter();
	}
	
	@Test
	public void isClassFile(){
		Assert.assertTrue(filter.isClass("test.class"));
	}
	
	@Test
	public void isAccepted(){
		File dir = new File("test");
		dir.mkdir();
	}

}
