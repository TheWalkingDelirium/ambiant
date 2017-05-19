package fit.cvut.cz.ambiant.model.entities;

import java.util.ArrayList;

/**
 * Created by George on 06-March-17.
 */

public class Project {
    private int id;
    private String name;
    private String path; // path to the folder
    private String description;
    private String author;
    private ArrayList<String> texturesPath;
    private boolean isExample = false;

    public Project(int id, String author, String name, String path, String description, ArrayList<String> texturesPath) {
        this(id, author, name, path, description, false, texturesPath);
    }

    public Project(int id, String author, String name, String path, String description, boolean isExample, ArrayList<String> texturesPath) {
        this.id = id;
        this.path = path;
        this.name = name;
        this.description = description;
        this.isExample = isExample;
        this.author = author;
        if (isExample) {
            this.path = "file:///android_asset/" + name;
        }
        this.texturesPath = texturesPath;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModelPath() {
        if (isExample()) {
            return name + "/model.g3db";
        }
        return path+"/model.g3db";
    }

    public String getThumbnailPath() {
        //TODO deleteme
        if (name.equals("tyan"))
            return this.path;
        return path+"/thumbnail.jpg";
    }

    public String getDescription() {
        return description;
    }

    public boolean isExample() {
        return isExample;
    }

    public String getAuthor() {
        return author;
    }

    public String getPath() {
        return path;
    }

    public ArrayList<String> getTexturesPath() {
        return texturesPath;
    }

    public void setTexturesPath(ArrayList<String> texturesPath) {
        this.texturesPath = texturesPath;
    }

    //todo getModel
}
