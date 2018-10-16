package kr.co.psw.controller;

public class ForwardAction {
	private String path;
	private boolean isRedirect;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Boolean getIsRedirect() {
		return isRedirect;
	}

	public void setIsRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
