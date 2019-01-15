//nodemon --quiet js/practice.js



/**
1
anagrams1
ex: anagrams('RAIL! SAFETY!', 'fairy tales') --> True
*/
function anagrams1(strA, strB) {
	return cleanStr(strA) === cleanStr(strB);
}
function cleanStr(str) {
	//match words globally
	return str.replace(/[^\w]/g,'').toLowerCase().split('').sort().join('');
}

//console.log(anagrams1('strA', 'strA'));

function anagrams2(strA, strB) {
	const aCharMap = buildCharMap(strA);
	const bCharMap = buildCharMap(strB);

	if (Object.keys(aCharMap).length !== Object.keys(bCharMap).length) {
		return false;
	}

	for(let char in aCharMap) {	
		if(aCharMap[char] !== bCharMap[char]) {
			return false;
		}
	}
	return true;
}

/**
2
buildCharMap
*/
function buildCharMap(str) {
	const charMap = {};
	for(let char of str.replace(/[^\w]/g,'').toLowerCase()){
		charMap[char] = charMap[char]+1 || 1;
	}
	return charMap;
}

//console.log(anagrams2('strA', 'strv'));


/**
3
palindrome
*/
function palindrome1(str) {
	return str.split('').every((char, i) => {
		return char === str[str.length-i-1];
	});
}

function palindrome2(str) {
	const reversed = str.split('').reverse().join('');
	return str === reversed;
}

/**
4
vowels
*/
function vowels1(str) {
	const matches = str.match(/[aeiou]/gi);
	return matches ? matches.length : 0;
}

function vowels2(str) {
	let count = 0;
	const checker = ['a', 'e', 'i', 'o', 'u'];

	for(let char of str.toLowerCase()) {
		if(checker.includes(char)) {
			count++;
		}
	}
	return count;
}

/**
5
capitalize
*/
function capitalize1(str) {
	let result  = str[0].toUpperCase();
	for(let i=1; i<str.length; i++) {
		if(str[i-1] === ' '){
			result += str[i].toUpperCase();
		} else {
			result += str[i];
		}
	}
	return result;
	console.log(result);
}

//console.log(capitalize('abc abc abc'));

function capitalize2(str) {
	const words = [];
	for(let w of str.split(' ')){
		words.push(w[0].toUpperCase()+w.slice(1));
	}
	return words.join(' ')
}
//console.log(capitalize2('abc abc abc'));

/**
6
chunk
*/
function chunk(array, size) {
	const chunked = [];
	let index = 0;
	while(index < array.length) {
		chunked.push(array.slice(index, index+size));
		index += size;
	}
	return chunked;
}
//console.log(chunk([1,2,3,4],2));

/**
7
fizzbuzz
*/
function fizzBuzz(n) {
	for(let i=1; i<=n; i++) {
		if(i%3 === 0 && i%5 === 0) {
			console.log('fizzbuzz');
		} else if(i%3 === 0) {
			console.log('fizz');
		} else if (i%5 === 0) {
			console.log('buzz');
		} else {
			console.log(i);
		}
	}
}

/**
8
reverseint
*/
function reverseInt(n) {
	const reversed = n.toString().split('').reverse().join('');
	return parseInt(reversed)*Math.sign(n);
}

/**
9
reversestring
*/
function reverse1(str) {
	return str.split('').reverse().join('');
}

function reverse2(str) {
	return str.split('').reduce((acc, currentChar) => currentChar+acc, '');
}

function reverse3(str) {
	let reversed = '';
	for(let c of str) {
		reversed = c + reversed;
	}
	return reversed;
}

/**
10
matrix
*/
function matrix(n) {
	const results = [];
	for(let i=0; i<n; i++) {
		results.push([]);
	}
	let counter =1;
	let startColumn = 0;
	let endColumn = n-1;
	let startRow = 0;
	let endRow = n-1;
	while(startColumn <= endColumn && startRow <= endRow) {
		for(let i= startColumn; i<= endColumn; i++) {
			results[startRow][i] = counter;
			counter++;
		}
		startRow++;

		for(let i= startColumn; i<= endColumn; i++) {
			results[i][endColumn] = counter;
			counter++;
		}
		endColumn--;

		for(let i= endColumn; i>=startColumn; i--) {
			results[endRow][i] = counter;
			counter++;
		}
		endRow--;

		for(let i=endRow; i>=startRow; i--) {
			results[i][startColumn] = counter;
			counter++;
		}
		startColumn++;

	}
	return results;
}

console.log(matrix(3));

/**
11
maxchar
*/
function maxChar(str) {
	const charMap = {};
	let max = 0;
	let maxChar = '';
	for(let char of str) {
		if(charMap[char]) {
			charMap[char]++;
		} else {
			charMap[char] = 1;
		}
	}

	for(let char in charMap) {
		if(charMap[char]>max){
			max = charMap[char];
			maxChar = char;
		}
	}
	return maxChar;
}
//console.log(maxChar("cabcaabc"));

