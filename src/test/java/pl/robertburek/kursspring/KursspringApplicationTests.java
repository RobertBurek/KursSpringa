package pl.robertburek.kursspring;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.robertburek.kursspring.domain.repository.KnightRepository;
import pl.robertburek.kursspring.domain.Knight;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KursspringApplicationTests {

	@Autowired
	Knight knight;
	@Autowired
    KnightRepository knightRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCastle(){
		String except ="Znajduje się tu zamek o nazwie New KnightRepository. Zamieszkuje go Rycerz o imieniu Zbyszko (35). Ma " +
				"za zadanie : Uratuj wszystkie księżniczki.";
		//KnightRepository knightRepository = new KnightRepository(knight); //nowy zamek nie posiada wstrzykniętych parametrów z properties
		//dla tedo test się wysypuje. musimy wstrzyknąć do testu spring beana knightRepository.
		assertEquals(except, knightRepository.toString());

	}

}
