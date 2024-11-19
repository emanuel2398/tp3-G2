package edu.spring.istfi;

import edu.spring.istfi.entity.PiedraPapelTijera;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class PiedraPapelTijeraTest{
    //1
    @Test
    public void testJugarPiedraYPapel() {
        PiedraPapelTijera ejemplo = new PiedraPapelTijera();
        String resultado = ejemplo.jugar(PiedraPapelTijera.Jugada.PIEDRA, PiedraPapelTijera.Jugada.PAPEL);
        assertEquals("Jugador 2", resultado);
    }

    //2
    @Test
    public void testJuagrPiedraYTijera() {
        PiedraPapelTijera ejemplo = new PiedraPapelTijera();
        String resultado = ejemplo.jugar(PiedraPapelTijera.Jugada.PIEDRA, PiedraPapelTijera.Jugada.TIJERA);
        assertEquals("Jugador 1", resultado);
    }

    //3
    @Test
    public void testJugarPiedraYPiedra() {
        PiedraPapelTijera ejemplo = new PiedraPapelTijera();
        String resultado = ejemplo.jugar(PiedraPapelTijera.Jugada.PIEDRA, PiedraPapelTijera.Jugada.PIEDRA);
        assertEquals("Empate", resultado);
    }

    //4
    @Test
    public void testJugarPapelYTijera() {
        PiedraPapelTijera ejemplo = new PiedraPapelTijera();
        String resultado = ejemplo.jugar(PiedraPapelTijera.Jugada.PAPEL, PiedraPapelTijera.Jugada.TIJERA);
        assertEquals("Jugador 2", resultado);
    }

    //5
    @Test
    public void testJugarTijeraYPapel() {
        PiedraPapelTijera ejemplo = new PiedraPapelTijera();
        String resultado = ejemplo.jugar(PiedraPapelTijera.Jugada.TIJERA, PiedraPapelTijera.Jugada.PAPEL);
        assertEquals("Jugador 1", resultado);
    }

    //6
    @Test
    public void testJugarTijeraYTijera() {
        PiedraPapelTijera ejemplo = new PiedraPapelTijera();
        String resultado = ejemplo.jugar(PiedraPapelTijera.Jugada.TIJERA, PiedraPapelTijera.Jugada.TIJERA);
        assertEquals("Empate", resultado);
    }


}