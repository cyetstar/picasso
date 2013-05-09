package org.cyetstar.picasso.web.controller;

import java.io.File;
import java.io.Serializable;

import org.cyetstar.picasso.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public abstract class CurdController<T, ID extends Serializable> {

	// @Autowired
	// BaseService<T, ID> service;

	Logger log = LoggerFactory.getLogger(CurdController.class);

	@RequestMapping("add")
	public String add(T entity) {
		log.info("base...");
		// service.save(entity);
		return path("add");
	}

	protected abstract BaseService<T, ID> getService();

	protected String path(String subPath) {
		return parentPath() + File.separator + subPath;
	}

	@SuppressWarnings("rawtypes")
	private String parentPath() {
		String parentPath = File.separator;
		Class<? extends CurdController> clazz = this.getClass();
		RequestMapping requestMapping = clazz.getAnnotation(RequestMapping.class);
		String[] values = requestMapping.value();
		if (values.length != 1) {
			throw new RuntimeException();
		} else {
			parentPath += values[0];
		}
		return parentPath;
	}
}
