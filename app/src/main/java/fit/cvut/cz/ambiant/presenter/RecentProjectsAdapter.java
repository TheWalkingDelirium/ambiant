package fit.cvut.cz.ambiant.presenter;

import android.content.Context;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collection;

import fit.cvut.cz.ambiant.model.entities.Project;
import fit.cvut.cz.ambiant.view.RecentProjectSingleItemViewImpl;
import fit.cvut.cz.ambiant.view.interfaces.RecentProjectSingleItemView;

/**
 * Created by George on 07-May-17.
 */

public class RecentProjectsAdapter extends BaseAdapter {
    private ArrayList<Project> data;
    private LayoutInflater mInflater;
    private Context mContext;
    private ArrayList<Long> selectedId;

    public RecentProjectsAdapter(Context context, LayoutInflater inflater, ArrayList<Project> data) {
        mInflater = inflater;
        this.data = data;
        this.mContext = context;
        selectedId = new ArrayList<>();
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
        return data.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            RecentProjectSingleItemView view = new RecentProjectSingleItemViewImpl(mContext, mInflater, parent);
            holder = new ViewHolder();
            holder.itemView = view;
            convertView = view.getRootView();
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            convertView = holder.itemView.getRootView();
        }

        holder.itemView.setProjectBriefInformation(data.get(position));
        return convertView;
    }

    public void clearSelection() {
        selectedId.clear();
    }

    public ArrayList<Long> getSelectedId() {
        return selectedId;
    }

    public void addSelection(long id) {
        selectedId.add(id);
    }

    public void removeSelection(long id) {
        selectedId.remove(id);
    }

    static class ViewHolder {
           private RecentProjectSingleItemView itemView;
    }


}
