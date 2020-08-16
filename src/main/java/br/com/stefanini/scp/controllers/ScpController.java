package br.com.stefanini.scp.controllers;

import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScpController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public HttpServletRequest getRequest() { 
		FacesContext ctx = getFacesContext();
		ExternalContext exc = ctx.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) exc.getRequest();
		return request;
	}
	
	public HttpServletResponse getResponse() { 
		FacesContext ctx = getFacesContext();
		ExternalContext exc = ctx.getExternalContext();
		HttpServletResponse response = (HttpServletResponse) exc.getResponse();
		return response;
	}
	
	public ServletContext getServletContext() { 
		FacesContext ctx = getFacesContext();
		ExternalContext exc = ctx.getExternalContext();
		return (ServletContext)exc.getContext();
	}

	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
}