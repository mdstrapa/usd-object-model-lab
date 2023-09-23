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

public class UsdCr {
    @JsonProperty("@id")
    private Integer id;
    @JsonProperty("@REL_ATTR")
    private String relAttr;
    @JsonProperty("@COMMON_NAME")
    private String commonName;
    private String description;
    private String summary;
    private UsdPcat category;
}
