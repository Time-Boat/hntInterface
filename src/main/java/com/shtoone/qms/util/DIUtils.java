package com.shtoone.qms.util;

import java.io.*;
import org.w3c.dom.*;
import java.util.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class DIUtils {
    public static final String NumericFieldPrefix = "Field-";
    public static DocumentBuilderFactory dbf;

    public static void initialize() {
    	if (null == dbf) {
    		dbf = DocumentBuilderFactory.newInstance();
		}
    }


    public static Document loadDocument(File file) {
        Document doc = null;
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(file);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (SAXException ex) {
            System.err.println(ex.getMessage());
        } catch (ParserConfigurationException ex) {
            System.err.println(ex.getMessage());
        }
        return doc;
    }

    public static Document loadDocument(InputStream is) {
        Document doc = null;
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(is);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (SAXException ex) {
            System.err.println(ex.getMessage());
        } catch (ParserConfigurationException ex) {
            System.err.println(ex.getMessage());
        }
        return doc;
    }


    public static Document loadDocument(String xml) {
        return loadDocument(new ByteArrayInputStream(xml.getBytes()));
    }

   
    public static String generateWhereCond(Hashtable keyFields) {
        StringBuffer whereCond = new StringBuffer();
        Enumeration emFieldName = keyFields.keys();
        Enumeration emFieldValue = keyFields.elements();
        String fieldName, fieldValue;
        for (; emFieldName.hasMoreElements(); ) {
            fieldName = (String)(emFieldName.nextElement());
            fieldValue = (String)(emFieldValue.nextElement());
            whereCond.append(" AND " + fieldName + "='" + fieldValue + "'");
        }
        if (whereCond.length() > 0) {
            whereCond.delete(0, 5);
        }
        return whereCond.toString();
    }


    public static String generateDateCond(String fieldName, String startDate, String endDate) {
        if ((null == startDate) || (0 == startDate.length())) {
            startDate = "0-1-1";
        }
        if ((null == endDate) || (0 == endDate.length())) {
            endDate = "9999-12-31";
        }
        String whereCond =
            "'" + startDate + "'<=" + fieldName +
            " AND " +
            fieldName +"<='" + endDate + "'";
        return whereCond.toString();
    }

  
    public static String getFieldName(String nodeName) {
        if ((nodeName.length() > NumericFieldPrefix.length()) &&
            (nodeName.substring(0, NumericFieldPrefix.length()).equals(NumericFieldPrefix))) {
            return nodeName.substring(NumericFieldPrefix.length());
        }
        return nodeName;
    }

  
    public static String getNodeName(String fieldName) {
        if (('0' <= fieldName.charAt(0)) && (fieldName.charAt(0) <= '9')) {
            return NumericFieldPrefix + fieldName;
        }
        return fieldName;
    }

 
    public static String getProperty(Element element, String propertyName) {
        element = XMLUtils.getElement2(element, "Property");
        if (null != element) {
            element = XMLUtils.getElement2(element, propertyName);
            if (null != element) {
                return XMLUtils.getText(element);
            }
        }
        return null;
    }
}
