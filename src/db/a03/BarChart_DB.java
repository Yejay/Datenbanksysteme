package db.a03;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChart_DB extends ApplicationFrame {
	private final static String url = "jdbc:oracle:thin:@localhost:1521:rispdb1";
	private final static String user = "s927077";
	private final static String pwd = "student";

	private static String applicationTitle;
	private static String chartTitle;
	private static String yAxis;
	private static String xAxis;
	private static String statement;
	private static Integer question;

	public BarChart_DB(String applicationTitle, String chartTitle, String yAxis, String xAxis, String selectedStatement)
			throws SQLException {
		super(applicationTitle);
		this.applicationTitle = applicationTitle;
		this.chartTitle = chartTitle;
		this.yAxis = yAxis;
		this.xAxis = xAxis;
		this.statement = selectedStatement;
		/* Create bar chart */
		JFreeChart barChart = ChartFactory.createBarChart(chartTitle, applicationTitle, yAxis,
				createDataset(selectedStatement), PlotOrientation.VERTICAL, true, false, false);

		/* Create chart panel */
		ChartPanel chartPanel = new ChartPanel(barChart);
		/* Set panel size */
		chartPanel.setPreferredSize(new Dimension(560, 367));
		/* add panel to pane */
		setContentPane(chartPanel);
	}

	private CategoryDataset createDataset(String selectedStatement) throws SQLException {
		/* Create dataset */
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		/* Create MySQL Database Connection */
		Connection connect = DriverManager.getConnection(url, user, pwd);

		/* Create and run statement */
		ResultSet resultSet = connect.createStatement().executeQuery(selectedStatement);

		if (question.equals(2) || question.equals(4) || question.equals(7)) {
			/* add data from Oracle database to dataset */
			while (resultSet.next()) {
				dataset.addValue(resultSet.getInt(2), resultSet.getString(1), xAxis);
			}
		}

		if (question.equals(1) || question.equals(5) || question.equals(8) || question.equals(10)) {

			while (resultSet.next()) {
				dataset.addValue(resultSet.getInt(1), resultSet.getString(1), xAxis);
			}
		}

		return dataset;
	}

	public static void barChart() throws SQLException {
		Scanner in = new Scanner(System.in);
		System.out.println("Bitte wählen Sie eine Frage zwischen 1-10 aus:");
		question = in.nextInt();
		System.out.printf("Frage %d ausgewählt, bitte warten Sie einen Moment.\n", question);

		BarChart_DB chart;

		switch (question) {
		case 1:
			chartTitle = "Amount of searches of 'terrorism'";
			yAxis = "Amount of searches";
			xAxis = "Searches";
			statement = Statements.QUESTION_1;
			chart = new BarChart_DB(applicationTitle, chartTitle, yAxis, xAxis, statement);
			chart.pack();
			RefineryUtilities.centerFrameOnScreen(chart);
			chart.setVisible(true);
			break;
		case 2:
			chartTitle = "Terrorist attack searches compared by Month";
			yAxis = "Amount of searches";
			xAxis = "Months";
			statement = Statements.QUESTION_2;
			chart = new BarChart_DB(applicationTitle, chartTitle, yAxis, xAxis, statement);
			chart.pack();
			RefineryUtilities.centerFrameOnScreen(chart);
			chart.setVisible(true);
			System.out.println("Ihr Diagramm wurde erfolgreich erstellt.");
			break;
		case 3:
			System.out.println("Diagramm nicht sinnvoll");
			break;
		case 4:
			chartTitle = "Terrorist attack searches compared by time of day";
			yAxis = "Amount of searches";
			xAxis = "Time of day";
			statement = Statements.QUESTION_4;
			chart = new BarChart_DB(applicationTitle, chartTitle, yAxis, xAxis, statement);
			chart.pack();
			RefineryUtilities.centerFrameOnScreen(chart);
			chart.setVisible(true);
			System.out.println("Ihr Diagramm wurde erfolgreich erstellt.");
			break;
		case 5:
			chartTitle = "Amount of times 9/11 or War on Terror was searched";
			yAxis = "Amount of searches";
			xAxis = "Searches";
			statement = Statements.QUESTION_5;
			chart = new BarChart_DB(applicationTitle, chartTitle, yAxis, xAxis, statement);
			chart.pack();
			RefineryUtilities.centerFrameOnScreen(chart);
			chart.setVisible(true);
			break;
		case 6:
			System.out.println("Diagramm nicht sinnvoll");
			break;
		case 7:
			chartTitle = "Terrorist attack searches compared by most clicked URLs";
			yAxis = "Amount of clicks";
			xAxis = "URLs";
			statement = Statements.QUESTION_7;
			chart = new BarChart_DB(applicationTitle, chartTitle, yAxis, xAxis, statement);
			chart.pack();
			RefineryUtilities.centerFrameOnScreen(chart);
			chart.setVisible(true);
			System.out.println("Ihr Diagramm wurde erfolgreich erstellt.");
			break;
		case 8:
			chartTitle = "How many users searched for terrorism?";
			yAxis = "Amount of searches";
			xAxis = "Users";
			statement = Statements.QUESTION_8;
			chart = new BarChart_DB(applicationTitle, chartTitle, yAxis, xAxis, statement);
			chart.pack();
			RefineryUtilities.centerFrameOnScreen(chart);
			chart.setVisible(true);
			break;
		case 9:
			System.out.println("Diagramm nicht sinnvoll");
			break;
		case 10:
			chartTitle = "Amount of religion queries in correlation to terrorism";
			yAxis = "Amount of searches";
			xAxis = "Searches";
			statement = Statements.QUESTION_10;
			chart = new BarChart_DB(applicationTitle, chartTitle, yAxis, xAxis, statement);
			chart.pack();
			RefineryUtilities.centerFrameOnScreen(chart);
			chart.setVisible(true);
			break;
		}
	}

	public static void main(String[] args) {
		try {
			BarChart_DB.barChart();
		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e.getMessage());
			System.out.println("SQL State: " + e.getSQLState());
			System.out.println("Vendor Error Code: " + e.getErrorCode());
		}
	}
}