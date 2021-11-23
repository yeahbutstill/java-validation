package com.yeahbutstill.javavalidation;

import com.yeahbutstill.javavalidation.container.Data;
import com.yeahbutstill.javavalidation.container.DataInteger;
import com.yeahbutstill.javavalidation.container.Entry;
import com.yeahbutstill.javavalidation.data.SampleData;
import com.yeahbutstill.javavalidation.data.SampleDataInteger;
import com.yeahbutstill.javavalidation.data.SampleEntry;
import org.junit.jupiter.api.Test;

public class ValueExtractorTest extends AbstractValidatorTest {

    @Test
    void testSampleData() {

        SampleData sampleData = new SampleData();
        sampleData.setData(new Data<>());
        sampleData.getData().setData("   ");

        validate(sampleData);

    }

    @Test
    void testSampleEntry() {

        SampleEntry sampleEntry = new SampleEntry();
        sampleEntry.setEntry(new Entry<>());
        sampleEntry.getEntry().setKey(" ");
        sampleEntry.getEntry().setValue(" ");

        validate(sampleEntry);

    }

    @Test
    void testSampleDataInteger() {

        SampleDataInteger sampleDataInteger = new SampleDataInteger();
        sampleDataInteger.setData(new DataInteger());
        sampleDataInteger.getData().setData(0);

        validate(sampleDataInteger);

    }
}
