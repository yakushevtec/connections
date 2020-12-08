package com;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.*;

@RunWith( SpringRunner.class )
@SpringBootTest
public class ConnectionsTest
{
	@Autowired
	Paths paths;

	@Test
	public void HelloWorld()
	{
		System.out.println("Hello World!");
		assertFalse(paths.connected("city1", "city2"));
	}
}
