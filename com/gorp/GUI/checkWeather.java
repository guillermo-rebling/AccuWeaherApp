package com.gorp.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gorp.Core.CurrentReading;
import com.gorp.Core.ForecastReading;

public class checkWeather {

	private JFrame frame;
	private JRadioButton buttonClover;
	private JRadioButton buttonCharlotte;
	private JRadioButton buttonQuebecCity;
	private JRadioButton buttonBlowingRock;
	private JTable tableCurrent;
	private JTable tableForecast;
	private String notAvailable = "...";

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
		frame = new JFrame("Weather Nation... by AccuWeather");
		frame.setBounds(100, 100, 1000, 600);
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
					JOptionPane.showMessageDialog(frame, "Version 0.2\nAuthor: Guillermo Rebling", "About",
							JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblEnterCityState = new JLabel("Select your city");
		GridBagConstraints gbc_lblEnterCityState = new GridBagConstraints();
		gbc_lblEnterCityState.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterCityState.gridx = 1;
		gbc_lblEnterCityState.gridy = 1;
		lblEnterCityState.setForeground(Color.red);
		frame.getContentPane().add(lblEnterCityState, gbc_lblEnterCityState);
		
		buttonClover = new JRadioButton("Clover, SC");
		GridBagConstraints gbc_rdbtnCloverSc = new GridBagConstraints();
		gbc_rdbtnCloverSc.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCloverSc.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnCloverSc.gridx = 1;
		gbc_rdbtnCloverSc.gridy = 2;
		buttonClover.setSelected(true);
		frame.getContentPane().add(buttonClover, gbc_rdbtnCloverSc);
		
		buttonCharlotte = new JRadioButton("Charlotte, NC");
		GridBagConstraints gbc_rdbtnCharlotteNc= new GridBagConstraints();
		gbc_rdbtnCharlotteNc.anchor = GridBagConstraints.WEST;
		gbc_rdbtnCharlotteNc.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnCharlotteNc.fill = GridBagConstraints.VERTICAL;
		gbc_rdbtnCharlotteNc.gridx = 4;
		gbc_rdbtnCharlotteNc.gridy = 2;
		frame.getContentPane().add(buttonCharlotte, gbc_rdbtnCharlotteNc);
		
		buttonBlowingRock = new JRadioButton("Blowing Rock, NC");
		GridBagConstraints gbc_rdbtnBlowingRockNc = new GridBagConstraints();
		gbc_rdbtnBlowingRockNc.anchor = GridBagConstraints.WEST;
		gbc_rdbtnBlowingRockNc.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnBlowingRockNc.gridx = 1;
		gbc_rdbtnBlowingRockNc.gridy = 3;
		frame.getContentPane().add(buttonBlowingRock, gbc_rdbtnBlowingRockNc);
		
		buttonQuebecCity = new JRadioButton("Quebec City, CAN");
		GridBagConstraints gbc_rdbtnQuebecCityCan = new GridBagConstraints();
		gbc_rdbtnQuebecCityCan.anchor = GridBagConstraints.WEST;
		gbc_rdbtnQuebecCityCan.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnQuebecCityCan.gridx = 4;
		gbc_rdbtnQuebecCityCan.gridy = 3;
		frame.getContentPane().add(buttonQuebecCity, gbc_rdbtnQuebecCityCan);
		
		ButtonGroup BG = new ButtonGroup();
		BG.add(buttonBlowingRock);
		BG.add(buttonClover);
		BG.add(buttonCharlotte);
		BG.add(buttonQuebecCity);
		
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
		lblDaysForecast.setForeground(Color.blue);
		frame.getContentPane().add(lblDaysForecast, gbc_lblDaysForecast);
		
		JLabel lblCurrentConditions = new JLabel("Current conditions");
		GridBagConstraints gbc_lblCurrentConditions = new GridBagConstraints();
		gbc_lblCurrentConditions.insets = new Insets(0, 0, 5, 0);
		gbc_lblCurrentConditions.gridx = 4;
		gbc_lblCurrentConditions.gridy = 7;
		lblCurrentConditions.setForeground(Color.blue);
		frame.getContentPane().add(lblCurrentConditions, gbc_lblCurrentConditions);
		
	    String dataForecast[][]={ {"General Notes",notAvailable}, 
	    		{"Day 1",notAvailable},
	    		{"Weather Day",notAvailable},
	    		{"Weather Night",notAvailable},
                {"Max Temperature",notAvailable},
	    		{"Min Temperature",notAvailable},
	    		{"Day 2",notAvailable},
	    		{"Weather Day",notAvailable},
	    		{"Weather Night",notAvailable},
                {"Max Temperature",notAvailable},
	    		{"Min Temperature",notAvailable},
	    		{"Day 3",notAvailable},
	    		{"Weather Day",notAvailable},
	    		{"Weather Night",notAvailable},
                {"Max Temperature",notAvailable},
	    		{"Min Temperature",notAvailable},
	    		{"Day 4",notAvailable},
	    		{"Weather Day",notAvailable},
	    		{"Weather Night",notAvailable},
                {"Max Temperature",notAvailable},
	    		{"Min Temperature",notAvailable},
	    		{"Day 5",notAvailable},
	    		{"Weather Day",notAvailable},
	    		{"Weather Night",notAvailable},
                {"Max Temperature",notAvailable},
	    		{"Min Temperature",notAvailable}};    
	    String columnForecast[]={"Info","Data"};
		tableForecast = new JTable(dataForecast, columnForecast);
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.insets = new Insets(0, 0, 0, 5);
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.gridx = 1;
		gbc_table_1.gridy = 9;
		frame.getContentPane().add(tableForecast, gbc_table_1);
		
	    String dataCurrent[][]={ {"Weather",notAvailable},    
                {"Temperature",notAvailable},
                {"Precipitation",notAvailable}};    
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
				String locationCode = null;
				if(buttonClover.isSelected()) {
					locationCode = "335503";
				}else if(buttonCharlotte.isSelected()) {
					locationCode = "349818";
				}else if(buttonBlowingRock.isSelected()) {
					locationCode = "334871";
				}else if(buttonQuebecCity.isSelected()) {
					locationCode = "50011";
				}
				String fiveDaysForecast = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/" + locationCode + "?apikey=mux6GsZNqWzNimEZnMag6K6x9xt5YdJT";
				String currentConditions = "http://dataservice.accuweather.com/currentconditions/v1/" + locationCode + "?apikey=mux6GsZNqWzNimEZnMag6K6x9xt5YdJT";
				
				String USER_AGENT ="Mozilla/5.0";
				URL obj;
				try {
					obj = new URL(fiveDaysForecast);
					HttpURLConnection con = (HttpURLConnection) obj.openConnection();
					con.setRequestMethod("GET");
					con.setRequestProperty("User-Agent", USER_AGENT);
					int responseCode = con.getResponseCode();
					System.out.println("GET Response Code (forecast 5d) :: " + responseCode);
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

						ForecastReading weatherForecastData = gson.fromJson(response.toString(), ForecastReading.class);
					

						dataForecast[0][1] = weatherForecastData.getHeadline().getText();							//Weather alerts
						
						int dayCounter = 0;
						for (int i = 1; i <= 25; i++) {
							//5 days forecast
							dataForecast[i][1] = weatherForecastData.DailyForecasts[dayCounter].getDate().substring(0, 10);		//Date for the days
							i++;
							dataForecast[i][1] = weatherForecastData.DailyForecasts[dayCounter].Day.IconPhrase;					//Weather perception day time
							i++;
							dataForecast[i][1] = weatherForecastData.DailyForecasts[dayCounter].Night.IconPhrase;				//Weather perception night time
							i++;
							dataForecast[i][1] = weatherForecastData.DailyForecasts[dayCounter].Temperature.Maximum.getValue();	//Value in Fahrenheit Max
							i++;
							dataForecast[i][1] = weatherForecastData.DailyForecasts[dayCounter].Temperature.Minimum.getValue();	//Value in Fahrenheit Min
							dayCounter++;
						}
						
						tableForecast.setToolTipText(dataForecast[0][1]);

						((AbstractTableModel) tableForecast.getModel()).fireTableDataChanged();
						

					} else {
						System.out.println("GET request did not work - Forecast");
					}
					//Accessing the current conditions
					obj = new URL(currentConditions);
					con = (HttpURLConnection) obj.openConnection();
					con.setRequestMethod("GET");
					con.setRequestProperty("User-Agent", USER_AGENT);
					responseCode = con.getResponseCode();
					System.out.println("GET Response Code (current conditions) :: " + responseCode);
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

						CurrentReading[] weatherCurrentData = gson.fromJson(response.toString(), CurrentReading[].class);
						
						System.out.println(weatherCurrentData[0].toString());
						
						//Current conditions
						dataCurrent[0][1] = weatherCurrentData[0].WeatherText;						//Wether headline
						dataCurrent[1][1] = weatherCurrentData[0].Temperature.Imperial.Value + " " + weatherCurrentData[0].Temperature.Imperial.Unit;		//Current temp
						dataCurrent[2][1] = weatherCurrentData[0].PrecipitationType;				//Preipitation type

						((AbstractTableModel) tableCurrent.getModel()).fireTableDataChanged();
						

					} else {
						System.out.println("GET request did not work - Current Conditions");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} 
		});
	}

}
