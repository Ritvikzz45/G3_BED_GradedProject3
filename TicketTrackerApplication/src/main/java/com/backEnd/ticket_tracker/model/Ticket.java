package com.backEnd.ticket_tracker.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "title", nullable= false)
	private String title;
	
	@Column(name = "shortDescription", nullable= false)
	private String shortDescription;
	
	@Column(name = "content", nullable= false)
	private String content;
	
	@Column(name = "createdOn", nullable= true)
	private LocalDate createdOn =LocalDate.now();

	public Ticket() {}

	public Ticket(long id, String title, String shortDescription, String content, LocalDate createdOn) {
		super();
		this.id = id;
		this.title = title;
		this.shortDescription = shortDescription;
		this.content = content;
		this.createdOn = createdOn;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", title=" + title + ", shortDescription=" + shortDescription + ", content="
				+ content + ", createdOn=" + createdOn + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, createdOn, id, shortDescription, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return Objects.equals(content, other.content) && Objects.equals(createdOn, other.createdOn) && id == other.id
				&& Objects.equals(shortDescription, other.shortDescription) && Objects.equals(title, other.title);
	}
	
	
}
