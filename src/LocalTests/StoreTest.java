package LocalTests;// Testing imports

import Objects.*;
import Objects.Buyer;
import Objects.Seller;
import Objects.Store;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
* This class contains test cases for 
* Methods in Store.java
*
* @author Michael Dimitrov
* @author Federico Lebron
* @author Sanya Mehra
* @author Aaron Ni 
* @author Diya Singh
*/

public class StoreTest {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestCase.class);
        if (result.wasSuccessful()) {
            System.out.println("Excellent - Tests ran successfully");
        } else {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
    }

    public static class TestCase {

        private final PrintStream originalOutput = System.out;
        private final InputStream originalSysin = System.in;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayInputStream testIn;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayOutputStream testOut;

        @Before
        public void outputStart() {
            testOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(testOut));
        }

        @After
        public void restoreInputAndOutput() {
            System.setIn(originalSysin);
            System.setOut(originalOutput);
        }

        private String getOutput() {
            return testOut.toString();
        }

        private void receiveInput(String str) {
            testIn = new ByteArrayInputStream(str.getBytes());
            System.setIn(testIn);
        }

        @Test(timeout = 1000)
        public void testAddStock() {
            try {
                Book book1 = new Book("Book 1", "Store 1", "Horror", "Scary Book", 100);
                Book book2 = new Book("Book 2", "Store 2", "Romance", "A romantic book", 100);

                Seller seller = new Seller("Seller 1",
                        "Someone@email.com",
                        "135ddb0636296c1cb0aa3f74bd852867a4dc64b97a9f4eb5d68586b47a4b66a6b86a17658fd95f0d28702b4f76ec1c028740caf671f2f50526f8e5a13ebcf144",
                        "CyberSecure");

                seller.createNewStore("Store 1");

                Store store = seller.getStoreByName("Store 1");

                store.addStock(10, book1);
                store.addStock(5, book2);

                HashMap<Book, Integer> expected = new HashMap<>();
                expected.put(book1, 10);
                expected.put(book2, 5);

                assertEquals("", expected, store.getStock());

            } catch (Exception e) {
                e.printStackTrace();
                fail();
            }
        }

        @Test(timeout = 1000)
        public void testGetAverageRating() {
            try {
                Book book1 = new Book("Book 1", "Store 1", "Horror", "Scary Book", 100);
                Book book2 = new Book("Book 2", "Store 2", "Romance", "A romantic book", 100);

                Seller seller = new Seller("Seller 1",
                        "Someone@email.com",
                        "135ddb0636296c1cb0aa3f74bd852867a4dc64b97a9f4eb5d68586b47a4b66a6b86a17658fd95f0d28702b4f76ec1c028740caf671f2f50526f8e5a13ebcf144",
                        "CyberSecure");

                seller.createNewStore("Store 1");

                Store store = seller.getStoreByName("Store 1");

                store.addStock(10, book1);
                store.addStock(5, book2);

                HashMap<Book, Integer> expected = new HashMap<>();
                expected.put(book1, 10);
                expected.put(book2, 5);

                assertEquals("", expected, store.getStock());

            } catch (Exception e) {
                e.printStackTrace();
                fail();
            }
        }


    }
}
