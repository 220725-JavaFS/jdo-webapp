package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Pokemon;
import com.revature.services.PokemonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class readServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private PokemonService pokemonService = new PokemonService();
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		List<Pokemon> pokes = pokemonService.getPokemons();
		
		String json = objectMapper.writeValueAsString(pokes);
		
		System.out.println(json);
		
		PrintWriter printWriter = response.getWriter();
		
		printWriter.print(json);
		
		response.setStatus(200);
		
		response.setContentType("application/json");
	} 
}