/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readxml;


import java.io.File;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
               
               System.out.println("Root is : " +root.getNodeName());
               
               for(int i = 0; i < root.getAttributes().getLength(); i++){
                    System.out.println("\t\t");
                    System.out.println(root.getAttributes().item(i).getNodeName() + " : " 
                            + root.getAttributes().item(i).getTextContent());
                    }
            
                NodeList list = root.getChildNodes();
                for(int i = 0; i < list.getLength(); i++){
                  
                    System.out.println("--"+ list.item(i).getNodeName()+ "--");
                       if(list.item(i).hasChildNodes()){
                           if(list.item(i).hasAttributes()){
                               //shelf, table
                               attribute((Element) list.item(i));
                              }
                           element((Element) list.item(i));
                           }
                   }
               
            } catch (SAXException  | ParserConfigurationException ex) {
            Logger.getLogger(ReadXml.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
    
}
public static void attribute(Element e){

        NamedNodeMap attr = e.getAttributes();
        for (int i = 0; i < attr.getLength(); i++) {
            System.out.println("\t\t");
            System.out.println("---------" + attr.item(i).getNodeName() + " : "
                    + attr.item(i).getTextContent());
        }
}


public static void element(Element e){
    
     NodeList node = e.getChildNodes();
     for(int i = 0; i < node.getLength(); i++){
         if(node.item(i).hasChildNodes()){
          if(node.item(i).hasAttributes()){
             attribute((Element) node.item(i));
          }
         element((Element) node.item(i));
     }else{
         System.out.println("\t\t");
         System.out.println(node.item(i).getNodeName() + " : " +
                 node.item(i).getTextContent());
             
         }
     
     } 
    
}



}