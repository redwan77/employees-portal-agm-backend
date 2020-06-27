package com.jobcommit.dto.AbstractTransformer;

public abstract class AbstractTransformer<T, DTO> {
	
	abstract DTO entityToDTO(T entity);
	abstract T DTOToentity(DTO dto);
	
}
