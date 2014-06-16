package gr.sperfect.jukebox.web.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.bramosystems.oss.player.core.client.AbstractMediaPlayer;
import com.bramosystems.oss.player.core.client.PlayException;
import com.bramosystems.oss.player.core.client.PlayerUtil;
import com.bramosystems.oss.player.core.client.PluginNotFoundException;
import com.bramosystems.oss.player.core.client.PluginVersionException;
import com.bramosystems.oss.player.youtube.client.ChromelessPlayer;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
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

	private static final String JSON_URL = GWT.getModuleBaseURL()
			+ "songList?q=";
	// "http://localhost:8888/jukebox/songList?q=";

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
	private Label errorMsgLabel = new Label();

	private AbstractMediaPlayer player = null;

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
		errorMsgLabel.setStyleName("errorMessage");
		errorMsgLabel.setVisible(false);
		mainPanel.add(errorMsgLabel);

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

		SimplePanel panel = new SimplePanel(); // create panel to hold the
												// player
		
		mainPanel.add(panel);

		try {
			
			
			// create the player, specifing URL of media
			// player = new YouTubePlayer("video-id", "width", "height");
			// player = new YouTubeIPlayer("JlYXp_3A64k", "100%", "350px");
			player = new ChromelessPlayer("JlYXp_3A64k", "100%", "100%");

			panel.setWidget(player); // add player to panel.
		} catch (PluginVersionException e) {
			// required Flash plugin version is not available,
			// alert user possibly providing a link to the plugin download page.
			panel.setWidget(new HTML(".. some nice message telling the "
					+ "user to download plugin first .."));
		} catch (PluginNotFoundException e) {
			// required Flash plugin not found, display a friendly notice.
			panel.setWidget(PlayerUtil.getMissingPluginNotice(e.getPlugin()));
		} catch (Exception e) {
			// required Flash plugin version is not available,
			// alert user possibly providing a link to the plugin download page.
			panel.setWidget(new HTML(".. some nice message telling the "
					+ "user to download plugin first . . " + e.getMessage()));
		}

		
		
		

	}

	protected void refreshWatchList() {

		if (songs.size() == 0) {
			return;
		}

		String url = JSON_URL;

		// Append watch list stock symbols to query URL.
		Iterator<String> iter = songs.iterator();
		while (iter.hasNext()) {
			url += iter.next();
			if (iter.hasNext()) {
				url += "+";
			}
		}

		url = URL.encode(url);

		// Send request to server and handle errors.

		// 1 - same site
		/*
		 * RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		 * try { Request request = builder.sendRequest(null, new
		 * RequestCallback() {
		 * 
		 * @Override public void onResponseReceived(Request request, Response
		 * response) { // Auto-generated method stub if (200 ==
		 * response.getStatusCode()) { updateList((JsArray<SongData>)
		 * JsonUtils.safeEval(response.getText())); } else {
		 * displayError("Couldn't retrieve JSON (" + response.getStatusText() +
		 * ")"); } }
		 * 
		 * @Override public void onError(Request request, Throwable e) { // TODO
		 * Auto-generated method stub displayError("Couldn't retrieve JSON" +
		 * e.getMessage()); } });
		 * 
		 * } catch (RequestException e) {
		 * displayError("Couldn't retrieve JSON (2) " + e.getMessage() ); }
		 */

		// 2 - cross site
		JsonpRequestBuilder builder = new JsonpRequestBuilder();
		builder.requestObject(url, new AsyncCallback<JsArray<SongData>>() {
			public void onFailure(Throwable caught) {
				displayError("Couldn't retrieve JSON " + caught.getMessage());
			}

			public void onSuccess(JsArray<SongData> data) {
				if (data == null) {
					displayError("Couldn't retrieve JSON null!");
					return;
				}

				updateList(data);
			}
		});
	}

	protected void displayError(String error) {
		errorMsgLabel.setText("Error: " + error);
		errorMsgLabel.setVisible(true);

	}

	private void updateList(JsArray<SongData> prices) {
		// TODO Auto-generated method stub
		for (int i = 0; i < prices.length(); i++) {
			updateTable(prices.get(i));
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
	private void updateTable(SongData price) {
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
		// playlistFlexTable.setText(row, 2, changeText + " (" +
		// changePercentText + "%)");

		Label changeWidget = (Label) playlistFlexTable.getWidget(row, 2);
		changeWidget.setText(changeText + " (" + changePercentText + "%)");

		String changeStyleName = "noChange";
		if (price.getChangePercent() < -0.1f) {
			changeStyleName = "negativeChange";
		} else if (price.getChangePercent() > 0.1f) {
			changeStyleName = "positiveChange";
		}

		changeWidget.setStyleName(changeStyleName);
	}

	protected void addSong() {
		
		try {
			player.playMedia();
		} catch (PlayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Window.alert(e.getMessage());
		}
		
		
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
