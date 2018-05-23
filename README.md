# find-duplicates

## Installation

    git clone https://github.com/stefanhengl/find-duplicates.git
    cd find-duplicates
    lein uberjar

## Usage

    java -jar find-duplicates-0.1.0-standalone.jar /path/to/folder

To find AND remove duplicate files, simply pipe the output to `rm`

    java -jar find-duplicates-0.1.0-standalone.jar /path/to/folder | xargs rm