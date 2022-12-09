/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readxml;


import java.io.File;
import org.w3c.dom.NodeList;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.w3c.dom.Text;




/**
 *
 * @author Yomna
 */
public class ReadXml {
    
    public static void main(String[] args) throws IOException {
       
       
        
        try {
            DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
            SchemaFactory sch = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema s = sch.newSchema(new File ("library.xsd"));
            fac.setIgnoringComments(true);
            fac.setIgnoringElementContentWhitespace(true);
            fac.setNamespaceAware(true);
            fac.setSchema(s);
            
           
               DocumentBuilder builder = fac.newDocumentBuilder();
               Document doc = builder.parse(new File ("Library.xml"));
               Element root = doc.getDocumentElement();
               
               NodeList list2 = doc.getElementsByTagName("person");
               for(int i = 0; i < list2.getLength(); i++){
                Text text = doc.createTextNode("Yomna Ahmed Kerir");
                list2.item(i).replaceChild(text, list2.item(i).getFirstChild());
                    }
               
               
               //new file
            Source source = new DOMSource(doc);
            Result result = new StreamResult(new File("edit.xml"));
            
           TransformerFactory tf = TransformerFactory.newInstance();
            try {
                Transformer tran = tf.newTransformer();
                tran.setOutputProperty(OutputKeys.INDENT, "yes");
                tran.transform(source, result);
                
                
            }

            
            catch (TransformerConfigurationException ex) {
                Logger.getLogger(ReadXml.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(ReadXml.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
               
            }
        //main catch
        catch (SAXException  | ParserConfigurationException ex) {
            Logger.getLogger(ReadXml.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
    
}
}