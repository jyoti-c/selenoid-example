# selenoid-example
A maven testng code to run your selenium scripts on Selenoid (Docker based Selenium hub)

The code consists sample tests run on Chrome and Firefox on Selenoid

YouTube Playlist - https://youtube.com/playlist?list=PLKpa9fJrn0A07frfki3p5fMCQJ08aaaZ-


* **mvn command to run a single test**
```
mvn -Dtest=SampleTest_Chrome test
```
* **mvn command to run multiple tests**
```
mvn -Dtest=SampleTest_Chrome,uiTests.FirefoxUITest test
```
*  **mvn command to run all tests in a package**
```
mvn -Dtest="uiTests.**" test
```
*  **mvn command to run all tests matching a group name**
```
mvn -Dtest="**" -Dgroups="chrome" test
```

