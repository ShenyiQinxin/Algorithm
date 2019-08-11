// --- Directions
// Given a string, return a new string with the reversed
// order of characters
// --- Examples
//   reverse('apple') === 'leppa'
//   reverse('hello') === 'olleh'
//   reverse('Greetings!') === '!sgniteerG'

// function reverse(str) {
//   return str
//     .split("")
//     .reverse()
//     .join("");
// }

//console.log(reverse("abcd"));
function reverse(str) {
  debugger;
  return str.split("").reduce((reversed, char) => char + reversed, "");
}
reverse("abcd");
module.exports = reverse;

// function reverse(str) {
//   return str
//     .split('')
//     .reverse()
//     .join('');
// }

// function reverse(str) {
//   let reversed = "";
//   for (let i of str) {
//     reversed = i + reversed;
//   }
//   return reversed;
// }
