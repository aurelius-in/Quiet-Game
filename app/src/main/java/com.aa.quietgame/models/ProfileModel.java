public class ProfileModel {

    private String name;
    private int avatarId;
    private int score;
    private List<Integer> soundIds;

    public ProfileModel(String name, int avatarId) {
        this.name = name;
        this.avatarId = avatarId;
        this.score = 0;
        this.soundIds = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(int avatarId) {
        this.avatarId = avatarId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Integer> getSoundIds() {
        return soundIds;
    }

    public void setSoundIds(List<Integer> soundIds) {
        this.soundIds = soundIds;
    }

    public void addSoundId(int soundId) {
        this.soundIds.add(soundId);
    }
}
