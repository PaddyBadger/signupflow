package views;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.betterment.signupflow.R;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.titled_paragraph)
public class TitledParagraphView extends RelativeLayout {

    @ViewById
    protected TextView title;
    @ViewById
    protected TextView message;

    private DataSource dataSource;

    public TitledParagraphView(Context context) {
        super(context);
    }

    public TitledParagraphView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TitledParagraphView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TitledParagraphView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        title.setText(dataSource.getTitle());
        title.setTextColor(getContext().getResources().getColor(dataSource.getTextColor()));
        message.setText(dataSource.getMessage());
        message.setTextColor(getContext().getResources().getColor(dataSource.getTextColor()));
    }

    public interface DataSource {
        String getTitle();
        String getMessage();
        int getTextColor();
    }
}
