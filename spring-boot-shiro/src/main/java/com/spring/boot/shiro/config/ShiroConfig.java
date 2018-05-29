package com.spring.boot.shiro.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.spring.boot.shiro.filter.JwtFilter;
import com.spring.boot.shiro.realm.MyRealm;

/**
 * shiro 配置文件.<br/>
 * 
 * 创建时间：2018年5月29日
 */
@Configuration
public class ShiroConfig {

	/**
	 * SecurityManager
	 * 
	 * @param realm
	 * @return
	 */
	@Bean("securityManager")
	public DefaultWebSecurityManager getManager(MyRealm realm) {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();

		// 使用自定义realm
		manager.setRealm(realm);

		// 关闭shiro自带的session，详情见文档
		// http://shiro.apache.org/session-management.html#SessionManagement-StatelessApplications%28Sessionless%29
		DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
		DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
		defaultSessionStorageEvaluator.setSessionStorageEnabled(Boolean.FALSE);
		subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
		manager.setSubjectDAO(subjectDAO);

		return manager;
	}

	/**
	 * 配置ShiroFilter过滤器.<br/>
	 * 
	 * 使用自定义Filter
	 * 
	 * @param securityManager
	 * @return
	 */
	@Bean
	public ShiroFilterFactoryBean shirFilter(DefaultWebSecurityManager securityManager) {
		
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);

		// TODO 如果不用session，使用token无状态设置，需要自定义filter，这也是前后端分离的趋势
		
		// 添加自己的过滤器并且取名为jwt
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("jwt", new JwtFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
		
        /*
         * 自定义url规则
         * http://shiro.apache.org/web.html#urls-
         */
        Map<String, String> filterRuleMap = new HashMap<>();
        // 所有请求通过我们自己的JWT Filter
        filterRuleMap.put("/**", "jwt");
        // 访问401和404页面不通过我们的Filter
        filterRuleMap.put("/401", "anon");
        filterRuleMap.put("/login", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterRuleMap);
        return shiroFilterFactoryBean;
		
		
		
//		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
//		// 注意过滤器配置顺序 不能颠倒
//		// 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了，登出后跳转配置的loginUrl
////		filterChainDefinitionMap.put("/logout", "logout");
//		// 配置不会被拦截的链接 顺序判断
//		filterChainDefinitionMap.put("/static/**", "anon");
//		filterChainDefinitionMap.put("/login", "anon");
//		filterChainDefinitionMap.put("/**", "authc");
//		// 配置shiro默认登录界面地址，前后端分离中登录界面跳转应由前端路由控制，后台仅返回json数据
////		shiroFilterFactoryBean.setLoginUrl("/unauth");
//		// 登录成功后要跳转的链接
//		// shiroFilterFactoryBean.setSuccessUrl("/index");
//		// 未授权界面;
//		// shiroFilterFactoryBean.setUnauthorizedUrl("/403");
//		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//		return shiroFilterFactoryBean;
	}

	/**
	 * 下面三个bean注入，启用shiro注解支持
	 * 
	 * @return
	 */
	@Bean
	@DependsOn("lifecycleBeanPostProcessor")
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		// 使用cglib代理
		defaultAdvisorAutoProxyCreator.setProxyTargetClass(Boolean.TRUE);
		return defaultAdvisorAutoProxyCreator;
	}
	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
	@Bean
	public AuthorizationAttributeSourceAdvisor advisor(DefaultWebSecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);
		return advisor;
	}

}
