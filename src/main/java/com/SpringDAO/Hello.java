package com.SpringDAO;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Hello implements InitializingBean, DisposableBean {

	public void afterPropertiesSet() throws Exception {
		System.out.println("After property set this is like init method");
	}

	public void test() {
		System.out.println("my code start here and ends here");
	}

	public void destroy() throws Exception {
		System.out.println("this is like an destroyed method");
	}

}
