package mvp.sample.com.mvpsample.people;

import java.util.List;

import mvp.sample.com.mvpsample.base.BaseView;
import mvp.sample.com.mvpsample.model.PersonDetail;

/**
 * @author amanbansal
 * @version 1.0
 * @since 28/7/17
 */
public interface PeopleListView extends BaseView {
    void showPeopleList(List<PersonDetail> personDetails);

}
