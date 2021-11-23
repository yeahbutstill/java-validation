package com.yeahbutstill.javavalidation;

import com.yeahbutstill.javavalidation.container.Data;
import com.yeahbutstill.javavalidation.data.SampleData;
import org.junit.jupiter.api.Test;

public class DataValueExtractorTest extends AbstractValidatorTest{

    @Test
    void testSampleData() {

        SampleData sampleData = new SampleData();
        sampleData.setData(new Data<>());
        sampleData.getData().setData("   ");

        validate(sampleData);

    }
}
