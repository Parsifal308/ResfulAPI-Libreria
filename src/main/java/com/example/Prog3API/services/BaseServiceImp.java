package com.example.Prog3API.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.Prog3API.entities.Base;
import com.example.Prog3API.repositories.BaseRepository;

public abstract class BaseServiceImp <E extends Base, ID extends Serializable> implements BaseService<E, ID>{
	
	protected BaseRepository<E, ID> baseRepository;
	
	public BaseServiceImp(BaseRepository<E, ID> baseRepository) {
		this.baseRepository = baseRepository;
	}
	@Override
	@Transactional
	public List<E> findAll() throws Exception {
		try {
			List<E> entities = baseRepository.findAll(); //busca todas las personaes en la BD
			return entities;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public E findById(ID id) throws Exception {
		try {
			Optional<E> entityOptional = baseRepository.findById(id); //busca Persona por id en la BD
			return entityOptional.get();
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public E save(E entity) throws Exception {
		try {
			entity = baseRepository.save(entity);
			return entity;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
 
	@Override
	@Transactional
	public E update(ID id, E entity) throws Exception {
		try {
			Optional<E> entityOptional = baseRepository.findById(id);
			E entityUpdate = entityOptional.get(); //SI obtenemos una persona, la asigna al id correspondiente, SINO hace un rollback
			entityUpdate = baseRepository.save(entity);
			return entityUpdate;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	@Override
	@Transactional
	public boolean delete(ID id) throws Exception {
		try {
			if(baseRepository.existsById(id)) { 	//SI se encuentra una persona con ese Id, se elimina y devuelve true
				baseRepository.deleteById(id);
				return true;
			}else {									//SINO, se lanza una excepcion alv
				throw new Exception();
			}
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Page<E> findAll(Pageable pageable) throws Exception{
		try {
			Page<E> entities = baseRepository.findAll(pageable);
			return entities;
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
