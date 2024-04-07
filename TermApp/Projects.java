package TermApp;

public class Projects extends Job {
    private String productID;
    private String productName;
    private String startDate;
    private String endDate;
    private String status;
    //default constructor
    public Projects() {

    }
    //setters
    private void setProductID(String productID) {
        this.productID = productID;
    }
    private void setProductName(String productName) {
        this.productName = productName;
    }
    private void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    private void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    private void setStatus(String status) {
        this.status = status;
    }
    //getters
    private String getProductID() {
        return productID;
    }
    private String getProductName() {
        return productName;
    }
    private String getStartDate() {
        return startDate;
    }
    private String getEndDate() {
        return endDate;
    }
    private String getStatus() {
        return status;
    }
    //other methods
    //adds a new project to the array
    private void addProject() {
        //FIXME adds a new project to the array
    }
    
    private static void updateProject() {
        //FIXME updates project with new information
    }

    private void deleteProject() {
        //FIXME deletes project at index in the array
    }
}
