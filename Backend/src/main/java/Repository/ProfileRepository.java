package Repository;

import interfaces.Context.IProfileContext;
import Model.Profile;

import java.util.List;

public class ProfileRepository implements IProfileContext{
    IProfileContext context;

    public ProfileRepository() {
    }

    public ProfileRepository(IProfileContext context) {
        this.context = context;
    }

    @Override
    public Profile getProfile(Profile profile) {
        return context.getProfile(profile);
    }

    @Override
    public Profile createProfile(Profile profile) {
        return context.createProfile(profile);
    }

    @Override
    public List<Profile> getAllProfiles() {
        return context.getAllProfiles();
    }
}
