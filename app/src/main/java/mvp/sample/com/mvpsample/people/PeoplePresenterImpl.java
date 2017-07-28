package mvp.sample.com.mvpsample.people;

import java.util.List;

import mvp.sample.com.mvpsample.network.DummyNetworkProvider;
import mvp.sample.com.mvpsample.listeners.OnLoadListener;
import mvp.sample.com.mvpsample.model.PersonDetail;

/**
 * @author amanbansal
 * @version 1.0
 * @since 28/7/17
 */
public class PeoplePresenterImpl implements PeoplePresenter {

    private PeopleListView view;
    private DummyNetworkProvider provider;

    public PeoplePresenterImpl(PeopleListView view, DummyNetworkProvider provider) {
        this.view = view;
        this.provider = provider;
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void fetchPeopleList() {
        view.showLoading();
        provider.getPeopleList(new OnLoadListener<List<PersonDetail>>() {
            @Override
            public void onCallback(List<PersonDetail> personDetails) {
                if (view != null) {
                    view.hideLoading();
                    view.showPeopleList(personDetails);
                }
            }
        });
    }
}
