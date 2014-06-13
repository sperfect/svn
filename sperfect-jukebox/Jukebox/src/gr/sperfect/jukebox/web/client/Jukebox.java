package gr.sperfect.jukebox.web.client;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
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

	private static final int REFRESH_INTERVAL = 5000; // ms

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
	private ArrayList<String> songs = new ArrayList<String>();

	/** * Entry point method. */
	public void onModuleLoad() {

		// Create table for stock data.
		playlistFlexTable.setText(0, 0, "order");
		playlistFlexTable.setText(0, 1, "song");
		playlistFlexTable.setText(0, 2, "Change");
		playlistFlexTable.setText(0, 3, "Remove");
		
		playlistFlexTable.setCellPadding(6);

		playlistFlexTable.getRowFormatter().addStyleName(0, "songListHeader");
		playlistFlexTable.addStyleName("songList");

		playlistFlexTable.getCellFormatter().addStyleName(0, 1,
				"watchListNumericColumn");
		playlistFlexTable.getCellFormatter().addStyleName(0, 2,
				"watchListNumericColumn");
		playlistFlexTable.getCellFormatter().addStyleName(0, 3,
				"watchListRemoveColumn");

		// Assemble Add Stock panel.
		addPanel.add(newSongTextBox);
		addPanel.add(addSongButton);
		addPanel.addStyleName("addPanel");

		// Assemble Main panel.
		mainPanel.add(addPanel);
		mainPanel.add(playlistFlexTable);
		mainPanel.add(lastUpdatedLabel);

		// Associate the Main panel with the HTML host page.
		RootPanel.get("jukeboxList").add(mainPanel);

		// Move cursor focus to the input box.
		newSongTextBox.setFocus(true);

		// Setup timer to refresh list automatically.
		Timer refreshTimer = new Timer() {
			@Override
			public void run() {
				refreshWatchList();
			}
		};
		refreshTimer.scheduleRepeating(REFRESH_INTERVAL);

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

	protected void refreshWatchList() {
		final double MAX_PRICE = 100.0; // $100.00
		final double MAX_PRICE_CHANGE = 0.02; // +/- 2%

		SongInfo[] prices = new SongInfo[songs.size()];
		for (int i = 0; i < songs.size(); i++) {
			double price = Random.nextDouble() * MAX_PRICE;
			double change = price * MAX_PRICE_CHANGE
					* (Random.nextDouble() * 2.0 - 1.0);

			prices[i] = new SongInfo(songs.get(i), price, change);
		}

		updateTable(prices);

	}

	private void updateTable(SongInfo[] prices) {
		// TODO Auto-generated method stub
		for (int i = 0; i < prices.length; i++) {
			updateTable(prices[i]);
		}
		// Display timestamp showing last refresh.
		lastUpdatedLabel.setText("Last update : "
				+ DateTimeFormat.getFormat(PredefinedFormat.DATE_TIME_MEDIUM)
						.format(new Date()));
	}

	/**
	 * Update a single row in the stock table.
	 * 
	 * @param price
	 *            Stock data for a single row.
	 */
	private void updateTable(SongInfo price) {
		// Make sure the stock is still in the stock table.
		if (!songs.contains(price.getSymbol())) {
			return;
		}

		int row = songs.indexOf(price.getSymbol()) + 1;

		// Format the data in the Price and Change fields.
		String priceText = NumberFormat.getFormat("#,##0.00").format(
				price.getPrice());
		NumberFormat changeFormat = NumberFormat
				.getFormat("+#,##0.00;-#,##0.00");
		String changeText = changeFormat.format(price.getChange());
		String changePercentText = changeFormat
				.format(price.getChangePercent());

		// Populate the Price and Change fields with new data.
		playlistFlexTable.setText(row, 1, priceText);
		//playlistFlexTable.setText(row, 2, changeText + " (" + changePercentText + "%)");
		
		Label changeWidget = (Label)playlistFlexTable.getWidget(row, 2);
	    changeWidget.setText(changeText + " (" + changePercentText + "%)");
	    
	    String changeStyleName = "noChange";
	    if (price.getChangePercent() < -0.1f) {
	      changeStyleName = "negativeChange";
	    }
	    else if (price.getChangePercent() > 0.1f) {
	      changeStyleName = "positiveChange";
	    }

	    changeWidget.setStyleName(changeStyleName);
	}

	protected void addSong() {
		final String symbol = newSongTextBox.getText().toUpperCase().trim();
		newSongTextBox.setFocus(true);

		// Stock code must be between 1 and 10 chars that are numbers,
		// letters, or dots.
		if (!symbol.matches("^[0-9A-Z\\.]{1,10}$")) {
			Window.alert("'" + symbol + "' is not a valid symbol.");
			newSongTextBox.selectAll();
			return;
		}

		newSongTextBox.setText("");

		// Window.alert("Hello, Jukebox");

		// Don't add the stock if it's already in the table.
		if (songs.contains(symbol))
			return;

		// Add the stock to the table.
		int row = playlistFlexTable.getRowCount();
		songs.add(symbol);
		playlistFlexTable.setText(row, 0, symbol);
		playlistFlexTable.setWidget(row, 2, new Label());

		playlistFlexTable.getCellFormatter().addStyleName(0, 1,
				"watchListNumericColumn");
		playlistFlexTable.getCellFormatter().addStyleName(0, 2,
				"watchListNumericColumn");
		playlistFlexTable.getCellFormatter().addStyleName(0, 3,
				"watchListRemoveColumn");

		// Add a button to remove this stock from the table.
		Button removeStockButton = new Button("x");
		removeStockButton.addStyleDependentName("remove");
		removeStockButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				int removedIndex = songs.indexOf(symbol);
				songs.remove(removedIndex);
				playlistFlexTable.removeRow(removedIndex + 1);
			}
		});
		playlistFlexTable.setWidget(row, 3, removeStockButton);

		// Get the stock price.
		refreshWatchList();

	}

}
