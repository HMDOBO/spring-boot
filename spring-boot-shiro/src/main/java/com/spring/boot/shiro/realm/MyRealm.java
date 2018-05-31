package com.spring.boot.shiro.realm;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
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
		System.out.println("===进入权限授权===");
		
		// 从token中获取admin_id
		Integer adminID = JwtUtil.getAdminID(principals.toString());
		
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		
		// 授权角色
		String role = adminService.getAdminRole(adminID);
		simpleAuthorizationInfo.addRole(role);	// 单角色
		System.out.println("===获得" + role + "角色===");
		// 授权操作权限
//		Set<String> permissions = new HashSet<>();
//		permissions.add("user:create");
		Set<String> permissions = adminService.getAdminPermission(adminID);
		
		simpleAuthorizationInfo.addStringPermissions(permissions);
		
		System.out.println("===获得权限" + permissions + "===");
		
		System.out.println("===授权完毕===");
		
		return simpleAuthorizationInfo;
	}

	/**
	 * 校验token
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
		
		System.out.println("===调用自定义Realm，对RequestHeader中token进行校验===");
		
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
