package com.xiplink.jira.git;

/**
 * Struct holding the linkformat.* link format parameters for a repository.
 *
 * @author Chenggong Lu
 */
public class ViewLinkFormat {

    private String type;
    private String changesetFormat;
    private String fileAddedFormat;
    private String viewFormat;
    private String fileModifiedFormat;
    private String fileDeletedFormat;
    private String branchFormat;

    public ViewLinkFormat(String type, String changesetFormat, String fileAddedFormat, String fileModifiedFormat,
            String fileDeletedFormat, String pathLinkFormat, String branchFormat) {
        this.setType(type);
        this.setViewFormat(pathLinkFormat);
        this.setFileAddedFormat(fileAddedFormat);
        this.setFileModifiedFormat(fileModifiedFormat);
        this.setFileDeletedFormat(fileDeletedFormat);
        this.setChangesetFormat(changesetFormat);
        this.setBranchFormat(branchFormat);
    }

    public void fillFormatFromOther(ViewLinkFormat other) {
        if (other != null) {
            if (this.getType() == null) {
                this.setType(other.getType());
            }
            if (this.getViewFormat() == null) {
                this.setViewFormat(other.viewFormat);
            }
            if (this.getFileAddedFormat() == null) {
                this.setFileAddedFormat(other.fileAddedFormat);
            }
            if (this.getFileModifiedFormat() == null) {
                this.setFileModifiedFormat(other.fileModifiedFormat);
            }
            if (this.getFileDeletedFormat() == null) {
                this.setFileDeletedFormat(other.fileDeletedFormat);
            }
            if (this.getChangesetFormat() == null) {
                this.setChangesetFormat(other.changesetFormat);
            }
            if (this.getBranchFormat() == null) {
                this.setBranchFormat(other.branchFormat);
            }

        }

    }

    public String toString() {
        return "pathLink: " + getViewFormat()
                + " addedFormat: " + getFileAddedFormat()
                + " modifiedFormat: " + getFileModifiedFormat()
                + " deletedFormat: " + getFileDeletedFormat()
                + " branchFormat: " + getBranchFormat();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChangesetFormat() {
        return changesetFormat;
    }

    public void setChangesetFormat(String changesetFormat) {
        this.changesetFormat = changesetFormat;
    }

    public String getFileAddedFormat() {
        return fileAddedFormat;
    }

    public void setFileAddedFormat(String fileAddedFormat) {
        this.fileAddedFormat = fileAddedFormat;
    }

    public String getViewFormat() {
        return viewFormat;
    }

    public void setViewFormat(String viewFormat) {
        this.viewFormat = viewFormat;
    }

    public String getFileModifiedFormat() {
        return fileModifiedFormat;
    }

    public void setFileModifiedFormat(String fileModifiedFormat) {
        this.fileModifiedFormat = fileModifiedFormat;
    }

    public String getFileDeletedFormat() {
        return fileDeletedFormat;
    }

    public void setFileDeletedFormat(String fileDeletedFormat) {
        this.fileDeletedFormat = fileDeletedFormat;
    }

	public String getBranchFormat() {
		return branchFormat;
	}

	public void setBranchFormat(String branchFormat) {
		this.branchFormat = branchFormat;
	}
}
