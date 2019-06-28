package td.controleur;

import javax.swing.table.DefaultTableModel;

import td.modele.DBUtil;
import td.modele.FilmText;

public class Lecontroleur {
	
 public DefaultTableModel  afficherFilm(DefaultTableModel tableEmpty) {
	 DefaultTableModel dm = null;
	 try {
		 DBUtil util = new DBUtil();
		 dm = util.afficherListe(tableEmpty); 
	 }
	 catch(Exception e) {
		 e.printStackTrace();
	 }
	 return dm;
 }
}
