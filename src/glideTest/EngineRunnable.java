package glideTest;

public class EngineRunnable implements Runnable {

    private final DecodeJob<?, ?, ?> decodeJob;

    public EngineRunnable() {
        decodeJob = new DecodeJob<>();
    }

    @Override
    public void run() {
        Resource<?> resource = null;
        try {
            resource = decode();
        } catch (Exception e) {
        
        }
        
    }

    private Resource<?> decode() throws Exception {
        return null;
    }



}