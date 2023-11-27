package entities;

import java.sql.Date;

public class Signalement {

	private int id_signalement ; 
	
	private String motiof;
	private Date date;
	
	
	public Signalement(int id_signalement, String motiof, Date date) {
		super();
		this.id_signalement = id_signalement;
		this.motiof = motiof;
		this.date = date;
	}


	public Signalement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId_signalement() {
		return id_signalement;
	}


	public void setId_signalement(int id_signalement) {
		this.id_signalement = id_signalement;
	}


	public String getMotiof() {
		return motiof;
	}


	public void setMotiof(String motiof) {
		this.motiof = motiof;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}

