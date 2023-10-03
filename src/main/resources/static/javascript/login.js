const loginSwitch = document.getElementById(`login-switch`);
const registerSwitch = document.getElementById(`register-switch`);
const loginForm = document.getElementById(`login-form`);
const registerForm = document.getElementById(`register-form`);

const baseUrl = 'http://localhost:8080/api/v1/users'

const register = body => {
    axios.post(`${baseUrl}/register`, body)
    .then(res => {
        document.cookie = `userId=${res.data[0]}`
        window.location.href = `./home.html`
    })
    .catch(error => alert(error.message))
}

const login = body => {
    axios.post(`${baseUrl}/login`, body)
    .then(res => {
        if(res.data.length > 1){
            alert(res.data[0])
        }
        else{
            document.cookie = `userId=${res.data[0]}`
            window.location.href = `./home.html`;
        }
    })
    .catch(error => alert(error.message))
}

const handleRegister = event => {
    event.preventDefault();
    let username = document.getElementById(`new-username`);
    let password = document.getElementById(`new-password`);
    let confirmPassword = document.getElementById(`confirm-password`);
    let newUser = {
        username: username.value,
        password: password.value
    }
    if (password.value !== confirmPassword.value){
        alert(`Password and Confirm Password must match!`)
    }
    else{
        register(newUser);
    }
    username.value = '';
    password.value = '';
    confirmPassword.value = '';
}

const handleLogin = event => {
    event.preventDefault();
    let username = document.getElementById(`username`);
    let password = document.getElementById(`password`);
    let user = {
        username: username.value,
        password: password.value
    }
    login(user);
    username.value = '';
    password.value = '';
}

const handleSwitch = event => {
    if (event.target.id === `register-switch`){
        registerForm.style.display = `flex`;
        loginForm.style.display = `none`;
    }
    else{
        registerForm.style.display = `none`;
        loginForm.style.display = `flex`;
    }
}

loginSwitch.addEventListener(`click`, handleSwitch);
registerSwitch.addEventListener(`click`, handleSwitch);
registerForm.addEventListener(`submit`, handleRegister);
loginForm.addEventListener(`submit`, handleLogin);