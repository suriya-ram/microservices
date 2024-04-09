package com.suriya.SpringProjectFirst.Company;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;

import com.suriya.SpringProjectFirst.Job.JobEntity;
import com.suriya.SpringProjectFirst.Review.Review;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	
	
	
	 
	@OneToMany(mappedBy = "company")
	
	private List<JobEntity>jobs;
	
	
	@OneToMany(mappedBy = "company")
	private List<Review>reviews;
	
	public List<Review> getReviews() {
		return reviews;
	}


	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}


	public Company() {
		super();
	}
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public List<JobEntity> getJobs() {
		return jobs;
	}



	public void setJobs(List<JobEntity> jobs) {
		this.jobs = jobs;
	}


//	public Company getCompanyById(Long companyId) {
//		// TODO Auto-generated method stub
//		return null;
//	}



	
	
	
}
