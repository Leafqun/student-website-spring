package cn.zjut.edu.dto;

public class Tables {
    private Integer tableId;

    private String tableName;

    private String tableFile;

    private Integer tableType;

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public String getTableFile() {
        return tableFile;
    }

    public void setTableFile(String tableFile) {
        this.tableFile = tableFile == null ? null : tableFile.trim();
    }

    public Integer getTableType() {
        return tableType;
    }

    public void setTableType(Integer tableType) {
        this.tableType = tableType;
    }
}