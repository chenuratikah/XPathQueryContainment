/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cw4.homo;


/**
 *
 * @author ROG_User
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class mainclass {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse("employees.xml");

            // Create XPathFactory object
            XPathFactory xpathFactory = XPathFactory.newInstance();

            // Create XPath object
            XPath xpath = xpathFactory.newXPath();

//            String name = getEmployeeNameById(doc, xpath, 4);
//            System.out.println("Employee Name with ID 4: " + name);
//
//            List<String> names = getEmployeeNameWithAge(doc, xpath, 25);
//            System.out.println("Employees with 'age>30' are:" + Arrays.toString(names.toArray()));
//
//            List<String> femaleEmps = getFemaleEmployeesName(doc, xpath);
//            System.out.println("Female Employees names are:" +
//                    Arrays.toString(femaleEmps.toArray()));
            
            List<String> name1 = getHomomorphism(doc, xpath, 1);
            System.out.println("Employee Name with ID 5: " + Arrays.toString(name1.toArray()));

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

    private static List<String> getHomomorphism(Document doc, XPath xpath, int id) {
        List<String> list = new ArrayList<>();
        try {
//            XPathExpression expr = xpath.compile("/Employees/Employee/*/text()");
            XPathExpression expr = xpath.compile("/Employees/Employee[@id='" + id + "']//room/text()");
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++)
                    list.add(nodes.item(i).getNodeValue());
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return list;
    }
}