package mytube;

public class VideoEncoder implements VideoEncodable {
    @Override
    public void encode(Video video) {
        System.out.println("Encoding video...");
        System.out.println("Done!\n");
    }
}
