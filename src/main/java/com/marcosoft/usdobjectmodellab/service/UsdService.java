package com.marcosoft.usdobjectmodellab.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcosoft.usdobjectmodellab.client.UsdClient;
import com.marcosoft.usdobjectmodellab.helper.JsonConverter;
import com.marcosoft.usdobjectmodellab.helper.StringGenerator;
import com.marcosoft.usdobjectmodellab.model.UsdCnt;
import com.marcosoft.usdobjectmodellab.model.UsdCntWrapper;
import com.marcosoft.usdobjectmodellab.model.UsdCr;
import com.marcosoft.usdobjectmodellab.model.UsdCrWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.OptionalInt;

@Service
@Slf4j
public class UsdService {

    @Autowired
    UsdClient usdClient;

    public Optional<UsdCr> findCrById(int id)  {
        String attributes = "summary,description,category,customer,priority,log_agent,zforma_abertura,group";
        HttpRequest request = usdClient.buildUsdRequest("GET","/cr/" + id,"",attributes);
        HttpResponse<String> response = usdClient.sendUsdRequest(request);
        ObjectMapper jsonConverter = JsonConverter.get();
        try {
            UsdCrWrapper usdCrWrapper = jsonConverter.readValue(response.body(), UsdCrWrapper.class);
            return Optional.of(usdCrWrapper.getCr());
        } catch (JsonProcessingException e) {
            log.error("{} - {}",StringGenerator.ERROR_MESSAGE,e.getMessage());
            return Optional.empty();
        }
    }

    public Optional<UsdCnt> findCntById(String id){
        String attributes = "userid";
        HttpRequest request = usdClient.buildUsdRequest("GET","/cnt/" + id,"",attributes);
        HttpResponse<String> response = usdClient.sendUsdRequest(request);
        ObjectMapper jsonConverter = JsonConverter.get();
        try {
            UsdCntWrapper usdCntWrapper = jsonConverter.readValue(response.body(), UsdCntWrapper.class);
            return Optional.of(usdCntWrapper.getCnt());
        } catch (JsonProcessingException e) {
            log.error("{} - {}",StringGenerator.ERROR_MESSAGE,e.getMessage());
            return Optional.empty();
        }
    }

}
