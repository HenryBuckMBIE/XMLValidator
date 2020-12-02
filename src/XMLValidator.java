import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.sf.saxon.Transform;


public class XMLValidator {

	static String sExpectedError = "id=\"AUNZ-R-001\"";
	static String sActualError = "No Error Found";
	static String sTestResult = "This Test Failed";
	static String sAnyFatalError = "flag=\"fatal\"";	
	static String REPORTFILE = "No Report File";
	static String REPORTFILE1 = "C:\\e-Invoice\\XMLValidator\\XMLValidator\\OutputFiles\\Report1.xml";
	static String REPORTFILE2 = "C:\\e-Invoice\\XMLValidator\\XMLValidator\\OutputFiles\\Report2.xml";
	static int passed = 0;
	static int failed = 0;
	
	
	public static void main(String[] args) throws Exception {
	
		GenerateXSLT();
		
		String[] TestFileList = new String[102];
		TestFileList[0] = "AUNZ-R-001";
		TestFileList[1] = "AUNZ-R-002";
		TestFileList[2] = "AUNZ-R-004";
		TestFileList[3] = "AUNZ-R-005";
		TestFileList[4] = "AUNZ-R-006";
		TestFileList[5] = "BR-01";
		TestFileList[6] = "BR-02";
		TestFileList[7] = "BR-03";
		TestFileList[8] = "BR-04";
		TestFileList[9] = "BR-05";
		TestFileList[10] = "BR-06";
		TestFileList[11] = "BR-08";
		TestFileList[12] = "BR-09";
		TestFileList[13] = "BR-29";
		TestFileList[14] = "BR-30";
		TestFileList[15] = "BR-50";  
		TestFileList[15] = "BR-51";
		TestFileList[16] = "BR-52"; 
		TestFileList[17] = "BR-55";
		TestFileList[18] = "BR-62";
		TestFileList[19] = "BR-63";
		TestFileList[20] = "BR-66";
		TestFileList[21] = "BR-67";		
		TestFileList[22] = "BR-CL-01";
		TestFileList[23] = "BR-CL-04";
		TestFileList[24] = "BR-CL-05";
		TestFileList[25] = "BR-CL-06-AUNZ";
		TestFileList[26] = "BR-CL-10";  
		TestFileList[27] = "BR-CL-11";				
		TestFileList[28] = "BR-CL-14";
		TestFileList[29] = "BR-CL-16";
		TestFileList[30] = "Valid01";
		TestFileList[31] = "BR-CL-17";
		TestFileList[32] = "BR-CL-24";		
		TestFileList[33] = "BR-CO-03-AUNZ";
		TestFileList[34] = "BR-CO-19"; 
		TestFileList[35] = "BR-CO-25";     
		TestFileList[36] = "BR-S-08-AUNZ";
		TestFileList[37] = "PEPPOL-COMMON-R040";
		TestFileList[38] = "PEPPOL-COMMON-R040";
		TestFileList[39] = "PEPPOL-EN16931-CL001";		
		TestFileList[40] = "PEPPOL-EN16931-CL002";
		TestFileList[41] = "PEPPOL-EN16931-CL007";
		TestFileList[42] = "PEPPOL-EN16931-CL008";
		TestFileList[43] = "PEPPOL-EN16931-F001";
		TestFileList[44] = "PEPPOL-EN16931-P0100"; 
		TestFileList[45] = "PEPPOL-EN16931-R001";
		TestFileList[46] = "PEPPOL-EN16931-R002";
		TestFileList[47] = "PEPPOL-EN16931-R003";
		TestFileList[48] = "PEPPOL-EN16931-R004-AUNZ";
		TestFileList[49] = "PEPPOL-EN16931-R006";
		TestFileList[50] = "PEPPOL-EN16931-R055-AUNZ";
		TestFileList[51] = "PEPPOL-EN16931-R007";
		TestFileList[52] = "PEPPOL-EN16931-R008";
		TestFileList[53] = "PEPPOL-EN16931-R010";
		TestFileList[54] = "PEPPOL-EN16931-R020";
		TestFileList[55] = "PEPPOL-EN16931-R051-AUNZ";
		TestFileList[56] = "PEPPOL-EN16931-R110";
		TestFileList[57] = "PEPPOL-EN16931-R120";
		TestFileList[58] = "Valid01";
		TestFileList[59] = "UBL-DT-06";
		TestFileList[60] = "UBL-DT-07";
		TestFileList[61] = "UBL-CR-666";
		TestFileList[62] = "UBL-CR-673";
		TestFileList[63] = "UBL-SR-01";
		TestFileList[64] = "UBL-SR-02";
		TestFileList[65] = "UBL-SR-03";
		TestFileList[66] = "UBL-SR-04";
		TestFileList[67] = "UBL-SR-05";
		TestFileList[68] = "UBL-SR-06";
		TestFileList[69] = "UBL-SR-07";
		TestFileList[70] = "UBL-SR-08";
		TestFileList[71] = "UBL-SR-09";
		TestFileList[72] = "UBL-SR-10";
		TestFileList[73] = "UBL-SR-10";		
		TestFileList[74] = "UBL-SR-12-AUNZ";
		TestFileList[75] = "UBL-SR-14";
		TestFileList[76] = "UBL-SR-15";
		TestFileList[77] = "UBL-SR-16";
		TestFileList[78] = "UBL-SR-16";
		TestFileList[79] = "UBL-SR-18-AUNZ";
		TestFileList[80] = "UBL-SR-19";
		TestFileList[81] = "UBL-SR-20";
		TestFileList[82] = "UBL-SR-21";
		TestFileList[83] = "UBL-SR-24";
		TestFileList[84] = "UBL-SR-25";
		TestFileList[85] = "UBL-SR-26";
		TestFileList[86] = "UBL-SR-28";
		TestFileList[87] = "Valid01";
		TestFileList[88] = "UBL-SR-33";
		TestFileList[89] = "UBL-SR-34";
		TestFileList[90] = "UBL-SR-35";
		TestFileList[91] = "UBL-SR-36";
		TestFileList[92] = "UBL-SR-36";  
		TestFileList[93] = "UBL-SR-39";
		TestFileList[94] = "UBL-SR-40";
		TestFileList[95] = "UBL-SR-48";
		TestFileList[96] = "UBL-SR-49";
		TestFileList[97] = "UBL-SR-50";
		TestFileList[98] = "UBL-SR-46";
		TestFileList[99] = "UBL-SR-47";
		TestFileList[100] = "UBL-CR-412";
		TestFileList[101] = "AUCreditnote";
		
		
		
		// TestFileList[68] = "ATO-2x30PaymentMeansCode";
			
		// TestFileList[xx] = "UBL-DT-01.xml"; // causes an error
		
		
		
		// Get date as string		
		String TestDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());		
		String ReportFileName = "TestReport-" + TestDate + ".txt";
		
