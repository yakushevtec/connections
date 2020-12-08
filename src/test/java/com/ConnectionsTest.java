package com;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.junit4.*;

@RunWith( SpringRunner.class )
@SpringBootTest
public class ConnectionsTest
{
	@Autowired
	PathsDAO pathsDAO;

	@Test
	public void testConnections()
	{
		assertFalse(pathsDAO.connected("city1", "city2"));
		assertTrue(pathsDAO.connected("Boston", "Newark"));
		assertTrue(pathsDAO.connected("Boston", "Philadelphia"));
		assertFalse(pathsDAO.connected("Philadelphia", "Albany"));
	}
}
