package cn.zjut.edu.dto;

public class Management {
    private Integer mId;

    private String handbooks;

    private String processes;

    private String requirements;

    private String gpc;

    private String tips;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getHandbooks() {
        return handbooks;
    }

    public void setHandbooks(String handbooks) {
        this.handbooks = handbooks == null ? null : handbooks.trim();
    }

    public String getProcesses() {
        return processes;
    }

    public void setProcesses(String processes) {
        this.processes = processes == null ? null : processes.trim();
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements == null ? null : requirements.trim();
    }

    public String getGpc() {
        return gpc;
    }

    public void setGpc(String gpc) {
        this.gpc = gpc == null ? null : gpc.trim();
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
    }
}