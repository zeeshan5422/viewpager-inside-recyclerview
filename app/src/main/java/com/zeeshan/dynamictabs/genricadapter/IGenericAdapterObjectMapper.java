package com.zeeshan.dynamictabs.genricadapter;

import java.util.List;

public interface IGenericAdapterObjectMapper<T> {

    List<KeyValueModel> getMappedModel(Object model);

}
