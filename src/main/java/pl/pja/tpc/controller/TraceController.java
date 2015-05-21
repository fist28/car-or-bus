package pl.pja.tpc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.pja.tpc.entity.Trace;
import pl.pja.tpc.service.TraceService;

@Controller
public class TraceController {
	@Autowired
	private TraceService traceService;
	
	@ModelAttribute("trace")
	public Trace construct() {
		return new Trace();
	}
	
	@RequestMapping("/traces")
	public String traces(Model model) {
		model.addAttribute("traces", traceService.findAll());
		return "traces";
	}
	
	@RequestMapping("/traces/{id}")
	public String detail(Model model, @PathVariable int id){
		model.addAttribute("trace", traceService.findOne(id));
		return "trace-detail";
	}
	
	@RequestMapping("/traces/new")
	public String new_trace(){
		return "new-trace";
	}
	
	@RequestMapping(value="/traces/new", method=RequestMethod.POST)
	public String create_trace(@ModelAttribute("trace") Trace trace){
		int id = traceService.save(trace);
		return "redirect:/traces/"+ id + ".html";
	}
}