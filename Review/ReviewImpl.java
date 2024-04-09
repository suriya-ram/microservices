package com.suriya.SpringProjectFirst.Review;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suriya.SpringProjectFirst.Company.Company;
//import com.suriya.SpringProjectFirst.Company.Company;
import com.suriya.SpringProjectFirst.Company.CompanyService;



@Service

public class ReviewImpl implements ReviewService {
	
	
	
	private final ReviewRepository reviewRepository;
	
	private final CompanyService  companyService;
	
	public ReviewImpl(ReviewRepository reviewRepository, CompanyService companyService) {
		super();
		this.reviewRepository = reviewRepository;
		this.companyService = companyService;
	}


	@Override
	public List<Review> getAllReviews(Long companyId) {
		
		List<Review>reviews = reviewRepository.findByCompanyId(companyId);
		return reviews;
	}

	@Override
	public boolean addReview(Long companyId, Review review) {
		Company company = companyService.getCompanyById(companyId);
		if(company != null)
		{
			review.setCompany(company);
			reviewRepository.save(review);
			return true;
		}
		
		return false;
	}


	@Override
	public Review getReview(Long companyId, Long reviewId) {
		List<Review> reviews = reviewRepository.findByCompanyId(companyId);
		return  reviews.stream()
				       .filter(review ->review.getId().equals(reviewId)	)	    		   
				       .findFirst()
				       .orElse(null);
	}


	@Override
	public boolean updateReview(Long companyId, Long reviewId, Review review) 
	{ if(companyService.getCompanyById(companyId) != null)
	{
		review.setCompany(  companyService.getCompanyById(companyId));
		review.setId(reviewId);
		reviewRepository.save(review);
		return true;
	}
		
		return false;
	}


	@Override
	public boolean deleteReview(Long companyId, Long reviewId) {
		if(companyService.getCompanyById(companyId) != null   &&  reviewRepository.existsById(reviewId))
		{
		  Review review = reviewRepository.findById(reviewId).orElse(null);
		  Company company =  review.getCompany();
		  company.getReviews().remove(review);  //bidirectional Mapping from company and review
		  companyService.updateCompanies(company,companyId );
		  reviewRepository.deleteById(reviewId);
		  return true;	  
	   }
		 return false;

}
}