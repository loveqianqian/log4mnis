package com.heren.log4mnis.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description:test for dom4j,read xml</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/5
 */
public class XmlReadTest {
    public static void main(String[] args) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File("src/test/resources/weather.xml"));
            Element root = document.getRootElement();
            System.out.println("root name:" + root.getName());
            System.out.println("root attribute num:" + root.attributeCount());
            Attribute rootAttribute = null;
            for (Iterator iterator = root.attributeIterator(); iterator.hasNext(); ) {
                rootAttribute = (Attribute) iterator.next();
                System.out.println("root attributes:" + rootAttribute.getName() + ":" + rootAttribute
                        .getValue());
            }
            //1
            for (Object o : root.elements()) {
                Element e = (Element) o;
                String name = e.getName();
                System.out.println("element name:"+name);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}
