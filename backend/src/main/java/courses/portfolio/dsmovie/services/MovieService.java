package courses.portfolio.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import courses.portfolio.dsmovie.dto.MovieDTO;
import courses.portfolio.dsmovie.entities.Movie;
import courses.portfolio.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;

	@Transactional(readOnly=true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> results = repository.findAll(pageable);
		
		return results.map(m -> new MovieDTO(m));
	}
	
	@Transactional(readOnly=true)
	public MovieDTO findById(Long id) {
		Movie movie = repository.findById(id).get();
		return new MovieDTO(movie);
	}

}
