package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class DBTest {

	Tenant junit;
	
	
	@org.junit.jupiter.api.Test
	void test() {
		fail("Not yet implemented");
	}

	@Before
	public void setUp() throws Exception
	{
		junit = new Tenant("user", "pass", "first", "last", "email@email.com", "0000000", false, false);
	}
	@After
	public void tearDown() throws Exception{}
	
	@Test
	public void testAdd()
	{
		Tenant junit = new Tenant("user", "pass", "first", "last", "email@email.com", "0000000", false, false);
	}
	
	
	
}
