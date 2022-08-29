package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;
import java.util.stream.Collectors;

import com.revature.models.Pokemon;
import com.revature.services.PokemonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class updateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PokemonService pokemonService = new PokemonService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		
		List<Pokemon> pokes = pokemonService.getPokemons();
		Pokemon sadPokemon = pokes.get(0);
		sadPokemon.setOwner("gary");
		pokemonService.updatePokemon(pokes.get(0));
		
		
		String URI = request.getRequestURI();
		System.out.println(URI);
		
		PrintWriter print = response.getWriter();
		print.print("<h1>You should update the pokemon!</h1>");
		response.setStatus(208);
		response.setHeader("content-type", "text/html");
		
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Pokemon> pokes = pokemonService.getPokemons();
		
		List<Pokemon> updatedList = pokes.stream()
                .map( e ->{
                	e.setOwner("gary");
                	pokemonService.updatePokemon(e);
                	return e;
                } ) 
                .collect(Collectors.toList());
		
		
		System.out.println(updatedList);
		String URI = request.getRequestURI();
		System.out.println(URI);
		
		PrintWriter print = response.getWriter();
		print.print("<h1>You have updated the pokemon!</h1>");
		response.setStatus(208);
		response.setHeader("content-type", "text/html");
	}
}
