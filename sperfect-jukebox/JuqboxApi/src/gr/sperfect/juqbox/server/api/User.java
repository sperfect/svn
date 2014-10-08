package gr.sperfect.juqbox.server.api;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class User {
	@Id
	Long id;
	String name;

	private User() {
	};

	public User(String name) {
		this.name = name;
	}
}
