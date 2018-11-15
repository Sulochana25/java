import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.microsoft.sqlserver.jdbc.*;


public class JDBCConnection {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		Statement s=null;
		ResultSet rs=null;
	            try
	            {
	                SQLServerDataSource ds = new SQLServerDataSource();
	                ds.setUser("sa");
	                ds.setPassword("Welcome@1234");
	                ds.setServerName("GGKU3SER2");
	                ds.setPortNumber(1433);
	                ds.setDatabaseName("Sulochana");
	                con = ds.getConnection();
	                String sql = "select * from tab;";
	                s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	                rs = s.executeQuery(sql);
	              
	                
	                
	            } catch (Exception e){
	                e.printStackTrace();
	            }finally{
	                rs.close();
                    s.close();
                    con.close();
	            }
	    }
	}