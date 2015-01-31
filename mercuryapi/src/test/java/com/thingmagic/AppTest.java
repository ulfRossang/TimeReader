package com.thingmagic;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
        TagProtocol tagProto = TagProtocol.GEN2;
        System.out.println(tagProto.toString());
        
        LLRPReader llrpreader = new LLRPReader("TEST");
        System.out.println(llrpreader.toString());
        
        Reader reader;
        String error = null;
        try {
            //Define the antenna port list to use for the reads
            int[] antennas = new int[] {1,2,3,4};
//            TagProtocol tagProto = TagProtocol.GEN2;
            // Define a read plan that will be execute when the reader is reading
            SimpleReadPlan readPlan = new SimpleReadPlan(antennas, tagProto);
            
            // Create the reader object
            try {
                reader = Reader.create("tmr://192.168.0.66/");
                reader.connect();
                
//                reader.checkConnection();
                
                reader.stopReading();
                        
                reader.destroy(); 
                
            } catch (Exception e) {
                e.printStackTrace();
            } 
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
