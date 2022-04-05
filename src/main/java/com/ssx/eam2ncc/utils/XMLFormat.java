package com.ssx.eam2ncc.utils;
import java.io.FileReader;

import java.io.IOException;

import java.io.StringReader;

import java.io.StringWriter;

import org.dom4j.Document;

import org.dom4j.io.OutputFormat;

import org.dom4j.io.SAXReader;

import org.dom4j.io.XMLWriter;
public class XMLFormat {

    public static String formatXML_str(String inputXMLString) throws Exception

    {
        SAXReader reader = new SAXReader();

        Document document = reader.read(new StringReader(inputXMLString));

        String requestXML = null;

        XMLWriter writer = null;

        if (document != null)

        {
            try

            {
                StringWriter stringWriter = new StringWriter();

                OutputFormat format = OutputFormat.createPrettyPrint();

                writer = new XMLWriter(stringWriter, format);

                writer.write(document);

                writer.flush();

                requestXML = stringWriter.getBuffer().toString();

            }

            finally

            {
                if (writer != null)

                {
                    try

                    {
                        writer.close();

                    }

                    catch (IOException e)

                    {
                    }

                }

            }

        }

        return requestXML;

    }

    public static String formatXML_file(String inputXML_URL) throws Exception

    {
        SAXReader reader = new SAXReader();

        Document document = reader.read(new FileReader(inputXML_URL));

        String requestXML = null;

        XMLWriter writer = null;

        if (document != null)

        {
            try

            {
                StringWriter stringWriter = new StringWriter();

                OutputFormat format = OutputFormat.createPrettyPrint();

                writer = new XMLWriter(stringWriter, format);

                writer.write(document);

                writer.flush();

                requestXML = stringWriter.getBuffer().toString();

            }

            finally

            {
                if (writer != null)

                {
                    try

                    {
                        writer.close();

                    }

                    catch (IOException e)

                    {
                    }

                }

            }

        }

        return requestXML;

    }
}
