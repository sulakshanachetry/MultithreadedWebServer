Single-Threaded Math Server & Client (Java)
===========================================

📖 Project Overview
-------------------

A lightweight **single-threaded client-server application in Java**.

*   The **Math Server** processes basic arithmetic commands (ADD, SUB, MUL, DIV) sent by the **Client** and returns the result.
    
*   Communication uses **Java Sockets** and **Data Streams** for structured messaging.
    
*   Designed to be minimal, easy to understand, and extendable.
    

✨ Features
----------

*   Supported Math Commands:
    
    *   ADD a b → a + b
        
    *   SUB a b → a – b
        
    *   MUL a b → a × b
        
    *   DIV a b → a ÷ b (with division-by-zero handling)
        
*   Graceful termination when client sends exit
    
*   **Single-threaded**: handles one client at a time
    
*   Uses DataInputStream & DataOutputStream for structured communication
    

📂 Project Structure
--------------------

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   .  ├── MathServer.java  ├── MathClient.java  └── README.md   `

▶️ How to Run
-------------

### Compile

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   javac MathServer.java MathClient.java   `

### Run Server

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   java MathServer   `

### Run Client (in another terminal)

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   java MathClient   `

### Example Usage

Plain textANTLR4BashCC#CSSCoffeeScriptCMakeDartDjangoDockerEJSErlangGitGoGraphQLGroovyHTMLJavaJavaScriptJSONJSXKotlinLaTeXLessLuaMakefileMarkdownMATLABMarkupObjective-CPerlPHPPowerShell.propertiesProtocol BuffersPythonRRubySass (Sass)Sass (Scss)SchemeSQLShellSwiftSVGTSXTypeScriptWebAssemblyYAMLXML`   ADD 5 3  DIV 7 0  exit   `

📝 Notes: Socket Programming Insights
-------------------------------------

*   **Socket programming** enables communication between programs (same or different machines).
    
*   A **socket** is an endpoint for sending/receiving data.
    
    *   ServerSocket → used by the server to listen for clients.
        
    *   Socket → used by the client to connect to the server.
        

### 🔗 Basic Steps (TCP)

1.  **Server** creates a ServerSocket on a port.
    
2.  Server calls accept() → waits for client.
    
3.  **Client** creates a Socket(address, port) → connects to server.
    
4.  Communication happens using **I/O streams**.
    
5.  Always **close sockets** when done (this closes streams too).
    

### 📡 Communication Uses Streams

*   InputStream → data coming **from client to server**
    
*   OutputStream → data going **from server to client**
    
*   Can be wrapped in higher-level classes for convenience.
    

🔑 Classes Used
---------------

*   **ServerSocket** → Listens on a port, waits for clients.
    
*   **Socket** → Actual link between client ↔ server.
    
*   **DataInputStream** → Reads structured data from the other side.
    
*   **DataOutputStream** → Sends structured data to the other side.
    
*   **System.in** → Reads user input (keyboard).
    
*   **BufferedReader** → Easier way to read text input from keyboard.
    
*   **String methods**:
    
    *   split() → breaks input (ADD 5 3 → \["ADD","5","3"\])
        
    *   equalsIgnoreCase() → checks commands like exit or EXIT
        
    *   parseInt() → converts "5" → 5
        

📌 Super-Simple Flow
--------------------

**Client**

*   User types command → Read from keyboard → Send to server
    

**Server**

*   Receives command → Performs math → Sends result
    

**Client**

*   Receives result → Displays on screen