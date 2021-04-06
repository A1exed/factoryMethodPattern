package com.pashin.app.strategy.impl;

import com.pashin.app.strategy.AnalyzeStrategy;
import com.pashin.app.strategy.Student;
import com.pashin.app.strategy.StudentHandler;
import com.pashin.app.strategy.Subject;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;

public class SAXAnalyzer implements AnalyzeStrategy {
    @Override
    public void repair(File file1, File file2) {
        try {
            StudentHandler studentHandler = new StudentHandler();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(studentHandler);
            xmlReader.parse(new InputSource(new FileInputStream(file1)));

            Student student = studentHandler.getStudent();

            System.out.println("Первый файл:\n" + student.toString());

            double avg = student.calculateAverage();

            if (avg != student.getAverage())
                student.setAverage(avg);

            FileWriter fileWriter = new FileWriter(file2);
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(fileWriter);

            xmlStreamWriter.writeStartDocument();

            xmlStreamWriter.writeStartElement("student");
            xmlStreamWriter.writeAttribute("lastname", student.getLastname());

            for (Subject subject : student.getSubjects()) {
                xmlStreamWriter.writeEmptyElement("subject");
                xmlStreamWriter.writeAttribute("mark", String.valueOf(subject.getMark()));
                xmlStreamWriter.writeAttribute("title", subject.getTitle());
            }

            xmlStreamWriter.writeStartElement("average");
            xmlStreamWriter.writeCharacters(String.valueOf(student.getAverage()));
            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.writeEndDocument();

            xmlStreamWriter.flush();
            xmlStreamWriter.close();

            System.out.println("Второй файл:\n" + student.toString());
        } catch (SAXException | IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
