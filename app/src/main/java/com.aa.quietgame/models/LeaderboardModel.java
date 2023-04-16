public class LeaderboardModel {

    private List<ProfileModel> profiles;

    public LeaderboardModel() {
        this.profiles = new ArrayList<>();
    }

    public List<ProfileModel> getProfiles() {
        return profiles;
    }

    public void addProfile(ProfileModel profile) {
        profiles.add(profile);
    }

    public void sortProfilesByScore() {
        Collections.sort(profiles, new Comparator<ProfileModel>() {
            @Override
            public int compare(ProfileModel p1, ProfileModel p2) {
                return p2.getScore() - p1.getScore();
            }
        });
    }
}
