package pl.pja.tpc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.pja.tpc.entity.Trace;
import pl.pja.tpc.repository.TraceRepository;

@Service
@Transactional
public class TraceService {
	@Autowired
	private TraceRepository traceRepository;
	
	public List<Trace> findAll(){
		return traceRepository.findAll();
	}

	public Object findOne(int id) {
		return traceRepository.findOne(id);
	}

	public int save(Trace trace) {
		traceRepository.save(trace);
		return trace.getId();
	}
}
