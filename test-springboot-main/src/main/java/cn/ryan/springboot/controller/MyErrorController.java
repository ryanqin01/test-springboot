package cn.ryan.springboot.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {

	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());

			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				return "404.html";
			} else if (statusCode == HttpStatus.BAD_REQUEST.value()) {
				return "400.html";
			} else if (statusCode == HttpStatus.UNAUTHORIZED.value()) {
				return "401.html";
			}
		}
		return "500.html";
	}
}
