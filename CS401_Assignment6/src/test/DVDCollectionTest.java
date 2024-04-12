package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import dev.DVD;
import dev.DVDCollection;
import org.junit.jupiter.api.DisplayName;
import java.io.*;
import java.util.Scanner;

@DisplayName("DVDCollection Test")
class DVDCollectionTest {
	
	// test data (total 15 movies)
	String[] titles = {
            "The Shawshank Redemption", "The Godfather", "The Dark Knight", 
            "Forrest Gump", "Inception", "The Matrix", 
            "Pulp Fiction", "Fight Club", "Interstellar", 
            "Goodfellas", "The Silence of the Lambs", "Saving Private Ryan", 
            "Spirited Away", "The Green Mile", "Parasite"
        };

    String[] ratings = {
        "R", "R", "PG-13", "PG-13", "PG-13", "R", 
        "R", "R", "PG-13", "R", "R", "R", 
        "PG", "R", "R"
    };

    String[] duration = {
        "142", "175", "152", "142", "148", "136", 
        "154", "139", "169", "146", "118", "169", 
        "125", "189", "132"
    };
    
    DVD[] myDVD;
    DVDCollection dvdCollection;
	

	@BeforeEach
	void setUp() {
		// set up dvd
		myDVD = new DVD[15];
	    for (int i = 0; i < 15; i++) {
	    	int runningTime = Integer.parseInt(duration[i]);
	    	myDVD[i] = new DVD(titles[i], ratings[i], runningTime);
	    }
	    
	    // set up dvd collection
	    dvdCollection = new DVDCollection();
	}

	
	@DisplayName("Test addOrModifyDVDTest() method")
	@Nested
	class AddOrModifyDVDTest {
		
		@DisplayName("Test adding new DVDs")
		@Test
		void addOrModifyDVDTest1() {
			// add 4 new dvds
			for (int i = 0; i < 4; i++) {
				dvdCollection.addOrModifyDVD(titles[i], ratings[i], duration[i]);
			}
			// verify add by toString()
			String expectedInfo = "numdvds = 4\n"
					+ "dvdArray.length = 7\n"
					+ "dvdArray[0] = Forrest Gump/PG-13/142min\n"
					+ "dvdArray[1] = The Dark Knight/PG-13/152min\n"
					+ "dvdArray[2] = The Godfather/R/175min\n"
					+ "dvdArray[3] = The Shawshank Redemption/R/142min\n";
			// verify
			String actualInfo = dvdCollection.toString();
			assertTrue(expectedInfo.equals(actualInfo));
		}
		
		@DisplayName("Test modifying a DVD")
		@Test
		void addOrModifyDVDTest2() {
			// add 4 new dvds
			for (int i = 0; i < 4; i++) {
				dvdCollection.addOrModifyDVD(titles[i], ratings[i], duration[i]);
			}
			// modify a dvd
			dvdCollection.addOrModifyDVD("Forrest Gump", "R", "999");
			
			// verify add by toString()
			String expectedInfo = "numdvds = 4\n"
					+ "dvdArray.length = 7\n"
					+ "dvdArray[0] = Forrest Gump/R/999min\n"
					+ "dvdArray[1] = The Dark Knight/PG-13/152min\n"
					+ "dvdArray[2] = The Godfather/R/175min\n"
					+ "dvdArray[3] = The Shawshank Redemption/R/142min\n";
			// verify
			String actualInfo = dvdCollection.toString();
			assertTrue(expectedInfo.equals(actualInfo));
		}
	}
	
	@DisplayName("Test removeDVD() method")
	@Nested
	class RemoveDVDTest {
		@DisplayName("Test 1")
		@Test
		void removeDVDTest1() {
			// add 4 new dvds
			for (int i = 0; i < 4; i++) {
				dvdCollection.addOrModifyDVD(titles[i], ratings[i], duration[i]);
			}
			// remove DVD The Shawshank Redemption
			dvdCollection.removeDVD("The Shawshank Redemption");
			// verify add by toString()
			String expectedInfo = "numdvds = 3\n"
					+ "dvdArray.length = 7\n"
					+ "dvdArray[0] = Forrest Gump/PG-13/142min\n"
					+ "dvdArray[1] = The Dark Knight/PG-13/152min\n"
					+ "dvdArray[2] = The Godfather/R/175min\n";
			// verify
			String actualInfo = dvdCollection.toString();
			assertTrue(expectedInfo.equals(actualInfo));
		}
		
		@DisplayName("Test 2")
		@Test
		void removeDVDTest2() {
			// add 4 new dvds
			for (int i = 0; i < 4; i++) {
				dvdCollection.addOrModifyDVD(titles[i], ratings[i], duration[i]);
			}
			// remove DVD Forrest Gump
			dvdCollection.removeDVD("Forrest Gump");
			// verify add by toString()
			String expectedInfo = "numdvds = 3\n"
					+ "dvdArray.length = 7\n"
					+ "dvdArray[0] = The Dark Knight/PG-13/152min\n"
					+ "dvdArray[1] = The Godfather/R/175min\n"
					+ "dvdArray[2] = The Shawshank Redemption/R/142min\n"; 
			// verify
			String actualInfo = dvdCollection.toString();
			assertTrue(expectedInfo.equals(actualInfo));
		}
		
