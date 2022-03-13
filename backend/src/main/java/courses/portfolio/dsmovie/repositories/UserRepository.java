package courses.portfolio.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import courses.portfolio.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);

}
