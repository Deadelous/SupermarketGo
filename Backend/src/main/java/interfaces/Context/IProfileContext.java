package interfaces;

import Model.Profile;

import java.util.List;

public interface IProfileContext {
    Profile getProfile(Profile profile);
    Profile createProfile(Profile profile);
    List<Profile> getAllProfiles();
}
