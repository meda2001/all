array1=[1,2,3,4]
array2=[2,3,4,5]
console.log(array1,array2)
array3=[...array1,...array2]
console.log(array3)


user={
    name:"Meda murari prasad",
    age:22
}
details={
    ...user,
    address:"Anantpur"

}
console.log(details)