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

* __Version 0.2.1 - Map (minor visual improvements and command checks)__
    * minor visual improvements and command checks

* __Version 0.3.0 - Basic Combat__
    * Added Player and Monster Entities
    * Added basic (really basic) combat mechanics
    * Implemented additional commands ("attack")
    
* __Version 0.4.0 - Re-designed combat, Item support__
    * Re-designed combat system
        * Separate combat sequence, allowing for display of enemy information (name, desc, health)
        * Ability to use items during combat, such as weapon (eg. attack with knife) and consumables (eg. use medkit)
    * Added item support
        * Added player inventory
        * take and drop items ("take", "drop")
        * added support for consumables via the use command (eg. use medkit)
    * Various bug fixes and general polish