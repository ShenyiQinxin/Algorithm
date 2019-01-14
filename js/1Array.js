/**
anagrams
ex: anagrams('RAIL! SAFETY!', 'fairy tales') --> True
*/
function anagrams1(strA, strB) {
	return cleanStr(strA) === cleanStr(strB);
}

function cleanStr(str) {
	return str.replace(/[^\w]/g, '').toLowerCase()
	.split('').sort().join('');
}