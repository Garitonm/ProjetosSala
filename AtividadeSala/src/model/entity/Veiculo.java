package model.entity;

import model.dao.PessoaDAO;
import model.dao.VeiculoDAO;

public class Veiculo {
    // atributos
	
    private int id;
    private String chassi;
    private String placa;
    private String modelo;
    private String nome;
    private double valor;
    
    // construtor padrao
    public Veiculo(){
    }
    // construtor parametrico
    public Veiculo(String chassi, String placa,String modelo, String nome, double valor) {
        this.chassi = chassi;
        this.placa = placa;
        this.modelo = modelo;
        this.valor = valor;
        this.nome = nome;
        
    }
    // metodos de acesso
    
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public void inserir() {
        System.out.println("to no inserir em Veiculo");
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        veiculoDAO.inserir(this);
    }
    
}