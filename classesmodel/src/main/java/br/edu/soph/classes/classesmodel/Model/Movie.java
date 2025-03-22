package br.edu.soph.classes.classesmodel.Model;
    import jakarta.persistence.*;
    import lombok.*;
    
    import java.util.List;
    import java.util.UUID;
    
    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    
    public class Movie {

        @Id
        private UUID id = UUID.randomUUID();
    
        private String IMDB;
        private String title;
        private String description;
        private short releaseYear;
        private String director;
        private short duration;
        private String genre;
    
        @OneToMany(mappedBy = "movie")
        private List<Review> reviews;
    }


