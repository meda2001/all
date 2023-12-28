const { expect } = require("chai");

describe("SimpleStorage Contract", function () {
  let SimpleStorage;

  beforeEach(async function () {
    // Deploy the SimpleStorage contract before each test
    SimpleStorage = await ethers.getContractFactory("SimpleStorage");
  });

  it("should deploy with the initial message", async function () {
    // Deploy the contract
    const simpleStorage = await SimpleStorage.deploy();
    
    // Wait for the deployment transaction to be mined
    await simpleStorage.deployTransaction.wait();

    // Get the initial message and check if it matches the expected value
    const initialMessage = await simpleStorage.message();
    expect(initialMessage).to.equal("Hello world");
  });

  it("should set a new message", async function () {
    // Deploy the contract
    const simpleStorage = await SimpleStorage.deploy();
    
    // Wait for the deployment transaction to be mined
    await simpleStorage.deployTransaction.wait();

    // Set a new message and check if it was updated
    const newMessage = "New message";
    await simpleStorage.setMessage(newMessage);
    
    // Get the updated message and check if it matches the new value
    const updatedMessage = await simpleStorage.message();
    expect(updatedMessage).to.equal(newMessage);
  });
});
