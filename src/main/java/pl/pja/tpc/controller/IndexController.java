package pl.pja.tpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import pl.pja.tpc.service.TraceService;

@Controller
public class IndexController {

	@Autowired
	private TraceService traceService;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	
}
