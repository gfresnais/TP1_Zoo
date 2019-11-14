import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class TestZoo {
    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public final void testLimiteVisiteur() throws LimiteVisiteurException, AnimalDansMauvaisSecteurException {
        Zoo zoo = new Zoo();
        assertEquals(0, zoo.getNbSecteurs());

        zoo.ajouterSecteur("Canidés");
        assertEquals(1, zoo.getNbSecteurs());

        assertEquals(0, zoo.nombreAnimaux());
        assertEquals(0, zoo.getVisiteurs());
        assertEquals(15, zoo.getLimiteVisiteur());

        zoo.nouvelAnimal(new Chien("Bill"));
        assertEquals(1, zoo.nombreAnimaux());

        thrown.expect(LimiteVisiteurException.class);

        for (int i = 0; i < 20; i++) {
            zoo.nouveauVisiteur();
        }
    }

    @Test
    public final void testAjoutLion() throws AnimalDansMauvaisSecteurException {
        Zoo zoo = new Zoo();
        assertEquals(0, zoo.getNbSecteurs());

        zoo.ajouterSecteur("Canidés");
        assertEquals(1, zoo.getNbSecteurs());

        assertEquals(0, zoo.nombreAnimaux());

        zoo.nouvelAnimal(new Chien("Bill"));
        assertEquals(1, zoo.nombreAnimaux());

        thrown.expect(AnimalDansMauvaisSecteurException.class);
        zoo.nouvelAnimal(new Lion("Simba"));
        //assertEquals(1, zoo.nombreAnimaux());
    }
}
