package com.marcosoft.usdobjectmodellab.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsdCnt {
    @JsonProperty("@id")
    private String id;
    @JsonProperty("@COMMON_NAME")
    private String commonName;
    @JsonProperty("userid")
    private String userId;
}
