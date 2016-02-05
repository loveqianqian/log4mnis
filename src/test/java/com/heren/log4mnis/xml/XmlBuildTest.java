package com.heren.log4mnis.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description:test for dom4j ,build xml</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/6
 */
public class XmlBuildTest {
    public static void main(String[] args) {
        Document document= DocumentHelper.createDocument();
        Element root=document.addElement("definitions");
        root.addAttribute("name","WeatherImplService");
        root.addAttribute("targetNamespace","http://impl.Server.myloverqian.com/");
        /**
         * 1
         */
        Element types= root.addElement("types");
        Element message=root.addElement("message");
        Element message2=root.addElement("message");
        Element portType=root.addElement("portType");
        Element binding=root.addElement("binding");
        Element service=root.addElement("service");
        /**
         * 2
         */
        Element xsdSchema=types.addElement("schema");
        Element xsdImport= xsdSchema.addElement("import");
        xsdImport.addAttribute("namespace","http://impl.Server.myloverqian.com/");
        xsdImport.addAttribute("schemaLocation","http://192.168.40.1:8081/weather?xsd=1");

        message.addAttribute("name","queryWeather");
        Element part = message.addElement("part");
        part.addAttribute("name","parameters");
        part.addAttribute("element","tns:queryWeather");

        message2.addAttribute("name","queryWeatherResponse");
        Element part2 = message2.addElement("part");
        part2.addAttribute("name","parameters");
        part2.addAttribute("element","tns:queryWeatherResponse");

        try {
            FileWriter writer=new FileWriter("src/test/resources/weather2.xml");
            OutputFormat format=OutputFormat.createPrettyPrint();
            format.setEncoding("utf-8");
            XMLWriter xmlWriter=new XMLWriter(writer,format);
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
