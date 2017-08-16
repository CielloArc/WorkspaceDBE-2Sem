package br.com.fiap.bean;

import java.io.Serializable;
import java.nio.channels.NetworkChannel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

import br.com.fiap.bo.UsuarioBO;

@ManagedBean
public class GraficoBean implements Serializable{	
	private PieChartModel pizza;
	private LineChartModel graficoLinha;
	private UsuarioBO bo;
	
	@PostConstruct
	private void init(){
		bo = new UsuarioBO();
		pizza = new PieChartModel();
		
		
		pizza.set("Abaixo da média", bo.buscarPorNivel(1) + bo.buscarPorNivel(2));
		pizza.set("Acima da média", bo.buscarPorNivel(3));
		pizza.set("Normal", bo.buscarPorNivel(4) + bo.buscarPorNivel(5));
		
		pizza.setLegendPosition("e");
		pizza.setShowDataLabels(true);
		
		//////////////////////////////
		////////Grafico Linha////////
		////////////////////////////
		String[] meses = {"JAN", "FEV", "MAR", "ABR", "MAI", "JUN", "JUL", "AGO", "SET", "OUT", "NOV", "DEZ"};
		
		graficoLinha = new LineChartModel();
		graficoLinha.setLegendPosition("e");
		graficoLinha.getAxes().put(AxisType.X, new CategoryAxis("Mes"));
		
		
		LineChartSeries series = new LineChartSeries();
		series.setLabel("Alunos");
		
		for (int i = 1; i < 12; i++) {
			series.set(meses[i-1], bo.contarPorMesAniversario(i));
		}
		
				
		graficoLinha.addSeries(series);
		
	}

	public PieChartModel getPizza() {
		return pizza;
	}

	public void setPizza(PieChartModel pizza) {
		this.pizza = pizza;
	}

	public LineChartModel getGraficoLinha() {
		return graficoLinha;
	}

	public void setGraficoLinha(LineChartModel graficoLinha) {
		this.graficoLinha = graficoLinha;
	} 

}
