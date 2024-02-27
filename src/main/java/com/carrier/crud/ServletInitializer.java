/*
 * No funciona en splap, en local si 02/11/22 
 */

package com.carrier.crud;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	  System.out.println("***************ServletInitializer.configure*************** ");	
          return application.sources(CrudApplication.class);
	}

}
