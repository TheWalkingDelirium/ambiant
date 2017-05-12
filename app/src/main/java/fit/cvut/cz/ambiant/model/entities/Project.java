package fit.cvut.cz.ambiant.model.entities;

/**
 * Created by George on 06-March-17.
 */

public class Project {
    private int id;
    private String name;
    private String path; // path to the folder
    private String description;
    private String author;
    private boolean isExample = false;

    public Project(int id, String author, String name, String path, String description) {
        this(id, author, name, path, description, false);
    }

    public Project(int id, String author, String name, String path, String description, boolean isExample) {
        this.id = id;
        this.path = path;
        this.name = name;
        this.description = description;
        this.isExample = isExample;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModelPath() {
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

    //todo getModel
}
