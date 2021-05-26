#### find single record
db.getCollection('spring').find({"name": "shimul"})

#### and query
db.getCollection('spring').find({$and: [{"name": "shimul"}, {"email": "shimul@gmail.com"} ]})

#### or query
db.getCollection('spring').find({$or: [{"name": "hasan"}, {"email": "shimul@gmail.com"} ]})

#### in query
db.getCollection('spring').find({"name": {
        $in: ["mahadi","hasan","shimul"]
    }})

#### update
db.getCollection('student').update(
    // query 
    {
        "name" : "mahadi"
    },    
    // update 
    {
        $set: {
                "phone": "01830889631"
            }
    },
    // options 
    {
        "multi" : false,  // update only one document 
        "upsert" : false  // insert a new document, if no existing document match the query 
    }
);

#### remove all
db.getCollection('student').remove({ });

#### remove where the name is shimul
db.getCollection('student').remove({ 'name' : 'shimul' });

#### like query (contains)
db.getCollection('student').find({"email": /gmail/});


#### name starts with Mahadi (case sensitive)
db.getCollection('student').find({"name": /^Mahadi/})