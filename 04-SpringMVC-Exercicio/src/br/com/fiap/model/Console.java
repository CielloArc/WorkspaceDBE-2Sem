package br.com.fiap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqConsole", sequenceName="SQ_CONSOLE", allocationSize=1)
public class Console {

	@Id
	@GeneratedValue(generator="seqConsole", strategy=GenerationType.SEQUENCE)
	private int codigo;
	private String marca;
	private String modelo;
	private double valor;
	private boolean travado;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public boolean isTravado() {
		return travado;
	}
	public void setTravado(boolean travado) {
		this.travado = travado;
	}
}
