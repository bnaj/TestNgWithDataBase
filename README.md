*First, this is not a tutorial it’s something like idea.*

**About**

Hello, 

Automation testers need often to handle big chunks of data.

There are various reasons for that, for example:

- Big systems with many users-profile data

- System with many time stamps

How to deal with this?

How create test framework with comfortable data provider?

In this project I try to show an example using SQLite.

For test we use demo page: [*https://phptravels.com/Demo/%7C2*](https://phptravels.com/Demo/%7C2)

**What is in?**

Project contains three modules:

1) DriverSetup – Selenium driver Manager. Module providing SeleniumDriver (I won't describe this module)

2) TestNg – module with simple test, just two steps where we see how it works.

3)DataBase – this module contains all of the mechanics for providing data.

**Lets start**

To storage data we use SQLite project. It allows us to avoid running database server. We operate on file with database like testData.db.

To provide driver for SQLite I use maven dependencies:

     <!-- https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc -->
        <dependency>
            <groupId>org.xerial</groupId>
            <artifactId>sqlite-jdbc</artifactId>
            <version>3.28.0</version>
        </dependency>

You can also use jar.

In the DataBase module we have packages:

_sample_<br>
|

_dataBase_

|- _dao_

|- _entities_

|- _sql_

And now in package sql we have one class:

ComunicationWithBase – this class have one method responsible for connection with database.

Package entities stores a data model of object like in class `User`. We have fields, getter and setter e.g:

    private String login;

    public void setUserId(int userId){

    this.userId = userId;

    }

    public String getLogin(){

    return login;

    }

In this class has also a constructor with and without attributes.

(If you want to force all fields to be filled use constructor with all fields.)

Second class `Address` have the same function like `User`.

Package dao provides data from database. Have 2 interfaces and 2 classes which implements interfaces.

Interfaces are used here only in role of contract.

In classes we have 2 methods: one provides data by using user id and second which provides all data.

In class `UserDao` and in method `getUserDataById` we can see fragment where we create user with data from base:

    User user = new User();

    user.setUserId(resultSets.getInt("userId"));

    user.setLogin(resultSets.getString("login"));

    user.setName(resultSets.getString("name"));

    user.setAge(resultSets.getInt("age"));
 

As you see, we use setter from `User` Class. This method return `User` object that we can later use.

**How we use it?**

How I use it? In module `TestNg` and class `SmapleTest` we have fields like:

User userData;

Address addressData;

I’ declare object `User` and `Adress`, next I initialize these fields in test method with BeforeClass adnotaion `step00`. For this purpose, I call method from `UserDao` and `AdressDao`. First argument is `userId` and second is `baseName`

    public void step00(){

    object = new PageObject(driver.getWebDriver());

    userData = new UserDao().getUserById(1,"testData");

    addressData = new AddressDao().getAddressByUserId(2,"testData");

    }

Now we have object with data, we can use it very simple like in test method step01:

    public void step01() {

    driver.getWebDriver().get(addressData.getFirst());

    }

As you can see, to provide www address I just use getter from Address class.

That is all!

Regards<br>
JB