		// initiaize the test number for the report
		int testNumber = 0;
				
		// Create a test report file
		File testReportFile = new File("C:\\e-Invoice\\XMLValidator\\XMLValidator\\OutputFiles\\" + ReportFileName);
		testReportFile.createNewFile();
		FileWriter fw = new FileWriter(testReportFile.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		// Write in file
		bw.write("Test Report Generated Using Automated Test Suite " + TestDate);
		bw.newLine();
		bw.write("-----------------------------------------------------------");
		bw.newLine();
		
		// Get Test file and validate
		for (String sFileUnderTest: TestFileList)
        {
		  // add .xml to filename (we are using sFileUnderTest for error finding later)
		  String ActualFileName = sFileUnderTest + ".xml";
          System.out.println("Test String = " + sFileUnderTest);
          String sTestFile = "C:\\e-Invoice\\XMLValidator\\XMLValidator\\TestFiles\\" + ActualFileName;
          System.out.println("Actual File Name =" + ActualFileName);
          System.out.println("path =" + sTestFile);
          String INFILE = sTestFile;
          sExpectedError = "id=\"" + sFileUnderTest + "\"";   
         
          
          // Initialize the test results for each file
          sTestResult = "This Test Failed";
          sActualError = "No Error Found";
          // reset and some rigging for valid files
          if(sExpectedError.contains("Valid")) {
        	  sExpectedError = "No Error Found";
        	  sTestResult = "Test is not expected to find an error - check using Validex";
        	  passed++;
          }
          
          
          // increment the test number
         // failed = testNumber - passed; 
          testNumber++;
            
          // Validate Test File against AUNZ-PEPPOL-validation.xslt
            String  XSLFILE = "C:\\e-Invoice\\XMLValidator\\XMLValidator\\SchematronFiles\\AUNZ-PEPPOL-validation.xslt";        
            //String  REPORTFILE1 = "C:\\e-Invoice\\XMLValidator\\XMLValidator\\OutputFiles\\Report1.xml";
  		    REPORTFILE = REPORTFILE1;
            Validate(INFILE,XSLFILE);
  		
  		  // Validate Test File against AUNZ-UBL-validation.xslt
  		    XSLFILE = "C:\\e-Invoice\\XMLValidator\\XMLValidator\\SchematronFiles\\AUNZ-UBL-validation.xslt";
  			//String REPORTFILE2 = "C:\\e-Invoice\\XMLValidator\\XMLValidator\\OutputFiles\\Report2.xml";
  			REPORTFILE = REPORTFILE2;
  			Validate(INFILE,XSLFILE);
  			
  		  // Write the result to a test report file
  			bw.write("Test " + testNumber);
  			bw.newLine();
  			bw.write("File Tested : " + sTestFile);
  			bw.newLine();
  			bw.write("Expected Result : " + sExpectedError);
  			bw.newLine();
  			bw.write("Actual Result : " + sActualError);
  			bw.newLine();
  			bw.write("Test Result : " + sTestResult);
  			bw.newLine();
  		
        }
			
		// Final Metrics
		bw.write("***********************************");
		bw.newLine();
		bw.write("Passed " + passed );
		bw.newLine();
		bw.write("Failed " + failed );
		bw.newLine();
		bw.write("Total Tests " + testNumber );
		bw.newLine();
		bw.write("***********************************");
		
		// Close connection
        bw.close();
        
        // End of Program
        System.out.println("************************************************************************************************");
        System.out.println("Passed " + passed);
        System.out.println("Failed " + failed);
        System.out.println("Total Tests " + testNumber );
        System.out.println("Validations completed - For the detailed results");
        System.out.println("Go to C:\\e-Invoice\\XMLValidator\\XMLValidator\\OutputFiles\\TestResults-Date.txt");
       	       
      }

	

