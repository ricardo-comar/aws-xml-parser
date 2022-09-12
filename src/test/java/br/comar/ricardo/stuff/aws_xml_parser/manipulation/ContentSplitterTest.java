package br.comar.ricardo.stuff.aws_xml_parser.manipulation;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

public class ContentSplitterTest {

    private static final String JSON_PATH = "$.content.notes[*][*]";

    ContentSplitter splitter = new ContentSplitter();

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testSample() throws IOException {

        String contentJson = FileUtils
                .readFileToString(new File(getClass().getResource("/sample.json").getFile()), "UTF-8");

        ReadContext ctx = JsonPath.parse(contentJson);

        List<Map<String, Object>> notesList = ctx.read(JSON_PATH, List.class);

        assertEquals(notesList, splitter.splitJson(JSON_PATH, contentJson));

    }   

}
