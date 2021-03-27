package com.pashin.app.strategy.impl;

import com.pashin.app.strategy.AnalyzeStrategy;
import com.pashin.app.strategy.Student;
import com.pashin.app.strategy.Subject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DOMAnalyzer implements AnalyzeStrategy {
    @Override
    public void repair(File file1, File file2) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document1 = documentBuilder.parse(file1);
            Document document2 = documentBuilder.newDocument();

            Element studentElement, subjectElement, averageElement;
            NodeList subjectNodeList, averageNodeList;

            Student student = new Student();
            Subject[] subjects;

            studentElement = document1.getDocumentElement();
            student.setLastname(studentElement.getAttribute("lastname"));
            subjectNodeList = studentElement.getElementsByTagName("subject");
            subjects = new Subject[subjectNodeList.getLength()];
            for (int i = 0; i < subjects.length; i++) {
                subjectElement = (Element) subjectNodeList.item(i);
                subjects[i] = new Subject(subjectElement.getAttribute("title"), Integer.parseInt(subjectElement.getAttribute("mark")));
            }
            student.setSubjects(subjects);
            averageNodeList = studentElement.getElementsByTagName("average");
            averageElement = (Element) averageNodeList.item(0);
            student.setAverage(Double.parseDouble(averageElement.getTextContent()));

            System.out.println("Первый файл:\n" + student.toString());

            student.calculateAverage();

            studentElement = document2.createElement("student");
            studentElement.setAttribute("lastname", student.getLastname());

            for (Subject subject : student.getSubjects()) {
                subjectElement = document2.createElement("subject");
                subjectElement.setAttribute("title", subject.getTitle());
                subjectElement.setAttribute("mark", String.valueOf(subject.getMark()));
                studentElement.appendChild(subjectElement);
            }

            averageElement = document2.createElement("average");
            averageElement.setTextContent(String.valueOf(student.getAverage()));

            studentElement.appendChild(averageElement);

            document2.appendChild(studentElement);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(document2);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            StreamResult streamResult = new StreamResult(fileOutputStream);
            transformer.transform(domSource, streamResult);
            fileOutputStream.close();

            System.out.println("Второй файл:\n" + student.toString());
        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
