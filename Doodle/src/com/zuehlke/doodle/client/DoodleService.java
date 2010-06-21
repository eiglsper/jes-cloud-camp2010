package com.zuehlke.doodle.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.zuehlke.doodle.shared.Vote;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface DoodleService extends RemoteService {
	
	String addVote(String name) throws IllegalArgumentException;
	List<Vote> getVotes() throws IllegalArgumentException;
	
}
