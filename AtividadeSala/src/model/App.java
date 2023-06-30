package model;

import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import model.dao.PessoaDAO;
import model.dao.VeiculoDAO;
import model.entity.Pessoa;
import model.entity.Veiculo;

public class App {
    public static String leString(String msg) {
        String valor = JOptionPane.showInputDialog(null, msg);
        return valor;
    }

    public static int menu() {
        Scanner teclado = new Scanner(System.in);        
        System.out.println("MENU");
        System.out.println("1- Inserir Pessoa");
        System.out.println("2- Listar todas as Pessoas");
        System.out.println("3- Listar por id as Pessoas");
        System.out.println("4- Excluir por id as Pessoas");
        System.out.println("5- Atualizar Pessoas");
        System.out.println("6- Inserir Veiculo");
	    System.out.println("7- Listar todos os Veiculos");
	    System.out.println("8- Listar por id os Veiculos");
	    System.out.println("9- Excluir por id os Veiculos");
	    System.out.println("10- Atualizar");
	    System.out.println("11- Sair\n");
	    System.out.print("Digite: ");
   
        System.out.print("Digite: ");
        return teclado.nextInt();
    }
    
    public static void metodoInserir() {
        String nome = leString("Digite nome");
        String email = leString("Digite e-mail");
        Pessoa pessoa = new Pessoa(nome,email);
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoaDAO.inserir(pessoa);        
    }

    public static void metodoConsultarTodos() {
        // Metodo que percorre a lista retornada e exibe os registros
        // PessoaDAO pDAO = new PessoaDAO();
        // List<Pessoa> reg = pDAO.consultarTodos();
        List<Pessoa> registros = new PessoaDAO().consultarTodos();
        if (!registros.isEmpty()){
            String saida = "";
            saida += "id\tnome\temail\n";
            for (int i = 0; i < registros.size(); i++) {
                Pessoa p = registros.get(i);
                saida += p.getId()+"\t";
                saida = saida + p.getNome()+"\t";
                saida += p.getEmail()+"\n";                
            }
            JOptionPane.showMessageDialog(null, new JTextArea(saida));
        }else{
            System.out.println("Nao tem registros");
        }
    }
    
    public static void metodoExcluir() {
        String tmp = leString("Digite id para excluir");
        int id = Integer.parseInt(tmp); // converte pra int
        PessoaDAO dao = new PessoaDAO();
        if (dao.excluir(id)){
            JOptionPane.showMessageDialog(null, "Registro " +id + " exluido");
        }else{
            JOptionPane.showMessageDialog(null, "Registro " +id + " nao existe");
        }
    }
    public static Pessoa metodoConsultarId() {
        String idStr = leString("Digite id");
        // converter de String para int
        int id = Integer.parseInt(idStr);
        PessoaDAO dao = new PessoaDAO();
        Pessoa p = dao.consultar(id);
        return p;       
    }

    public static void metodoAtualizar(Pessoa p) {
        String nomeAntigo = p.getNome();
        String emailAntigo = p.getEmail();
        String novoNome = leString("Alterar nome: "+ nomeAntigo);
        String novoEmail = leString("Alterar email: "+ emailAntigo);
        p.setNome(novoNome);
        p.setEmail(novoEmail);
        PessoaDAO dao = new PessoaDAO();
        dao.atualizar(p);
    }
    
    public static void metedoInserirVeiculo() {
		String Chassi = leString("Digite número Chassi: ");
		String Placa = leString("Digite a Placa: ");
		String Modelo = leString("Digite o Modelo: ");
		String marca = leString("Digite Marca: ");
		String Valor = leString("Digite o Valor: ");
		double doubleValor = Double.parseDouble(Valor);
		Veiculo veiculo01 = new Veiculo(Chassi, Placa, Modelo,  marca,doubleValor);
		
		
		VeiculoDAO produto01 = new VeiculoDAO();
		produto01.inserir(veiculo01);
		
	}
    
