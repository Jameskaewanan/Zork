# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added
- Character Creation: Gender, Race, Class, Name
- 3 Races, 3 Classes, 12 Skills
- Combat logic accounts for strength to add damage multiplier

### Removed
- Player no longer chooses a map, only 1 map is available
- Player no longer regenerates health after every turn

##  v1.0.0 - 15-06-2021 - VERSION 1.0.0 RELEASE
The release version which reaches all project requirements for the System Software Construction Course.
Going forward, this project will not be associated with the course and will become an independent personal project.
Future updates and changelogs will be more substantial and in-depth and more work will be done to make this project
a viable game that you might see released as an indie title.

## v0.4.2 - 14-06-2021 - Load/Save, Combat Logic

### Added
- "save" command that logs all previous player commands and saves it as a file
- "load" command that reads and execute all previous player commands from save file
- Combat logic now accounts for damage percentage, hit rate, defense, etc... to create a more varied combat experience

### Changed
- Add additional parameters to Player and Monster Entities to account for combat logic

## v0.4.1 - 12-06-2021 - Added "info" Command

### Added
- "info" command that shows player stats, room stats, monster/item stats

### Fixed
- Minor bug fixes

## v0.4.0 - 10-06-2021 - Re-designed Combat

### Added
- "use" command that adds support for items such as consumables
- "take" command to take items from the map and add to player inventory
- "drop" command to remove items form player inventory
- Re-designed combat system
- Separate combat sequence, allowing for display of enemy information (name, desc, health)
- Some weapons
- Some consumables
- Ability to use items during combat, such as weapon (eg. attack with knife) and consumables (eg. use medkit)
- Player inventory to check what weapons or items they have

### Changed
- "attack" command now accepts and parses elements relating to combat
- Items placed around in the map

### Fixed
- Various bug fixes and general polish

## v0.3.0 - 09-06-2021 - Basic Combat

### Added
- Player and Monster Entities
- "attack" command that deals damage to the monster
- Basic (really basic) combat mechanics with no combat logic to calculate damage, hit chance, etc...

### Changed
- Monsters placed around the map

## v0.2.1 - 09-06-2021 - Minor Visual Improvements

### Added
- Minor visual improvements to the game menu

### Fixed
- Checks to ensure that player inputs commands in the proper format

## v0.2.0 - 09-06-2021 - Map

### Added
- "go" command that moves the player in one of four directions ( north / east / south / west ) on the map
- "quit" command that quits the current game session and return players to the menu
- "play" command that initializes a game session
- A map, SpaceshipMap, in the form of a txt file with appropriate displays such as: name, desc, connecting rooms
- Individual rooms implemented (although no items and/or monsters yet)
- Map can be fully traversed with the "go" command

## v0.1.0 - 07-06-2021 - Parser and Command Handler

### Added
- Basic game loop for the game to continuously run
- Basic command parser and command handler without any error checking
- "exit" command that quits the game loop, hence quit the game
- "help" command which shows a list of commands and their description and uses

##  v0.0.0 - 07-06-2021 - Initial Commit

### Added
- Initial Commit
    

    





    

    

    

        
