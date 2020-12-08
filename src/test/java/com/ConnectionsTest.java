package com;

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
System.out.println("+++ "+paths.connected("city1", "city2"));
	}
}
