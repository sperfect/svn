package gr.sperfect.juqbox.server.api;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

public class OfyService {

	 static {
	        factory().register(Room.class);	   
	        factory().register(Song.class);
	        factory().register(SongList.class);
	        factory().register(User.class);
	        factory().register(YoutubeSong.class);
	        
	        // ...etc
	    }
	 
	 public static Objectify ofy() {
	        return ObjectifyService.ofy();
	    }

	    public static ObjectifyFactory factory() {
	        return ObjectifyService.factory();
	    }


}
