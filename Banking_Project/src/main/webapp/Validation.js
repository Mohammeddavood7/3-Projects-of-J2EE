document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("frm").addEventListener("submit", function(event) {
        event.preventDefault();
        validatingGetParameter();
    });
});

function validatingGetParameter() {
    let valid = true;
    
    // Account number validation
    let account = document.getElementById("accountno");
    const acv = /^\d+$/;
    if (!acv.test(account.value) || account.value.trim() === "") {
        document.getElementById("accountnoError").innerHTML = `<center><i>ACCOUNT NO SHOULD BE DIGITS</i></center>`;
    } else {
        document.getElementById("accountnoError").innerText = "";
    }

    // Target account number validation
    let targetaccount = document.getElementById("targetaccount");
    const targetaccountV = /^\d+$/;
    if (!targetaccountV.test(targetaccount.value) || targetaccount.value.trim() === "") {
        document.getElementById("targetaccountnoError").innerHTML = `<center><i>ACCOUNT NO SHOULD BE DIGITS</i></center>`;
    } else {
        document.getElementById("targetaccountnoError").innerText = "";
    }

    // Username validation
    let uname = document.getElementById("uname");
    const unameValid = /^[a-zA-Z ]+$/;
    if (!unameValid.test(uname.value) || uname.value.trim() === "") {
        document.getElementById("unameError").innerHTML = `<center><i>USERNAME MUST BE IN ALPHABETS</i></center>`;
        valid = false;
    } else {
        document.getElementById("unameError").innerText = "";
    }

    // Password validation
    let pword = document.getElementById("pword");
    const password = /^\d{10}$/;
    if (!password.test(pword.value) || pword.value.trim() === "") {
        document.getElementById("pwordError").innerHTML = `<center><i>PASSWORD SHOULD BE 10 DIGITS NUMBER</i></center>`;
    } else {
        document.getElementById("pwordError").innerText = "";
    }

    // Confirm Password validation
    let rword = document.getElementById("rword");
    if (!password.test(rword.value) || rword.value.trim() === "") {
        document.getElementById("rwordError").innerHTML = `<center><i>RE-PASSWORD SHOULD BE 10 DIGITS NUMBER</i></center>`;
    } else {
        document.getElementById("rwordError").innerText = "";
    }

    // Password match validation
    if (pword.value !== rword.value) {
        document.getElementById("matchError").innerHTML = `<center><i>PASSWORD AND RE-PASSWORD SHOULD MATCH</i></center>`;
    } else {
        document.getElementById("matchError").innerText = "";
    }

    // Amount validation
    let amount1 = document.getElementById("amount");
    let parsAmount = parseFloat(amount1.value);
    const amountV = /^\d+$/;
    if (!amountV.test(amount1.value) || parsAmount <= 0) {
        document.getElementById("amountError").innerHTML = `<center><i>AMOUNT SHOULD BE A POSITIVE NUMBER</i></center>`;
    } else {
        document.getElementById("amountError").innerText = "";
    }

    // Address validation
    let address = document.getElementById("address");
    const addressV = /^[a-zA-Z ]+$/;
       if (!addressV.test(address.value) || address.value.trim() === "") {
           document.getElementById("addressError").innerHTML = `<center><i>ADDRESS MUST BE IN ALPHABETS</i></center>`;
       } else {
           document.getElementById("addressError").innerText = "";
       }

       // Phone number validation
       let phone = document.getElementById("phone");
       const phno = /^[6-9]\d{9}$/;
       if (!phno.test(phone.value) || phone.value.trim() === "") {
           document.getElementById("phoneError").innerHTML = `<center><i>INDIAN PHONE NUMBER MUST BE 10 DIGITS</i></center>`;
       } else {
           document.getElementById("phoneError").innerText = "";
       }

       if (valid) {
           document.getElementById("frm").submit();
       }
   }
