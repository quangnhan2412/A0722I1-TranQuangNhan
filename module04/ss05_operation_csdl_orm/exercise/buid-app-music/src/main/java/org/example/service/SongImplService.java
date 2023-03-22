package org.example.service;

import org.example.entity.Song;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class SongImplService implements SongService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Song> findAll() {
        return entityManager.createQuery("select  s from Song AS s").getResultList();
    }

    @Override
    public void create(Song song) {
        entityManager.persist(song);
    }

    @Override
    public Song update( Song song) {
        return entityManager.merge(song);
    }

    @Override
    public void remove(int id) {
        entityManager.remove(finById(id));
    }


    @Override
    public Song finById(int id) {
        return entityManager.find(Song.class, id);
    }
}
