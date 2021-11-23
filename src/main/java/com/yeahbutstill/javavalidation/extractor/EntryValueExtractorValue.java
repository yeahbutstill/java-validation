package com.yeahbutstill.javavalidation.extractor;

import com.yeahbutstill.javavalidation.container.Entry;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;

public class EntryValueExtractorValue implements ValueExtractor<Entry<?, @ExtractedValue ?>> {

    @Override
    public void extractValues(Entry<?, ?> originalValue, ValueReceiver receiver) {
        receiver.keyedValue("null", "value", originalValue.getValue());
    }

}
