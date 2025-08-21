<strong>** DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>

# WESTERN GOVERNORS UNIVERSITY 
## D287 – JAVA FRAMEWORKS
Welcome to Java Frameworks! This is an opportunity for students to implement user interfaces and learn to leverage existing frameworks, assets, and content for object-oriented programming.
FOR SPECIFIC TASK INSTRUCTIONS AND REQUIREMENTS FOR THIS ASSESSMENT, PLEASE REFER TO THE COURSE PAGE.
## BASIC INSTRUCTIONS
For this project, you will use the Integrated Development Environment (IDE) link in the web links section of this assessment to install the IDE, IntelliJ IDEA (Ultimate Edition). All relevant links are on the course page. Please refer to the course of study for specific links. You will sign up for a free student license using your WGU.edu email address. Please see the “IntelliJ Ultimate Edition Instructions” attachment for instructions on how do this. Next you will download the “Inventory Management Application Template Code” provided in the web links section and open it in IntelliJ IDEA (Ultimate Edition). You will upload this project to a private external GitLab repository and backup regularly. As a part of this, you have been provided with a base code (starting point). 

## SUPPLEMENTAL RESOURCES  
1.	How to clone a project to IntelliJ using Git?

> Ensure that you have Git installed on your system and that IntelliJ is installed using [Toolbox](https://www.jetbrains.com/toolbox-app/). Make sure that you are using version 2022.3.2. Once this has been confirmed, click the clone button and use the 'IntelliJ IDEA (HTTPS)' button. This will open IntelliJ with a prompt to clone the proejct. Save it in a safe location for the directory and press clone. IntelliJ will prompt you for your credentials. Enter in your WGU Credentials and the project will be cloned onto your local machine.  

2. How to create a branch and start Development?

- GitLab method
> Press the '+' button located near your branch name. In the dropdown list, press the 'New branch' button. This will allow you to create a name for your branch. Once the branch has been named, you can select 'Create Branch' to push the branch to your repository.

- IntelliJ method
> In IntelliJ, Go to the 'Git' button on the top toolbar. Select the new branch option and create a name for the branch. Make sure checkout branch is selected and press create. You can now add a commit message and push the new branch to the local repo.

## SUPPORT
If you need additional support, please navigate to the course page and reach out to your course instructor.
## FUTURE USE
Take this opportunity to create or add to a simple resume portfolio to highlight and showcase your work for future use in career search, experience, and education!

## Changes
### C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
#### Changes
mainscreen.html
- Change headers and titles to reflect Kyle's Workout Warehouse
- Line 17-23
  - Added a gym-themed background image to top of the page
  - Display h1 over the image
- Customize element styles with bootstrap
- Add bootstrap support to ALL .html files, make link to mainscreen.html a button

### D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
#### Changes
about.html
- Created about.html with bootstrap support to provide users with information about Kyle's Workout Warehouse
- Lines 12-19
  - Add same gym-themed image background from mainscreen.html to top of about page
  - Display h1 centered over the background image
- Lines 21-46
  - Created a container of three information columns for ("What We Do," "Our Products," and "Our Mission") to describe the company
- Lines 46-48 Added navigation button back to mainscreen.html

### E. Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
#### Changes
BootStrapData.java
- Lines 46-51
  - Added a condition to check if the database is already populated with parts and products
  - Skip initialization if data is already present
- Lines 54-56
  - Initialize parts and products, log that default parts and products were initialized
    - Lines 66-72
      - Define a function to initialize five default products and save each to the database
    - Lines 74-119
      - Define a function to initialize five default parts and save each to the database

### F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
#### Changes by criteria
1. The “Buy Now” button must be next to the buttons that update and delete products.
    - mainscreen.html line 94
      - Added "Buy now" button next to update and delete, links to /buyProduct endpoint
2. The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
    - AddProductController.java lines 177-188
      - Implements /buyProduct endpoint.
      - Decrements the inventory value of the selected product by one
3. Display a message that indicates the success or failure of a purchase.
   - AddProductController.java lines 177-188 & confirmationbuyproduct.html & outofstockerror.html 
     - Checks if the inventory value is 0, if so purchase fails and user is taken to the outofstockerror.html page
     - If the inventory value is greater than 0 purchase is successful and user is redirected to confirmationbuyproduct.html

### G.  Modify the parts to track maximum and minimum inventory by doing the following:
1. Add additional fields to the part entity for maximum and minimum inventory.
    - Part.java lines 33-36
      - Create minInventoryValue and maxInventoryValue fields with @Min annotation to ensure positive numbers
    - Part.java lines 99-113
      - Create getter and setter methods for minInventoryValue and maxInventoryValue
2. Modify the sample inventory to include the maximum and minimum fields. 
   - BootStrapData.java lines 74-119
     - Add minimum and maximum values to sample part data initializeDefaultParts()
3. Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values. 
    - inhousepartform.html lines 34-38
      - Add minimum and maximum inventory values to the input forms with thymeleaf
    - outsourcedpartform.html lines 32-36
      - Add minimum and maximum inventory values to the input forms with thymeleaf
4. Rename the file the persistent storage is saved to. 
   - application.properties line 6
     - rename database to "WebbDatabaseV_01"
5. Modify the code to enforce that the inventory is between or at the minimum and maximum value.
   - inhousepartform.html lines 40-44
     - Create unordered list of each constraintViolation to the user if inventory is invalid
   - outsourcedpartform.html lines 41-45
     - Create unordered list of each constraintViolation to the user if inventory is invalid

### H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
   - Create file InventoryValidator.java
     - Lines 29-41 ensure that updated inventory value is between min and max value
     - If it is not, add a constraint violation to display the errors to user
   - Modify EnufPartsValidator.java lines 33-45
     - Added validation to ensure updating product inventory doesn't take related parts below minimum inventory value
1. Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts. 
    - InhousePartForm.html lines 40-44
      - Added error display for inventory validation using thymleaf from constraintViolation
2. Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum. 
   - OutsourcedPartForm.html Line 41-45
     -  Added error display for inventory validation when adding and updating products reduces related parts below minimum
3. Display error messages when adding and updating parts if the inventory is greater than the maximum.
   - OutsourcedPartForm.html Line 41-45
        -  Added error display for inventory validation when adding and updating products reduces related parts below minimum
   - InhousePartForm.html lines 40-44
     - Added error display for inventory validation using thymleaf from constraintViolation

### I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.
- PartTest.java lines 161-198
  - Two get and set tests for maxInventoryValue
  - Two get and set tests for minInventoryValue

### J.  Remove the class files for any unused validators in order to clean your code.
- Deleted DeleteProductValidator.java as it was unused to clean up the project code.

