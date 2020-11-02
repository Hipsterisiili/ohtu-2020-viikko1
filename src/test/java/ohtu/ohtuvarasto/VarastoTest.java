package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    Varasto v2;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
        v2 = new Varasto(10, 5);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenAlkuTilavuus() {
        
        Varasto vvv = new Varasto(-1.0);
        assertEquals(0, vvv.getTilavuus(), vertailuTarkkuus);
    }
    @Test
    public void KuormitetunVarastonLuonti() {
        assertEquals(5, v2.paljonkoMahtuu(), vertailuTarkkuus);
    }
    @Test
    public void OtetaanNegatiiivinenLukUVarastosta() {
        varasto.otaVarastosta(-1);
        assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    @Test
    public void LisataanLiikaa() {
        varasto.lisaaVarastoon(100);
        assertEquals(0, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    @Test
    public void OtetaanLiikaa() {
        varasto.lisaaVarastoon(5);
        varasto.otaVarastosta(6);
        assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    @Test
    public void HuonotAlkuarvot() {
        Varasto v1 = new Varasto(-1, -1);
        assertEquals(0, v1.getSaldo(), vertailuTarkkuus);
        assertEquals(0, v1.getTilavuus(), vertailuTarkkuus);
        Varasto v2 = new Varasto(-1);
        assertEquals(0, v2.getTilavuus(), vertailuTarkkuus);
        Varasto v3 = new Varasto(5,7);
        assertEquals(5, v3.getSaldo(), vertailuTarkkuus);
    }
    @Test
    public void LisättyNegatiivinenMaara() {
        varasto.lisaaVarastoon(-1);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void TulostusToimii() {
        String sana = varasto.toString();
        assertEquals(sana, varasto.toString());
    }
}