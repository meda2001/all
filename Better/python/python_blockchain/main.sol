// SPDX-License-Identifier: MIT
pragma solidity ^0.8.2;

contract Main {

    uint public myNum;

    function setMyNum(uint _myNum) public {
        myNum=_myNum;
    }
}