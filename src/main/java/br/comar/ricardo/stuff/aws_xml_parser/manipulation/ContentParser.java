package br.comar.ricardo.stuff.aws_xml_parser;

import org.json.JSONObject;
import org.json.XML;

public class ContentParser {
    
    public String xmlToJson(String source) {

        JSONObject jsonObj = XML.toJSONObject(source);
        String jsonString = jsonObj.toString(2);

        return jsonString;
    }
}