	private static void GenerateXSLT() {
		// TODO Auto-generated method stub
		System.out.println("Generating the .xslt file for e-Invoice");
		// The Transform function requires an arg list as follows:
			String OUTFILE1 = "C:\\e-Invoice\\XMLValidator\\XMLValidator\\SchematronFiles\\AUNZ-PEPPOL-validation.xslt";
			String INFILE1 = "C:\\e-Invoice\\XMLValidator\\XMLValidator\\SchematronFiles\\AUNZ-PEPPOL-validation.sch";
			String XSLFILE1 = "C:\\e-Invoice\\XMLValidator\\XMLValidator\\SchematronFiles\\ISO_SVRL.xsl";
							
			String[] arglist1 = {"-o:" + OUTFILE1, INFILE1, XSLFILE1};
		    Transform.main(arglist1);
		        
		    System.out.println(" AUNZ-PEPPOL-validation.xslt has been generated");	
		    
		 // The Transform function requires an arg list as follows:
		    String OUTFILE2 = "C:\\e-Invoice\\XMLValidator\\XMLValidator\\SchematronFiles\\AUNZ-UBL-validation.xslt";
		 	String INFILE2 = "C:\\e-Invoice\\XMLValidator\\XMLValidator\\SchematronFiles\\AUNZ-UBL-validation.sch";
		 	String XSLFILE2 = "C:\\e-Invoice\\XMLValidator\\XMLValidator\\SchematronFiles\\ISO_SVRL.xsl";
		 							
		 	String[] arglist2 = {"-o:" + OUTFILE2, INFILE2, XSLFILE2};
		 	Transform.main(arglist2);
		 		        
		 	System.out.println(" AUNZ-UBL-validation.xslt has been generated");	   
		    		    
	}	
	
	private static void Validate(String iNFILE, String xSLFILE) throws IOException {
		// TODO Auto-generated method stub
		   String INFILE = iNFILE;
		   String XSLFILE = xSLFILE;
		   String OUTFILE = REPORTFILE;
		   //String  OUTFILE = "C:\\e-Invoice\\XMLValidator\\XMLValidator\\OutputFiles\\Report.xml";
		   
		   System.out.println("Performing Validation using " + XSLFILE);
		   
		   String[] arglist = {"-o:" + OUTFILE, INFILE, XSLFILE};
           Transform.main(arglist);  
           
           System.out.println("Validation Complete Report.xml");
           
        // Search File
           System.out.println(" Line 150 - Searching Error File " + OUTFILE  + " for Exprected Error : " + sExpectedError);
           
           try {
               FileReader fileIn = new FileReader(OUTFILE);
               
               BufferedReader reader = new BufferedReader(fileIn);
               String line;
               boolean errorfoundReport1 = false;
               boolean errorfoundReport2 = false;
               boolean errorfound = false;
               while((line = reader.readLine()) != null) {
            	         	   
            	             	         	   
                   if(line.contains(sExpectedError)) {
                       System.out.println(line);                     
                       System.out.println("line 120 Found Expected Error " + line);
                       sActualError = line;
                       System.out.println("line 122 Output Actual Error" + sActualError);
                       if (REPORTFILE.equals(REPORTFILE1)) {
                    	   errorfoundReport1 = true;
                    	   errorfound = true;
                       }
                   if(line.contains(sAnyFatalError)) {
                           System.out.println(line);                     
                           System.out.println("A fatal Error was Found " + line);
                           errorfound = true;
                           }    
                                             
                       if (REPORTFILE.equals(REPORTFILE2)) {
                    	   errorfoundReport2 = true;
                    	   errorfound = true;
                       }
                                                         
                   }
                   
               }
               reader.close();
               
               // Set the overall test result to a pass if the expected error was found
               if (errorfoundReport1 == true) {
            	   System.out.println("The expected error was found in REPORTFILE1"); 
            	   sTestResult = "This Test Passed";
            	   passed++;
               }
               if (errorfoundReport2 == true) {
            	   System.out.println("The expected error was found in REPORTFILE2"); 
            	   sTestResult = "This Test Passed";
            	   passed++;
               }
                          
               // Test where an error is found in a file expected to be valid
               if(sExpectedError.contains("Valid")) {
            	   if (errorfound == true) {
            		   sActualError = "Unexpected Error";
            		   sTestResult = "This Test Failed (Unexpected Error Found)";
            		   System.out.println("Unexpected Error - code line 265");
            		   failed++;
            	   }           	  
               }
               
               
           	}catch (IOException e){
               System.out.println(e);
           }
           
           System.out.println("-----------------------");
                     
	}

}
