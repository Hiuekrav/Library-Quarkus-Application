package pl.pas.mgd.users;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;
import pl.pas.mgd.AbstractEntityMgd;
import pl.pas.mgd.AbstractEntityMgd;
import pl.pas.model.users.User;
import pl.pas.utils.consts.DatabaseConstants;
import pl.pas.utils.consts.DatabaseConstants;

import java.util.UUID;

@EqualsAndHashCode(callSuper=true)
@SuperBuilder(toBuilder = true)
@ToString
@Getter @Setter
@BsonDiscriminator(key = pl.pas.utils.consts.DatabaseConstants.BSON_DISCRIMINATOR_KEY , value = pl.pas.utils.consts.DatabaseConstants.USER_DISCRIMINATOR)
public class UserMgd extends AbstractEntityMgd {

    @BsonProperty(pl.pas.utils.consts.DatabaseConstants.USER_FIRST_NAME)
    private String firstName;

    @BsonProperty(pl.pas.utils.consts.DatabaseConstants.USER_LAST_NAME)
    private String lastName;

    @BsonProperty(pl.pas.utils.consts.DatabaseConstants.USER_EMAIL)
    private String email;

    @BsonProperty(pl.pas.utils.consts.DatabaseConstants.USER_PASSWORD)
    private String password;

    @BsonProperty(pl.pas.utils.consts.DatabaseConstants.USER_CITY_NAME)
    private String cityName;

    @BsonProperty(pl.pas.utils.consts.DatabaseConstants.USER_STREET_NAME)
    private String streetName;

    @BsonProperty(pl.pas.utils.consts.DatabaseConstants.USER_STREET_NUMBER)
    private String streetNumber;

    @BsonProperty(pl.pas.utils.consts.DatabaseConstants.USER_ACTIVE)
    private boolean active;

    @BsonCreator
    public UserMgd(
            @BsonProperty(pl.pas.utils.consts.DatabaseConstants.ID) UUID id,
            @BsonProperty(DatabaseConstants.USER_FIRST_NAME) String firstName,
            @BsonProperty(DatabaseConstants.USER_LAST_NAME) String lastName,
            @BsonProperty(DatabaseConstants.USER_EMAIL) String email,
            @BsonProperty(DatabaseConstants.USER_PASSWORD) String password,
            @BsonProperty(DatabaseConstants.USER_CITY_NAME) String cityName,
            @BsonProperty(DatabaseConstants.USER_STREET_NAME) String streetName,
            @BsonProperty(DatabaseConstants.USER_STREET_NUMBER) String streetNumber) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.cityName = cityName;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.active = true;
    }

    public UserMgd(User user) {
        super(user.getId());
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.cityName = user.getCityName();
        this.streetName = user.getStreetName();
        this.streetNumber = user.getStreetNumber();
        this.active = user.isActive();
    }

    public UserMgd(Document document) {
        super(
                document.get(DatabaseConstants.ID, UUID.class)
        );
        this.firstName = document.getString(DatabaseConstants.USER_FIRST_NAME);
        this.lastName = document.getString(DatabaseConstants.USER_LAST_NAME);
        this.email = document.getString(DatabaseConstants.USER_EMAIL);
        this.password = document.getString(DatabaseConstants.USER_PASSWORD);
        this.cityName = document.getString(DatabaseConstants.USER_CITY_NAME);
        this.streetName = document.getString(DatabaseConstants.USER_STREET_NAME);
        this.streetNumber = document.getString(DatabaseConstants.USER_STREET_NUMBER);
        this.active = document.getBoolean(DatabaseConstants.USER_ACTIVE);
    }
}
