package com.mycompany.myapp.twilo.api.bulkexport.createjob;

import com.mycompany.myapp.twilo.api.bulkexport.ExportResourceTypeTwDto;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ExportJobRequestTwDto {
    private final ExportResourceTypeTwDto resourceType;
    /**
     * format: yyyy-MM-dd
     */
    private final String startDate;
    /**
     * format: yyyy-MM-dd
     */
    private final String endDate;
}
