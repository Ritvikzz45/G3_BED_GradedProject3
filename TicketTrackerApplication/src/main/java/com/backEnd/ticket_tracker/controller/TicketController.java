package com.backEnd.ticket_tracker.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.backEnd.ticket_tracker.model.Ticket;
import com.backEnd.ticket_tracker.services.TicketServices;

@Controller
public class TicketController {
	
private final TicketServices ticketServices;
	
	public TicketController(TicketServices ticketServices) {
		this.ticketServices = ticketServices;
	}
	
	@GetMapping("/tickets")
	public String listTickets(Model model) {
		model.addAttribute("ticket", this.ticketServices.getAllTicket());
		return "tickets";
	}
	
	@GetMapping("/tickets/new")
	public String createTicketForm(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "create_ticket";
	}
	
	@GetMapping("/tickets/edit/{id}")
	public String editTicketForm(@PathVariable Long id, Model model) {
		model.addAttribute("ticket", ticketServices.getTicketById(id));
		return "edit_ticket";
	}
	
	@GetMapping("/tickets/view/{id}")
	public String viewTicketForm(@PathVariable Long id, Model model) {
		model.addAttribute("ticket", ticketServices.getTicketById(id));
		return "view_ticket";
	}
	
	
	@PostMapping("/tickets")
	public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
		ticketServices.saveTicket(ticket);
		return "redirect:/tickets";
	}

	
	@GetMapping("/tickets/{id}")
	public String deleteTicket(@PathVariable Long id) {
		ticketServices.deleteTicketById(id);
		return "redirect:/tickets";
	}
	
	@PostMapping("/tickets/{id}")
	public String updateTicket(@PathVariable Long id, @ModelAttribute("ticket") Ticket ticket, Model model) {
		
		Ticket existingTicket = ticketServices.getTicketById(id);
		existingTicket.setId(id);
		existingTicket.setTitle(ticket.getTitle());
		existingTicket.setShortDescription(ticket.getShortDescription());
		existingTicket.setCreatedOn(ticket.getCreatedOn());

		ticketServices.updateTicket(existingTicket);
		return "redirect:/tickets";
	}

	 @GetMapping("/search")
	 public String searchForm(Ticket ticket, Model model, String keyword) {
	  if(keyword!=null) {
	   List<Ticket> list = ticketServices.getByKeyword(keyword);
	   model.addAttribute("list", list);
	  }else {
	  List<Ticket> list = ticketServices.getAllTicket();
	  model.addAttribute("list", list);}
	  return "search_ticket";
	 }


}
