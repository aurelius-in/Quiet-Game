public class AvatarUtils {

    private static final int[] AVATAR_DRAWABLES = {
            R.drawable.avatar_default,
            R.drawable.avatar_cat,
            R.drawable.avatar_dog,
            R.drawable.avatar_monkey,
            R.drawable.avatar_penguin,
            R.drawable.avatar_rabbit,
            R.drawable.avatar_robot
    };

    /**
     * Returns the drawable resource ID for the given avatar ID.
     */
    public static int getAvatarDrawable(int avatarId) {
        return AVATAR_DRAWABLES[avatarId];
    }

    /**
     * Returns an array of avatar names for display in the UI.
     */
    public static String[] getAvatarNames() {
        return new String[] {
                "Default",
                "Cat",
                "Dog",
                "Monkey",
                "Penguin",
                "Rabbit",
                "Robot"
        };
    }
}
