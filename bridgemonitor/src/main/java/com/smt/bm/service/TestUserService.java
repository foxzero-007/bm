/**
 * 
 */
package com.smt.bm.service;

/**
 * @author Administrator
 *
 */

import com.smt.bm.entity.TestUser;

public interface TestUserService {
	
	TestUser findUserByUsernameAndPassowrd(String username,String password);
	 
    boolean addUser(TestUser tu);

}
