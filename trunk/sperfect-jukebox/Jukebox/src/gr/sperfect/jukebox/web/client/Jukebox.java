package gr.sperfect.jukebox.web.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
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
		// TODO
		// Create table for stock data.
		playlistFlexTable.setText(0, 0, "Symbol");
		playlistFlexTable.setText(0, 1, "Price");
		playlistFlexTable.setText(0, 2, "Change");
		playlistFlexTable.setText(0, 3, "Remove");

		// http://www.gwtproject.org/doc/latest/tutorial/buildui.html
		// 2. Create a table for stock data

		// TODO
		// Assemble Add Stock panel.

		// TODO
		// Assemble Main panel.

		// TODO
		// Associate the Main panel with the HTML host page.

		// TODO Move cursor focus to the input box.

	}

}
