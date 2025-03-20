package br.edu.soph.classes.classesmodel.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.edu.soph.classes.classesmodel.Model.Review;
import br.edu.soph.classes.classesmodel.Repository.ReviewRepository;


@Service

public class ReviewService {
    
     private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
     
    @Transactional
    public Review registerOrUpdate(Review review){
        return reviewRepository.save(review);
    }

    public Optional<Review> findById(UUID id){
        return reviewRepository.findById(id);
    }
     
    @Transactional
    public void remove(UUID id) {
        reviewRepository.deleteById(id);
    }

    public List<Review> findByAuthor(String author){
        return reviewRepository.findByAuthor(author);
    }
}


