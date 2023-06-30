package model.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.entity.Pessoa;
import model.entity.Veiculo;

public class VeiculoDAO {
    // CRUD
    // C - create | R - retrieve | U - update | D - delete
    public void inserir(Veiculo veiculo){
        ConectaBD con = new ConectaBD();
        String sql = "INSERT INTO Veiculo (chassi, placa, modelo, nome, valor) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement pst = con.getConexao().prepareStatement(sql);
            pst.setString(1, veiculo.getChassi());
            pst.setString(2, veiculo.getPlaca());
            pst.setString(1, veiculo.getModelo());
            pst.setString(2, veiculo.getNome());
            pst.setDouble(1, veiculo.getValor());
            pst.execute();
            System.out.println(veiculo.getNome() + " inserido");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo que consulta registro do tipo pessoa por id
     * @param id - refere-se a chave primaria do registro
     * @return um objeto do tipo Pessoa, caso nao encontre o registro retorna null
     */
    public Veiculo consultar(int id){
        ConectaBD con = new ConectaBD();
        String sql = "SELECT * FROM Veiculo WHERE id = ?";
        Veiculo v = null;
        try {
            PreparedStatement pst = con.getConexao().prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs =  pst.executeQuery();
            if (rs.next()){
                String chassi = rs.getString("chassi");
                String placa = rs.getString("placa");
                String modelo = rs.getString("modelo");
                double valor = rs.getDouble("valor");
                String nome = rs.getString("nome");
                v = new Veiculo(chassi,placa, modelo, nome,valor );
                v.setId(rs.getInt("id"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return v;
    }

    public List<Veiculo> consultarTodos(){
        ConectaBD con = new ConectaBD();
        String sql = "SELECT * FROM veiculo";
        List<Veiculo> lista = new LinkedList<Veiculo>();
        try {
            PreparedStatement pst = con.getConexao().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()){
                Veiculo veiculo = new Veiculo(); 
                String chassi = rs.getString("chassi");
                String placa = rs.getString("placa");
                String modelo = rs.getString("modelo");
                double valor = rs.getDouble("valor");
                String nome = rs.getString("nome");
                veiculo.setModelo(modelo);
                veiculo.setChassi(chassi);
                veiculo.setPlaca(placa);
                veiculo.setValor(valor);
                veiculo.setNome(nome);
                lista.add(veiculo);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public boolean excluir(int chave){
        String sql = "DELETE FROM Veiculo WHERE id = ?";
        try{
            ConectaBD conexao = new ConectaBD();
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, chave);
            int linhas = pst.executeUpdate();
            return linhas>0;

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean atualizar(Veiculo veiculo){
        try {
            String sql = "UPDATE Veiculo SET chassi = ?, placa= ?,modelo= ?, nome= ?,valor= ? WHERE id = ?";
            ConectaBD conexao = new ConectaBD();
            PreparedStatement pst = conexao.getConexao().prepareStatement(sql);
            pst.setString(1, veiculo.getChassi());
            pst.setString(2, veiculo.getPlaca());
            pst.setString(1, veiculo.getModelo());
            pst.setString(2, veiculo.getNome());
            pst.setDouble(1, veiculo.getValor());
            pst.setInt(3, veiculo.getId());
            int linhas = pst.executeUpdate();
            return linhas>0;            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

	


}
