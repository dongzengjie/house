package com.dzj.house.elasticSearch;

public class HouseIndexMessage {

	public static final String INDEX="index";
	public static final String REMOVE="remove";
	public static final int MAX_RELAY=3;
	
	private int relay;
	private String operation;
	private long houseId;
	public int getRelay() {
		return relay;
	}
	public void setRelay(int relay) {
		this.relay = relay;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public long getHouseId() {
		return houseId;
	}
	public void setHouseId(long houseId) {
		this.houseId = houseId;
	}
	
	public HouseIndexMessage() {
		
	}
	public HouseIndexMessage(int relay, String operation, long houseId) {
		
		this.relay = relay;
		this.operation = operation;
		this.houseId = houseId;
	}
	
	
}
