// SPDX-License-Identifier: MIT
pragma solidity >=0.4.22 <0.9.0;

contract SimpleStorage {



  uint public message;

  function setMessage(uint _message) public {
    message=_message;
  }

  function getMessage() public view returns(uint){
    return message;
  }


}
