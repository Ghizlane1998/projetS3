package dao;

import entities.Vendeur;

public interface VendeurDao extends iDao<Vendeur> {
	 public Vendeur getByEmail(String email);
}
