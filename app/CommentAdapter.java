import android.content.Context;
import android.view.LayoutInflater;

import org.w3c.dom.Comment;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder>
{
    private List<Comment> mData;
    private LayoutInflater mInflater;
    private Context context;
    private FirebaseServices fbs;
    public CommentAdapter(Context context, List<Comment> mData) {
        this.mData = mData;
        this.context = context;
        this.fbs = FirebaseServices.getInstance();

        @NonNull
        @Override
        public CommentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            mInflater = LayoutInflater.from(parent.getContext());
            View view = mInflater.inflate(R.layout.comment_item, parent, false);
            return new CommentAdapter.ViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Comment c = mData.get(position);
            holder.position = holder.getAdapterPosition();
            String customerImgStr;
            Optional<User> user = fbs.getUsers().stream().filter(b -> b.getUsername().equals(mData.get(position).getCommentatorUsername())).findFirst();
            customerImgStr = user.get().getPhoto();
            if (customerImgStr == null || customerImgStr.isEmpty())
                Glide.with(context).load(R.drawable.ic_fav).into(holder.ivCustomer);
            else
                Glide.with(context).load(customerImgStr).into(holder.ivCustomer);
            //Picasso.get().load(ap.getPhoto()).into(holder.ivBarber);
            holder.tvCustomerUsername.setText(user.get().getFirstName() + " " + user.get().getLastName());
            holder.tvComment.setText(mData.get(position).getComment());
            holder.rbBarber.setRating((float) (mData.get(position).getRating()));
        }
        @Override
        public int getItemCount() {
            return mData.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            ImageView ivCustomer;
            TextView tvCustomerUsername, tvComment;
            RatingBar rbBarber;
            int position;
            ViewHolder(View itemView) {
                super(itemView);
                ivCustomer = itemView.findViewById(R.id.ivCustomerInCommentItem);
                tvCustomerUsername = itemView.findViewById(R.id.tvCustomerUsernameCommentItem);
                tvComment = itemView.findViewById(R.id.tvCustomerCommentInCommentItem);
                rbBarber = itemView.findViewById(R.id.rbCommentInCommentItem);
                itemView.setOnClickListener(this);
            }
            @Override
            public void onClick(View v) {
                ((MainActivity)context).getMsg().showMessageDialog(context, mData.get(position).getComment());
                //FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();
            /*
            ((MainActivity)context).getIntent().putExtra("barber", mData.get(position).getUsername());
            ((MainActivity)context).getIntent().putExtra("customer", FirebaseServices.getInstance().getAuth().getCurrentUser().getEmail());
            ((MainActivity)context).getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayout, new AddNewAppointmentFragment())
                    .addToBackStack(null)
                    .commit(); */
            }
        }

}
