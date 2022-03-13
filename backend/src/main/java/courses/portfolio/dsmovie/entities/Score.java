package courses.portfolio.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_score")
public class Score {
	
	@EmbeddedId
	ScorePK id = new ScorePK();
	Double value;
	
	public Score() {
	}

	public ScorePK getId() {
		return id;
	}

	public void setId(ScorePK id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	
	public void setUser(User user) {
		this.id.setUser(user);		
	}
	
	
	public void setMovie(Movie movie) {
		this.id.setMovie(movie);
	}

}
