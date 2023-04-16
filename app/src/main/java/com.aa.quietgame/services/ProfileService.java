public class ProfileService {

    private static final String PROFILES_FILE_NAME = "profiles.json";

    /**
     * Saves the given list of profiles to the profiles file.
     */
    public static void saveProfiles(List<Profile> profiles, Context context) {
        try {
            JSONArray jsonArray = new JSONArray();
            for (Profile profile : profiles) {
                JSONObject jsonProfile = profile.toJson();
                jsonArray.put(jsonProfile);
            }
            String profilesJson = jsonArray.toString();

            FileOutputStream outputStream = context.openFileOutput(PROFILES_FILE_NAME, Context.MODE_PRIVATE);
            outputStream.write(profilesJson.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the list of profiles from the profiles file.
     */
    public static List<Profile> loadProfiles(Context context) {
        List<Profile> profiles = new ArrayList<>();
        try {
            FileInputStream inputStream = context.openFileInput(PROFILES_FILE_NAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            inputStream.close();

            String profilesJson = builder.toString();
            JSONArray jsonArray = new JSONArray(profilesJson);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonProfile = jsonArray.getJSONObject(i);
                Profile profile = Profile.fromJson(jsonProfile);
                profiles.add(profile);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return profiles;
    }
}
