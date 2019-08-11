// --- Directions
// Given a string, return true if the string is a palindrome
// or false if it is not.  Palindromes are strings that
// form the same word if it is reversed. *Do* include spaces
// and punctuation in determining if the string is a palindrome.
// --- Examples:
//   palindrome("abba") === true
//   palindrome("abcdefg") === false

// function palindrome(str) {
//   const arr = str.split("");
//   for (let i = 0; i < str.length; i++) {
//     if (arr[i] !== arr[str.length - i - 1]) {
//       return false;
//     }
//   }
//   return true;
// }

function palindrome(str) {
  return str.split("").every((char, i) => char === str[str.length - 1 - i]);
}

console.log(palindrome("abcba"));

module.exports = palindrome;

// function palindrome(str) {
//   const reversed = str
//     .split('')
//     .reverse()
//     .join('');
//
//   return str === reversed;
// }
