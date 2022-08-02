package com.crud.jeuxVideo.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.crud.jeuxVideo.model.Jeux;

public class JeuxFactory {

	private static Connection connect;

    /*
	 * Utilise l'accés à la db pour récupérer les élément de la table jeuxvidéo dans un ArrayList de Jeux
	 * @return l'ArrayList de Jeux
	 */

    public static ArrayList<Jeux> getJeux() {
		
		connect = DBConnection.getConnection();
        ArrayList<Jeux> jeux = new ArrayList<Jeux>();
		try {
			String sql = "SELECT DISTINCT * FROM jeux";
			Statement getJeuxQuery = connect.createStatement();
			
			ResultSet rs = getJeuxQuery.executeQuery(sql);
			
			while(!rs.isLast()) {
				rs.next();
				
				Jeux j = new Jeux();
				j.setJeux_Id(rs.getInt("Jeux_Id"));
				j.setJeux_Titre(rs.getString("Jeux_Titre"));
				j.setJeux_Description(rs.getString("Jeux_Description"));
				j.setJeux_Prix(rs.getInt("Jeux_Prix"));
				j.setJeux_DateSortie(rs.getDate("Jeux_DateSortie"));
				j.setJeux_PaysOrigine(rs.getString("Jeux_PaysOrigine"));
				j.setJeux_Connexion(rs.getString("Jeux_Connexion"));
				j.setJeux_Mode(rs.getString("Jeux_Mode"));
				jeux.add(j);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL went Kaboom");
		}

		return jeux;
		
	}
// 	public static void insertJeux(Jeux jeux) {
//         try(Session session = HibernateUtil.getSessionFactory().openSession()) {
//                      session.save(jeux);
//         } catch (HibernateException e) {
//             e.printStackTrace();
//         }
// }
}
