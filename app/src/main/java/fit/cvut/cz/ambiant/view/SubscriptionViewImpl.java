package fit.cvut.cz.ambiant.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import fit.cvut.cz.ambiant.R;
import fit.cvut.cz.ambiant.presenter.RecentProjectsAdapter;
import fit.cvut.cz.ambiant.presenter.SubscriptionsAdapter;
import fit.cvut.cz.ambiant.view.interfaces.SubscriptionsView;

/**
 * Created by George.
 */

public class SubscriptionViewImpl implements SubscriptionsView {
    private View mRootView;
    private ListView mSubscriptionsLV;

    private SubscriptionManagementListener mSubscriptionsManagementListener;
    private SubscriptionsAdapter mSubscriptionsAdapter;

    public SubscriptionViewImpl(LayoutInflater inflater, ViewGroup container, SubscriptionsAdapter adapter) {
        mRootView = inflater.inflate(R.layout.fragment_subscriptions, container, false);
        mSubscriptionsAdapter = adapter;

        initialize();

        mSubscriptionsLV.setAdapter(mSubscriptionsAdapter);
    }

    private void initialize() {
        mSubscriptionsLV = (ListView) mRootView.findViewById(R.id.subscription_listview);
    }

    @Override
    public void setSubscriptionsAdapter(SubscriptionsAdapter adapter) {
        mSubscriptionsAdapter = adapter;
        mSubscriptionsLV.setAdapter(mSubscriptionsAdapter);
    }

    @Override
    public void SubscriptionManagementListener(SubscriptionManagementListener listener) {
        mSubscriptionsManagementListener = listener;
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public Bundle getViewState() {
        return null;
    }
}
