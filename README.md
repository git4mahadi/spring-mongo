#### find single record
db.getCollection('spring').find({"name": "shimul"})
db.getCollection('spring').find({}, {_id: 1, name:1}).pretty();

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

#### Running docker container for mongodb
sudo docker run --name docker-mongo -v /home/software/fileuploads/mongodata:/data/db -d -p 27017:27017 mongo


### Install mongodb compass
https://docs.mongodb.com/compass/current/install/

### Uninstall mongodb
sudo apt-get autoremove --purge mongodb


### Uninstall mongodb compass
sudo dpkg --remove mongodb-compass

sudo apt --fix-broken install



sudo docker run --name docker-mongo -e MONGO_INITDB_ROOT_USERNAME=mongoadmin -e MONGO_INITDB_ROOT_PASSWORD=mongo092624 -v /opt/fileuploads/mongodata:/data/db -d -p 27017:27017 mongo

