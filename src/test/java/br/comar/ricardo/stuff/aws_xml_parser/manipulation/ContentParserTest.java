package br.comar.ricardo.stuff.aws_xml_parser.manipulation;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ContentParserTest {

    ContentParser contentParser = new ContentParser();

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testSample() throws IOException {

        String contentXML = FileUtils
                .readFileToString(new File(getClass().getResource("/sample.xml").getFile()), "UTF-8");
        String contentJson = FileUtils
                .readFileToString(new File(getClass().getResource("/sample.json").getFile()), "UTF-8");

        assertEquals(mapper.readTree(contentJson), mapper.readTree(contentParser.xmlToJson(contentXML)));        
    }

}
