# PROVA FINALE DI INGEGNERIA DEL SOFTWARE 2021-2022

![](src/main/resources/images/LogoEriantys.png)

*Eriantys* is an Italian board game, for 2-4 players, created by Leo Colovini.
It is a game full of strategy and twists. Plan your moves carefully and try to control the moves of your opponents. With three different game modes, including a team game, Eriantys offers always different and interesting matches. Also, if you play with the expert variant, you can use the fantastic abilities of the special characters. 
*Manage your Eriantys’ school and compete with other wizards to increase your fame!*

The *target* of the projet is the implementation of a distributed system composed by a single server capable of managing one game at a time and multiple clients (one per player) that can participate in only one game at a time. The game has been implemented according to the architectural pattern MVC (Model-View-Controller) and a TCP network using sockets.

## DOCUMENTATION:
In this paragraph will be shown the documentation of the project:
## UML
The [initial UML](deliveries/initial_uml.png) features an initial and  general idea of the game, later the diagram has been modified according to a more defined implementation for reaching the [final UML](deliveries/final_uml.png).

## Network Protocol
The [network protocol](deliveries/communicationProtocol.pdf) describes the communication between the server and the client.

## JavaDoc
[JavaDoc](docs) provides a descripition of the classes and the methos.

## PeerReview
- [UML PeerReview Ricevuta](deliveries/Peer_Review_Ricevuta.md)
- [UML PeerReview Inviata](deliveries/Peer_Review_55_UML.tex)
- [Protocol PeerReview Ricevuta](deliveries/Peer_Review_Ricevuta_Communication_Protocol.md)
- [Protocol PeerReview Inviata](deliveries/Peer_Review_55_Comunication_Protocol.tex)

## TOOL, PLUGINS AND EXTERNAL LIBRARIES USED:
- Intellij IDEA,
- JUnit, 
- Maven, 
- JavaFX + Scene Builder, 
- Github

## FUNCTIONALITIES:
|FUNCTIONALITIES|IMPLEMENTED|
|-----|:---:|
|Complete Rules| **X** |
|Socket Connection| **X** |
|Cli| **X** |
|Gui| **X** |
|**ADVANCED FUNCTIONALITIES**|**IMPLEMENTED**|
|12 Character Cards| **X**  |
|4 – Player Game| **X** |

## JAR:
The following jars allow to launch the game as descriped:  

Server: java -jar ServerMain.jar 

Client: java -jar ClientMain.jar

Once the Client started, follow the displayed text to play in CLI or GUI (press "C" for CLI or "G" for GUI)

## DEVELOPERS:
[PAOLO GAMBARIN](https://github.com/paologambarin), [ANTONINO GATTUSO](https://github.com/AntoninoGattuso0), [REBECA MERSAM](https://github.com/RebecaMersamF)




