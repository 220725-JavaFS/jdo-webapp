package com.revature.models;

public class Pokemon implements Comparable<Pokemon>{
	private int id;
	private String name;
	private String type;
	private String owner;
	private int hp;
	
	public Pokemon(int id, String name, String type, String owner, int hp) {
		super();
		this.id = 0;
		this.name = name;
		this.type = type;
		this.owner = owner;
		this.hp = hp;
	}
	
	public Pokemon() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String moves(int move) {
		switch(move) {
			case 1:
				return "protect";
			case 2:
				return "electric bolt";
			case 3:
				return "surf";
			case 4:
				return "thunder";
			default:
				return "there are no other moves";
			}
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hp;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		if (hp != other.hp)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", type=" + type + ", owner=" + owner + ", hp=" + hp + "]";
	}

	@Override
	public int compareTo(Pokemon arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
