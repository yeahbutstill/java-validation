package com.yeahbutstill.javavalidation.extractor;

import com.yeahbutstill.javavalidation.container.Data;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;

public class DataValueExtractor implements ValueExtractor<Data<@ExtractedValue ?>> {

    @Override
    public void extractValues(Data<?> originalValue, ValueReceiver receiver) {
        Object data = originalValue.getData();

        /*
          kenapa disini nodeName nya null, karena disini kita memang pengenya Data ini
          dianggap sebagai data biasa seperti Optional jadi bukan sebagai Objek
         */
        receiver.value(null, data);
    }
}
