package com.example.poc.string;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


public class ReceiptTest {
	
	private static String temp_dir = "temp" + File.separator;
	private static String payment_receipt_1 = temp_dir + "payment_receipt_1.pdf";
	private static String payment_receipt_2 = temp_dir + "payment_receipt_2.pdf";
	
	private static String inputFile = payment_receipt_1;
	
	private final static String inputStr = "Hello World!";

    public static void main(String[] args) throws Exception {
        
    	String compressedStr = getCompressedPDFBase64();
    	
    	decompressPdfBase64(compressedStr);
    	
    	
    }
    
    public static String getCompressedPDFBase64()  throws IOException {	
    	
    	byte[] compressedByte = compressPDF();
    	
    	String compressedStr = Base64.getEncoder().encodeToString(compressedByte);
    	log("Compressed Str Length", "" + compressedStr.length());
    	
    	return compressedStr;
    }
    
    public static byte[] compressPDF() throws IOException {
    	
    	ByteArrayOutputStream os = new ByteArrayOutputStream();
        GZIPOutputStream gos = new GZIPOutputStream(os);
		gos.write(readFile());
        gos.close();
        byte[] compressed = os.toByteArray();
        os.close();
		return compressed;
	}
    
    public static byte[] readFile() throws IOException {
	    File file = new File(inputFile);
	    return readContentIntoByteArray(file);
	}
    
    private static byte[] readContentIntoByteArray(File file)
    {
       FileInputStream fileInputStream = null;
       byte[] bFile = new byte[(int) file.length()];
       try
       {
          //convert file into array of bytes
          fileInputStream = new FileInputStream(file);
          fileInputStream.read(bFile);
          fileInputStream.close();
       }
       catch (Exception e)
       {
          e.printStackTrace();
       }
       return bFile;
    }
    
    /*
     * Decompress and generate PDF
     */
    public static void decompressPdfBase64(String compressedStr) {
    	long timestamp = System.currentTimeMillis();
    	
    	writeStringToFile(compressedStr, timestamp);
    	
    	byte[] byteArray = Base64.getDecoder().decode(compressedStr.getBytes());
    	
    	String decompressed = decompressTest(byteArray, timestamp);
    	
    	log("Decompressed :", "");
    }

    public static String decompressTest(byte[] compressed, long timestamp) {
    	
    	final int BUFFER_SIZE = 32;
		
		GZIPInputStream gis = null;
		FileOutputStream fileOutputStream = null;
		StringBuilder string = new StringBuilder();
		
        try {
        	
        	ByteArrayInputStream is = new ByteArrayInputStream(compressed);
        	gis = new GZIPInputStream(is, BUFFER_SIZE);
        	
        	fileOutputStream = new FileOutputStream("dec_"+ timestamp +".pdf");
        	
        	
        	byte[] data = new byte[BUFFER_SIZE];
        	int bytesRead;
        	
			while ((bytesRead = gis.read(data)) != -1) {
			    string.append(new String(data, 0, bytesRead));
			    try {
						fileOutputStream.write(data, 0, bytesRead);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
		        	}
			}
			 gis.close();
		     is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
       
        return string.toString();
    }

	private static void writeStringToFile(String text, long timestamp) {
		PrintWriter out = null;
		try {
			out = new PrintWriter("dec_"+ timestamp +".txt");
			out.println(text);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(out != null) {
				out.close();
			}
		}
	}

	
    private static void log(String tag, String msg) {
    	System.out.println(tag + " : " + msg);
    }
}
