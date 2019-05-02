package za.co.bbd.gradprogram.jigsaw;

public class TargetImage {
	private Long id;
	private byte[] bits;

	public TargetImage() {
		super();
	}

	public TargetImage(Long id, byte[] bits) {
		super();
		this.id = id;
		this.bits = makeDeepCopy(bits);
	}

	public TargetImage(byte[] bits) {
		super();
		this.bits = bits;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getBits() {
		return bits;
	}

	public void setBits(byte[] bits) {
		this.bits = makeDeepCopy(bits);
	}

	@Override
	public String toString() {
		return String.format("TargetImage [id=%s, bits=%s]", id, bits);
	}

	private byte[] makeDeepCopy(byte[] originalArray) {
		byte[] targetArray = new byte[originalArray.length];
		for (int i = 0; i < targetArray.length; i++) {
			targetArray[i] = originalArray[i];			
		}
		return targetArray;
	}

}
