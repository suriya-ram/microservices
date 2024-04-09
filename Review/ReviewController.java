package com.suriya.SpringProjectFirst.Review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

	
	@Autowired
	private ReviewService reviewService;
	
	
	@GetMapping("/reviews")
	public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
     
		
		return new ResponseEntity<>(reviewService.getAllReviews(companyId),HttpStatus.OK);
	
	}
	
	
	@PostMapping("/reviews")
	public ResponseEntity<String> addReview (@PathVariable Long companyId,
			                                     @RequestBody Review review)
	{
   boolean isSaved = reviewService.addReview(companyId, review);
   if(isSaved)
    return new ResponseEntity<>("Reviews added successfully",HttpStatus.OK);
   else
	   return new ResponseEntity<>("Reviews not saved",HttpStatus.NOT_FOUND);
	
	}
	
	@GetMapping("/reviews/{reviewId}")
	
	public ResponseEntity<Review>  getReview(@PathVariable Long companyId,
			                                      @PathVariable Long reviewId)
	{ return new ResponseEntity<>(reviewService.getReview(companyId, reviewId),HttpStatus.OK);
    }
	
	

	@PutMapping("/reviews/{reviewId}")
	
	public ResponseEntity<String>  updateReview(@PathVariable Long companyId,
			                                      @PathVariable Long reviewId,
			                                      @RequestBody Review review)
	
	   
	{ 
		 boolean isUpdated = reviewService.updateReview(companyId,reviewId,review);
		 if(isUpdated)
		return new ResponseEntity<>("Review updated successfully",HttpStatus.OK);
		 else
			 return new ResponseEntity<>("Review not found",HttpStatus.NOT_FOUND);
		
    }
	

	@DeleteMapping("/reviews/{reviewId}")
	
	public ResponseEntity<String>  deleteReview(@PathVariable Long companyId,
			                                      @PathVariable Long reviewId)
			                                      
	
	   
	{ 
		 boolean isDeleted = reviewService.deleteReview(companyId,reviewId);
		 if(isDeleted)
		return new ResponseEntity<>("Review deleted successfully",HttpStatus.OK);
		 else
			 return new ResponseEntity<>("Review not deleted",HttpStatus.NOT_FOUND);
		
	}
}