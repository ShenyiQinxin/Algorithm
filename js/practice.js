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
	}

}
//circular



//events

//fib

//fizzbuzz

//fromlast

//levelwidth

//linkedlist


//matrix

//maxchar

//midpoint

//palindrome

//pyramid

//qfroms

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













