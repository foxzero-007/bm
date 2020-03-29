/**
 * 
 */
package com.smt.bm.repository;

/**
 * @author Administrator
 *
 */

import com.smt.bm.entity.TestUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TestUserDao extends JpaRepository<TestUser,Integer>{
	
	@Query(value = "select * from  testuser where name=:username and pwd=:password",nativeQuery = true)
    TestUser findUserByUsernameAndPassword(String username,String password);

}
