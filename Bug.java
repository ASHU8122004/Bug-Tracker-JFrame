public class Bug {
    private String id;
    private String description;
    private String status;
    private String priority;

    public Bug(String id, String description, String status, String priority) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public Bug() {
        this("", "", "", "");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
