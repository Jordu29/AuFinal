package com.mycompany.polypro.business;

import com.mycompany.polypro.model.Film;
import java.util.List;
import javax.persistence.*;
import javax.ejb.Stateless;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
public class FilmEJB {

    // ======================================
    // =             Attributes             =
    // ======================================
    @PersistenceContext(unitName = "jsfExamplePU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================
    public List<Film> findAll() {
        Query query = em.createNamedQuery(Film.FIND_ALL);
        return query.getResultList();
    }

    public Film create(Film film) {
        em.persist(film);
        return film;
    }

    public void delete(List<Film> list) {
        for (Film film : list) {
            delete(film);
        }
    }

    public void delete(Film film) {
        em.remove(em.merge(film));
    }
    
    public void update(Film film) {
        em.merge(film);
    }
}
