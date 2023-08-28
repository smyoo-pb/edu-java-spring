package com.precisionbio.restfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 *
 * @author miniyus
 * @date 2023/08/27
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
