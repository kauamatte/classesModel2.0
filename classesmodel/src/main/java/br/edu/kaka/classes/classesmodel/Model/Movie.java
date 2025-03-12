package br.edu.kaka.classes.classesmodel.Model;
    import jakarta.persistence.*;
    import lombok.*;
    
    import java.util.List;
    
    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    
    public class Movie {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        private String IMDB;
        private String title;
        private String description;
        private short releaseYear;
        private String director;
        private short duration;
        private String genre;
    
        @OneToMany(mappedBy = "movie1")
        private List<Review> reviews;
    }


