
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestZoo {

    private static final Logger LOGGER = LogManager.getLogger(TestZoo.class.getName());

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public final void testLimiteVisiteur() throws LimiteVisiteurException, AnimalDansMauvaisSecteurException {
        LOGGER.debug("Test Limite Visiteur");

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
        LOGGER.debug("Test Ajout Lion");

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

    @Test
    public final void testCompareSecteur() throws AnimalDansMauvaisSecteurException {
        LOGGER.debug("Test Comparator");

        Zoo zoo = new Zoo();

        zoo.ajouterSecteur("Canidés");
        zoo.ajouterSecteur("Oiseaux");

        zoo.nouvelAnimal(new Chien("Bill"));
        zoo.nouvelAnimal(new Chat("Garfield"));

        List<Secteur> secteurs = zoo.getSecteurAnimaux();

        ComparatorSecteur cs = new ComparatorSecteur();

        // Compare the two sectors, they have the same animals
        assertEquals(0, cs.compare(secteurs.get(0), secteurs.get(1)));
    }

    @Test
    public final void testCreationAnimal() {
        Chat chat = new Chat("Minou");
        assertEquals("Minou", chat.getNomAnimal());
        assertEquals("CHAT", chat.getTypeAnimal());

        Chien chien = new Chien("Brutus");
        assertEquals("Brutus", chien.getNomAnimal());
        assertEquals("CHIEN", chien.getTypeAnimal());
    }

    @Test
    public final void testLogs() {
        String message = "Hello there!";
        LOGGER.trace(message);
        LOGGER.debug(message);
        LOGGER.info(message);
        LOGGER.warn(message);
        LOGGER.error(message);
        LOGGER.fatal(message);
    }
}
