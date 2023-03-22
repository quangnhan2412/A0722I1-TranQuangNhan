package org.example.service;

import org.example.entity.Song;

import java.util.List;

public interface SongService {
    List<Song> findAll();

    void create(Song song);
    Song update(Song song);
    void remove(int id);
    Song finById(int id);


}
