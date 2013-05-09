package org.cyetstar.picasso.service;

import java.io.Serializable;

public interface BaseService<T, ID extends Serializable> {

	public T save(T entity);

}
