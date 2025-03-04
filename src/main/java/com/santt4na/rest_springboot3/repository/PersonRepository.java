package com.santt4na.rest_springboot3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.santt4na.rest_springboot3.model.Person;

/*
 * @Repository -> Marca esta interface como um componente Spring de acesso a dados (DAO)
 * 
 * extends JpaRepository<Parametro1, Parametro2> 
 * 
 *  Sendo Parametro1 = Person: Entidade JPA gerenciada
 *  Sendo Parametro2 = Long: Tipo da chave primária (@Id)
 *   
 *  -> Herda operações CRUD básicas e métodos de paginação/sorting 
 *    save(Person entity)   -->  Salva/atualiza entidade
 *    findById(Long id)     -->  Busca por ID
 *    findAll()             -->  Lista todos registros
 *    deleteById(Long id)   -->  Remove por ID
 *    + métodos de paginação e sorting
 * 
 */

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}