package util;

import property.data.DbQuery;
import property.data.model.ConnectionSpec;

import java.util.List;

/**
 * Created by cihanozdemir on 12.11.2017.
 */
public class PropertyReader
{
    private String applicationName;
    private ConnectionSpec connectionSpec;
    private int refreshTimer;
    private DbQuery dbQuery;
    private String val;

    public PropertyReader(String applicationName, ConnectionSpec connectionSpec, int refreshTimerInMs)
    {
        this.refreshTimer = refreshTimerInMs;
        this.applicationName = applicationName;
        this.connectionSpec = connectionSpec;
        dbQuery = new DbQuery(connectionSpec);

    }

    public <T> List<T> getValue(String val)
    {
        return dbQuery.getValue(val, applicationName);
    }



    public String getApplicationName()
    {
        return applicationName;
    }

    public void setApplicationName(String applicationName)
    {
        this.applicationName = applicationName;
    }

    public ConnectionSpec getConnectionSpec()
    {
        return connectionSpec;
    }

    public void setConnectionSpec(ConnectionSpec connectionSpec)
    {
        this.connectionSpec = connectionSpec;
    }

    public int getRefreshTimer()
    {
        return refreshTimer;
    }

    public void setRefreshTimer(int refreshTimer)
    {
        this.refreshTimer = refreshTimer;
    }
}
