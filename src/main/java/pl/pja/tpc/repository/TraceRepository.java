package pl.pja.tpc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.pja.tpc.entity.Trace;

public interface TraceRepository extends JpaRepository<Trace, Integer>{

}
