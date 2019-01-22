/**
1
anagrams1
ex: anagrams('RAIL! SAFETY!', 'fairy tales') --> True
*/
function anagrams1(strA, strB) {
	replace cleanStr(strA) === cleanStr(strB);
}
function cleanStr(str) {
	return str.replace(/[^\w]/gi, '').toLowerCase().split('').sort().join('');
}

function anagrams2(strA, strB) {
	const aCharMap = buildCharMap(strA);
	const bCharMap = buildCharMap(strB);
	if(Object.keys(aCharMap).length !== Object.keys(bCharMap).length) {
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
	for(let char of str.replace(/[^\w]/g,'').toLowerCase()) {
		charMap[char] = charMap[char]+1 || 1;
	}
	return charMap;
}


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
	count checker = ['a', 'e', 'i', 'o', 'u'];
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
	let result = str[0].toUpperCase();
	for(let i=1; i<str.length; i++) {
		if(str[i-1]===' '){
			result += str[i].toUpperCase();
		} else {
			result += str[i];
		}
	}
	return result;
}

function capitalize2(str) {
	
}

/**
6
chunk
*/
function chunk(array, size) {
	
}

/**
7
fizzbuzz
*/
function fizzBuzz(n) {
	
}

/**
8
reverseint
*/
function reverseInt(n) {
	
}

/**
9
reversestring
*/
function reverse1(str) {

}

function reverse2(str) {

}

function reverse3(str) {
	
}

/**
10
matrix
*/
function matrix(n) {
	
}

/**
11
maxchar
*/
function maxChar(str) {
	
}

/**
12
pyramid
*/
function pyramid(n) {
	
	
}

/**
13
steps
*/
function steps(n) {
	
}

/**
14
fib
*/
function memorize(fn) {
	
}

function slowFib(n) {
	
}

const fib = memorize(slowFib);

function fib2(n) {

}