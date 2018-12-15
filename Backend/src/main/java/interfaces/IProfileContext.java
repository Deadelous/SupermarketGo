package interfaces;

import model.profile;

public interface IProfileContext {
    profile getProfile(profile profile);
    profile updateProfile(profile profile);
}
