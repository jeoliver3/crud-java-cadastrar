package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.FormCadastroView;

/**
 *
 * @author bella
 */
// Classe responsável por manipular um usuario no banco de dados
public class UsuarioDao {

    Connection conection;
    PreparedStatement statement;

    public UsuarioDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public UsuarioDao(Connection conexao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // metodo para autenticar usuario ja existente no bco de dados ao clicar no button entrar
    public ResultSet autenticacao(Usuario usuarioModel) throws SQLException {
        conection = new Conexao().getConnection();

        try {
            // fazendo validação de senha e usuario
            String sql = "select * from usuario where usuario = ? and senha = ? ";

            // preparando conexao
            PreparedStatement statement = conection.prepareStatement(sql);

            statement.setString(1, usuarioModel.getUsuario());
            statement.setString(2, usuarioModel.getSenha());

            ResultSet result = statement.executeQuery();
            return result;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDao" + erro);
            return null;
        }

    }

    private String usuarioCadastro;
    private String senhaCadastro;

    public String getUsuarioCadastro() {
        return usuarioCadastro;
    }

    public void setUsuarioCadastro(String usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }

    public String getSenhaCadastro() {
        return senhaCadastro;
    }

    public void setSenhaCadastro(String senhaCadastro) {
        this.senhaCadastro = senhaCadastro;
    }

    public void cadastrar(UsuarioDao usuarioDao) {
        
        
        String sql = " insert into usuario (nome,senha) values (?,?)";
        try {
            //acessando conexao. Chamando classe e método
            Connection conection = new Conexao().getConnection();

            try (PreparedStatement statement = conection.prepareStatement(sql)) {
                statement.setString(1, usuarioDao.getUsuarioCadastro());
                statement.setString(2, usuarioDao.getSenhaCadastro());

                statement.execute();
            }

        } catch (Exception erro) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, erro);
            JOptionPane.showMessageDialog(null, "UsuarioDao" + erro);
        }

    }

}
