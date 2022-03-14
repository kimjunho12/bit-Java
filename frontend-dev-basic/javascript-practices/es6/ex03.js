/**
 *  Template Literal
 */

let no = 10;
let name = "둘리";
let email = "dooly@gmail.com";

// ex1
console.log("no: " + no + ", name: " + name + ", email: " + email);
console.log(`no: ${no}, name: ${name}, email: ${email}`);

// ex2 : 다중행 지원
console.log("no: " + no + "\nname: " + name + "\nemail: " + email);
console.log(`no: ${no}
name: ${name}
email: ${email}`);
