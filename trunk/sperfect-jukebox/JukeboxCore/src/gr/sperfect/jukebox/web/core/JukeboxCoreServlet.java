package gr.sperfect.jukebox.web.core;


import static gr.sperfect.jukebox.web.core.objectify.OfyService.ofy;
import gr.sperfect.jukebox.web.core.objectify.Room;
import gr.sperfect.jukebox.web.core.objectify.Song;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Result;

@SuppressWarnings("serial")
public class JukeboxCoreServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
		//ObjectifyService.factory().register(Room.class);


		
		Song s = new Song("tst/url");
		ofy().save().entity(s).now();
		
		Room r = new Room("test");		
		r.setLastSong(s);
		
		ofy().save().entity(r).now();
		
		assert r.id != null;
		
		Result<Room> result = ofy().load().key(Key.create(Room.class, r.id));  // Result is async
		Room fetched1 = result.now();    // Materialize the async value

		fetched1.name += "1";
		ofy().save().entity(fetched1);
		
		resp.getWriter().println(fetched1.id);
		
		
		 
	}
}
