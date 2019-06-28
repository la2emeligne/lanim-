package td.controleur;

import javax.swing.table.DefaultTableModel;

public class Lecontroleur {
 public DefaultTableModel  afficherFilm(DefaultTableModel tableEmpty) {
	 try {
	 DefaultTableModel dm = FilmText.afficherFilm(tableEmpty);
	 return dm;
	 }
	 catch(Exception e) {
		 e.printStackTrace();
	 }
	 
 }
}
