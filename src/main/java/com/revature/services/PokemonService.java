package com.revature.services;

import java.util.List;
import com.revature.models.Pokemon;
import com.revature.orm.ORM;
//import com.revature.orm2.ORM;
public class PokemonService {
	
	
	private ORM orm = new ORM();

	
	public PokemonService() {
		super();
		
	}
	
	public void createPokemon(Pokemon p) {
		orm.createObject(p);
	}
	
	
	public List<Pokemon> getPokemons() {
		List<Pokemon> pokeList = orm.readObjects(Pokemon.class);
		return pokeList;
	}
	
	public void updatePokemon(Pokemon p) {
		orm.updateObject(p);
	}
	
	public void deletePokemon(Pokemon p) {
		orm.deleteObject(p);
	}
}
