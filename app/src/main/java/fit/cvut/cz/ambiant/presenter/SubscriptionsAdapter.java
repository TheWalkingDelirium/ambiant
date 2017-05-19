package fit.cvut.cz.ambiant.presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import fit.cvut.cz.ambiant.model.entities.AccountBriefInfoPOJO;
import fit.cvut.cz.ambiant.model.entities.Project;
import fit.cvut.cz.ambiant.view.SingleSubscriptionViewImpl;
import fit.cvut.cz.ambiant.view.interfaces.SingleSubscriptionView;
import fit.cvut.cz.ambiant.view.interfaces.SubscriptionsView;

/**
 * Created by George.
 */

public class SubscriptionsAdapter extends BaseAdapter{
    private ArrayList<AccountBriefInfoPOJO> data;
    private LayoutInflater mInflater;
    private Context mContext;
    private SubscriptionsView.SubscriptionManagementListener mListener;

    public SubscriptionsAdapter(Context context, LayoutInflater inflater, ArrayList<AccountBriefInfoPOJO> data, SubscriptionsView.SubscriptionManagementListener listener) {
        mInflater = inflater;
        this.data = data;
        this.mContext = context;
        this.mListener = listener;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getAccountId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            SingleSubscriptionView view = new SingleSubscriptionViewImpl(mContext, mInflater, parent);
            holder = new ViewHolder();
            holder.itemView = view;
            convertView = view.getRootView();
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            convertView = holder.itemView.getRootView();
        }

//        holder.itemView.setProjectBriefInformation(data.get(position));
        holder.itemView.setSubscriptionInfo(data.get(0), mListener);

        return convertView;
    }

    static class ViewHolder {
        private SingleSubscriptionView itemView;
    }
}
