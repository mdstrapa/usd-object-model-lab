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
public class UsdPcat {
    @JsonProperty("@id")
    private Integer id;
    @JsonProperty("@COMMON_NAME")
    private String commonName;
}
