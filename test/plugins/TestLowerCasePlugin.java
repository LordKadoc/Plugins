package plugins;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestLowerCasePlugin extends TestPlugin{

	@Override
	@Before
	public void initPlugin() {
		plugin = new LowerCasePlugin();
	}

	@Override
	@Test
	public void testTransform() {
		String texte = "ABC";
		Assert.assertEquals("abc", plugin.transform(texte));
	}

	

}
