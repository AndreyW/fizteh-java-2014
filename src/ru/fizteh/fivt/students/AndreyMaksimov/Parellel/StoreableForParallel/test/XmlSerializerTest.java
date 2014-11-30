package ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.test;


import org.junit.Test;
import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.XmlSerializer;

import javax.xml.parsers.ParserConfigurationException;
import java.text.ParseException;
import java.util.List;
import java.util.Vector;

import static org.junit.Assert.assertEquals;


public class XmlSerializerTest {
    @Test
    public void testSerialize() throws Exception {
        List<Object> objects = new Vector<>();
        Integer a = 300000;
        objects.add(a);
        Double b = 87.43;
        objects.add(b);
        objects.add(true);
        objects.add(null);
        objects.add(" test string");
        String xml = XmlSerializer.serializeObjectList(objects);
        assertEquals(xml, "<row><col>300000</col><col>87.43</col><col>true</col><null/><col> test string</col></row>");
    }

    @Test
    public void testDeSerialize() throws Exception {
        String xml = "<row><col>300000</col><col>87.43</col><col>true</col><null/><col> test string</col></row>";
        List<Class<?>> types = new Vector<>();
        types.add(Integer.class);
        types.add(Double.class);
        types.add(Boolean.class);
        types.add(Float.class);
        types.add(String.class);
        List<Object> result = XmlSerializer.deserializeString(xml, types);
        assertEquals(result.get(0), 300000);
        assertEquals(result.get(1), 87.43);
        assertEquals(result.get(2), true);
        assertEquals(result.get(3), null);
        assertEquals(result.get(4), " test string");
    }

    @Test
    public void testDeSerializeIncorrectType() throws ParserConfigurationException {
        String xml = "<row><col>aba</col></row>";
        List<Class<?>> types = new Vector<>();
        types.add(Double.class);
        try {
            XmlSerializer.deserializeString(xml, types);
        } catch (ParseException e) {
            assertEquals(e.getMessage(), "Incorrect number format. For input string: \"aba\"");
        }
    }

    @Test
    public void testIncorrectXml() throws ParserConfigurationException {
        String xml = "<row><cool></cool></row>";
        try {
            List<Class<?>> types = new Vector<>();
            types.add(String.class);
            XmlSerializer.deserializeString(xml, types);
        } catch (ParseException e) {
            assertEquals(e.getMessage(),
                    "Incorrect tag inside row statement: cool");
        }
    }
}
