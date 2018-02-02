package compressing.and.decompressing;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author ayoubfalah
 */
public class DocumentCompresser {
    
    private static void compress(String inputFile, String outputFile) 
            throws IOException, DocumentException
    {
        PdfReader reader = new PdfReader(inputFile);
        PdfStamper stamper = new PdfStamper(reader, 
                new FileOutputStream(outputFile), PdfWriter.VERSION_1_7);
        
        stamper.getWriter().setCompressionLevel(9);
        int numberOfPages = reader.getNumberOfPages() + 1;
        for (int i = 1; i < numberOfPages; i++) 
        {
            reader.setPageContent(i, reader.getPageContent(i));
        }
        stamper.setFullCompression();
        
        stamper.close();
    }    
}
