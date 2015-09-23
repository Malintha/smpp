package com.vesess.smpp;

import com.cloudhopper.smpp.SmppSession;
import com.cloudhopper.smpp.SmppSessionConfiguration;

import java.util.HashMap;

/**
 * Created by Malintha on 8/26/2015.
 */
public class MainClient {

    public SmppSessionConfiguration[] loadConfigurations() {
        return null;}

    public void loadDirectoryFromRedis() {}

    public void createSessions(SmppSessionConfiguration[] serviceProviders) {}

    public void persistantSessions(SmppSession[] smppSessions) {}

    public void sendBulkSMS(String text) {}

    public void pauseSending() {}

    public void stopSending() {}

    public void resumeSending() {}

}
