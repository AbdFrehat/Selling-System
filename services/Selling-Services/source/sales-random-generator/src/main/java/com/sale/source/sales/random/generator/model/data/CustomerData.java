package com.sale.source.sales.random.generator.model.data;

import com.selling.shared.models.commons.Range;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerData {

    private List<String> genderValues;

    private SatisfactionRange satisfactionRange;

    private AgeRange ageRange;

    private List<String> emailValues;


    @Data
    public static class AgeRange extends Range<Integer> {
    }

    public static class SatisfactionRange extends Range<Integer> {
    }

}