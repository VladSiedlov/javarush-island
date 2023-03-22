# javarush-island

Final project of Java Rush University 2nd module

Main features:
- Configurable options for animals and island in Json files
- Factories for Animals and Grass creation (/factories folder)
- Settings from Json files loads only once for avoiding future file loading
- All animals inherited from higher abstraction described in /abstraction folder
- `Eat()` method of herbivores Duck, Boar and Mouse overrided to make them able to eat Caterpillars and some other herbivores

Configuration location
----------
All configuration files located in /resources folder

`IslandSettings.json` contains main simulations settings such as island size, number of simulation iteration, animals population etc 

`AnimalsSettings.json` contains main animal parameters and eat probabilities

Configuration loading
------------------------
All configuration loads and parse using `jackson-databind` library by `SettingsManager` class during initialization
