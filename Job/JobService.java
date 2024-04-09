package com.suriya.SpringProjectFirst.Job;

import java.util.List;

public interface JobService {
	
	
	
	List<JobEntity>findAll();
	void CreateJob(JobEntity job);
	JobEntity getJobByid(Long id);
	boolean deleteJobById(Long id);
	boolean updateJobById(Long id, JobEntity updatedjob);

}
