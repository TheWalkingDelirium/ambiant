package fit.cvut.cz.ambiant.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fit.cvut.cz.ambiant.R;
import fit.cvut.cz.ambiant.model.entities.Project;
import fit.cvut.cz.ambiant.view.interfaces.ProjectDetailsView;

/**
 * Created by George.
 */

public class ProjectDetailViewImpl implements ProjectDetailsView {

    private final View mRootView;
    private final Context mContext;
    private ImageView mIllustration;
    private TextView mProjectName;
    private TextView mProjectDescription;
    private ImageView mMarkerImageView;

    public ProjectDetailViewImpl(LayoutInflater inflater, ViewGroup container, Context context) {
        mRootView = inflater.inflate(R.layout.fragment_project_detail, container, false);
        initialize();
        mContext = context;
    }

    private void initialize() {
        mIllustration = (ImageView) mRootView.findViewById(R.id.project_illustration_imageview);
        mProjectName = (TextView) mRootView.findViewById(R.id.project_name_textview);
        mProjectDescription = (TextView) mRootView.findViewById(R.id.project_description_textview);
        mMarkerImageView = (ImageView) mRootView.findViewById(R.id.marker_imageview);
    }

    @Override
    public void setProjectDetails(Project projectDetails) {
        mProjectName.setText(projectDetails.getName());
        mProjectDescription.setText(projectDetails.getDescription());
        Picasso.with(mContext)
                .load("file:///android_asset/pikachu.png")
                .into(mIllustration);


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
