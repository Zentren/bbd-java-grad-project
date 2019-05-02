package za.co.bbd.gradprogram.jigsaw.db;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TargetImage {

    private Long id;
    private byte[] image;

    public TargetImage(byte[] image) {
        this.image = image.clone();
    }

    public TargetImage(Long id, byte[] image) {
        this.id = id;
        this.image = image.clone();
    }

    public void setId(long id) { this.id = id; }

    public Long getId() {
        return id;
    }

    public void setImage(byte[] image) { this.image = image.clone(); }

    public byte[] getImage() {
        return image.clone();
    }

    @Override
    public String toString() {
        return String.format("TargetImage [id=%s, image=%s]", id, image);
    }
}
