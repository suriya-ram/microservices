package com.suriya.SpringProjectFirst.Job;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class JobsImpl implements JobService{
	
	
	//private List<JobEntity>jobs = new ArrayList<>();
	//private Long nextID= 1L;
	JobRepository jobRepository;

	public JobsImpl(JobRepository jobRepository) {
		super();
		this.jobRepository = jobRepository;
	}

	@Override
	public List<JobEntity> findAll() {
		
		//return jobs;
		 return jobRepository.findAll();
	}

	@Override
	public void CreateJob( JobEntity job) {
		
		//job.setId(nextID++);
		//jobs.add(job);
		
		jobRepository.save(job);
	}

	@Override
	public JobEntity getJobByid(Long id) {
//		for(JobEntity job: jobs)
//		{
//			if(job.getId().equals(id))
//				return job;
//		}
//		return null;
		
		return jobRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteJobById(Long id) {
//		Iterator<JobEntity> i =  jobs.iterator();
//		
//		while (i.hasNext())
//		{
//			JobEntity job = i.next();
//			if(job.getId().equals(id))
//				i.remove();
//			return true;
//					
//		}
//		return false;
		try {
		jobRepository.deleteById(id);
		return true;}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateJobById(Long id, JobEntity updatedjob) {
		
		
//		for(JobEntity job : jobs)
//		{
//			if(job.getId().equals(id))
//			{
//				job.setTitle(updatedjob.getTitle());
//				job.setDescription(updatedjob.getDescription());
//				job.setMinSalary(updatedjob.getMinSalary());
//				job.setMaxSalary(updatedjob.getMaxSalary());
//				job.setLocation(updatedjob.getLocation());
//				
//			return true;
//			}
//		
//		}
//		return false;
//	}
		
		Optional<JobEntity>Joboptional = jobRepository.findById(id);
	
		if(Joboptional.isPresent())
		{
			JobEntity job = Joboptional.get();
				
			job.setTitle(updatedjob.getTitle());
			job.setDescription(updatedjob.getDescription());
			job.setMinSalary(updatedjob.getMinSalary());
			job.setMaxSalary(updatedjob.getMaxSalary());
			job.setLocation(updatedjob.getLocation());
			
			jobRepository.save(job);
			
		return true;
		}
		return false;
		}
	}
	
