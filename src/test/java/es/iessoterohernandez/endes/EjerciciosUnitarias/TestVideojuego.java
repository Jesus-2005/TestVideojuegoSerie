package es.iessoterohernandez.endes.EjerciciosUnitarias;

import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestVideojuego {
	private static Videojuego v;
	@BeforeEach
	public void init() {
		v = new Videojuego("Minecraft",30,"Mundo Abierto","Mojang");
	}
	
	@Test
	public void testIsEnregado() {
		 assertThat(v.isEntregado(), is(false));
		 v.entregar();
		 assertThat(v.isEntregado(), is(true));
	}
	
	@Test
	public void testToString() {
		
		String resultado = "Informacion del videojuego: \n" +
                "\tTitulo: Minecraft\n" +
                "\tHoras estimadas: 30\n" +
                "\tGenero: Mundo Abierto\n" +
                "\tcompañia: Mojang";
		assertThat(v.toString(), matchesPattern(resultado));
	}
	
	@Test
	public void testEquals(){
		Videojuego v1 = new Videojuego("Minecraft",30,"Mundo Abierto","Mojang");
		assertThat(v.equals(v1), is(true));
		Videojuego v2 = new Videojuego("Zelda Tear of the Kingdom",40,"Mundo Abierto","Nintendo");
		assertThat(v.equals(v2), is(false));
	}
	
	@Test
	public void testCompareTo(){
		Videojuego v1 = new Videojuego("Super Mario Bross",12,"Mundo Abierto","nintendo");
		assertThat(v.compareTo(v1), is(Videojuego.MAYOR));
		Videojuego v2 = new Videojuego("Zelda Tear of the Kingdom",40,"Mundo Abierto","Nintendo");
		assertThat(v.compareTo(v2), is(Videojuego.MENOR));
		Videojuego v3 = new Videojuego("Tetris",30,"Puzzle","Nintendo");
		assertThat(v.compareTo(v3), is(Videojuego.IGUAL));
	}
}
