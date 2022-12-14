package users;

import data.Request;

public  interface CanHaveRequest {

	void fullfillRequest(Request r);
	
	void declineRequest(Request r);

}

