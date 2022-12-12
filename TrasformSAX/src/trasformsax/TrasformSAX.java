/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trasformsax;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.HandlerBase;
import org.xml.sax.SAXException;

/**
 *
 * @author Yomna
 */
public class TrasformSAX {
    
    public static void main(String[] args) {
        
      new TrasformSAX();
      
    }
    
    public TrasformSAX(){
        
        try {
            //factory
            SAXParserFactory fac = SAXParserFactory.newInstance();
            
            //parser
            SAXParser parser = fac.newSAXParser();
            
            //file
            HandlerBase handler = new MyHandler();
            try {
                parser.parse(new File("Library.xml"), handler);
                
            } catch (IOException ex) {
                Logger.getLogger(TrasformSAX.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(TrasformSAX.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(TrasformSAX.class.getName()).log(Level.SEVERE, null, ex);
        }
         
       }
}
