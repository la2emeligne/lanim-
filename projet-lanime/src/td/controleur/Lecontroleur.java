package td.controleur;

import javax.swing.table.DefaultTableModel;

import td.modele.FilmText;

public class Lecontroleur {
 public DefaultTableModel  afficherFilm(DefaultTableModel tableEmpty) {
	 try {
	 DefaultTableModel dm = DBUtil.afficherList(tableEmpty);
	 return dm;
	 }
	 catch(Exception e) {
		 e.printStackTrace();
	 }
	 
 }
}
