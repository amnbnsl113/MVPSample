package mvp.sample.com.mvpsample.people;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import mvp.sample.com.mvpsample.network.DummyNetworkProvider;
import mvp.sample.com.mvpsample.R;
import mvp.sample.com.mvpsample.adapter.PeopleAdapter;
import mvp.sample.com.mvpsample.base.BasePresenter;
import mvp.sample.com.mvpsample.model.PersonDetail;

public class PeopleListActivity extends AppCompatActivity implements PeopleListView {

    PeoplePresenterImpl presenter;
    RecyclerView personList;
    private PeopleAdapter peopleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personList = (RecyclerView) findViewById(R.id.personList);
        personList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        peopleAdapter = new PeopleAdapter(null);
        personList.setAdapter(peopleAdapter);

        presenter = new PeoplePresenterImpl(this, new DummyNetworkProvider());

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.fetchPeopleList();
    }

    @Override
    public BasePresenter setPresenter() {
        return presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showPeopleList(List<PersonDetail> personDetails) {
        if (peopleAdapter != null) {
            peopleAdapter.setItems(personDetails);
        }
    }
}
