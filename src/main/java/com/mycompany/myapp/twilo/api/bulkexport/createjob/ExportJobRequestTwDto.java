package com.mycompany.myapp.twilo.api.bulkexport.createjob;

import com.mycompany.myapp.twilo.api.bulkexport.ExportResourceTypeTwDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
@Getter
public class ExportJobRequestTwDto {
    @NonNull
    private final ExportResourceTypeTwDto resourceType;
    /**
     * format: yyyy-MM-dd
     */
    @NonNull
    private final String startDate;
    /**
     * format: yyyy-MM-dd
     */
    private final String endDate;

    private final String email;
}
