package com.zuehlke.doodle.server;

import java.util.List;

import javax.jdo.PersistenceManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.zuehlke.doodle.client.DoodleService;
import com.zuehlke.doodle.shared.FieldVerifier;
import com.zuehlke.doodle.shared.Vote;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class DoodleServiceImpl extends RemoteServiceServlet implements
		DoodleService {

	public String addVote(String name) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(name)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		// Insert row into database.
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Vote vote = new Vote(name);
        try {
            pm.makePersistent(vote);
        } finally {
            pm.close();
        }

        // Construct HTML response.
		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");
		return "Hello, " + name + "!<br><br>I saved your name. I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}
	
	public List<Vote> getVotes() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		return (List<Vote>) pm.getManagedObjects(Vote.class);
	}
	
}
