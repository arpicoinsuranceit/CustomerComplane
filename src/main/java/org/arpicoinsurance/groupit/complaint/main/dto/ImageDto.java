package org.arpicoinsurance.groupit.complaint.main.dto;


public class ImageDto {
	
	private Integer imageId;
	private String imagePath;
	
	private ComplaintStageDetailsDto complaintStageDetails;
	

	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public ComplaintStageDetailsDto getComplaintStageDetails() {
		return complaintStageDetails;
	}
	public void setComplaintStageDetails(ComplaintStageDetailsDto complaintStageDetails) {
		this.complaintStageDetails = complaintStageDetails;
	}
	@Override
	public String toString() {
		return "ImageModel [imageId=" + imageId + ", imagePath=" + imagePath + ", complaintStageDetails="
				+ complaintStageDetails + "]";
	}
	

}
