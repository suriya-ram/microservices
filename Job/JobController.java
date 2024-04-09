package com.suriya.SpringProjectFirst.Job;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping("jobz")
public class JobController {

	
	private JobService jobservice;
	
	public JobController(JobService jobservice) {
		super();
		this.jobservice = jobservice;
	}

	@GetMapping("jobz")
	public List<JobEntity> findAll(){
		return jobservice.findAll();
		
	}
	
	@PostMapping("/jobz")
	
		public String createJob(@RequestBody JobEntity job) {
			 jobservice.CreateJob(job);
			 
			 return "jobs added successfully";
			
		}
//	@GetMapping("jobz/{id}")
//	 public JobEntity getJobByid(@PathVariable Long id) {
//	  JobEntity job =jobservice.getJobByid(id);
//	  if(job !=null)
//		  return job;
//	  return new JobEntity(1L,"test job","summa oru desc","20","30","loc");
//	  
//	 }
//	
	@GetMapping("jobz/{id}")
	 public ResponseEntity< JobEntity> getJobByid(@PathVariable Long id) {
	  JobEntity job =jobservice.getJobByid(id);
	  if(job !=null)
		  return  new ResponseEntity<> (job,HttpStatus.OK);
	  //return  new ResponseEntity.OK(job); 
	  return  new ResponseEntity<> (HttpStatus.NOT_FOUND);
	  
	 }
	
	@DeleteMapping("jobz/{id}")
	public ResponseEntity<String>DeleteJob(@PathVariable Long id)
	{
		boolean deleted = jobservice.deleteJobById(id);
		if( deleted)
		{
			return new ResponseEntity<>("job deleted Successfully",HttpStatus.OK);
		}
		return new ResponseEntity<>("there is no job",HttpStatus.NOT_FOUND);
	}
	
	//@PutMapping("jobz/{id}")
	
	@RequestMapping(value = "jobz/{id}", method=RequestMethod.PUT)
	
	public ResponseEntity<String>updateJob  (@PathVariable Long id, @RequestBody JobEntity updatedjob)
	{
		boolean updated = jobservice.updateJobById(id,updatedjob );
		if(updated)
			return new ResponseEntity<>("job updated successfully",HttpStatus.OK);
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
