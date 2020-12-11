/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.Controller;

import java.awt.Dimension;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.util.Rotation;
import org.jfree.data.general.PieDataset;
import org.jfree.chart.JFreeChart;
/**
 *
 * @author gabsg
 */
public class GraficoDisco extends JFrame {

    public GraficoDisco(String applicationTitle, String chartTitle, PieDataset pdataset) {
        super(applicationTitle);

        JFreeChart graficoDisco = createChart(pdataset, chartTitle);
        ChartPanel painelGrafico = new ChartPanel(graficoDisco);
        painelGrafico.setPreferredSize(new Dimension(800,640));
                this.add(painelGrafico);
        
    }

    private JFreeChart createChart(PieDataset pPieDataset, String pTituloGrafico) {
        JFreeChart grafico = ChartFactory.createPieChart3D(
                pTituloGrafico,
                pPieDataset,
                true,
                true,
                false);

        PiePlot3D plot = (PiePlot3D) grafico.getPlot();

        plot.setForegroundAlpha(0.7f);
        plot.setStartAngle(0);
        plot.setDirection(Rotation.CLOCKWISE);

        return grafico; 
    }
}
