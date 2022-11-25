package utility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CreateFilePDF implements DBOperation, Facade{
	private static Connection connection; 
	private static Connection getDBConnection() {
		Connection connection = null;
		
		//Context initContext;
		try {
		
			connection = ((DataSource)InitialContext.doLookup("java:/comp/env/jdbc/SEG31_DS")).getConnection();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return connection;
	}
	
	//now this is the global method that can be accessed statically by
	//other classes when creating a Connection object
	public static Connection getConnection() { 
	  return (( connection !=null ) ?
	  connection : getDBConnection());
	}
	
    public static void createPDF() {
    	Connection connection = getDBConnection();
    	
    	if (connection != null) {
	    	try {
	     	    String file_name = "C:\\Users\\user\\Desktop\\DESPATT\\PDF\\Order Receipt.pdf";
	     	    
	            Document document = new Document();
	            PdfWriter.getInstance(document, new FileOutputStream(file_name));
			         
	            Font fontSize_16 =  FontFactory.getFont(FontFactory.TIMES, 16f);
	            Font fontSize_12 =  FontFactory.getFont(FontFactory.TIMES, 12f);
	            
		        document.open();

			        PreparedStatement pstmnt = connection.prepareStatement(GET_CUSTOMER_ORDER);
					ResultSet rs = pstmnt.executeQuery();
					
		            // SIMPLE TITLE
		            Paragraph para = new Paragraph("Order Receipt", fontSize_16);
		            para.setAlignment(Element.ALIGN_CENTER);
		            document.add(para);
		            
		            Paragraph para1 = new Paragraph("");
		            document.add(para1);
		            
		            Paragraph para2 = new Paragraph("");
		            document.add(para2);
		            
		            Image image = Image.getInstance("C:\\Users\\user\\Desktop\\DESPATT\\SEG31-DESPATT-RADA_JOHNLEONARD-MP4\\web\\images\\icon.jpg");
		            image.setAlignment(Element.ALIGN_CENTER);
		            image.scaleAbsolute(30f, 30f);
		     	    document.add(image);
		     	    
		     	    Paragraph para3 = new Paragraph("");
		     	    document.add(para3);
		     	    
		            // TABLE 
		            PdfPTable table = new PdfPTable(3);
		            PdfPCell cl = new PdfPCell(new Phrase("Item Name"));
		            table.addCell(cl);
		            
		            cl = new PdfPCell(new Phrase("Item Price"));
		            table.addCell(cl);
		            
		            cl = new PdfPCell(new Phrase("Quantity"));
		            table.addCell(cl);
		            table.setHeaderRows(1);
		            
		            while(rs.next()) {
		            	table.addCell(rs.getString("itemName"));
			            table.addCell(rs.getString("itemPrice"));
			            table.addCell(rs.getString("itemQuantity"));	
		            }
		            document.add(table);
		            
		            Paragraph para4 = new Paragraph("Thank you for shopping in SwallowTail Shop", fontSize_12);
		            para4.setAlignment(Element.ALIGN_CENTER);
		            document.add(para4);
		            
	            document.close();
	     	   
		 	} catch (Exception e) {
		 		e.getMessage();
		 	}	
    	}
    	System.out.println("PDF Generated!");
    }
    
    public static void sendAttachment(){  
		 
    	final String username = "bscsmail.se31@gmail.com";
		final String password = "BSCS-SE31";
		String fromEmail = "bscsmail.se31@gmail.com";
		String toEmail = "bscsmail.se31@gmail.com";
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		//Start our mail message
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject("LEZ GO, I MADE IT MOMMA!");
			
			Multipart emailContent = new MimeMultipart();
			
			//Text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText("Here's your order receipt from SwallowTail Shop!");
			
			//Attachment body part.
			MimeBodyPart pdfAttachment = new MimeBodyPart();
			pdfAttachment.attachFile("C://Users//user//Desktop//DESPATT//PDF//Order Receipt.pdf");
			
			//Attach body parts
			emailContent.addBodyPart(textBodyPart);
			emailContent.addBodyPart(pdfAttachment);
			
			//Attach multipart to message
			msg.setContent(emailContent);
			
			Transport.send(msg);
			System.out.println("Sent message");
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

    
	@Override
	public void process() {
		createPDF();
		sendAttachment();
	}
	
}