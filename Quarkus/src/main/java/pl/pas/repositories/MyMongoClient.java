package pl.pas.repositories;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import io.quarkus.arc.DefaultBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Getter;
import org.bson.UuidRepresentation;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.Conventions;
import org.bson.codecs.pojo.PojoCodecProvider;
import pl.pas.mgd.BookMgd;
import pl.pas.mgd.users.AdminMgd;
import pl.pas.mgd.users.LibrarianMgd;
import pl.pas.mgd.users.ReaderMgd;
import pl.pas.mgd.users.UserMgd;
import pl.pas.utils.consts.DatabaseConstants;

import java.util.List;

@Getter
@ApplicationScoped
public class MyMongoClient {

    private MongoClient client;

    @Inject
    public MyMongoClient() {
        initDatabaseConnection();
    }

    public void initDatabaseConnection() {
        ConnectionString connectionString = new ConnectionString(DatabaseConstants.connectionString);

        MongoCredential credential = MongoCredential.createCredential("admin", "admin", "adminpassword".toCharArray());

        CodecRegistry pojoCodecRegistry = CodecRegistries.fromProviders(PojoCodecProvider.builder()
                .automatic(true)
                .register(BookMgd.class)
                .register(UserMgd.class)
                .register(AdminMgd.class)
                .register(LibrarianMgd.class)
                .register(ReaderMgd.class)
                .conventions(List.of(Conventions.ANNOTATION_CONVENTION)).build());

        MongoClientSettings settings = MongoClientSettings.builder()
                .credential(credential)
                .applyConnectionString(connectionString)
                .uuidRepresentation(UuidRepresentation.STANDARD)
                .codecRegistry(
                        CodecRegistries.fromRegistries(
                                MongoClientSettings.getDefaultCodecRegistry(),
                                pojoCodecRegistry
                        ))
                .readConcern(ReadConcern.MAJORITY)
                .writeConcern(WriteConcern.MAJORITY)
                .readPreference(ReadPreference.primary())
                .build();
        client = MongoClients.create(settings);
    }
}
