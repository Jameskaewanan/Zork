# Zork
An individual project, developing a text based game, Zork in Java. For my University's Software System Construction Course

# Version History

* __Version 0.0.0 - Initial Commit__
    * Initial Commit
    
* __Version 0.1.0 - Basic Parser and Command Handler__
    * Implemented basic game loop
    * Basic parser and command handler without any error checking
    * "exit" and "help" commands implemented
    
* __Version 0.2.0 - Map__
    * Implemented additional commands ("go", "quit", "play")
    * Added the first map, SpaceshipMap
        * Individual rooms implemented (although no items and/or monsters yet)
    * Map can be fully traversed
        * "go [ north / east / south / west ]"
        * Includes appropriate displays such as: name, desc, connecting rooms
