package com.vesess.smpp;

import com.google.gson.stream.JsonReader;

import java.io.*;

/**
 * Created by Malintha on 8/26/2015.
 */
public class ConfigurationManager {

    private static String serviceProviderName;
    private static String bindType;
    private static String host;
    private static int port;
    private static int enquireLinkTimerSecs;
    private static String sourceTon;
    private static String sourceNPI;
    private static String destinationTon;
    private static String destinationNPI;

    public static String getServiceProviderName() {
        return serviceProviderName;
    }

    public static String getBindType() {
        return bindType;
    }

    public static String getHost() {
        return host;
    }

    public static int getPort() {
        return port;
    }

    public static int getEnquireLinkTimerSecs() {
        return enquireLinkTimerSecs;
    }

    public static String getSourceTon() {
        return sourceTon;
    }

    public static String getSourceNPI() {
        return sourceNPI;
    }

    public static String getDestinationTon() {
        return destinationTon;
    }

    public static String getDestinationNPI() {
        return destinationNPI;
    }

    public void readFromfile() throws Exception {
        try {
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("smppConfigs.json");
            JsonReader reader = new JsonReader(new InputStreamReader(in));
            reader.beginArray();
            reader.beginObject();
            String nextName;
            String nextString;
            while (reader.hasNext()) {
                nextName = reader.nextName();
                nextString = reader.nextString();
                if (nextName.equals("name"))
                    serviceProviderName = nextString;
                else if(nextName.equals("bindType"))
                    bindType = nextString;
                else if(nextName.equals("host"))
                    host = nextString;
                else if(nextName.equals("port"))
                    port = Integer.parseInt(nextString);
                else if(nextName.equals("enquireLinkTimerSecs"))
                    enquireLinkTimerSecs = Integer.parseInt(nextString);
                else if(nextName.equals("sourceTon"))
                    sourceTon = nextString;
                else if(nextName.equals("sourceNPI"))
                    sourceNPI = nextString;
                else if(nextName.equals("destinationTon"))
                    destinationTon = nextString;
                else if(nextName.equals("destinationNPI"))
                    destinationNPI = nextString;
                else
                    throw new Exception("Malformed Configuration file. No known configuration as "+nextName);
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        ConfigurationManager cm = new ConfigurationManager();
        cm.readFromfile();
        System.out.println(serviceProviderName);
    }
}
