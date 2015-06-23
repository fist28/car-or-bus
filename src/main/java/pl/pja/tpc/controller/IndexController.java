package pl.pja.tpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import pl.pja.tpc.entity.Trace;
import pl.pja.tpc.service.TraceService;

@Controller
public class IndexController {

	@Autowired
	private TraceService traceService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("traces", traceService.findLast());
		return "index";
	}
	
	@RequestMapping("/traces/{id}")
	public String detail(Model model, @PathVariable int id){
		model.addAttribute("trace", traceService.findOne(id));
		return "trace-detail";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String create_trace(@ModelAttribute("trace") Trace trace){
		int id = traceService.save(trace);
		return "redirect:/traces/"+ id + ".html";
	}
}
