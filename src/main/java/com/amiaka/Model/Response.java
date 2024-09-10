package com.amiaka.Model;

import lombok.Data;

@Data
public class Response {
     private String respons;
     
     public Response() {}
     
     public Response(String response) {
    	 this.respons = response;
     }

	public String getRespons() {
		return respons;
	}

	public void setRespons(String respons) {
		this.respons = respons;
	}

	@Override
	public String toString() {
		return "Response [respons=" + respons + "]";
	}
     
     
}
