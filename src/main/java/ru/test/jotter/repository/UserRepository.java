package ru.test.jotter.repository;

import ru.test.jotter.model.User;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	User findOne(long id);
	void delete(long id);
	User save(User user);
}