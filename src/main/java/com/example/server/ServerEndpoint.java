package com.example.server;

import org.springframework.util.DigestUtils;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ServerEndpoint {
	private static final String NAMESPACE_URI = "http://com/example/server";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "request")
	@ResponsePayload
	public Response getRequest(@RequestPayload Request request) {
		Response response = new Response();

		String hash = DigestUtils.md5DigestAsHex(request.getData());

		response.setHash(hash);

		return response;
	}
}