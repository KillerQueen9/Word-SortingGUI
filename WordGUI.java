//*******************************************************************I M P O R T********************************************************************************//
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.*;
//***************************************************************************************************************************************************************//
/*
 * Name: Liwen Cui
 * Lab Instructor: Zhujun Li
 * Lab Section: 212-11A
 * 
 *****************************************************************************************************************************************************************/

public class WordGUI extends JFrame implements ActionListener{
	static JFrame WordGUI;
	static TextArea As, Es, Is, Os, Us, other;
	static Scanner check;
	static WordTree Map;
	static WordTree Add;
	static String word;
	static File file;
	static JMenuBar menuBar  = new JMenuBar();
    static JMenu fileMenu = new JMenu("File");
    static JMenu Addon =  new JMenu("Edit");
    
	public WordGUI() {
		this.setTitle("Project4 - Liwen Cui");//title
	   JMenuItem item;//new Menu item
	   
	   // File Menu
	   item = new JMenuItem("Open");//Menu button "Open"
	   item.addActionListener(this);//action listener for "open", if user click on open, action_perfromed method will receive this as a action event parameter
	   fileMenu.add( item );// add button onto the file Menu
	   fileMenu.addSeparator(); // A bar that separates two buttons
	   item = new JMenuItem("Quit"); // Menu button "Quit"
	   item.addActionListener(this); // action listener for "Quit", same use as button "Open"
	   fileMenu.add( item );// add button onto the file Menu
	   
	   
	   // Edit Menu
	   item = new JMenuItem("Add Word"); // Menu button "Quit"
	   item.addActionListener(this); // action listener for "Quit", same use as button "Open"
	   Addon.add( item );
	   setJMenuBar(menuBar);// add the menu bar onto the jFrame
	   menuBar.add(fileMenu);// add menu "File" onto the menu bar
	   menuBar.add(Addon);
	   /*************************************************************************************************************************/
		this.setLayout(new GridLayout(2,3)); // Grid Layout 2 rows by 3 column
		this.setSize(1500,1000); // size 1500 pixel by 1000 pixel
		this.setVisible(true);   // set visible to the user
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);  // Close and terminate when user click on Exit
	}// constructor
	
	
	
public void actionPerformed(ActionEvent event) {
	// if event name is "Open", open the file chooser
	if(event.getActionCommand().equals("Open")) {
		JFileChooser fc = new JFileChooser("./");// open up the file chooser on current file path
		switch(fc.showOpenDialog(null /*Open up the file choosing dialog FIRST*/)) {  // switch case used to prevent null pointer exception
		case JFileChooser.APPROVE_OPTION: // if user chose a file
		file = fc.getSelectedFile();//, assign it to variable file
		}// End of switch case, now file has been selected
		
		Map = new WordTree(); // instantiate a new WordTree
		try {
			check = new Scanner(file);
		} catch (FileNotFoundException FNFE) {
			System.out.println("No valid File was Selected! ");
			System.exit(0);
		}
		// loop through the file and scan
		while(check.hasNextLine()) {
			try {
				word = check.next();
			    Word W = new Word(word); // instantiate a new Word Object for every String in the text file
			    Map.put(W); // call the put method in WordTree class (to put Words into the sorted map)
			} catch (IllegalWordException w) {
				System.out.println(w.getMessage()); // if invalid words are found, catch it and print the message specified in Word Class onto the console
			}
		}
		check.close();  // close the scanner to prevent memory leak
		
		print(Map.getMap());// call the getMap() method in Class WordTree to get the Sorted Map that saved all the Words and call the print method
		// because Map is a WordTree object, can not be directly casted to Sorted Map
	}
	else if(event.getActionCommand().equals("Quit")) { // if event name is "Quit", terminate the program
		System.exit(0);
	}
	
	if(event.getActionCommand().equals("Add Word")) {	
		word = JOptionPane.showInputDialog(null, "Please Enter Your Words: ");
		Add = new WordTree();
		try {
			Word W = new Word(word);
			Add.put(W);
		} catch (IllegalWordException e) {
			System.out.println(e.getMessage());
		}
		add(Add.getMap());
	}
}


public void print(SortedMap<Word,Word> Map) {
	// ContentPane
	Container showStuff = this.getContentPane();
	// 6 TextAreas
	As = new TextArea();showStuff.add(As); 
	Es = new TextArea();showStuff.add(Es);
	Is = new TextArea();showStuff.add(Is);
	Os= new TextArea();showStuff.add(Os);
	Us = new TextArea();showStuff.add(Us);
	other = new TextArea();showStuff.add(other);	
	
	
	Iterator i = Map.keySet().iterator(); //use a iterator and while loop to loop through the Sorted Map
	while(i.hasNext()) {
		word = i.next().toString(); // iterator. next() can only be used once in a loop, so using a temporary String variable to store each word
		switch(word.charAt(0))  { // if the first letter of the String
		case 'a':case 'A': As.append(word+" " + "\n"); break; // equals a or A, append it to textArea As
		case 'e':case 'E': Es.append(word+" " + "\n"); break; // equals e or E, append it to textArea Es
		case 'i':case 'I': Is.append(word+" " + "\n"); break; // equals i or I, append it to textArea Is
		case 'o':case 'O': Os.append(word+" " + "\n"); break; // equals o or O, append it to textArea Os
		case 'u':case 'U': Us.append(word+" " + "\n"); break; // equals u or U, append it to textArea Us
		default: other.append(word+" " + "\n");break; // equals something else, append it to textArea other
		
			} // End of switch Case
		this.setVisible(true); // set the JFrame visible second time to get the TextAreas and Words showing instantly after user chose a file
		
	}
} // Print method


public void add(SortedMap<Word,Word> Map) {
	Iterator i = Map.keySet().iterator(); //use a iterator and while loop to loop through the Sorted Map
	while(i.hasNext()) {
		word = i.next().toString(); // iterator. next() can only be used once in a loop, so using a temporary String variable to store each word
		switch(word.charAt(0))  { // if the first letter of the String
		case 'a':case 'A': As.append(word+" " + "\n"); break; // equals a or A, append it to textArea As
		case 'e':case 'E': Es.append(word+" " + "\n"); break; // equals e or E, append it to textArea Es
		case 'i':case 'I': Is.append(word+" " + "\n"); break; // equals i or I, append it to textArea Is
		case 'o':case 'O': Os.append(word+" " + "\n"); break; // equals o or O, append it to textArea Os
		case 'u':case 'U': Us.append(word+" " + "\n"); break; // equals u or U, append it to textArea Us
		default: other.append(word+" " + "\n");break; // equals something else, append it to textArea other
		
			} // End of switch Case
		//this.setVisible(true); // set the JFrame visible second time to get the TextAreas and Words showing instantly after user chose a file
		
	}
}
}