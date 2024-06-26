package br.com.projeto.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.projeto.api.modelo.Pessoa;

@Repository
public interface repositorio extends CrudRepository<Pessoa, Integer> {
    
    @Override
    List<Pessoa> findAll();

    Pessoa findByCodigo(int codigo);

    List<Pessoa> findByOrderByNome();

    List<Pessoa> findByNomeOrderByIdade(String nome);

    List<Pessoa> findByNomeContaining(String termo);

    List<Pessoa> findByNomeStartsWith(String termo);

    List<Pessoa> findByNomeEndsWith(String termo);

    @Query(value = "SELECT SUM(idade) FROM pessoa", nativeQuery = true)
    int somaIdades();

    @Query(value = "SELECT * FROM pessoa WHERE idade >= :idade", nativeQuery = true)
    List<Pessoa> idadeMaiorIgual(@Param("idade") int idade);

    @Query(value = "SELECT * FROM pessoa WHERE idade <= :idade", nativeQuery = true)
    List<Pessoa> idadeMenorIgual(@Param("idade") int idade);

    int countByCodigo(int codigo);


}
