package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import dev.DVDCollection;
import dev.DVDConsoleUI;
import dev.DVDUserInterface;

@DisplayName("DVDConsoleUI Test")
class DVDConsoleUITest {
	
	@DisplayName("Test consoleUI constructor")
	@Test
	void test() {
		DVDCollection dl = new DVDCollection();
		DVDUserInterface dvdConsoleUI = new DVDConsoleUI(dl);
		assertNotNull(dvdConsoleUI);
	}

}
