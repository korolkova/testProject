package ru.test.jotter.repository;

import ru.test.jotter.model.User;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
         
@RepositoryRestResource(path = "user")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	User findOne(@Param("id") long id);
	void delete(long id);	
}