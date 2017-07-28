package mvp.sample.com.mvpsample.network;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

import mvp.sample.com.mvpsample.R;
import mvp.sample.com.mvpsample.listeners.OnLoadListener;
import mvp.sample.com.mvpsample.model.PersonDetail;

/**
 * @author amanbansal
 * @version 1.0
 * @since 28/7/17
 */
public class DummyNetworkProvider implements BaseDataProvider {

    public void getPeopleList(final OnLoadListener<List<PersonDetail>> onLoadListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onLoadListener.onCallback(dummyList());
            }
        }, 2000);
    }

    private List<PersonDetail> dummyList() {
        List<PersonDetail> personDetails = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            personDetails.add(new PersonDetail("Name " + i, "Details " + i, R.mipmap.ic_launcher));
        }
        return personDetails;
    }
}
