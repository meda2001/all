from flask import Flask, request, jsonify
from web3 import Web3

app = Flask(__name__)

# Connect to a local Ethereum node
w3 = Web3(Web3.HTTPProvider('http://localhost:8545'))

# Replace with your contract address and ABI
contract_address = '0xd9145CCE52D386f254917e481eB44e9943F39138'

contract_abi = [
	{
		"inputs": [
			{
				"internalType": "uint256",
				"name": "id",
				"type": "uint256"
			}
		],
		"name": "deleteData",
		"outputs": [],
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"inputs": [
			{
				"internalType": "uint256",
				"name": "id",
				"type": "uint256"
			},
			{
				"internalType": "string",
				"name": "value",
				"type": "string"
			}
		],
		"name": "setData",
		"outputs": [],
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"inputs": [
			{
				"internalType": "uint256",
				"name": "id",
				"type": "uint256"
			}
		],
		"name": "getData",
		"outputs": [
			{
				"internalType": "string",
				"name": "",
				"type": "string"
			}
		],
		"stateMutability": "view",
		"type": "function"
	}
]

contract = w3.eth.contract(address=contract_address, abi=contract_abi)


@app.route('/data', methods=['GET', 'POST', 'DELETE'])
def manage_data():
    if request.method == 'GET':
        data_id = int(request.args.get('id'))
        data = contract.functions.getData(data_id).call()
        return jsonify({'id': data_id, 'value': data})

    elif request.method == 'POST':
        data_id = int(request.json['id'])
        data_value = request.json['value']
        transaction_hash = contract.functions.setData(data_id, data_value).transact()
        w3.eth.waitForTransactionReceipt(transaction_hash)
        return jsonify({'message': 'Data set successfully'})

    elif request.method == 'DELETE':
        data_id = int(request.args.get('id'))
        transaction_hash = contract.functions.deleteData(data_id).transact()
        w3.eth.waitForTransactionReceipt(transaction_hash)
        return jsonify({'message': 'Data deleted successfully'})


if __name__ == '__main__':
    app.run(debug=True)
