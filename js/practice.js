//nodemon --quiet js/practice.js



//anagrams1
function anagrams1(strA, strB) {
	return cleanStr(strA) === cleanStr(strB);
}

function cleanStr(str) {
	return str.replace(/[^\w]/g,'').toLowerCase().split('').sort().join('');
}

console.log(anagrams1('strA', 'strA'));
//anagrams2
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

console.log(anagrams2('strA', 'strv'));

//bst
class Node {
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
//capitalize

//chunk

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













