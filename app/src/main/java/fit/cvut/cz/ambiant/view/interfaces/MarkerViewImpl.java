package fit.cvut.cz.ambiant.view.interfaces;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fit.cvut.cz.ambiant.R;
import fit.cvut.cz.ambiant.model.entities.Project;

/**
 * Created by George.
 */

public class MarkerViewImpl implements MarkerView {

    private final View mRootView;
    private final Context mContext;
    private ImageView mIllustration;
    private TextView mProjectName;
    private TextView mProjectDescription;
    private ImageView mMarkerImageView;

    public MarkerViewImpl(LayoutInflater inflater, ViewGroup container, Context context) {
        mRootView = inflater.inflate(R.layout.fragment_markers, container, false);
        initialize();
        mContext = context;
    }

    private void initialize() {

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
