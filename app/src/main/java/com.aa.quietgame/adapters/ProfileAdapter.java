public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {

    private Context context;
    private List<ProfileModel> profiles;

    public ProfileAdapter(Context context, List<ProfileModel> profiles) {
        this.context = context;
        this.profiles = profiles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProfileModel profile = profiles.get(position);
        holder.tvName.setText(profile.getName());
        holder.tvScore.setText(String.valueOf(profile.getScore()));
        holder.ivAvatar.setImageResource(profile.getAvatar());
    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvScore;
        public ImageView ivAvatar;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_profile_name);
            tvScore = itemView.findViewById(R.id.tv_profile_score);
            ivAvatar = itemView.findViewById(R.id.iv_profile_avatar);
        }
    }
}