/**
12
pyramid
*/
function pyramid(n) {
	const midpoint = Math.floor((2*n-1)/2);
	for(let row=0; row<n; row++) {
		let level = '';
		for(let column = 0; column<2*n-1; column++) {
			if(column>=midpoint-row && column<=midpoint+row) {
				level += '#';
			} else {
				level += ' ';
			}
		}
		console.log(level);
	}
}

//pyramid(3);

/**
13
steps
*/
function steps(n) {
	for(let row = 0; row <n; row++) {
		let stair = '';
		for(let column=0; column<n; column++) {
			if(column <= row) {
				stair += '#';
			} else {
				stair += ' ';
			}
		}
		console.log(stair);
	}
}

/**
14
fib
*/
function memorize(fn) {
	const cache = {};
	return function(...args) {
		if(cache[args]) {
			return cache[args];
		}
		const result = fn.apply(this, args);
		cache[args] = result;
		return result;
	};
}

function slowFib(n) {
	if(n<2) {
		return n;
	}
	return fib(n-1)+fib(n-2);
}

const fib = memorize(slowFib);

function fib2(n) {
	const result = [0,1];
	for(let i=2; i<=n; i++) {
		const a = result[i-1];
		const b = result[i-2];
		result.push(a+b);
	}
	return result[n];
}

/**
1
LinkedList
*/
class LinkedListNode {
	constructor(data, next = null) {
		this.data = data;
		this.next = next;
	}
}

class LinkedList {
	constructor(values = []) {
		this.head = null;
		for(let v of values) {
			this.insertLast(v);
		}
	}

	clear() {
		this.head = null;
	}

	size() {
		let counter = 0;
		let node = this.head;

		while(node) {
			counter++;
			node = node.next;
		}

		return counter;
	}

	getFirst() {
		return this.head;
	}

	insertFirst(data) {
		this.head = new Node(data, this.getFirst());
	}

	removeFirst() {
		if(!this.head) {
			return;
		}
		this.head = this.head.next;
	}

	getAt(index) {
		if(!this.head) {
			return null;
		}
		let counter = 0;
		let node = this.head;
		while(node) {
			if(counter === index) {
				return node;
			}
			node = node.next;
			counter++;
		}
		return null;
	}

	insertAt(data, index) {
		if(!this.head) { //empty
			this.head = new Node(data);
			return;
		}
		if(index === 0) { //insert at the front of the head
			this.head = new Node(data, this.head);
			return;
		}
		let counter = 1;
		let previous  = this.head; //1st
		let node = this.head.next; //2nd
		while(node) {
			if(counter === index) { //insert between the head and next of the head
				previous.next = new Node(data, node);
				return;
			}
			previous = node;
			node = node.next;
			counter++;
		}
		previous.next = new Node(data, node); //insert at the next of the head as the end of the list
	}

	removeAt(index) {
		if(!this.head) {
			return;
		}
		let counter = 0;
		let node = this.head;
		while(node) {
			if(counter === index-1) {
				if(node.next) {
					return (node.next = node.next.next);
				} else {
					return (node.next = null);
				}
			}
			node = node.next;
			counter++;
		}
	}

	

	getLast() {
		if(!this.head) {
			return null;
		}
		let node = this.head;
		while(node.next) {
			node = node.next;
		}
		return node;
	}

	insertLast(data) {
		const last = this.getLast();
		if(last) {
			last.next = new Node(data);
			return last.next;
		} else {
			this.head = new Node(data);
			return this.head;
		}
	}

	removeLast() {
		if(!this.head) {//empty
			return;
		}
		if(!this.head.next){//only head
			this.head = null;
			return;
		}
		let pre = this.head; 
		let curr = this.head.next; // head, curr
		while(curr.next){ //head, curr, curr.next
			pre = curr;
			curr = curr.next;
		}
		pre.next = null; //head, curr=null
	}

	forEach(fn) {
		if(!this.head) {
			return null;
		}
		let node = this.head;
		while(node) {
			fn(node);
			node = node.next;
		}
	}

}

/**
2
midpoint
*/
function midpoint(list) {
	let slow = list.getFirst();
	let fast = list.getFirst();
	while(fast.next && fast.next.next) {
		slow = slow.next;
		fast = fast.next.next;
	}
	return slow;
}

/**
3
circular
*/
function circular(list) {
	let slow = list.getFirst();
	let fast = list.getFirst();

	while(fast.next && fast.next.next) {
		slow = slow.next;
		fast = fast.next.next;

		if(slow === fast) {
			return true;
		}
	}
	return false;
}

/**
4
fromlast
*/
function fromLast(list, n) {
	let slow = list.getFirst();
	let fast = list.getFirst();
	while(n>0) {
		fast = fast.next;
		n--;
	}
	while(fast.next) {
		slow = slow.next;
		fast = fast.next;
	}
	return slow;
}


