package fit.cvut.cz.ambiant.ar.libgdx;

import android.util.Log;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.ExternalFileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.model.data.ModelData;
import com.badlogic.gdx.graphics.g3d.utils.TextureProvider;
import com.badlogic.gdx.utils.UBJsonReader;

import java.io.File;

import fit.cvut.cz.ambiant.ar.vuforia.VuforiaRenderer;
import fit.cvut.cz.ambiant.model.entities.Project;

/**
 * Screen implementation responsible for model loading and calling renderer properly.
 */
public class Display implements Screen {

    public ModelInstance modelInstance;
    public Model model;

    private Renderer mRenderer;

    public Display(VuforiaRenderer vuforiaRenderer, final Project project) {

        mRenderer = new Renderer(vuforiaRenderer);

        if (project.isExample()) {
            AssetManager assets = new AssetManager();
            assets.load(project.getModelPath(), Model.class);
            assets.finishLoading();
            model = assets.get(project.getModelPath(), Model.class);
        } else {
            UBJsonReader jsonReader = new UBJsonReader();
            G3dModelLoader modelLoader = new G3dModelLoader(jsonReader);
            FileHandle dirHandel = Gdx.files.absolute(project.getModelPath());
            final File modelFile = new File(project.getModelPath());
            TextureProvider provider = new TextureProvider() {
                @Override
                public Texture load(String fileName) {
                    Log.d("TEXTURE LOADING2", fileName);
                    Texture result = new Texture(Gdx.files.absolute(fileName));
                    result.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
                    result.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
                    return result;
                }
            };
            Log.d("TEXTURE LOADING", "Textures array size: "  + project.getTexturesPath().size());
            for(String texturePath: project.getTexturesPath()) {
                provider.load(texturePath);
            }

            model = modelLoader.loadModel(dirHandel, provider);
        }

        modelInstance = new ModelInstance(model);

    }

    @Override
    public void render(float delta) {
        mRenderer.render(this, delta);
    }

    @Override
    public void dispose() {
        mRenderer.dispose();
    }


    @Override
    public void resize(int i, int i2) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}
