package com.crud.jeuxVideo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GenreRepository extends JpaRepository<Genre,Long>{
    // @Query ("SELECT u FROM Genre WHERE u.Genre_Id = ?1")
    // public List<Genre> sortByGenre(Long Genre_Id);
}
