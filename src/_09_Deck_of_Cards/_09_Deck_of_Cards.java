package _09_Deck_of_Cards;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class _09_Deck_of_Cards {

	public static void main(String[] args) {
	
		Document document = new Document();
		try {
			//create pdf document and open it
			PdfWriter.getInstance(document, new FileOutputStream("DeckOfCards.pdf"));
			document.open();
			document.newPage();	
			//crete and setup the table sizes
			PdfPTable table = new PdfPTable(8);
			table.setWidthPercentage(100);
			float[] columnWidths = {1f,0.5f,1f,0.5f,1f,0.5f,1f,0.5f};
			table.setWidths(columnWidths);
			
			for (int rank = 0; rank < 13; rank++) {
				for (int suit = 0; suit < 4; suit++) {					
					PdfPCell cell = new PdfPCell(new Paragraph(getCard(suit,rank), getColor(suit)));
					cell.setFixedHeight(120);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBorderColor(BaseColor.BLACK);
					PdfPCell cellSpacer = new PdfPCell(new Paragraph(""));
					cellSpacer.setFixedHeight(120);
					cellSpacer.setBorder(0);
					table.addCell(cell);
					table.addCell(cellSpacer);
				}
				for (int i = 0; i < 8; i++) {
					PdfPCell rowCellSpacer = new PdfPCell(new Paragraph(""));
					rowCellSpacer.setFixedHeight(30f);
					rowCellSpacer.setBorder(0);
					table.addCell(rowCellSpacer);
				}
			}
			document.add(table);
			document.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ggg:"+e);
		}
		

	}
	public static String getCard(int suit, int rank){
	//  spades, hearts, diamonds, and clubs 
			String[] suits = new String[]{"\u2660","\u2665","\u2666","\u2663"};
			String[] ranks = new String[]{"2","3","4","5","6","7","8","9","10","A","J","Q","K"};
		return ranks[rank]+suits[suit];
	}
	public static Font getColor(int suit) throws DocumentException, IOException{
		BaseFont baseFont = BaseFont.createFont("times.ttf", BaseFont.IDENTITY_H, true);
		Font color;
		if(suit == 1 || suit == 2){
			color = new Font(baseFont, 20f, 0, BaseColor.RED);
		}else{
			color = new Font(baseFont, 20f, 0, BaseColor.BLACK);
		}
		return color;
	}
	
}
