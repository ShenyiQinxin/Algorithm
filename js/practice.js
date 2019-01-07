//nodemon --quiet js/practice.js



/**
anagrams1
*/
function anagrams1(strA, strB) {
	return cleanStr(strA) === cleanStr(strB);
}

function cleanStr(str) {
	return str.replace(/[^\w]/g,'').toLowerCase().split('').sort().join('');
}

//console.log(anagrams1('strA', 'strA'));

/**
anagrams2
*/
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
function buildCharMap(str) {
	const charMap = {};
	for(let char of str.replace(/[^\w]/g,'').toLowerCase()){
		charMap[char] = charMap[char]+1 || 1;
	}
	return charMap;
}

//console.log(anagrams2('strA', 'strv'));


/**
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
capitalize1
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

/**
capitalize2
*/
function capitalize2(str) {
	const words = [];
	for(let w of str.split(' ')){
		words.push(w[0].toUpperCase()+w.slice(1));
	}
	return words.join(' ')
}
//console.log(capitalize2('abc abc abc'));

/**
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
console.log(chunk([1,2,3,4],2));

/**
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

	removeFirst() {
		if(!this.head) {
			return;
		}
		this.head = this.head.next;
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

	getFirst() {
		return this.head;
	}

	insertFirst(data) {
		this.head = new Node(data, this.getFirst());
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

/**circular
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

//events

//fib
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

console.log();
//fizzbuzz

//fromlast
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
//levelwidth
class TreeNode {
	constructor(data) {
		this.data = data;
		this.children = [];
	}

	add(data) {
		this.children.push(new Node(data));
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


//matrix
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

//maxchar
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
console.log(maxChar("cabcaabc"));

//pyramid
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

pyramid(3);

/**
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

class Queue{
	constructor() {
		this.first = new Stack();
		this.second = new Stack();
	}

	add(record) {
		this.first.push(record);
	}
}


/**
qfroms
*/

//queue

//reverseint

//reversestring

//sorting

//stack

//steps


//tree

//validate

//vowels

//weave













