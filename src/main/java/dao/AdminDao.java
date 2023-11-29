package dao;

import entities.Admin;

public interface AdminDao extends iDao<Admin> {
	 public Admin getByEmail(String email);
}
