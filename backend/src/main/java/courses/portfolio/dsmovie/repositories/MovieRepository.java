package courses.portfolio.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import courses.portfolio.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
