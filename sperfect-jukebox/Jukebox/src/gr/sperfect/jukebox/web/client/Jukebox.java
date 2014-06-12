package gr.sperfect.jukebox.web.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Jukebox implements EntryPoint {

	/**
	 * the api url location
	 */
	private static final String API_URL = "";

	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	private VerticalPanel mainPanel = new VerticalPanel();
	private FlexTable playlistFlexTable = new FlexTable();
	private HorizontalPanel addPanel = new HorizontalPanel();
	private TextBox newSongTextBox = new TextBox();
	private Button addSongButton = new Button("AddSong");
	private Label lastUpdatedLabel = new Label();

	/** * Entry point method. */
	public void onModuleLoad() {
		
		
		// Create table for stock data.
		playlistFlexTable.setText(0, 0, "order");
		playlistFlexTable.setText(0, 1, "song");
		playlistFlexTable.setText(0, 2, "Change");
		playlistFlexTable.setText(0, 3, "Remove");

		// http://www.gwtproject.org/doc/latest/tutorial/buildui.html
		// 2. Create a table for stock data

		// Assemble Add Stock panel.
		addPanel.add(newSongTextBox);
		addPanel.add(addSongButton);

		// Assemble Main panel.
		mainPanel.add(playlistFlexTable);
		mainPanel.add(addPanel);
		mainPanel.add(lastUpdatedLabel);

		// Associate the Main panel with the HTML host page.
		RootPanel.get("jukeboxList").add(mainPanel);

		// Move cursor focus to the input box.
		newSongTextBox.setFocus(true);
		
		 // Listen for mouse events on the Add button.
		addSongButton.addClickHandler(new ClickHandler() {
	      public void onClick(ClickEvent event) {
	        addSong();
	      }
	    });
		
		 // Listen for keyboard events in the input box.
	    newSongTextBox.addKeyDownHandler(new KeyDownHandler() {
	      public void onKeyDown(KeyDownEvent event) {
	        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
	          addSong();
	        }
	      }
	    });
	    

	}

	protected void addSong() {
		final String symbol = newSongTextBox.getText().toUpperCase().trim(); 
		newSongTextBox.setFocus(true);

		/*
	    // Stock code must be between 1 and 10 chars that are numbers, letters, or dots.
	    if (!symbol.matches("^[0-9A-Z\\.]{1,10}$")) {
	      Window.alert("'" + symbol + "' is not a valid symbol.");
	      newSongTextBox.selectAll();
	      return;
	    }
*/
	    newSongTextBox.setText("");
	    
	    Window.alert("Hello, Jukebox");

	    // TODO Don't add the stock if it's already in the table.

	    // TODO Add the stock to the table.

	    // TODO Add a button to remove this stock from the table.

	    // TODO Get the stock price.
		
	}

}
