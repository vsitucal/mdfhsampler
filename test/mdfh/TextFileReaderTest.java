/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdfh;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 88119g
 */
public class TextFileReaderTest {
    
//    public TextFileReaderTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }

    /**
     * Test of readFileData method, of class TextFileReader.
     */
    @Test
    public void testReadFileData() {
        System.out.println("readFileData");
        TextFileReader instance = new TextFileReader("sample.txt");
        String expResult = "00000000,A,123456789,B,002000,   IBM,0002000000,Y\r\n00000000,A,123456790,S,006000,   IBM,0002010000,Y";
        String result = instance.readFileData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        //
    }
    
}
