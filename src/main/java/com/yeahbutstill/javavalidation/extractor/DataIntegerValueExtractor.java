package com.yeahbutstill.javavalidation.extractor;

import com.yeahbutstill.javavalidation.container.DataInteger;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.UnwrapByDefault;
import jakarta.validation.valueextraction.ValueExtractor;

@UnwrapByDefault    // artinya disini dia bukan generic type
public class DataIntegerValueExtractor
    // bedanya disini ExtractedValue bukan lagi dalam type generic tapi langsung dan dikasih tau typenya apa
        implements ValueExtractor<@ExtractedValue(type = Integer.class) DataInteger> {
    @Override                                                                          
    public void extractValues(@ExtractedValue(type = Integer.class) DataInteger originalValue, ValueReceiver receiver) {
        receiver.value(null, originalValue.getData());
    }
}
