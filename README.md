# AWS FullStack Inventory Management System

## Overview
This project demonstrates inventory management by filtering for engine parts and car products. It includes indexing as well as search functionality for either parts or products. CRUD is used in the project to create, update, and delete engine parts and car products. The theme of the project focuses on car products which will be car models in this case, with engine parts corresponding to each product.

## Features
- **Comprehensive Inventory Management**. Manage and maintain a detailed inventory of car parts and products.
- **Advanced Search and Filtering**. Quickly locate specific car parts or products using the powerful search and filter functionalities.
- **CRUD Operations**. Users can seamlessly add new parts or products, update existing records, and delete items that are no longer needed.
- **User-Friendly Interface**. Includes buttons for adding in-house or outsourced parts, as well as update and delete actions for each item, ensuring smooth navigation.

## Technologies Used
- Backend: SpringBoot
- Frontend: React 
- Database: H2 (Embedded) Used for development and testing purposes.
- Hosting: AWS Services
- Version Control: GitHub
- Backend Components: SpringBootStarterWeb, SpringBootStarterDataJPA, Thymeleaf, SpringBootStarterValidation,
  SpringBootDevTools,H2 Database, SpringBootStarterTest, JUnit, Lombok, Maven.


# Getting Started

## Prerequisites
- **JDK 17+**
- **Maven** (or Gradle)
- **Node.js & npm**

Here’s your full **README.md** installation and deployment section formatted for copy-paste:

---

## 🛠️ Installation

### **Step 1: Clone the Repository**

```bash
git clone https://github.com/KevinLlano/Java-Frameworks2.0.git
```

---

### **Step 2: Backend Setup (Spring Boot)**

1. Open the project in your preferred IDE (e.g., IntelliJ, Eclipse).
2. Ensure Maven dependencies are downloaded.
3. Run the application:

```bash
./mvnw spring-boot:run
```

* The backend will start at: `http://localhost:8080`

---

### **Step 3: Frontend Setup (React)**

1. Navigate to the frontend directory:

```bash
cd frontend
```

2. Install dependencies:

```bash
npm install
```

3. Start the development server:

```bash
npm start
```

* The frontend will be available at: `http://localhost:3000`

---

### **Step 4: Usage**

#### **Backend**

* Handles REST APIs for managing engine parts and car products (CRUD).

#### **Frontend**

* Provides UI to:

  * View, add, update, and delete items.
  * Filter/search parts and products.
  * Use buttons for managing inventory.

---

## Step 5: Backend Deployment (AWS Elastic Beanstalk)

### 1. Package the Spring Boot App

```bash
./mvnw clean package
```

* This creates a `.jar` file in the `target/` directory.

### 2. Install AWS CLI & EB CLI

[EB CLI install guide](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/eb-cli3-install.html)

### 3. Initialize Beanstalk

```bash
eb init
```

* Select your region
* Choose **Java** platform
* Link to your AWS account

### 4. Create Environment & Deploy

```bash
eb create my-env-name
eb deploy
```

### 5. Access the Deployed App

You’ll get a live URL like:

```
http://my-env-name.elasticbeanstalk.com
```

---


## Screenshots 
![image](https://github.com/user-attachments/assets/00b4818e-7944-49bb-be82-842f1e2c79bd)
![image](https://github.com/user-attachments/assets/2a9dc156-8de5-4b4c-bc4c-ba71b0bdd911)
![image](https://github.com/user-attachments/assets/f2b30d03-d212-4ed5-bc04-d2a3773cac12)
![image](https://github.com/user-attachments/assets/afb2d82b-06ba-4122-91db-b95c4dbf9d27)
![image](https://github.com/user-attachments/assets/7fe222b4-7def-4f85-9a32-253017c99754)



