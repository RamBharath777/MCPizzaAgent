# MCPizzaAgent

<b> I have created a frame work with below fetures or technoligies

            - Maven
            - POM
            - Java
            - TestNG
           
### MCPizza\src\main\java
- com/mcpizza/config - To maintain configurations for entire project like browser, URL ..etc
- com\mcpizza\general
  - base.java- To intilize and teardown the browser (Chrome and firefox) 
  - pageFactorObjectIntilizer.java - To intilize the page objects as we are using Pagefactory we must intilize all the page java classes in this class
- com\mcpizza\lib - To maintain common actions and testng listners 
- com\mcpizza\pages - To maintain all the page elements 

### MCPizza\src\main\test
- com.mcPizza.sanityTestSuite - To write and excecute test scripts
### MCPizza\test-output 
- Once test excecuted all the HTML reports will generate under this folder for your reference please open emailablereport.html
### MCPizza\Screenshots 
- Contains failed screenshot/s


## How to excecute

- Please go to the TC_001.java file under MCPizza\src\main\test and right click and Run as TestNG Test
