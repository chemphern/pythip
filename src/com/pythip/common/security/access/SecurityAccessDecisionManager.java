package com.pythip.common.security.access;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
/**
 * 判断该url与数据库中定义的url需要的访问权限，当前用户是否拥有，并决定是否放行
 * @author chemphone
 */
public class SecurityAccessDecisionManager implements ISecurityAccessDecisionManager {

	/**
	 * 思路:如果该页面不需要权限访问,则直接结束
	 * authentication:用户的权限
	 * configAttributes:访问该资源所需要的权限
	 */
	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if (null == configAttributes) {
			return;
		}

		//访问该uri所需要的角色列表
		Iterator<ConfigAttribute> cons = configAttributes.iterator();

		while (cons.hasNext()) {
			ConfigAttribute ca = cons.next();
			String needRole = ((SecurityConfig) ca).getAttribute();//访问该资源所需要的权限
			for (GrantedAuthority gra : authentication.getAuthorities()) {//gra:该用户拥有的权限
				if (needRole.trim().equals(gra.getAuthority().trim())) {
					//放行
					return;
				}
			}
		}
		//该用户没有权限访问该资源
		throw new AccessDeniedException("Access Denied");
	}

	@Override
	public boolean supports(ConfigAttribute arg0) {
		return true;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
