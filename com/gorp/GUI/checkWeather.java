package com.gorp.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gorp.Core.WeatherReading;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;

public class checkWeather {

	private JFrame frame;
	private JTextField textField;
	private JTable tableCurrent;
	private JTable tableForecast;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkWeather window = new checkWeather();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public checkWeather() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Weather Nation");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("/home/rebjac2/eclipse/java-2019-09/eclipse/weatherApp/AccuWeatherApp/src/weather.jpg").getImage());
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("FILE");
		menuBar.add(mnFile);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mnFile.add(mntmClose);
		
		JMenu mnEdit = new JMenu("EDIT");
		menuBar.add(mnEdit);
		
		JMenuItem mntmEnterApiKey = new JMenuItem("Enter API key...");
		mnEdit.add(mntmEnterApiKey);
		
		JMenu mnHelp = new JMenu("HELP");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		mntmAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent aboutEvent) {
				if (aboutEvent.getSource() == mntmAbout)
					JOptionPane.showMessageDialog(frame, "Version 0.1\nAuthor: Guillermo Rebling", "About",
							JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblEnterCityState = new JLabel("Enter City, State, Country");
		GridBagConstraints gbc_lblEnterCityState = new GridBagConstraints();
		gbc_lblEnterCityState.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterCityState.gridx = 1;
		gbc_lblEnterCityState.gridy = 1;
		frame.getContentPane().add(lblEnterCityState, gbc_lblEnterCityState);
		
		JLabel lblegCloverSc = new JLabel("(e.g. Clover, SC, USA)");
		GridBagConstraints gbc_lblegCloverSc = new GridBagConstraints();
		gbc_lblegCloverSc.insets = new Insets(0, 0, 5, 5);
		gbc_lblegCloverSc.gridx = 1;
		gbc_lblegCloverSc.gridy = 2;
		frame.getContentPane().add(lblegCloverSc, gbc_lblegCloverSc);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 5, 5);
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 4;
		frame.getContentPane().add(btnOk, gbc_btnOk);
		
		JLabel lblDaysForecast = new JLabel("Forecast for 5 days");
		GridBagConstraints gbc_lblDaysForecast = new GridBagConstraints();
		gbc_lblDaysForecast.insets = new Insets(0, 0, 5, 5);
		gbc_lblDaysForecast.gridx = 1;
		gbc_lblDaysForecast.gridy = 7;
		frame.getContentPane().add(lblDaysForecast, gbc_lblDaysForecast);
		
		JLabel lblCurrentConditions = new JLabel("Current conditions");
		GridBagConstraints gbc_lblCurrentConditions = new GridBagConstraints();
		gbc_lblCurrentConditions.insets = new Insets(0, 0, 5, 0);
		gbc_lblCurrentConditions.gridx = 4;
		gbc_lblCurrentConditions.gridy = 7;
		frame.getContentPane().add(lblCurrentConditions, gbc_lblCurrentConditions);
		
	    String dataForecast[][]={ {"General Notes","N/A"}, 
	    		{"Day 1","N/A"},
	    		{"Weather Day","N/A"},
	    		{"Weather Night","N/A"},
                {"Max Temperature","N/A"},
	    		{"Min Temperature","N/A"},
	    		{"Day 2","N/A"},
	    		{"Weather Day","N/A"},
	    		{"Weather Night","N/A"},
                {"Max Temperature","N/A"},
	    		{"Min Temperature","N/A"},
	    		{"Day 3","N/A"},
	    		{"Weather Day","N/A"},
	    		{"Weather Night","N/A"},
                {"Max Temperature","N/A"},
	    		{"Min Temperature","N/A"},
	    		{"Day 4","N/A"},
	    		{"Weather Day","N/A"},
	    		{"Weather Night","N/A"},
                {"Max Temperature","N/A"},
	    		{"Min Temperature","N/A"},
	    		{"Day 5","N/A"},
	    		{"Weather Day","N/A"},
	    		{"Weather Night","N/A"},
                {"Max Temperature","N/A"},
	    		{"Min Temperature","N/A"}};    
	    String columnForecast[]={"Info","Data"};
		tableForecast = new JTable(dataForecast, columnForecast);
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.insets = new Insets(0, 0, 0, 5);
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.gridx = 1;
		gbc_table_1.gridy = 9;
		frame.getContentPane().add(tableForecast, gbc_table_1);
		
	    String dataCurrent[][]={ {"Weather","N/A"},    
                {"Temperature","N/A"},
                {"Precipitation","N/A"}};    
	    String columnCurrent[]={"Info","Data"}; 
		tableCurrent = new JTable(dataCurrent, columnCurrent);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 4;
		gbc_table.gridy = 9;
		frame.getContentPane().add(tableCurrent, gbc_table);
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent buttonEvent) {
				String searchForCloverSC_5Days = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/335503?apikey=mux6GsZNqWzNimEZnMag6K6x9xt5YdJT";
				String USER_AGENT ="Mozilla/5.0";
				URL obj;
				try {
					obj = new URL(searchForCloverSC_5Days);
					HttpURLConnection con = (HttpURLConnection) obj.openConnection();
					con.setRequestMethod("GET");
					con.setRequestProperty("User-Agent", USER_AGENT);
					int responseCode = con.getResponseCode();
					System.out.println("GET Response Code :: " + responseCode);
					if (responseCode == HttpURLConnection.HTTP_OK) { // success
						BufferedReader in = new BufferedReader(new InputStreamReader(
								con.getInputStream()));
						String inputLine;
						StringBuffer response = new StringBuffer();
						
						while ((inputLine = in.readLine()) != null) {
							response.append(inputLine);
						}
						in.close();

						
						// Gson object to obtain the json file with the weather data
						Gson gson = new GsonBuilder().create();

						WeatherReading weatherData = gson.fromJson(response.toString(), WeatherReading.class);
						

						
						// print object data
						System.out.println("\nJSON Object\n\n" + response.toString());
						System.out.println("\nWeather Reading Object\n\n" + weatherData.toString());
						for (int i = 0; i < dataForecast.length; i++) {
							for (int j = 0; j < dataForecast[i].length; j++) {
								if(i == 0 && j == 1) {
									dataForecast[i][j] = weatherData.getHeadline().getText();	
								}
								if(i == 1 && j == 1) {
									dataForecast[i][j] = weatherData.DailyForecasts[0].Date;	
								}
							}
						}
						((AbstractTableModel) tableForecast.getModel()).fireTableDataChanged();
						

					} else {
						System.out.println("GET request not worked");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} 
		});
	}

}
