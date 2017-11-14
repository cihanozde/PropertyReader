package property.data.model;

/**
 * Created by cihanozdemir on 12.11.2017.
 */
public class ConnectionSpec
{
    private String host;
    private int port;
    private String dbName;

    public ConnectionSpec(String host, int port, String dbName)
    {
        this.host = host;
        this.port = port;
        this.dbName = dbName;
    }

    public String getHost()
    {
        return host;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public int getPort()
    {
        return port;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public String getDbName()
    {
        return dbName;
    }

    public void setDbName(String dbName)
    {
        this.dbName = dbName;
    }
}
