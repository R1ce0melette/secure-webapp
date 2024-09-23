package edu.deakin.sit218.vulnweb.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;


public class PayloadXSS {
	@NotNull(message = "is required")
	@Size(min = 3, message="is required")
	@Pattern(regexp = "[a-zA-Z!@#*]*", message = "Message can only contain alphabet characters and !@#*")
	private String payload;

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "PayloadXSS [payload=" + payload + "]";
	}
}
