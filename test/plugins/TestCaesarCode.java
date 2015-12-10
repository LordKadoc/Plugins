package plugins;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCaesarCode extends TestPlugin {

	@Override
	@Before
	public void initPlugin() {
		plugin = new CaesarCode();
	}

	@Override
	@Test
	public void testTransform() {
		String texte = "abcde";
		Assert.assertEquals("bcdef", plugin.transform(texte));
		texte = "abczZ";
		Assert.assertEquals("bcdaA", plugin.transform(texte));
		texte = "abc123";
		Assert.assertEquals("bcd123", plugin.transform(texte));
	}

}
