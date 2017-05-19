package fit.cvut.cz.ambiant.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fit.cvut.cz.ambiant.R;
import fit.cvut.cz.ambiant.model.entities.AccountBriefInfoPOJO;
import fit.cvut.cz.ambiant.model.entities.Project;
import fit.cvut.cz.ambiant.view.interfaces.SingleSubscriptionView;
import fit.cvut.cz.ambiant.view.interfaces.SubscriptionsView;

/**
 * Created by George.
 */

public class SingleSubscriptionViewImpl implements SingleSubscriptionView {
    private View mRootView;

    private TextView mTitleTextView;
    private TextView mDescTextView;
    private ImageButton mUnsubscribeImageButton;
    private Context mContext;

    public SingleSubscriptionViewImpl(Context context, LayoutInflater inflater, ViewGroup container) {
        mContext = context;
        mRootView = inflater.inflate(R.layout.list_view_singleitem_subscription, container, false);
        initialize();
    }

    private void initialize() {
        mTitleTextView = (TextView) mRootView.findViewById(R.id.account_name_tv);
        mDescTextView = (TextView) mRootView.findViewById(R.id.account_desc_tv);
        mUnsubscribeImageButton = (ImageButton) mRootView.findViewById(R.id.remove_subscription_button);
    }


    @Override
    public void setSubscriptionInfo(final AccountBriefInfoPOJO accountBriefInfo, final SubscriptionsView.SubscriptionManagementListener listener) {
        mTitleTextView.setText(accountBriefInfo.getAccountName());
        mDescTextView.setText(accountBriefInfo.getDescription());
        mUnsubscribeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.unsubscribe(accountBriefInfo.getAccountId());
            }
        });
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
