package com.backEnd.ticket_tracker.services;

import java.util.List;

import com.backEnd.ticket_tracker.model.Ticket;

public interface TicketServices {

	List<Ticket> getAllTicket();

	Ticket saveTicket(Ticket ticket);

	Ticket getTicketById(Long id);

	Ticket updateTicket(Ticket ticket);	

	void deleteTicketById(Long id);
	
	List<Ticket> getByKeyword(String keyword);

}
