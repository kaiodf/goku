package br.com.goku.repository;

import br.com.goku.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long> {

    @Query("SELECT e FROM Adress e WHERE LOWER(e.cep) = LOWER(:cep)")
    Adress findbyCep(@Param(value = "cep") String cep);
}
