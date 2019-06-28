package td.modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
	
	private static final String URL="jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	private static final String USERNAME="root";
	private static final String PASSWORD="root";
	
	
	public List<FilmText> afficherListe()
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		Connection	cx = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String req= "SELECT * FROM film_text";
			
			PreparedStatement ps=cx.prepareStatement(req);
			
			ResultSet rs=ps.executeQuery();
			
			List<FilmText> listeOut= new ArrayList<FilmText>();

			
			while(rs.next())
			{
				int idOut=rs.getInt("film_id");	
				String titleOut=rs.getString("title");
				String descrOut=rs.getString("description");				
				FilmText ftOut=new FilmText(titleOut, descrOut);				
				listeOut.add(ftOut);
				
			}
			
			return listeOut;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}	
	}
	
	
	public void addFilm(FilmText ft)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection	cx = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String req="INSERT INTO film_text (title,description) VALUES (?,?)";
			
			PreparedStatement ps=cx.prepareStatement(req);
			
			ps.setString(1, ft.getTitle());
			ps.setString(2, ft.getDescription());
			
			int verif=ps.executeUpdate();
			
			System.out.println(verif);
		
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void updateFilm(FilmText ft)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection	cx = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String req="UPDATE film_text set film_id=? , title=?,description=?";
			
			PreparedStatement ps=cx.prepareStatement(req);

			ps.setInt(1, ft.getId());
			ps.setString(2, ft.getTitle());
			ps.setString(3, ft.getDescription());
			
			int verif=ps.executeUpdate();
			
			System.out.println(verif);
		


		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
		
	}


