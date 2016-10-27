package com.example.model;

import com.example.entity.Pessoa;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by grayson on 27/10/16.
 */
@Repository
public class PessoaDAO {

    @PersistenceContext
    private EntityManager em;

    /**
     * Retorna todas as pessoas com um nome que começa com a string passada
     * @param name Nome da pessoa
     * @return Lista de pessoas
     */
    public List<Pessoa> getPessoaWithNameLike(String name){
        return em.createQuery("select p from Pessoa p where p.nome like :nome")
                .setParameter("nome", name + "%")
                .getResultList();
    }

    @Transactional
    public Pessoa inserirPessoa(Pessoa pessoa){
        em.persist(pessoa);
        return pessoa;
    }

    public List<Pessoa> getAll() {
        return em.createQuery("select p from Pessoa p").getResultList();
    }
}
