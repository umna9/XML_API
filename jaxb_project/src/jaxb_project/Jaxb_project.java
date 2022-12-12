/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb_project;

/**
 *
 * @author Yomna
 */




import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import generted.BookType;
import generted.LibraryType;
import generted.ObjectFactory;
import generted.ShelfType;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;



/**
 *
 * @author Yomna
 */
public class Jaxb_project {
   
    public static void main(String[] args) {
       
     new  Jaxb_project();  
    }
    
    public Jaxb_project (){
      
        try {
            
            //to deal with xml, i use context
            JAXBContext context = JAXBContext.newInstance("generted");
           
            //book   // note book on the shelf, shelf on library
            ObjectFactory factory = new ObjectFactory();
            BookType book = factory.createBookType();
            book.setAuthor("yomna ahmed");
            book.setAdress("unknown");
            book.setChapter("12");
            
            //add another book
            ObjectFactory factory2 = new ObjectFactory();
            BookType bookType = factory2.createBookType();
            bookType.setAuthor("Khaled Ahmed");
            bookType.setAdress("sharqia");
            bookType.setChapter("5");
                        
            //add book on shelf
            ShelfType shelf = factory.createShelfType();
            shelf.getBook().add(book);
            //add another book on the shelf
            shelf.getBook().add(bookType);
            
            
            //add shelf on library
            LibraryType library = factory.createLibraryType();
            library.getShelf().add(shelf);
            
            JAXBElement libraryElement = factory.createLibrary(library);
            
            Marshaller marshaler = context.createMarshaller();
            marshaler.setProperty(marshaler.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            try {
                marshaler.marshal(libraryElement, new FileOutputStream("Edit.xml"));
                
         
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Jaxb_project.class.getName()).log(Level.SEVERE, null, ex);
            }
            
          
            
        } catch (JAXBException ex) {
            Logger.getLogger(Jaxb_project.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}









