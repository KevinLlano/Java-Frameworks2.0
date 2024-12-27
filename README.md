
"TASK C"  
Prompt: Changed the names to match the theme and content related to cars.  
File name: mainscreen.html  
Line number:  
Changes:  
14: Changed the title to `<title>Kevin's Hot Wheels Dealership</title>`.  
19: Updated the heading to `<h1>Car Supply Shop</h1>`.  
21: Updated the subheading to `<h2>Car Parts</h2>`.  
53: Updated another subheading to `<h2>Car Products</h2>`.



"TASK D"  
Prompt: Added an "About" page for the car store, with navigation links and related content.  
File name: mainscreen.html, about.html, MainScreenController.java  
Line number & Changes:  
18: Added navigation link `<a href="/about">About Us</a>`.  
19: Added navigation link `<a href="/">Home</a>`.  
56-58: Added `@GetMapping("/about")` method



"TASK E"  
Prompt: Added sample parts and products, with conditions to check if the data already existed or was empty.  
File name: BootStrapData.java  
Line number & Changes:  
44-47: Added a conditional check to ensure the sample inventory is added only if both the part and product repositories are empty.  
57-73: Created `addSampleInventory()` method to add sample parts and products if they don't already exist.  
74-83: Created `addPartIfNotExists()` method to add a part only if it doesn't already exist in the repository.  
85-95: Created `addProductIfNotExists()` method vto add a product only if it doesn't already exist in the repository.



"TASK F"  
Prompt: Added success or fail validators  
File name: AddProductController.java, Product.java, mainscreen.html  
Line number & Changes:  
86: Added a Buy Now button and styled it similar to the others like delete, update.  
177-189: Added if logic in the controller to display the success or failure of a purchase.  
94-102: Set up encapsulation in Product.java to make it simple and add modularity to the code.  
1-15: In errobuyproduct.html, I added the visual view for failure pop-up when the product is out of stock.  
1-15: In confirmationbuyproduct.html, I added the visual to display if it was a successful purchase with an option to go to the main page.



"TASK G"  
Prompt: Overall set the min and max value restrictions  
File name: Part.java, InhousePart.java, inhousePartForm.html, application.properties  
Line number & Changes:  
32-36: Added min and max inventory fields in Part.java  
59-65: Added getters and setters in Part.java  
81-84: In BootStrapData.java, set values for default min and max to 1 min and 9 max  
17-29: Set up default min and max values for InhousePart and created a constructor for InhousePart  
17-28: Set up default min and max values for OutsourcePart.java and also created the corresponding constructor  
40-47: Added getters and setters to InhousePart.java because I had a type error for not using camelCase, this is just extra code I wrote.  
24-31: Added visual look, label, and textbox to inhousePartForm.html  
25-32: Added form fields for min and max to OutsourcePartForm.html to display visually on the website  
131-138: Added min and max validator to enforce that inventory is between min and max.  
6: In application.properties, I renamed the database to Kevin_HotWheel_Rides



"TASK H"  
Prompt:  
File name: Part.java, outsourcePartForm.html, inhousePartForm.html, partForm.html  
Line number & Changes:  
134 & 136: Added in Part.java a validator that validates you input a min and max allowed value  
42-57: In inhousePartForm.html, added a method to visually display allowed values, and if not, it gives an error message.  
12-13: Added method for saving outsourcePartForm.html to the correct endpoint.  
12-28: In partForm.html, defined input for minimum and maximum inventory in outsourcePartForm.html and inhousePartForm.html
15-17: in outsourcedpartform.html added a hidden ID field to make sure update works when you update, instead of creating a new field



"TASK I"  
Prompt:  
File name: PartTest.java  
Line number & Changes:  
159-177: Added test for both InhousePart and OutsourcePart max and min inventory values.



"TASK J"  
Line 3 & Line 18: From Part.java, removed `ValidDeletePart` annotation and import  
File: DeletePartValidator.java, deleted the whole file since it is not being used.  
Performed a unit test on DeletePartValidator to verify it was being used, and it failed. Commented this code.

