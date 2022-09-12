package br.comar.ricardo.stuff.aws_xml_parser;

import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

public class ContentSplitter {
    

    public List<?> splitJson(String jsonPath, String sourceJson) {

        ReadContext ctx = JsonPath.parse(sourceJson);

        List<Map<String, Object>> objectList = ctx.read(jsonPath, List.class);

        return objectList;
    }
}
