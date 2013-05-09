package org.cyetstar.picasso.web.controller;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SuppressWarnings("rawtypes")
public abstract class BaseController<T, ID extends Serializable> {

	// @Autowired
	// BaseService<T, ID> service;

	Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("add")
	public String add(T entity) {
		log.info("base...");
		// service.save(entity);
		return parentPath() + "add";
	}

	private String parentPath() {
		String parentPath = "/";
		Class<? extends BaseController> clazz = this.getClass();
		RequestMapping requestMapping = clazz.getAnnotation(RequestMapping.class);
		String[] values = requestMapping.value();
		if (values.length != 1) {
			throw new RuntimeException();
		} else {
			parentPath = values[0] + "/";
		}
		return parentPath;
	}
}
