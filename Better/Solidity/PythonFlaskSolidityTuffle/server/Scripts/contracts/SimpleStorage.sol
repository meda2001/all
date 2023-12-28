// SimpleStorage.sol
pragma solidity ^0.8.0;

contract SimpleStorage {
    mapping(uint256 => string) private data;

    function setData(uint256 id, string memory value) public {
        data[id] = value;
    }

    function getData(uint256 id) public view returns (string memory) {
        return data[id];
    }

    function deleteData(uint256 id) public {
        delete data[id];
    }
}
