// --- Directions
// Given a string, return the character that is most
// commonly used in the string.
// --- Examples
// maxChar("abcccccccd") === "c"
// maxChar("apple 1231111") === "1"

function maxChar(str) {
  const charMap = {};
  let count = 0;
  let maxChar = "";

  //for o
  for (const char of str) {
    charMap[char] = charMap[char] + 1 || 1;
  }
  for (const char in charMap) {
    if (charMap[char] > count) {
      count = charMap[char];
      maxChar = char;
    }
  }
  return maxChar;
}

console.log(maxChar("abcccccccd"));
module.exports = maxChar;
