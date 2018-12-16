package Repository;

import interfaces.IProfileContext;
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
    public Profile updateProfile(Profile profile) {
        return context.updateProfile(profile);
    }

    @Override
    public List<Profile> getAllProfiles() {
        return context.getAllProfiles();
    }
}
