package filter;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import plugins.CaesarCode;
import plugins.Plugin;
import plugins.UpperCasePlugin;

public class TestPluginPool {
	
	private PluginPool pool;
	
	@Before
	public void initPool(){
		this.pool = PluginPool.getInstance();
		this.pool.clear();
	}

	@Test
	public void testEmptyPool(){
		Assert.assertEquals(0,pool.getPluginNames().size());
	}
	
	@Test
	public void testAddPlugin(){
		List<Plugin> list = new ArrayList<Plugin>();
		list.add(new CaesarCode());
		
		pool.updatePool(list);
		Assert.assertEquals(1, pool.getPluginNames().size());
		
		list.add(new UpperCasePlugin());
		pool.updatePool(list);
		
		Assert.assertEquals(2, pool.getPluginNames().size());
		
	}
	
	@Test
	public void testCannotHaveTwiceSamePlugin(){
		List<Plugin> list = new ArrayList<Plugin>();
		list.add(new CaesarCode());
		list.add(new CaesarCode());
		pool.updatePool(list);
		Assert.assertEquals(1, pool.getPluginNames().size());
	}
	
	@Test
	public void testPluginName(){
		Plugin test = new CaesarCode();
		List<Plugin> list = new ArrayList<Plugin>();
		list.add(test);
		String name = test.getName();
		pool.updatePool(list);
		Assert.assertEquals(name,pool.getPluginNames().get(0));
		Assert.assertEquals(test,pool.getPlugin(name));
		
	}

}
