package fit.cvut.cz.ambiant.ar.libgdx;

import android.util.Log;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.FPSLogger;

import fit.cvut.cz.ambiant.ar.vuforia.VuforiaRenderer;
import fit.cvut.cz.ambiant.model.entities.Project;


/**
 * Instance of libgdx Game class responsible for rendering 3D content over augmented reality.
 */
public class Engine extends Game {

    private FPSLogger fps;
    private VuforiaRenderer vuforiaRenderer;
    private Project mProject;

    public Engine(VuforiaRenderer vuforiaRenderer, Project project) {
        this.vuforiaRenderer = vuforiaRenderer;
        mProject = project;
    }

    @Override
    public void create () {
        Display mDisplay = new Display(vuforiaRenderer, mProject);
        setScreen(mDisplay);
        vuforiaRenderer.initRendering();
        fps = new FPSLogger();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        Log.d("ENGINE", "Resize: "+width+"x"+height);
        vuforiaRenderer.onSurfaceChanged(width, height);
    }

    @Override
    public void render () {
        super.render();
        fps.log();
    }

}
