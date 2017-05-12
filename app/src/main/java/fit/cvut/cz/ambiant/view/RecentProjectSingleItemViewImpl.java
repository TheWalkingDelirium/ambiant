package fit.cvut.cz.ambiant.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fit.cvut.cz.ambiant.R;
import fit.cvut.cz.ambiant.model.entities.Project;
import fit.cvut.cz.ambiant.view.interfaces.RecentProjectSingleItemView;

/**
 * Created by George on 07-May-17.
 */

public class RecentProjectSingleItemViewImpl implements RecentProjectSingleItemView {

    private View mRootView;

    private TextView mTitleTextView;
    private ImageView mThumbnailImageView;
    private Context mContext;

    public RecentProjectSingleItemViewImpl(Context context, LayoutInflater inflater, ViewGroup container) {
        mContext = context;
        mRootView = inflater.inflate(R.layout.gridview_singleitem_recentproject_layout, container, false);
        initialize();
    }

    private void initialize() {
        mTitleTextView = (TextView) mRootView.findViewById(R.id.thumbnail_title_text_view);
        mThumbnailImageView = (ImageView) mRootView.findViewById(R.id.thumbnail_image_view);
    }

    @Override
    public void setProjectBriefInformation(Project project) {
        mTitleTextView.setText(project.getName());
        Picasso.with(mContext)
                .load("file:///android_asset/pikachu.png")
                .into(mThumbnailImageView);
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
