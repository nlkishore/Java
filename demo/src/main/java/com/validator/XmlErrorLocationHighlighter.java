package com.validator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlErrorLocationHighlighter {

    public static boolean isXmlWellFormed(String xmlString) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Setting a custom ErrorHandler to capture parsing errors
            CustomErrorHandler errorHandler = new CustomErrorHandler();
            builder.setErrorHandler(errorHandler);

            // Parse the XML string to create a Document object
            Document document = builder.parse(new InputSource(new java.io.StringReader(xmlString)));

            // If parsing succeeds, XML is well-formed
            return true;
        } catch (SAXException se){
            se.printStackTrace();
            return false;
        } catch (Exception e) {
            // Catching any exceptions if XML is not well-formed
            //e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        String malformedXml = "<person><name>John<name><age>25</age></person>"; // Missing closing tag for "person"

        System.out.println("Is well-formed XML: " + isXmlWellFormed(malformedXml));
    }

    static class CustomErrorHandler extends DefaultHandler {
        @Override
        public void error(SAXParseException e) {
            System.out.println("Parsing Error: " + e.getMessage());
            System.out.println("Error at line " + e.getLineNumber() + ", column " + e.getColumnNumber());
        }
    }
}