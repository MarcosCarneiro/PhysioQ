package br.com.stenio.physioq.domain;

public class Questionary {

    private String name;
    private String category;
    private int resultPoints;
    private int photo;

    public Questionary(String name, String category, int p) {
        this.name = name;
        this.category = category;
        this.photo = p;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}


    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }



    public int getPhoto() {
        return photo;
    }
    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getClassification() {
        return category;
    }

    public void setClassification(String classification) {
        this.category = classification;
    }

    public int getResultPoints() {
        return resultPoints;
    }

    public void setResultPoints(int resultPoints) {
        this.resultPoints = resultPoints;
    }

}
