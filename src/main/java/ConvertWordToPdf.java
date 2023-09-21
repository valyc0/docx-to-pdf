import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class ConvertWordToPdf {
	public static void main(String[] args) {
		// Create a Document instance and load a Word document
		
		
		
		ConvertWordToPdf cp = new ConvertWordToPdf();
		String inFilePath = "template.docx";
		String outFileDir = "./out.pdf";
		
		try {
			FileInputStream fis = new FileInputStream(inFilePath);
			ByteArrayOutputStream newInp = (ByteArrayOutputStream) cp.replace(fis);
			UUID uuid = UUID.randomUUID();
			String tmpFile = uuid.toString()+".docx";
			OutputStream outputStream = new FileOutputStream(tmpFile);
			newInp.writeTo(outputStream);
			outputStream.close();
			
			boolean convertToPdf = cp.convertToPdfFromFile(tmpFile, outFileDir);
			System.out.println(convertToPdf);
			if(convertToPdf) {
				File fileToDelete = new File(tmpFile); 
				fileToDelete.delete();
			}
			fis.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	
	public boolean convertToPdfFromFile(final String inFilePath, final String outFileDir) {
		boolean result = false;

		
		try {
			InputStream is = new FileInputStream(new File(inFilePath));
			OutputStream out = new FileOutputStream(new File(outFileDir));

			long start = System.currentTimeMillis();
			// 1) Load DOCX into XWPFDocument
			XWPFDocument document = new XWPFDocument(is);

			// 2) Prepare Pdf options
			PdfOptions options = PdfOptions.create();

			// 3) Convert XWPFDocument to Pdf
			PdfConverter.getInstance().convert(document, out, options);
			result = true;

			System.out.println("Converted to PDF file in :: " + (System.currentTimeMillis() - start) + " ms");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public boolean convertToPdf(InputStream is, final String outFile) {
		boolean result = false;

		
		try {
			
			
			OutputStream out = new FileOutputStream(new File(outFile));

			long start = System.currentTimeMillis();
			// 1) Load DOCX into XWPFDocument
			XWPFDocument document = new XWPFDocument(is);

			// 2) Prepare Pdf options
			PdfOptions options = PdfOptions.create();

			// 3) Convert XWPFDocument to Pdf
			PdfConverter.getInstance().convert(document, out, options);
			result = true;

			System.out.println("Converted to PDF file in :: " + (System.currentTimeMillis() - start) + " ms");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return result;
	}
	
	  public  OutputStream replace(InputStream is) {
		  ByteArrayOutputStream fos =new ByteArrayOutputStream();
	        try {
	            // Carica il documento DOCX esistente
	            
	            XWPFDocument document = new XWPFDocument(is);
	            
	            // Sostituisci "pippo" con "pluto" in tutto il documento
	            for (XWPFParagraph paragraph : document.getParagraphs()) {
	                for (XWPFRun run : paragraph.getRuns()) {
	                    String text = run.getText(0);
	                    if (text != null && text.contains("{{Nome}}")) {
	                        text = text.replace("{{Nome}}", "pippetto");
	                        run.setText(text, 0);
	                    }
	                }
	            }
	            
	            // Salva il nuovo documento DOCX
	            //fos = new FileOutputStream("out.docx");
	            document.write(fos);
//	            fos.close();
//	            
//	            // Chiudi il file di input
//	            fis.close();
	            
	            System.out.println("Sostituzione completata. Il nuovo documento è stato creato.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			return fos;
	    }
	
	
}