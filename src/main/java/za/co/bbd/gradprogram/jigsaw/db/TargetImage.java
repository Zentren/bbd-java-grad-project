package za.co.bbd.gradprogram.jigsaw.db;

public class TargetImage {

    private Long id;
    private byte[] image;

    public TargetImage(Long id, byte[] image) {
        this.id = id;
        this.image = image.clone();
    }

    public Long getId() {
        return id;
    }

    public byte[] getImage() {
        return image.clone();
    }

    @Override
    public String toString() {
        return String.format("TargetImage [id=%s, image=%s]", id, image);
    }
}