/**
5
bst
*/
class BSTNode {
  constructor(data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  insert(data) {
  	if(data<this.data && this.left) {
  		this.left.insert(data);
  	} else if (data < this.data) {
  		this.left = new Node(data);
  	} else if (data > this.data && this.right) {
  		this.right.insert(data);
  	} else if (data > this.data) {
  		this.right = new Node(data);
  	}
  }

  contains(data) {
  	if(this.data === data) {
  		return this;
  	}
  	if(this.data < data && this.right) {
  		return this.right.contains(data);
  	} else if (this.data > data && this.left) {
  		return this.left.contains(data);
  	}
  	return null;
  }
}

/**
6
validate bst
*/
function validateBST(node, min=null, max=null) {
	if(max !== null && node.data > max) {
		return false;
	}
	if(min !== null && node.data < min) {
		return false;
	}
	if(node.left && !validateBST(node.left, min, node.data)) {
		return false;
	}
	if(node.right && !validateBST(node.left, node.data, max)) {
		return false;
	}
	return true;
}

/**
7
levelwidth
*/
class TreeNode {
	constructor(data) {
		this.data = data;
		this.children = [];
	}

	add(data) {
		this.children.push(new Node(data));
	}

	remove(data) {
		this.children = this.children.filter(node => {
			return node.data != data;
		});
	}
}

function levelWidth(root) {
	const arr = [root, 's'];
	const counters = [0];
	while(arr.length >1){
		const node = arr.shift();
		if(node === 's'){
			counters.push(0);
			arr.push('s');
		} else {
			arr.push(...node.children);
			counters[counters.length-1]++;
		}
	}
	return counters;
}

class Tree {
	constructor() {
		this.root = null;
	}

	traverseBF(fn) {
		const arr= [this.root];
		while(arr.length) {
			const node = arr.shift();
			arr.push(...node.children);
			fn(node);
		}
	}

	traverseDF(fn) {
		const arr = [this.root];
		while(arr.length) {
			const node = arr.shift();
			arr.unshift(...node.children);
			fn(node);
		}
	}
}


/**
8
stack
*/
class Stack{
	constructor() {
		this.data = [];
	}

	push(record) {
		this.data.push(record);
	}

	pop(){
		return this.data.pop();
	}

	peek(){
		return this.data[this.data.length-1];
	}
}

/**
9
qfroms
*/

class QueueFromStack{
	constructor() {
		this.first = new Stack();
		this.second = new Stack();
	}

	add(record) {
		this.first.push(record);
	}

	remove(record) {
		while(this.first.peek()) {
			this.second.push(this.first.pop());
		}

		const record = this.second.pop();
		while(this.second.peek()) {
			this.first.push(this.second.pop());
		}
		return record;
	}

	peek() {
		while(this.first.peek()) {
			this.second.push(this.first.pop());
		}
		const record = this.second.peek();
		while(this.second.peek()) {
			this.first.push(this.second.pop());
		}
		return record;
	}
}

/**
10
queue
*/
class Queue {
	constructor() {
		this.data = [];
	}
	add(record) {
		this.data.unshift(record);
	}
	remove() {
		return this.data.pop();
	}
}

/**
11
weav
*/
function weave(sourceOne, sourceTwo) {
	const q = new Queue();
	while(sourceOne.peek() || sourceTwo.peek()) {
		if(sourceOne.peek()) {
			q.add(sourceOne.remove());
		}
		if(sourceTwo.peek()) {
			q.add(sourceTwo.remove());
		}
	}
	return q;
}


/**
1
sorting
*/
function bubbleSort(arr) {
	for(let i=0; i<arr.length; i++) {
		for(let j=0; j<arr.length-i-1; j++) {
			if(arr[j] > arr[j+1]) {
				const lesser = arr[j+1];
				arr[j+1] = arr[j];
				arr[j] = lesser;
			}
		}
	}
	return arr;
}


function selectionSort(arr) {
	for(let i=0; i< arr.length; i++) {
		let indexOfMin = i;
		for(let j=i+1; j<arr.length; j++) {
			if(arr[j] < arr[indexOfMin]){
				indexOfMin = j;
			}
		}
		if(indexOfMin !== i) {
			let lesser = arr[indexOfMin];
			arr[indexOfMin] = arr[i];
			arr[i] = lesser;
		}
	}
	return arr;
}

function mergeSort(arr) {
	if(arr.length === 1) {
		return arr;
	}
	const center = Math.floor(arr.length/2);
	const left = arr.slice(0, center);
	const right = arr.slice(center);
	return merge(mergeSort(left), mergeSort(right));
}

function merge(left, right) {
	const results = [];
	while(left.length && right.length) {
		if(left[0] < right[0]) {
			results.push(left.shift());
		} else {
			results.push(right.shift());
		}
	}
	return [...results, ...left, ...right];
}

/**
2
events
*/
class Events {
	constructor() {
		this.events = {};
	}

	on(eventName, callback) {
		if(this.events[eventName]) {
			this.events[eventName].push(callback);
		} else {
			this.events[eventName] = [callback];
		}
	}

	trigger(eventName) {
		if(this.events[eventName]) {
			for(let cb of this.events[eventName]) {
				cb();
			}
		}
	}

	off(eventName) {
		delete this.events[eventName];
	}
}










