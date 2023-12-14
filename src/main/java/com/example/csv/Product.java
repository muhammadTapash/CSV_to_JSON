package com.example.csv;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")


public class Product {

  @Id
  @Column(name = "id")
  private long id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  

  
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	public Product(long id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}
	
	
	
	
	public Product(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
	public Product() {
		super();
	}
	  
	  

	  
	  

}
