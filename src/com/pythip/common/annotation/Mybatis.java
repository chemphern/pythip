package com.pythip.common.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
//自定义注解，用于简化mybatis操作template时的前缀，详看BaseService
@Target({java.lang.annotation.ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Mybatis {
	public abstract String namespace();
}
