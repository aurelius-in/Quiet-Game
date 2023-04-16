public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder> {

    private List<LeaderboardModel> mLeaderboardList;

    public LeaderboardAdapter(List<LeaderboardModel> leaderboardList) {
        mLeaderboardList = leaderboardList;
    }

    @NonNull
    @Override
    public LeaderboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_leaderboard, parent, false);
        return new LeaderboardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardViewHolder holder, int position) {
        LeaderboardModel leaderboard = mLeaderboardList.get(position);
        holder.mProfileNameTextView.setText(leaderboard.getProfileName());
        holder.mScoreTextView.setText(String.valueOf(leaderboard.getScore()));
    }

    @Override
    public int getItemCount() {
        return mLeaderboardList.size();
    }

    public static class LeaderboardViewHolder extends RecyclerView.ViewHolder {

        private TextView mProfileNameTextView;
        private TextView mScoreTextView;

        public LeaderboardViewHolder(View itemView) {
            super(itemView);
            mProfileNameTextView = itemView.findViewById(R.id.textview_profile_name);
            mScoreTextView = itemView.findViewById(R.id.textview_score);
        }
    }
}
