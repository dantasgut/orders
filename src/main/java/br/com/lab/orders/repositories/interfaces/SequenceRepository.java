package br.com.lab.orders.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.lab.orders.repositories.entities.Sequence;

public interface SequenceRepository  extends JpaRepository<Sequence, String>{
	
	@Query("select s from Sequence s where s.name=:name")
	public Sequence findByName(@Param("name") String name);

}
