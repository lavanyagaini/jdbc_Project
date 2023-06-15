package jdbc_prc_ass;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class UserCRUD {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root", "root");
		return connection;
	}
	public void deleteUser(int id) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("delete from userr where id=?");
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
		connection.close();
			
		
	}

	public void signUser(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedstatement = connection
				.prepareStatement("insert into userr values(?,?,?,?,?,?,?,?,?,?)");
		preparedstatement.setInt(1, user.getId());
		preparedstatement.setString(2, user.getUsername());
		preparedstatement.setString(4, user.getPassword());
		preparedstatement.setString(5, user.getAddress());
		preparedstatement.setString(3, user.getEmail());
		preparedstatement.setString(6, user.getFacebookpwd());
		preparedstatement.setString(7, user.getInstapwd());
		preparedstatement.setString(8, user.getSnappwd());
		preparedstatement.setString(9, user.getWhatsapppwd());
		preparedstatement.setString(10, user.getTwitterpwd());
		preparedstatement.execute();
		connection.close();
		System.out.println("signned in successfully");

	}

	public boolean loginUser(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from userr where email=?");
		preparedStatement.setString(1, user.getEmail());
		ResultSet rs = preparedStatement.executeQuery();
		String password = null;
		while (rs.next()) {
			password = rs.getString("password");
		}
		if (password.equals(user.getPassword())) {
			return true;
		}
		return false;

	}

	public String pwdInfo(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select facebookpwd=? from userr where email=?");
		preparedStatement.setString(1, user.getFacebookpwd());
		preparedStatement.setString(2, user.getEmail());
	    ResultSet rs= preparedStatement.executeQuery();
	  
	 return rs.getString("facebookpwd");
	 
	  
	   }
	public void setPwd(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedstatement = connection.prepareStatement(
				"update userr set facebookpwd=?, instapwd=?, snappwd=?,whatsapppwd=?, twitterpwd=? where email=?");
		preparedstatement.setString(1, user.getFacebookpwd());
		preparedstatement.setString(2, user.getInstapwd());
		preparedstatement.setString(3, user.getSnappwd());
		preparedstatement.setString(4, user.getWhatsapppwd());
		preparedstatement.setString(5, user.getTwitterpwd());
		preparedstatement.setString(6, user.getEmail());
		preparedstatement.execute();
		connection.close();
		System.out.println("passwords stored successfullys");

	}

	public void displayPwd(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from userr where email=?");
		preparedStatement.setString(1, user.getEmail());
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			System.out.println("your facebook password is "+rs.getString("facebookpwd"));
			System.out.println("your instagram password is"+rs.getString("instapwd"));
			System.out.println("your snapchat password is"+rs.getString("snappwd"));
			System.out.println("your whatsapp password is"+rs.getString("whatsapppwd"));
			System.out.println("your twitter password is"+rs.getString("twitterpwd"));
		}
		connection.close();
	}
	public void updateFacebookPwd(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update  userr set facebookpwd=? where email=?");
		preparedStatement.setString(1, user.getFacebookpwd());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.execute();
		connection.close();
		System.out.println("facebookpassword updated successfully");
		System.out.println("Your new pass word is "+user.getFacebookpwd());
	}
	public void updateInstagramPwd(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update  userr set instapwd=? where email=?");
		preparedStatement.setString(1, user.getInstapwd());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.execute();
		connection.close();
		System.out.println("instagrampassword  updated successfully");
		System.out.println("Your new pass word is "+user.getInstapwd());
	}
	public void updateSnapPwd(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update  userr set snappwd=? where email=?");
		preparedStatement.setString(1, user.getSnappwd());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.execute();
		connection.close();
		System.out.println("Snapchatpassword updated successfully");
		System.out.println("your new password is "+user.getSnappwd());
	}
	public void updateWhatsappPwd(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update  userr set whatsapppwd=? where email=?");
		preparedStatement.setString(1, user.getWhatsapppwd());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.execute();
		connection.close();
		System.out.println("Whatsapp password updated successfully");
		System.out.println("Your new password is "+user.getWhatsapppwd());
	}public void updateTwitterPwd(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update  userr set twitterpwd=? where email=?");
		preparedStatement.setString(1, user.getTwitterpwd());
		preparedStatement.setString(2, user.getEmail());
		preparedStatement.execute();
		connection.close();
		System.out.println("Twitter password updated successfully");
		System.out.println("Your new password is "+user.getTwitterpwd());
	}

}
