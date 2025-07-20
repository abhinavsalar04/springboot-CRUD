package com.springbootbootcamp.project.Repositories;

import com.springbootbootcamp.project.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users u WHERE LOWER(u.name) LIKE LOWER(CONCAT('%', :searchParam, '%')) OR LOWER(u.profession) LIKE LOWER(CONCAT('%', :searchParam, '%')) LIMIT :records OFFSET :offset", nativeQuery = true)
    List<User> getUsersByLimitOffsetAndSearchParam(@Param("records") int records, @Param("offset") int offset, @Param("searchParam") String searchParam);
}
