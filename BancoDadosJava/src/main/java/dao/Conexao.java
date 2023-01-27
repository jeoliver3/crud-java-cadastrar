
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author bella
 */

//Classe de conexao
public class Conexao {
    public Connection getConnection() throws SQLException
    {
        try{
        Connection conexao =  DriverManager.getConnection("jdbc:mysql://localhost:3306/cursoJava?user=&password=");
        
        }
        catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Conexao" +erro.getMessage());
        }
        Connection conexao = null;
        return conexao;
        
    } 
    
}
