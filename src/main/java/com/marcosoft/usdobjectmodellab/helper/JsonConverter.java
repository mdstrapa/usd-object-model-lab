package com.marcosoft.usdobjectmodellab.helper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class JsonConverter {

    private JsonConverter(){
        throw new IllegalStateException(StringGenerator.UTILITY_CLASS);
    }
    public static ObjectMapper get(){
        ObjectMapper jsonConverter = new ObjectMapper();
        jsonConverter.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        jsonConverter.setDateFormat(df);
        return jsonConverter;
    }
}
