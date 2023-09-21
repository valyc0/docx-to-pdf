import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class ConvertWordToPdfStream {
	public static void main(String[] args) {
		// Create a Document instance and load a Word document

		ConvertWordToPdfStream cp = new ConvertWordToPdfStream();
		String inFilePath = "template.docx";
		String outFileDir = "./out.pdf";
		
		//creo una mappa di variabili da sostituire nel file doc
		Map<String, String> variableList = new HashMap<String, String>();
		variableList.put("{{Nome}}", "ciccio");
		variableList.put("{{data}}", "21/09/2023");
		variableList.put("{{città}}", "roma");

		try {
			//leggo il doc
			FileInputStream fis = new FileInputStream(inFilePath);
			
			//effettuo la replace delle variabili
			ByteArrayOutputStream outStream = (ByteArrayOutputStream) cp.replace(fis,variableList);
			
			//travaso l'out nell'in
			ByteArrayInputStream newInputStream = new ByteArrayInputStream(outStream.toByteArray());

			//converto in pdf
			boolean convertToPdf = cp.convertToPdfFromFile(newInputStream, outFileDir);
			System.out.println(convertToPdf);
			
			fis.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public boolean convertToPdfFromFile(final InputStream is, final String outFileDir) {
		boolean result = false;

		try {

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

	private List<String> findVariables(String text) {
		List<String> variables = null;
		if (text != null) {
			if (text.contains("{{")) {
				variables = new ArrayList<String>();
				Pattern pattern = Pattern.compile("\\{\\{([^}]+)}}");
				Matcher matcher = pattern.matcher(text);

				while (matcher.find()) {
					String variabile = matcher.group(1); // Prende il testo all'interno delle doppie parentesi graffe
					variables.add("{{"+variabile+"}}");
				}
			}

		}
		return variables;

	}

	public OutputStream replace(InputStream is, Map<String, String> mapToSubstitute) {
		ByteArrayOutputStream fos = new ByteArrayOutputStream();
		try {
			// Carica il documento DOCX esistente

			XWPFDocument document = new XWPFDocument(is);
			if (mapToSubstitute != null) {
				// Sostituisci "pippo" con "pluto" in tutto il documento
				for (XWPFParagraph paragraph : document.getParagraphs()) {
					for (XWPFRun run : paragraph.getRuns()) {
						String text = run.getText(0);
						if (text != null) {
							List<String> findVariables = findVariables(text);
							if (findVariables != null) {
								for (String variaB : findVariables) {

									text = text.replace(variaB, mapToSubstitute.get(variaB));
									run.setText(text, 0);
								}

							}
						}

					}
				}

				// Salva il nuovo documento DOCX
				// fos = new FileOutputStream("out.docx");
				document.write(fos);
//		            fos.close();
//		            
//		            // Chiudi il file di input
//		            fis.close();

				System.out.println("Sostituzione completata. Il nuovo documento è stato creato.");

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return fos;
	}

}