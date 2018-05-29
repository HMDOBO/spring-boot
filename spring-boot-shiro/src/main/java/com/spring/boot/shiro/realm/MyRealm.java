package com.spring.boot.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.boot.entity.AdminEntity;
import com.spring.boot.service.AdminService;
import com.spring.boot.shiro.token.JWTToken;
import com.spring.boot.utils.JwtUtil;

@Component
public class MyRealm extends AuthorizingRealm {

	@Autowired
	private AdminService adminService;
	
	/**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 授权权限
		System.out.println("====================");
		System.out.println("授权权限");
		System.out.println("====================");
		
		return null;
	}

	/**
	 * 校验token
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
//		String token = (String) auth.getCredentials();
		
//		JWTToken jwtToken = (JWTToken)auth;
//		String token = jwtToken.getToken();
		
		String token = (String) auth.getCredentials();
		
		// 获取token中的adminId
		Integer admin_id = JwtUtil.getAdminID(token);
		
		// 从数据库查询用户信息
		AdminEntity admin = adminService.getAdmin(admin_id);
		
		if (null == admin) {
			throw new AuthenticationException("用户不存在");
		}
		
		if (!JwtUtil.verify(token, admin_id, admin.getPassword())) {	// token校验未通过
			throw new AuthenticationException("token校验未通过");
		}
		
		System.out.println("===token校验成功===");
		
		return new SimpleAuthenticationInfo(token, token, getName());
	}

}
