package property.data;

import com.mongodb.*;
import property.data.model.ConnectionSpec;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cihanozdemir on 12.11.2017.
 */
public class DbQuery
{
    private ConnectionSpec connectionSpec;

    public DbQuery(ConnectionSpec connectionSpec)
    {
        this.connectionSpec = connectionSpec;
    }

    public <T> List<T> getValue(String val, String applicationName)
    {
        DB db = getConnection(connectionSpec);

        DBCollection table = db.getCollection("service");

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("ApplicationName", applicationName);
        searchQuery.put("isActive", "1");

        DBCursor cursor = table.find(searchQuery);
        T t = null;
        List<T> tList = new ArrayList<>();
        while (cursor.hasNext())
        {
            DBObject dbObject = cursor.next();
            t =  (T)dbObject.get(val);
            tList.add(t);
        }

        return tList;
    }



    private DB getConnection(ConnectionSpec connectionSpec)
    {
        try
        {
            DbConnection dbConnection = DbConnection.getInstance(connectionSpec.getHost(), connectionSpec.getPort(), connectionSpec.getDbName());
            DB db = dbConnection.getDb();
            return db;
        } catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        return null;
    }


}