    public static void metodoConsultarProdutos() {
		List<Veiculo> registro = new VeiculoDAO().consultarTodos();
		if (!registro.isEmpty()) {
			String saida = "";
			saida += ("id\t NumeroChassi\t Placa \t Modelo \t Marca \t Valor\n");
		 for (int i = 0; i < registro.size(); i++) {
			 Veiculo v = registro.get(i);
			 saida += v.getId()+"\t";
			 saida += v.getChassi()+"\t";
			 saida += v.getPlaca()+"\t";
			 saida += v.getModelo()+"\t";
			 saida += v.getNome()+"\t";
			 saida += v.getValor()+"\n";
		 }
		JOptionPane.showMessageDialog(null, new JTextArea (saida));
		
	     
	}else{
		System.out.println("Não tem registros!");
	}
	}

    public static Veiculo metodoConsultarIdVeiculo(){
		String idStr = leString("Digite id: ");
	     
        int id = Integer.parseInt(idStr);
        VeiculoDAO dao = new VeiculoDAO();
        Veiculo v = dao.consultar(id);
		return v;
		
	}
    public static void metodoAtualizarProduto(Veiculo v) {
        String ChassiAntigo = v.getChassi();
        String PlacaAntiga = v.getPlaca();
        String ModeloAntigo = v.getModelo();
        String MarcaAntiga = v.getNome();
        double DoubleValorAntigo = v.getValor();
        String valorAntigo = String.valueOf(DoubleValorAntigo);
        String novoChassi = leString("Alterar Número de Chassi "+ ChassiAntigo);
        String novaPlaca = leString("Alterar Placa " + PlacaAntiga);
        String novoModelo = leString("Alterar Modelo " + ModeloAntigo);
        String novaMarca = leString("Alterar Marca " + MarcaAntiga);
        String StrNovoValor = leString("Alterar Valor " + valorAntigo);
        double NovoValor = Double.parseDouble(StrNovoValor);
        
        v.setChassi(novoChassi);
        v.setPlaca(novaPlaca);
        v.setModelo(novoModelo);
        v.setNome(novaMarca);
        v.setValor(NovoValor);

        VeiculoDAO dao = new VeiculoDAO();
        dao.atualizar(v);
        JOptionPane.showMessageDialog(null, "Registro Atualizado com Sucesso!");
    }
    
    
    public static void metodoExcluirProduto() {
        String tmp = leString("Digite id para excluir");
        int id = Integer.parseInt(tmp); 
        VeiculoDAO dao = new VeiculoDAO();
        if (dao.excluir(id)){
            JOptionPane.showMessageDialog(null, "Registro " +id + " Excluido");
        }else{
            JOptionPane.showMessageDialog(null, "Registro " +id + " Não existe");
        }
    }
    
    
    
    
    
    
    public static void main(String[] args) {
        int op;
        do{
            op = menu();
            switch (op){
                case 1:
                    metodoInserir();
                    break;
                case 2:
                    metodoConsultarTodos();
                    break;
                case 3:
                    Pessoa pess=metodoConsultarId();
                    // String idStr = leString("Digite id");
                    // // converter de String para int
                    // int id = Integer.parseInt(idStr);
                    // PessoaDAO dao = new PessoaDAO();
                    // Pessoa pess = dao.consultar(id);
                    String saida;
                    if (pess != null){
                        saida = "id\tnome\temail\n";
                        saida += pess.getId()+"\t";
                        saida = saida + pess.getNome()+"\t";
                        saida += pess.getEmail()+"\n"; 
                    }else{
                        saida = "Registro nao foi localizado";
                    }
                    JOptionPane.showMessageDialog(null, new JTextArea(saida));
                    break;
                case 4:
                    metodoExcluir();
                    break;
                case 5:
                    Pessoa p = metodoConsultarId();
                    if (p !=null){
                        metodoAtualizar(p);
                    }else{
                        System.out.println("registro nao encontrado");
                    }                  

                    break;
                case 6:
                    
                    break;
                case 7:
                	break;
                	
                case 8:
                	break;
                	
                case 9:
                	break;
                	
                case 10:
                	break;
                	
                case 11:
                	System.out.println("Saindo");
                	break;
                default:
                    System.out.println("Opcao invalida");
            }
        }while(op!=6);
    }
}
