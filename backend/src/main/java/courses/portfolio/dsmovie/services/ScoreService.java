package courses.portfolio.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import courses.portfolio.dsmovie.dto.MovieDTO;
import courses.portfolio.dsmovie.dto.ScoreDTO;
import courses.portfolio.dsmovie.entities.Movie;
import courses.portfolio.dsmovie.entities.Score;
import courses.portfolio.dsmovie.entities.User;
import courses.portfolio.dsmovie.repositories.MovieRepository;
import courses.portfolio.dsmovie.repositories.ScoreRepository;
import courses.portfolio.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		User user = userRepository.findByEmail(dto.getEmail());
		
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setUser(user);
		score.setMovie(movie);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		Double sum = 0.0;
		for (Score s : movie.getScores()){
			sum += s.getValue();			
		}
		System.out.printf("Sum=%.2f", sum);
		Double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}

}
