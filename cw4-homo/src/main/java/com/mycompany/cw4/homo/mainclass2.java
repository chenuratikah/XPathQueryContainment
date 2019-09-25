/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cw4.homo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.xml.sax.SAXException;
/**
* File: Ex1.java @author ronda
*/
public class mainclass2 {
public static void main(String[] args) throws Exception {
    
    try {
        DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = Factory.newDocumentBuilder();
        Document doc = builder.parse("employees.xml");

        //creating an XPathFactory:
        XPathFactory factory = XPathFactory.newInstance();
        //using this factory to create an XPath object: 
        XPath xpath = factory.newXPath();
    
        //List<String> name = getHomomorphism(doc, xpath, 4);
        //System.out.println("Employee Name with ID 5: " + Arrays.toString(name.toArray()));
        
        List<String> dupe = getHomomorphism(doc, xpath);
        //System.out.println("Duplicate ids: " + Arrays.toString(dupe.toArray()));

    } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
    }

}
    
// private static List<String> getHomomorphism(Document doc, XPath xpath, int id) {
//    List<String> tagList = new ArrayList<>();
//    List<String> nodeList = new ArrayList<>();
//    try {    
//    
//        // XPath Query for showing all nodes value
//        XPathExpression expr = xpath.compile("//" + "Employee" + "/*");
//        //XPathExpression expr = xpath.compile("/Employees/Employee/*");
//        Object result = expr.evaluate(doc, XPathConstants.NODESET);
//        NodeList nodes = (NodeList) result;
//
//        System.out.println(nodes.getLength());
//
//        //Get tag names
//        for (int i = 0; i < nodes.getLength(); i++) {
//
//            Element el = (Element) nodes.item(i);
//
//            System.out.println("tag: " + el.getNodeName());
//            //System.out.println("id : " + el.get);
//
//            // search for the Text children
//            if (el.getFirstChild().getNodeType() == Node.TEXT_NODE)
//                System.out.println("inner value:" + el.getFirstChild().getNodeValue());
//
//            //Get inner child
//            NodeList children = el.getChildNodes();
//            for (int k = 0; k < children.getLength(); k++) {
//                Node child = children.item(k);
//            
//                if (child.getNodeType() != Node.TEXT_NODE) {
//                    System.out.println("child tag: " + child.getNodeName());
//                    if (child.getFirstChild().getNodeType() == Node.TEXT_NODE){
//                        System.out.println("inner child value:" + child.getFirstChild().getNodeValue());;
//                        
//                //System.out.println("abc: " + el.getElementsByTagName("sexuality").item(i).getChildNodes());
//                    
//                    }
//                    tagList.add(child.getFirstChild().getNodeValue());
//                }
//                //tagList.add(el.getFirstChild().getNodeValue());
//            }
//            tagList.add(el.getFirstChild().getNodeValue());
//      
//        
//        }
//
//    } catch (XPathExpressionException e) {
//            e.printStackTrace();
//        }
//        return tagList;
//  }
 
 // Find duplicates
 private static List<String> getHomomorphism(Document doc, XPath xpath) {
    List<String> tagList = new ArrayList<>();

    try {    
        // XPath Query for showing all nodes value
            XPathExpression expr = xpath.compile("/Employees/Employee/@id");
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            
            //Find dupes id
            for (int i = 0; i < nodes.getLength(); i++){
                
               for (int j = i+1; j < nodes.getLength(); j++){
                   
                   if (nodes.item(i).getNodeValue().equals(nodes.item(j).getNodeValue())) {
                   
                       //System.out.println("Duplicate id: " + nodes.item(j).getNodeValue());
                       System.out.println("Root nodes match!");
                       
                       int d = Integer.parseInt(nodes.item(j).getNodeValue());
                       //tagList.add(nodes.item(j).getNodeValue());
                       
                       XPathExpression expr1 = xpath.compile("/Employees/Employee[@id='" + d + "']//room/text()");
                       NodeList nodes1 = (NodeList) expr1.evaluate(doc, XPathConstants.NODESET);
                       
                       Object nodes7 = expr1.evaluate(doc, XPathConstants.BOOLEAN);
                       //System.out.println("node99 " + nodes7);
                       
                       if(nodes7.equals(true))
                       {       
                       for (int k = 0; k < nodes1.getLength(); k++){
                           
                           System.out.println("Descendant node: " + nodes1.item(k).getNodeValue());
                           
                       }
                       System.out.println("Descendant nodes match!");
                       }
                       else{
                           System.out.println("No decendant nodes to match. Condition 3 failed!");
                       }
                            //taglist.add(nodes.item(k).getNodeValue());

                       XPathExpression expr2 = xpath.compile("/Employees/Employee[@id='" + d + "']/name/text()");
                       NodeList nodes2 = (NodeList) expr2.evaluate(doc, XPathConstants.NODESET);
                       Object nodes99 = expr2.evaluate(doc, XPathConstants.BOOLEAN);
                       //System.out.println("node99 " + nodes99);
                       
                       if(nodes99.equals(true))
                       {
                       
                       for (int m = 0; m < nodes2.getLength(); m++){
                           
                           System.out.println("Child node: " + nodes2.item(m).getNodeValue());
                           
                       }
                       System.out.println("Child nodes match!");
                       }
                       else{
                       System.out.println("Child does not nodes match. Condition 2 failed!");
                       }
                            //taglist.add(nodes.item(k).getNodeValue());
                            
                       XPathExpression expr3 = xpath.compile("/Employees/Employee[@id='" + d + "']/age/text()");
                       NodeList nodes3 = (NodeList) expr3.evaluate(doc, XPathConstants.NODESET);
                       
                       Object nodes9 = expr3.evaluate(doc, XPathConstants.BOOLEAN);
                       //System.out.println("node99 " + nodes9);
                       
                       if(nodes9.equals(true))
                       {
                       for (int n = 0; n < nodes3.getLength(); n++){
                           
                           System.out.println("Child node: " + nodes3.item(n).getNodeValue());
                           
                       }
                       System.out.println("Child nodes match!");
                       }
                       else{
                       System.out.println("Child does not nodes match. Condition 2 failed!");
                       
                       }
                            //taglist.add(nodes.item(k).getNodeValue());
                            
                       XPathExpression expr4 = xpath.compile("/Employees/Employee[@id='" + d + "']/*/supervisor/text()");
                       NodeList nodes4 = (NodeList) expr4.evaluate(doc, XPathConstants.NODESET);
                       
                       Object nodes8 = expr4.evaluate(doc, XPathConstants.BOOLEAN);
                       //System.out.println("node99 " + nodes9);
                       
                       if(nodes8.equals(true))
                       {
                       for (int c = 0; c < nodes4.getLength(); c++){
                           
                       System.out.println("Wildcard nodes: " + nodes4.item(c).getNodeValue());
                           
                       }
                       }
                       else{
                       System.out.println("No other nodes match. Condition 4 failed!");
                       
                       }
                       System.out.println("Wildcard node match!");
                       System.out.println("All conditions hold. Query containment exists.");
                       System.out.println("------------------------------------------------------------------------");
                            //taglist.add(nodes.item(k).getNodeValue());
                       
                   } //end if for finding root node
                   else if (!nodes.item(i).getNodeValue().equals(nodes.item(j).getNodeValue()))
                   {
                       System.out.println("------------------------------------------------------------------------");
                       //System.out.println("No root node matches for id "+ nodes.item(j).getNodeValue());
                       System.out.println("No root node matches. Condition 1 failed!");
                       System.out.println("------------------------------------------------------------------------");
                   }

               }
            }
            //System.out.println("P is subset of q. Query containment exists.");
            

    } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return tagList;
}
}


//                            if (el.getFirstChild().getNodeType() == Node.TEXT_NODE)
//                            System.out.println("inner value:" + el.getFirstChild().getNodeValue());
//                            
//                            //Get inner child
//                                NodeList children = el.getChildNodes();
//                            for (int l = 0; l < children.getLength(); l++) {
//                                Node child = children.item(l);
//
//                                if (child.getNodeType() != Node.TEXT_NODE) {
//                                    System.out.println("child tag: " + child.getNodeName());
//                                    if (child.getFirstChild().getNodeType() == Node.TEXT_NODE){
//                                        System.out.println("inner child value:" + child.getFirstChild().getNodeValue());;
//
//                                    }
//                                    tagList.add(child.getFirstChild().getNodeValue());
//                                  
//                                }
//
//                            }