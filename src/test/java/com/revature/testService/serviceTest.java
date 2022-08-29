package com.revature.testService;

import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.models.Pokemon;
import com.revature.orm.ORM;

public class serviceTest {
	private Pokemon testPokemon = new Pokemon(4, "cyndaquil", "fire", "max", 100);
	
	
	private ResultSet mockResultSet = Mockito.mock(ResultSet.class);
	private Connection mockConnection = Mockito.mock(Connection.class);
	private PreparedStatement mockPreparedStatement = Mockito.mock(PreparedStatement.class);
	
	private ORM mockORM = new ORM();
	
	@BeforeEach
	public void mockObjects() {
		try {
			Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
			Mockito.when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
			Mockito.when(mockResultSet.next()).thenReturn(true).thenReturn(false);

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCreateObject() {

		Object createdPokemon = mockORM.createObject(testPokemon);
		
		assertEquals(testPokemon, createdPokemon);
	}

	@Test
	public void testReadObject() {

		try {
			Mockito.when(mockResultSet.getString("id")).thenReturn("4");
			Mockito.when(mockResultSet.getString("name")).thenReturn("cyndaquil");
			Mockito.when(mockResultSet.getString("type")).thenReturn("fire");
			Mockito.when(mockResultSet.getString("owner")).thenReturn("max");
			Mockito.when(mockResultSet.getString("hp")).thenReturn("100");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		List<Pokemon> testList = mockORM.readObjects(Pokemon.class);

		Pokemon testPoke = testList.get(0);

		assertEquals(testPokemon, testPoke);

	}

	@Test
	public void testUpdateObject() {
		Object updatedPokemon = mockORM.updateObject(testPokemon);
		
		assertEquals(testPokemon, updatedPokemon);
	}

	@Test
	public void testDeleteObject() {
		Boolean updated = mockORM.deleteObject(testPokemon);
		assertTrue(updated);
	}
}