package com.zuehlke.doodle.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.zuehlke.doodle.shared.Vote;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface DoodleServiceAsync {
	
	void addVote(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;
	
	void getVotes(AsyncCallback<List<Vote>> callback)
			throws IllegalArgumentException;
	
}
