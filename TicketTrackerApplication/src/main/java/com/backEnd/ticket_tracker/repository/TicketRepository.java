package com.backEnd.ticket_tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backEnd.ticket_tracker.model.Ticket;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

	@Query(value = "select * from ticket t where t.title like %:keyword% or t.shortDescription like %:keyword%", nativeQuery = true)
	 List<Ticket> findByKeyword(@Param("keyword") String keyword);
	
}
