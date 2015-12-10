package plugins;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestUpperCasePlugin extends TestPlugin{

	@Override
	@Before
	public void initPlugin() {
		plugin = new UpperCasePlugin();
	}

	@Override
	@Test
	public void testTransform() {
		String texte = "abc";
		Assert.assertEquals("ABC", plugin.transform(texte));
	}

	

}
