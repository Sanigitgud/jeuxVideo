package com.crud.jeuxVideo.model;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JeuxRepository extends JpaRepository<Jeux, Long>{

    @Query("SELECT u FROM Jeux u WHERE u.Jeux_Titre LIKE %?1%")
	public List<Jeux> searchJeux(String Jeux_Titre);
    @Query ("SELECT u FROM Jeux u WHERE u.Genre_Id = ?1")
    public List<Jeux> filterByGenre(Long Genre_Id);
   
}
