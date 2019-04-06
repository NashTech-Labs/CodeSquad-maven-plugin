//package com.knoldus;
//
//import java.io.File;
//import org.apache.maven.plugin.testing.AbstractMojoTestCase;
//import org.junit.Test;
//
//public class CodeSquadTest extends AbstractMojoTestCase {
//
//	@Test
//    public void testSomething()
//        throws Exception
//    {
//        File pom = getTestFile( "src/test/resources/com.knoldus/pom.xml" );
//        assertNotNull( pom );
//        assertTrue( pom.exists() );
//
//        CodeSquad myMojo = (CodeSquad) lookupMojo( "ReportUpload", pom );
//        assertNotNull( myMojo );
//        myMojo.execute();
//    }
//}