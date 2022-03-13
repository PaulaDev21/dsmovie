package courses.portfolio.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import courses.portfolio.dsmovie.entities.Score;
import courses.portfolio.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