		@DisplayName("Test 3")
		@Test
		void removeDVDTest3() {
			// add 4 new dvds
			for (int i = 0; i < 4; i++) {
				dvdCollection.addOrModifyDVD(titles[i], ratings[i], duration[i]);
			}
			// remove DVD The Dark Knight
			dvdCollection.removeDVD("The Dark Knight");
			// verify add by toString()
			String expectedInfo = "numdvds = 3\n"
					+ "dvdArray.length = 7\n"
					+ "dvdArray[0] = Forrest Gump/PG-13/142min\n"
					+ "dvdArray[1] = The Godfather/R/175min\n"
					+ "dvdArray[2] = The Shawshank Redemption/R/142min\n";
			// verify
			String actualInfo = dvdCollection.toString();
			assertTrue(expectedInfo.equals(actualInfo));
		}
		
		@DisplayName("Test 4")
		@Test
		void removeDVDTest4() {
			// add 4 new dvds
			for (int i = 0; i < 4; i++) {
				dvdCollection.addOrModifyDVD(titles[i], ratings[i], duration[i]);
			}
			// remove all four DVDs 
			dvdCollection.removeDVD("The Dark Knight");
			dvdCollection.removeDVD("Forrest Gump");
			dvdCollection.removeDVD("The Godfather");
			dvdCollection.removeDVD("The Shawshank Redemption");
			// verify add by toString()
			String expectedInfo = "numdvds = 0\n"
					+ "dvdArray.length = 7\n";
			// verify
			String actualInfo = dvdCollection.toString();
			assertTrue(expectedInfo.equals(actualInfo));
		}
		
	} // end RemoveDVDTest class
	

	@DisplayName("Test getDVDsByRating() method")
	@Test
	void getDVDsByRatingTest() {
		// add 4 new dvds
		for (int i = 0; i < 4; i++) {
			dvdCollection.addOrModifyDVD(titles[i], ratings[i], duration[i]);
		}
		String expectedRating = "The Godfather\n"
				+ "The Shawshank Redemption\n";
		String actualRating = dvdCollection.getDVDsByRating("R");
		assertTrue(expectedRating.equals(actualRating));
	}
	
	
	@DisplayName("Test getTotalRunningTime() method")
	@Test
	void getTotalRunningTimeTest() {
		// add 4 new dvds
		for (int i = 0; i < 4; i++) {
			dvdCollection.addOrModifyDVD(titles[i], ratings[i], duration[i]);
		}
		// calculate total running time
		int expectedTime = 0;
		for (int i = 0; i < 4; i++) {
			expectedTime += Integer.parseInt(duration[i]);
		}
		assertEquals(expectedTime, dvdCollection.getTotalRunningTime());
	}
	
	@DisplayName("Test loadData() method")
	@Nested
	class LoadDataTest {
		
		@DisplayName("Test load data from not-existing file")
		@Test
		void loadEmptyFile() {
			String filename = "dvddataNotFound.txt";
			dvdCollection.loadData(filename);
			String expectedInfo = "numdvds = 0\n"
					+ "dvdArray.length = 7\n";
			// verify
			String actualInfo = dvdCollection.toString();
			assertTrue(expectedInfo.equals(actualInfo));
		}
		
		@DisplayName("Test load data from corrupted file")
		@Test
		void loadCorruptedFile() {
			String filename = "dvddatatest_open_corrupted_file.txt";
			dvdCollection.loadData(filename);
			String expectedInfo = "numdvds = 2\n"
					+ "dvdArray.length = 7\n"
					+ "dvdArray[0] = Forrest Gump/PG-13/142min\n"
					+ "dvdArray[1] = The Dark Knight/PG-13/152min\n";
			String actualInfo = dvdCollection.toString();
			assertTrue(expectedInfo.equals(actualInfo));
		}
		
		@DisplayName("Test load data from normal file")
		@Test
		void loadNormalFile() {
			String filename = "dvddata_normal_file.txt";
			dvdCollection.loadData(filename);
			// verify
			String expectedInfo = "numdvds = 3\n"
					+ "dvdArray.length = 7\n"
					+ "dvdArray[0] = ANGELS AND DEMONS/PG-13/138min\n"
					+ "dvdArray[1] = STAR TREK/R/127min\n"
					+ "dvdArray[2] = UP/PG/96min\n";
			String actualInfo = dvdCollection.toString();
			assertTrue(expectedInfo.equals(actualInfo));
		}
		
	} // end LoadDataTest class
	
	
	@DisplayName("Test save() method")
	@Test
	void saveTest() {
		try {
			String filename = "temp.txt";
			File file = new File(filename);
			// remove temp.txt from directory
			if (file.exists()) {
				file.delete();
			}
			
			// load data from temp.txt
			dvdCollection.loadData(filename);
			
			// add 4 new dvds
			for (int i = 0; i < 4; i++) {
				dvdCollection.addOrModifyDVD(titles[i], ratings[i], duration[i]);
			}
			
			// save
			dvdCollection.save();
			
			// verify
			file = new File(filename);
			File file1 = new File("dvddata_save_sample.txt");
			
			Scanner scanner = new Scanner(file);
			Scanner scanner1 = new Scanner(file1);
			
			String info, info1;
			while(scanner.hasNextLine() && scanner1.hasNextLine()) {
				info = scanner.nextLine();
				info1 = scanner1.nextLine();
				assertTrue(info.equals(info1));
			}
			
			if (!scanner.hasNextLine() && !scanner1.hasNextLine()) {
				assertTrue(true);
			} else {
				fail();
			}
			
			file.delete(); // clean up temp.txt
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
} // end DVDCollectionTest class
