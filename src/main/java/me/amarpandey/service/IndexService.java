package me.amarpandey.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@Service
public class IndexService {

	public String submitXML(String xmlData) {

		Document parse = null;
		DocumentBuilder db = null;
		DocumentBuilder newDocumentBuilder = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// Parsing Method : One

		try {
			newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		try {
			parse = newDocumentBuilder.parse(new ByteArrayInputStream(xmlData.getBytes()));
		} catch (SAXException | IOException e1) {
			e1.printStackTrace();
		}

		System.out.println("Way one : " + parse);
		System.out.println("Way one : " + parse.getFirstChild());
		System.out.println("Way one : " + parse.getFirstChild().getFirstChild());

		// Parsing Method : Two

		try {
			db = dbf.newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xmlData));
			try {

				Document doc = db.parse(is);
				String message = doc.getDocumentElement().getTextContent();

				System.out.println("Way two : " + message);

			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (ParserConfigurationException e) {

		}

		return xmlData;
	}

}
