package com.example.dao;

import com.google.cloud.datastore.*;

/**
 * @author garden
 * @create 4/10/18
 */
public class TestDataStore {
    private Datastore datastore;
    private KeyFactory keyFactory;
    public TestDataStore(){
        this.datastore = DatastoreOptions.getDefaultInstance().getService();
        this.keyFactory = this.datastore.newKeyFactory().setKind("TestDataStoreKind");
    }

    public void testAdd(String content){
        StringValue value = StringValue.newBuilder(content).setExcludeFromIndexes(true).build();
        // The full key(including the automatically assigned ID) of the entity will be returned
        // when an entity with the incomplete key is saved to Cloud Datastore.
//        Key key = datastore.allocateId(keyFactory.newKey());
//        Entity task = Entity.newBuilder(key)
//                .set("testJob","001")
//                .set("description", (new Date()).toString())
//                .set("done",false)
//                .build();
//        // Update the entity if existing otherwise add into the cloud
//        this.datastore.put(task);

        IncompleteKey incompleteKey = this.keyFactory.newKey();
        FullEntity<IncompleteKey> curVisit = FullEntity.newBuilder(incompleteKey)
                .set("testJob","001")
                .set("description",value)
                .build();
        // Just add the entity to the cloud
        this.datastore.add(curVisit);

    }
    public String testRetrieve(){
        Query<Entity> query = Query.newEntityQueryBuilder().setKind("TestDataStoreKind")
                .setOrderBy(StructuredQuery.OrderBy.desc("description")).setLimit(10).build();
        QueryResults<Entity> results = datastore.run(query);
        String result = "";
        while(results.hasNext()){
            Entity entity = results.next();
            result += entity.getString("description") + "\n";
        }
        return result;
    }
}
