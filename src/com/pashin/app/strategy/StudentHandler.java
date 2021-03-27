package com.pashin.app.strategy;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;

import java.util.ArrayList;
import java.util.List;

public class StudentHandler implements ContentHandler {

    private Student student;

    private final List<Subject> subjects;

    private boolean isAverage;

    public StudentHandler() {
        subjects = new ArrayList<>();
        isAverage = false;
    }

    public Student getStudent() {
        Subject[] subjectsArray = new Subject[subjects.size()];
        subjects.toArray(subjectsArray);
        student.setSubjects(subjectsArray);
        return student;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        try {
            if (qName.equalsIgnoreCase("student")) {
                student = new Student();
                student.setLastname(attributes.getValue("lastname"));
            } else if (qName.equalsIgnoreCase("subject")) {
                Subject subject = new Subject();
                subject.setTitle(attributes.getValue("title"));
                subject.setMark(Integer.parseInt(attributes.getValue("mark")));
                subjects.add(subject);
            } else if (qName.equalsIgnoreCase("average")) {
                isAverage = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isAverage) {
            String avg = new String(ch, start, length);
            student.setAverage(Double.parseDouble(avg));
            isAverage = false;
        }
    }

    @Override
    public void setDocumentLocator(Locator locator) {

    }

    @Override
    public void startDocument() {

    }

    @Override
    public void endDocument() {

    }

    @Override
    public void startPrefixMapping(String prefix, String uri) {

    }

    @Override
    public void endPrefixMapping(String prefix) {

    }

    @Override
    public void endElement(String uri, String localName, String qName) {
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) {

    }

    @Override
    public void processingInstruction(String target, String data) {

    }

    @Override
    public void skippedEntity(String name) {

    }
}
