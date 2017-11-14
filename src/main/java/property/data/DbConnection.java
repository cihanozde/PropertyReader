package property.data;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

/**
 * Created by cihanozdemir on 12.11.2017.
 */
public class DbConnection
{
    private static MongoClient mongoClient;
    private static DB db;
    private static DbConnection instance = null;

    protected DbConnection()
    {}

    public static DbConnection getInstance(String localhost, int port, String dbName) throws UnknownHostException
    {
        if (instance == null)
        {
            instance = new DbConnection();
            mongoClient = new MongoClient(localhost, port);
            instance.setMongo(mongoClient);
            db = mongoClient.getDB(dbName);
            instance.setDb(db);
        }

        return instance;
    }

    public MongoClient getMongo()
    {
        return mongoClient;
    }

    public void setMongo(MongoClient mongo)
    {
        this.mongoClient = mongo;
    }

    public DB getDb()
    {
        return db;
    }

    public void setDb(DB db)
    {
        this.db = db;
    }
}
