package fit.cvut.cz.ambiant.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by George on 07-May-17.
 */

public class ProjectThumbnailImageView extends android.support.v7.widget.AppCompatImageView {

    public ProjectThumbnailImageView(Context context) {
        super(context);
    }

    public ProjectThumbnailImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ProjectThumbnailImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int width, int height) {
        super.onMeasure(width, height);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > measuredHeight) {
            setMeasuredDimension(measuredHeight, measuredHeight);
        } else {
            setMeasuredDimension(measuredWidth, measuredWidth);
        }
    }
}
