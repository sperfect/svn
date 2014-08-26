package gr.sperfect.jukebox.web.core.objectify;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

public class OfyService {

	 static {
	        factory().register(Room.class);	   
	        factory().register(Song.class);
	        
	        // ...etc
	    }
	 
	 public static Objectify ofy() {
	        return ObjectifyService.ofy();
	    }

	    public static ObjectifyFactory factory() {
	        return ObjectifyService.factory();
	    }


}
