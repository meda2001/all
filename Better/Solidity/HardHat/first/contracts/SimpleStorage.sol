// SPDX-License-Identifier: MIT
pragma solidity ^0.8.9;

contract SimpleStorage{

    string public message;

    constructor(){
        message="Hello world";
    }

    function setMessage(string memory _message)public{
        message=_message;
    }
}