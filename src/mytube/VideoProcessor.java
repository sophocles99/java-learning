package mytube;

public class VideoProcessor {
    public void process(Video video) {
        VideoEncodable encoder = new VideoEncoder();
        encoder.encode(video);

        Storable database = new VideoDatabase();
        database.store(video);

        Sendable sender = new EmailService();
        sender.sendEmail(video.getUser());
    }
}

