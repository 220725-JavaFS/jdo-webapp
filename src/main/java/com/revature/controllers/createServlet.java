package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Pokemon;

import com.revature.services.PokemonService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class createServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	private PokemonService pokemonService = new PokemonService();;
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		String URI = request.getRequestURI();
		System.out.println(URI);
		
		PrintWriter print = response.getWriter();
		print.print("<h1>Welcome to my project1!</h1>");
		response.setStatus(200);
		response.setHeader("content-type", "text/html");
		
	} 
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		String line = reader.readLine();
		
		while(line != null) {
			sb.append(line);
			line = reader.readLine();
		}
		
		String json = new String(sb);
		
		Pokemon pokemon = objectMapper.readValue(json, Pokemon.class);
		pokemonService.createPokemon(pokemon);
		response.setStatus(201);
		
		
		PrintWriter print = response.getWriter();
		print.print("<h1>You have created a pokemon!</h1>");
		
		response.setHeader("content-type", "text/html");	
			
	} 
}
