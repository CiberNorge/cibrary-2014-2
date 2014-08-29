package no.ciber.academy.model.repository;

import javax.transaction.Transactional;

import no.ciber.academy.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	User findByName(String name);
}
