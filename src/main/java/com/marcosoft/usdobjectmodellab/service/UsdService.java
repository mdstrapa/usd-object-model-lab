package com.marcosoft.usdobjectmodellab.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marcosoft.usdobjectmodellab.client.UsdClient;
import com.marcosoft.usdobjectmodellab.helper.JsonConverter;
import com.marcosoft.usdobjectmodellab.helper.StringGenerator;
import com.marcosoft.usdobjectmodellab.model.UsdCr;
import com.marcosoft.usdobjectmodellab.model.UsdCrWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@Service
@Slf4j
public class UsdService {

    @Autowired
    UsdClient usdClient;

    public Optional<UsdCr> findCrById(int id)  {
        String attributes = "summary,description,category,customer,priority,log_agent,zforma_abertura,group";
        HttpRequest request = usdClient.buildUsdRequest("GET","/cr/" + id,"",attributes);
        HttpResponse<String> response = usdClient.sendUsdRequest(request);
        //if(response!=null && response.statusCode() == 404) throw new UsdCrNotFoundException(StringGenerator.ERROR_MESSAGE + "item not found");
        //if(response==null || response.statusCode() >= 405) throw new UsdRestException(StringGenerator.ERROR_MESSAGE + "api internal error");
        ObjectMapper jsonConverter = JsonConverter.get();
        try {
            UsdCrWrapper usdCrWrapper = jsonConverter.readValue(response.body(), UsdCrWrapper.class);
            return Optional.of(usdCrWrapper.getCr());
        } catch (JsonProcessingException e) {
            //throw new UsdRestException(StringGenerator.ERROR_MESSAGE + "api internal error",e);
            log.error("{} - {}",StringGenerator.ERROR_MESSAGE,e.getMessage());
            return Optional.empty();
        }
    }

}
