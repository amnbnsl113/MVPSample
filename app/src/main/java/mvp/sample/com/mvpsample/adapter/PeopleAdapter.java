package mvp.sample.com.mvpsample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mvp.sample.com.mvpsample.R;
import mvp.sample.com.mvpsample.model.PersonDetail;

/**
 * @author amanbansal
 * @version 1.0
 * @since 28/7/17
 */
public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder> {
    private List<PersonDetail> personDetailList;

    public PeopleAdapter(List<PersonDetail> personDetailList) {
        this.personDetailList = personDetailList;
        if (personDetailList == null) {
            this.personDetailList = new ArrayList<>();
        }
    }

    @Override
    public PeopleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_view, parent, false);
        return new PeopleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PeopleViewHolder holder, int position) {
        PersonDetail personDetail = personDetailList.get(position);

        if (personDetail != null) {
            holder.name.setText(personDetail.getName());
            holder.description.setText(personDetail.getDetails());
            holder.image.setImageResource(personDetail.getIcon());
        }
    }

    @Override
    public int getItemCount() {
        return personDetailList.size();
    }

    public void setItems(List<PersonDetail> personDetails) {
        if (personDetails != null) {
            personDetailList = personDetails;
            notifyDataSetChanged();
        }
    }

    class PeopleViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView description;
        private ImageView image;

        PeopleViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            description = (TextView) itemView.findViewById(R.id.description);
            image = (ImageView) itemView.findViewById(R.id.image);

        }
    }
}
