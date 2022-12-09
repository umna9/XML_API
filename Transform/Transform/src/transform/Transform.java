/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transform;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Yomna
 */
public class Transform  {
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
           
            /*
            //root{message}
            Element message = doc.createElement("Message");
            doc.appendChild(message);
            
            //first element{sender}
            Element sender = doc.createElement("Sender");
            sender.setAttribute("name", "Yomna");
            Text textSend = doc.createTextNode("i'm the sender");
            sender.appendChild(textSend);
            message.appendChild(sender);
            
            
            //second element {reciever}
            Element reciever = doc.createElement("Receiver");
            reciever.setAttribute("name", "Ahmed");
            Text textRecive = doc.createTextNode("i'm the reciver");
            reciever.appendChild(textRecive);           
            message.appendChild(reciever);
            
            //third element {date}
            Element date = doc.createElement("Date");
            date.setAttribute("kind", "Gregorian");
            Text textDate = doc.createTextNode("8/12/2022");
            date.appendChild(textDate);
            message.appendChild(date);

            //fourth element {time}
            Element time = doc.createElement("Time");
            time.setAttribute("format", "24H");
            Text textTime = doc.createTextNode("12:32pm");
            time.appendChild(textTime);
            message.appendChild(time);
            
            //fifth element {note}
            Element note = doc.createElement("Note");
            Text textNote = doc.createTextNode("Here you can write the notes");
            note.appendChild(textNote);            
            message.appendChild(note);*/
            
            Source source = new DOMSource(doc);
            Result result = new StreamResult(new File("message.xml"));
            
            
            
            //the transformer
            TransformerFactory fac = TransformerFactory.newInstance();
            try {
                Transformer tran = fac.newTransformer();
                tran.setOutputProperty(OutputKeys.INDENT, "yes");
                tran.transform(source, result);
                
                
            }

            
            catch (TransformerConfigurationException ex) {
                Logger.getLogger(Transform.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(Transform.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Transform.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
