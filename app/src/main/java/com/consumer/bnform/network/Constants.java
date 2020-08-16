package com.consumer.bnform.network;

public class Constants {
    //base Url
    public static final String RECALL_URL = "https://www.saferproducts.gov";
    public static final String RECALL_FORMAT = "RestWebServices/Recall?format=json";
    public static final String RECALL_BY_DATE = RECALL_FORMAT + "&RecallDateStart=2020-05-01&" +
            "RecallEndDate=2020-08-15";
    public static final int EMPTY_RECALL_LIST = 0;
    public static final String APP_KEY = "e7baa5d8-ecf3-4c70-831c-7894079b8f43.";
}
;