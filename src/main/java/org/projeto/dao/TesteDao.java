package org.projeto.dao;

import jakarta.persistence.EntityManager;
import org.projeto.model.entities.Teste;

import java.util.List;

public class TesteDao {

    private EntityManager em;

    public TesteDao(EntityManager em) {
        this.em = em;
    }

    public void salvar(Teste teste) {
        try {
            em.getTransaction().begin();
            em.persist(teste);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }


    public Teste buscarPorId(Long id) {
        return em.find(Teste.class, id);
    }

    public void atualizar(Teste teste ) {
        try {
            em.getTransaction().begin();
            em.merge(teste);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }

    public void remover(Long id) {
        Teste teste = em.find(Teste.class, id);
        if (teste == null) {
            throw new RuntimeException("Teste não encontrado para o id: " + id);
        }
        try {
            em.getTransaction().begin();
            em.remove(teste);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }
    }


    public List<Teste> listarTodos() {
        return em.createQuery("SELECT c FROM Teste c", Teste.class)
                .getResultList();
    }

    public void removerTodos() {
        try {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Parcela p").executeUpdate();
            em.createQuery("DELETE FROM Teste c").executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }

    }

}
