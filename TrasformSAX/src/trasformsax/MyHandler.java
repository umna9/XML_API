/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trasformsax;

import java.util.Arrays;
import org.xml.sax.AttributeList;
import org.xml.sax.HandlerBase;
import org.xml.sax.SAXException;

/**
 *
 * @author Yomna
 */
public class MyHandler extends HandlerBase {

    @Override
    public void startElement(String name, AttributeList attributes) throws SAXException {
        
            System.out.println("Name : " + name);
            System.out.print("Value: ");
            
     
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        

        
        System.out.println(Arrays.copyOfRange(ch, start, start + length));
        System.out.println("------------------------" );
           }
    
    
    @Override
    public void startDocument() throws SAXException {
        System.out.print("Here The StartPoint of Document");
    }

    
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("Here The End Of Document");

    }

}
