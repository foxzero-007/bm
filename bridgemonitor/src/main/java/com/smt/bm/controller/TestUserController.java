/**
 * 
 */
package com.smt.bm.controller;

/**
 * @author Administrator
 *
 */

import com.smt.bm.service.impl.TestUserServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api")
@Api
public class TestUserController {
	
	@Resource
    private TestUserServiceImpl tusi;
	private int iretflag = -2; //-2初值，-1执行了post,0用户名密码错误，1登录成功
   //登录
	@CrossOrigin
    @PostMapping(value = "/userLogin")
    @ResponseBody
   public void userLogin(@RequestBody Map map){
    String username = map.get("userName").toString();
    String password = map.get("password").toString();
    System.out.println(username);
    System.out.println(password);
    iretflag = -1;
    if (tusi.findUserByUsernameAndPassowrd(username,password)==null){
    	System.out.println("not find!");
    	iretflag = 0;
    }else {
    	System.out.println("OK!");
    	iretflag = 1;
	} 
   }
	
	@CrossOrigin
	@GetMapping(value = "/retForeEnd")
	public int retForeEnd()
	{
    	System.out.println("get success!");
	    return iretflag;
	}

}
