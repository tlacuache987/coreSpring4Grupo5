package org.certificatic.spring.core.practica6.initdestroy.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Data;

@Data
public class ConnectionDataBase implements InitializingBean, DisposableBean{
	private String database;
	private String user;
	private String password;

	public void initMethod() {
		System.out.println("Executing default init Method");
	}

	public void destroyMethod() {
		System.out.println("Executing default destroy Method");
	}

	public void connect() {
		String msg = String.format("> Connecting to: %s:%s:%s**** [%s]", database, user,
				password.substring(0, password.length() / 4), Integer.toHexString(super.hashCode()));

		System.out.println(msg);
	}

	public void disconnect() {
		String msg = String.format("> Disconnect from: %s:%s [%s]", database, user,
				Integer.toHexString(super.hashCode()));

		System.out.println(msg);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Executing destroy from disposable bean interface");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Executing after properties set from initializing bean interface");
	}

}