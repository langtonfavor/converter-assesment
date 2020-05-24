package com.assement.converters.Conveters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.filter.OrderedFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;
import org.springframework.web.filter.OncePerRequestFilter;
@SpringBootApplication
public class ConvetersApplication {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(ConvetersApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean<OncePerRequestFilter> executionTimeLoginFilter() {
	   return new FilterRegistrationBean<OncePerRequestFilter>() {{
	      //set the order and it must less than or equal to zero...
	      setOrder(OrderedFilter.REQUEST_WRAPPER_FILTER_MAX_ORDER);
	      setFilter(new OncePerRequestFilter() {
	         @Override
	         protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
	            StopWatch watch = new StopWatch();
	            watch.start();
	            try {
	               chain.doFilter(req,res); // this is a blocking call so once we reach this it means we reached the targeted endpoint
	            }finally {
	               watch.stop();
	               // log the time
	               log.info("REQUEST: {} completed in {} ms", req.getRequestURI(), watch.getTotalTimeMillis());
	            }
	         }
	      });
	   }};

	}
}
