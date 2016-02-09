package com.pheonix.paymentTimingLogs;

import java.util.List;

public class Directory {
	
	private String path;
	private List<Directory> nodes;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public List<Directory> getNodes() {
		return nodes;
	}
	public void setNodes(List<Directory> nodes) {
		this.nodes = nodes;
	}
	public Directory(String path, List<Directory> nodes) {
		super();
		this.path = path;
		this.nodes = nodes;
	}
	public Directory() {
		super();
		// TODO Auto-generated constructor stub
	}

}
