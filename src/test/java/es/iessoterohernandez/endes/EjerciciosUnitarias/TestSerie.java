package es.iessoterohernandez.endes.EjerciciosUnitarias;



import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestSerie {
	
	private static Serie s;
	@BeforeEach
	public void init() {
		s = new Serie("Breaking Bad",6,"Suspense","Vince Gilligan");
	}
	
	@Test
	public void testIsEnregado() {
		 assertThat(s.isEntregado(), is(false));
		 s.entregar();
		 assertThat(s.isEntregado(), is(true));
	}
	
	@Test
	public void testToString() {
		
		String resultado = "Informacion de la Serie: \n" +
                "\tTitulo: Breaking Bad\n" +
                "\tNumero de temporadas: 6\n" +
                "\tGenero: Suspense\n" +
                "\tCreador: Vince Gilligan";
		assertThat(s.toString(), matchesPattern(resultado));
	}
	
	@Test
	public void testEquals(){
		Serie s1 = new Serie("Breaking Bad",6,"Suspense","Vince Gilligan");
		assertThat(s.equals(s1), is(true));
		Serie s2 = new Serie("Miercoles",1,"Terror","Tim Burton");
		assertThat(s.equals(s2), is(false));
	}
	@Test
	public void testCompareTo(){
		Serie s1 = new Serie("Miercoles",1,"Terror","Tim Burton");
		assertThat(s.compareTo(s1), is(Videojuego.MAYOR));
		Serie s2 = new Serie("One piece",12,"Aventura","Eiichiro Oda");
		assertThat(s.compareTo(s2), is(Videojuego.MENOR));
		Serie s3 = new Serie("La casa de papel",6,"Ladrones","Pepito");
		assertThat(s.compareTo(s3), is(Videojuego.IGUAL));
	}

}
