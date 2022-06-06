import com.google.gson.JsonArray;

public abstract class StoredFiles {
    private JsonArray memory;
    private String storedFile;

    public StoredFiles() {
    }

    public StoredFiles(JsonArray memory) {
        this.memory = memory;
    }

    public StoredFiles(String storedFile) {
        this.storedFile = storedFile;
    }

    public StoredFiles(JsonArray memory, String storedFile) {
        this.memory = memory;
        this.storedFile = storedFile;
    }

    public JsonArray getMemory() {
        return memory;
    }

    public String getStoredFile() {
        return storedFile;
    }
    
}
