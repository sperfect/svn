package gr.sperfect.juqbox.server.api;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static gr.sperfect.juqbox.server.api.OfyService.ofy;



@SuppressWarnings("serial")
public class TestingServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
		//ofy().load().key(thingKey).now();
 
		User u = new User("test");
		ofy().save().entity(u).now();
		Room r = new Room(u);
		r.name = "test2";
		ofy().save().entity(r).now();
		
		
		
		SongList sl = new SongList();
		ofy().save().entity(sl).now();
		r.setSonglist(sl);
		ofy().save().entity(r).now();
		
		Song s = new Song("name", "url");
		ofy().save().entity(s).now();
		 

		YoutubeSong us =  new YoutubeSong("name", "url");
		ofy().save().entity(us).now();
		
		 Room r2 = ofy().load().type(Room.class).filter("name", "test2").first().now();
		 resp.getWriter().println(r2.getCreator().name);
		 
		 SongList sl2 = r2.getSongList();
		
	}

}
