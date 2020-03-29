/**
 * 
 */
package com.smt.bm.service.impl;

/**
 * @author Administrator
 *
 */
import com.smt.bm.entity.TestUser;
import com.smt.bm.repository.TestUserDao;
import com.smt.bm.service.TestUserService;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class TestUserServiceImpl implements TestUserService{
	
	@Resource
    private TestUserDao tud;

    @Override
    public TestUser findUserByUsernameAndPassowrd(String username, String password) {
        return tud.findUserByUsernameAndPassword(username,password);
    }

    @Override
    public boolean addUser(TestUser u) {
        return tud.save(u)!=null;
    }

}
