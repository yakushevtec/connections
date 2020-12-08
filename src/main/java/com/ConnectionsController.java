package com;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("")
public class ConnectionsController
{
	@Autowired(required=true)
	public Paths paths;

	@RequestMapping(value = "/connected/{origin}/{destination}", method = RequestMethod.GET)
	public String connected
	(
		@PathVariable("origin") String origin
		, @PathVariable("destination") String destination
	) 
	{
		boolean connected = paths.connected(origin, destination);
		return connected ? "yes" : "no";
	}

	@RequestMapping(value = "/connected", method = RequestMethod.GET)
	public String connectedRequestParameter
	(
		@RequestParam(value = "origin", required = true) String origin
		, @RequestParam(value = "destination", required = true) String destination
	) 
	{
		boolean connected = paths.connected(origin, destination);
		return connected ? "yes" : "no";
	}
}
