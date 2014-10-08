<h2>Java Swing application demo</h2>
<br/>
<ol>
<li>Swing components (JFrame, JPanel, JButton, JLabel, etc)</li>
<li>AbstractTableModel to populate JTable</li>
<li>SwingWorker to run tasks in a background thread</li>
<li>MVC design pattern</li>
</ol>

<h5>Requirement:</h5>
<p>
Scenario - Football table<br/>
There are four main requirements of this coding exercise:<br/>
1. Write a standalone application that will read in values from a pre-defined text file, 'football.dat'. The file includes information relating to football teams, the games played, goals scored per match, etc.<br/>
2. Display the data within the file in a JTable in the same order as that within the text file.<br/>
3. Include a button in the frame that, when clicked, calculates the most consistent team. The definition of 'consistent' is left open.<br/>
4. The calculation of the most consistent team will be performed off the Event Dispatch Thread (EDT), such that after pressing the button the EDT will not freeze while calculating.<br/>
<br/><br/>
Packaging<br/>
Package the source code alongside a built Football.jar file. The jar file must be runnable, and the code must compile without exceptions.<br/>
</p>

<h5>Design</h5>
<p>
MVC design pattern is used to separate data and user interface concerns so that changes to the user interface will not affect data handling making the application more maintainable.<br/>
<br/>
Model (FootballStatsModel and TableModel) - represents data from interface file football.dat and the business logic to calculate the most consistent team<br/>
View (FootballStatsView) - class where components are arranged and components' properties are set. <br/>
Controller (FootballStatsController) - it keeps model and view separated. controls all actions and data flow from model and view.
</p>

<h5>Assumption:</h5>
<p>
- data from file is tab delimited<br/>
- first line of file contains table headers<br/>
- file football.dat is on the same folder as the executable jar<br/>
- no sort functionality<br/>
- data from text file is displayed as is, data is not validated.<br/>
- any changes to football.dat will not refresh the table<br/>
- netbeans IDE designer is used to design user interface<br/>
</p>

<h5>Exception Handling:</h5>
<p>
- "Unable to load file" is displayed when file is not found<br/>
- "Unable to calculate" is displayed when scores contain letters or special characters<br/>
</p>

<h5>Possible improvements</h5>
<p>
- data validation of football.dat<br/>
- improve algorithm in calculating most consistent team<br/>
- display multiple teams when teams have equal consistency ratings<br/>
- maintain error messages and location of football.dat in a properties file<br/>
- create test scripts for regression testing<br/>
</p>
