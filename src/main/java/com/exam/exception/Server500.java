package com.exam.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


public class Server500 implements HandlerExceptionResolver {

	/**
	 *
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param o
	 * @param e
	 * @return
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/_error/500");

		return modelAndView;
	}
}