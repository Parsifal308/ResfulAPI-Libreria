package com.example.Prog3API.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Prog3API.entities.Persona;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long>{

	//CON METODO QUERY:
	List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
	
	//boolean existByDni(int dni);
	
	//-----------------------------------
	//CON JPQL:
	@Query(value="SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
	List<Persona> search(@Param("filtro") String filtro);
	
	//-----------------------------------
	//CON SQL:
	@Query(	
			value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
			nativeQuery = true
			)
	List<Persona> searchNativo(@Param("filtro") String filtro);
	
	
	
	
	
	//------LO MISMO PERO USANDO PAGINACION--------
	
	//CON METODO QUERY:
	Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);
	
	//CON JPQL:
	@Query(value="SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
	Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);
	
	//CON SQL:
	@Query(	
			value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
			countQuery = "SELECT count(*) FROM persona",
			nativeQuery = true
			)
	Page<Persona> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
