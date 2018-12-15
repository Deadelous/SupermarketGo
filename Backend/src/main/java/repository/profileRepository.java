package repository;

import interfaces.IProfileContext;
import model.profile;

public class profileRepository implements IProfileContext{
    IProfileContext context;

    public profileRepository(IProfileContext context) {
        this.context = context;
    }

    @Override
    public profile getProfile(profile profile) {
        return context.getProfile(profile);
    }

    @Override
    public profile updateProfile(profile profile) {
        return context.updateProfile(profile);
    }
}
