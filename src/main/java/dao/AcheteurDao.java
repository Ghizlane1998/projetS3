package dao;

import entities.Acheteur;


public interface AcheteurDao extends iDao<Acheteur> {
	 public Acheteur getByEmail(String email);
}
