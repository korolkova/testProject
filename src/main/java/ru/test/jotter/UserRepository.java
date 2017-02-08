package ru.test.jotter;

import java.util.List;

import ru.test.jotter.model.User;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	List<User> findByName(@Param("name")String name);
	User findOne(@Param("id") long id);
}
