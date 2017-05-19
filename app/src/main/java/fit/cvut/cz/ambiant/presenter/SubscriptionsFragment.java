package fit.cvut.cz.ambiant.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fit.cvut.cz.ambiant.model.OnAccountsUpdatedListener;
import fit.cvut.cz.ambiant.model.entities.AccountBriefInfoPOJO;
import fit.cvut.cz.ambiant.model.entities.Project;
import fit.cvut.cz.ambiant.view.RecentProjectsViewImpl;
import fit.cvut.cz.ambiant.view.SubscriptionViewImpl;
import fit.cvut.cz.ambiant.view.interfaces.RecentProjectsView;
import fit.cvut.cz.ambiant.view.interfaces.SubscriptionsView;

/**
 * Created by George.
 */

public class SubscriptionsFragment extends BaseFragment implements OnAccountsUpdatedListener {
    final static String LOG_TAG = "myLogs,RecentProjectsFr";

    private SubscriptionsView mSubscriptionsView;
    private SubscriptionsAdapter mSubscriptionAdapter;
    private SubscriptionsView.SubscriptionManagementListener listener;
    private ArrayList<AccountBriefInfoPOJO> mAccounts;


    public static SubscriptionsFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SubscriptionsFragment fragment = new SubscriptionsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAccounts = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        listener = new SubscriptionsView.SubscriptionManagementListener() {
            @Override
            public void subscribe() {

            }

            @Override
            public void unsubscribe(int accountId) {
                MainActivity activity = (MainActivity) getActivity();
                activity.getInteractor().unsubscribe(accountId);
                mAccounts.remove(0);
                mSubscriptionAdapter.notifyDataSetChanged();
            }
        };

        mSubscriptionAdapter = new SubscriptionsAdapter(getContext(), inflater, mAccounts, listener);
        mSubscriptionsView = new SubscriptionViewImpl(inflater, container, mSubscriptionAdapter);
        mSubscriptionsView.SubscriptionManagementListener(listener);

        // Return the root view of the associated MVC view
        return mSubscriptionsView.getRootView();
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity activity = (MainActivity) getActivity();
        activity.getInteractor().getSubscribedAccounts(this);
    }

    @Override
    public View getRootView() {
        return mSubscriptionsView.getRootView();
    }

    @Override
    public void onAccountsUpdated(List<AccountBriefInfoPOJO> accounts) {
        mAccounts.clear();
        mAccounts.addAll(accounts);
        mSubscriptionAdapter.notifyDataSetChanged();
    }
}
