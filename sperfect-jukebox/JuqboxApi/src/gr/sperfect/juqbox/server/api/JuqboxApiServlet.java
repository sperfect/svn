package gr.sperfect.juqbox.server.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.PlaylistItem;
import com.google.api.services.youtube.model.PlaylistItemListResponse;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;

@SuppressWarnings("serial")
public class JuqboxApiServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");

		try {
			YouTube youtube = new YouTube.Builder(UrlFetchTransport.getDefaultInstance(),
					JacksonFactory.getDefaultInstance(), new HttpRequestInitializer() {
						public void initialize(HttpRequest request) throws IOException {
						}
					}).setApplicationName("sperfect-juqbox-api").build();

			YouTube.Search.List search = youtube.search().list("id,snippet");

			String queryTerm = "radiohead";

			search.setKey("AIzaSyC1lpLnlmQjy7PO_YuOYhzxzPUq83pvi3k");
			search.setQ(queryTerm);

			search.setType("video");
			search.setVideoCategoryId("10");

			// search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
			search.setMaxResults((long) 50);

			SearchListResponse searchResponse = search.execute();
			List<SearchResult> searchResultList = searchResponse.getItems();

			if (searchResultList != null) {
				// resp.getWriter().println(
				// prettyPrint(searchResultList.iterator(), queryTerm));

				for (SearchResult searchResult : searchResultList) {

					resp.getWriter().println("----");
					resp.getWriter().println(searchResult.getSnippet().getTitle());

					List<PlaylistItem> playlistItemList = new ArrayList<PlaylistItem>();

					YouTube.PlaylistItems.List playlistItemRequest = youtube.playlistItems().list(
							"id,contentDetails,snippet");
					playlistItemRequest.setPlaylistId("RD" + searchResult.getId().getVideoId());
					playlistItemRequest.setKey("AIzaSyC1lpLnlmQjy7PO_YuOYhzxzPUq83pvi3k");
					playlistItemRequest.setMaxResults((long) 50);

					PlaylistItemListResponse playlistItemResult = playlistItemRequest.execute();
					playlistItemList.addAll(playlistItemResult.getItems());

					Iterator<PlaylistItem> playlistEntries = playlistItemList.iterator();

					while (playlistEntries.hasNext()) {
						PlaylistItem playlistItem = playlistEntries.next();

						resp.getWriter().println(" video name  = " + playlistItem.getSnippet().getTitle());
					}

				}

			}
		} catch (Exception ex) {

			// resp.getWriter().println(ex.getCause());
			resp.getWriter().println(ex.getMessage());
		}

	}

	private String prettyPrint(Iterator<SearchResult> iteratorSearchResults, String query) {

		String _ret = "";
		_ret += "\n=============================================================";
		_ret += "   First videos for search on \"" + query + "\".";
		_ret += "=============================================================\n";

		if (!iteratorSearchResults.hasNext()) {
			_ret += " There aren't any results for your query.";
		}

		while (iteratorSearchResults.hasNext()) {

			SearchResult singleVideo = iteratorSearchResults.next();
			ResourceId rId = singleVideo.getId();

			// Confirm that the result represents a video. Otherwise, the
			// item will not contain a video ID.
			if (rId.getKind().equals("youtube#video")) {
				Thumbnail thumbnail = singleVideo.getSnippet().getThumbnails().getDefault();

				_ret += " Video Id: " + rId.getVideoId();
				_ret += " Title: " + singleVideo.getSnippet().getTitle();
				_ret += " Thumbnail: " + thumbnail.getUrl();
				_ret += "\n-------------------------------------------------------------\n";
			}
		}
		return _ret;
	}

}
