package com.shtoone.qms.util;

import java.io.*;
import java.util.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

public class XMLUtils {
    public static String idName = "Name";

    public static Element getElement2(Element parentElement, String nodeName) {
        Node node = parentElement.getFirstChild();
        while (null != node) {
            if ((Element.ELEMENT_NODE == node.getNodeType()) &&
                (nodeName.equals(node.getNodeName()))) {
                return (Element) node;
            }
            node = node.getNextSibling();
        }
        return null;
    }

    public static Element getElement(Element parentElement, String nodeName) {
        NodeList nodeList = parentElement.getElementsByTagName(nodeName);
        if (nodeList.getLength() == 1) {
            Node node = nodeList.item(0);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                return (Element) node;
            }
        }
        return null;
    }

    public static Element getElement(Element parentElement, String nodeName,
                                     String id) {
        NodeList nodeList = parentElement.getElementsByTagName(nodeName);
        int i;
        for (i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if (id.equals(element.getAttribute(idName))) {
                    return element;
                }
            }
        }
        return null;
    }

    public static String getText(Element element) {
        Node node;
        node = element.getFirstChild();
        while (null != node) {
            if (Node.TEXT_NODE == node.getNodeType()) {
                Text text = (Text) node;
                return text.getData();
            }
        }
        return "";
    }

    public static void setText(Element element, String Text) {
        Node node;
        node = element.getFirstChild();
        while (null != node) {
            if (Node.TEXT_NODE == node.getNodeType()) {
                Text text = (Text) node;
                text.setData(Text);
                return;
            }
        }
        Text text = element.getOwnerDocument().createTextNode(Text);
        element.appendChild(text);
    }

    public static Element newElement(Element elParent, String tagName) {
        Element element = elParent.getOwnerDocument().createElement(tagName);
        return (Element)(elParent.appendChild(element));
    }

    public static Element newElement(Element elParent, String tagName, String text) {
        Element element = newElement(elParent, tagName);
        if (null != element) {
            Text tx = element.getOwnerDocument().createTextNode(text);
            element.appendChild(tx);
        }
        return element;
    }

    public static String getXml(Document doc) {
        DOMSource doms = new DOMSource(doc);
        StringWriter sw = new StringWriter();
        StreamResult sr = new StreamResult(sw);
        String xml = null;
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            Properties properties = t.getOutputProperties();
            properties.setProperty(OutputKeys.ENCODING, "GB2312");
            properties.setProperty(OutputKeys.METHOD, "xml");//!
            properties.setProperty(OutputKeys.VERSION, "1.0");
            properties.setProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            t.setOutputProperties(properties);
            t.transform(doms, sr);
            String dtd = doc.getDoctype().getInternalSubset();
            if ((null != dtd) && (dtd.length() > 0)) {
                dtd = "\n<!DOCTYPE Catalog [\n" + dtd + "]>\n";
            };
            xml = "<?xml version=\"1.0\" encoding=\"GB2312\"?>" + dtd;
            xml += sw.toString();
        } catch (TransformerConfigurationException tce) {
            //"Transformer Configuration Exception\n-----"
        } catch (TransformerException te) {
            //"Transformer Exception\n---------"
        }
        return xml;
    }
}

