const cookieArr = document.cookie.split("=");
const userId = cookieArr[1];
const loginButton = document.getElementById(`login-nav`);
const logoutButton = document.getElementById(`logout-nav`);
const profileButton = document.getElementById(`profile-nav`);
const packContainer = document.getElementById(`pack-container`);
const beerSlots = document.getElementsByClassName(`beer-slot`);
const addButtons = document.getElementsByClassName(`cart`);
const addButtonTexts = document.getElementsByClassName(`txt`);
const cardsWrapper = document.getElementById(`cards-wrapper`);

const baseUrl = "http://localhost:8080/api/v1"
let currentPack;

function renderPackDisplay(){
    axios.get(`${baseUrl}/beers/getbeersbypack/${currentPack}`)
    .then(res => {
        console.log("beers: ")
        console.log(res.data)
        console.log(beerSlots)
        for (let i = 0; i < res.data.length; i++){
            let beerIcon = document.createElement("img");
            beerIcon.src = "https://static.vecteezy.com/system/resources/previews/024/864/595/non_2x/beer-glass-icon-free-png.png";
            beerIcon.classList.add("beer-icon");
            beerIcon.setAttribute("beerId", res.data[i].id)
            beerIcon.addEventListener("click", handleRemove);
            packContainer.replaceChild(beerIcon ,beerSlots[0])
        }
    })
}

function increaseRenderDisplay(id){
    axios.get(`${baseUrl}/beers/getbeersbypack/${currentPack}`)
    .then(res => {
        console.log("beers: ")
        console.log(res.data)
        console.log(beerSlots)
        console.log("add buttons: ")
        console.log(addButtons)
        console.log(addButtonTexts)
        if (res.data.length > 5){
            for (let i = 0; i < addButtons.length; i++){
                addButtonTexts[i].textContent = "Pack is currently full!";
                addButtons[i].removeEventListener("click", handleClick);
            }
        }
        let beerIcon = document.createElement("img");
        beerIcon.src = "https://static.vecteezy.com/system/resources/previews/024/864/595/non_2x/beer-glass-icon-free-png.png";
        beerIcon.classList.add("beer-icon");
        beerIcon.setAttribute("beerId", id)
        beerIcon.addEventListener("click", handleRemove);
        packContainer.replaceChild(beerIcon ,beerSlots[0])
    })
}

function decreaseRenderDisplay(beer){
    console.log("beer to remove:")
    console.log(beer)
    axios.get(`${baseUrl}/beers/getbeersbypack/${currentPack}`)
    .then(res => {
        console.log("beers: ")
        console.log(res.data)
        console.log(beerSlots)
        console.log("add buttons: ")
        console.log(addButtons)
        console.log(addButtonTexts)
        if (addButtonTexts[0].textContent === "Pack is currently full!"){
            for (let i = 0; i < addButtons.length; i++){
                addButtonTexts[i].textContent = "Add to pack";
                addButtons[i].addEventListener("click", handleClick);
            }
        }
        let beerSlot = document.createElement("span");
        beerSlot.classList.add("beer-slot");
        packContainer.replaceChild(beerSlot, beer)
    })
}

const checkAuth = () => {
    if (!userId){
        loginButton.style.display = `inline`;
        logoutButton.style.display = `none`;
        profileButton.style.display = `none`;
    }
    else{
        loginButton.style.display = `none`;
        logoutButton.style.display = `inline`;
        profileButton.style.display = `inline`;
        axios.get(`${baseUrl}/packs/getpacks/${userId}`)
        .then(res => {
            console.log(res.data)
            if(!res.data.length){
                axios.post(`${baseUrl}/packs/add/${userId}`)
                .then(() => {
                    axios.get(`${baseUrl}/packs/getpacks/${userId}`)
                    .then(res2 => {
                        console.log(res2)
                        currentPack = res2.data[0].id;
                        console.log("first currentPack: " + currentPack)
                        renderPackDisplay();
                    })
                })
            }
            else{
                for (let i = 0; i < res.data.length; i++){
                    if(res.data[i].active){
                        currentPack = res.data[i].id;
                        console.log("existing currentPack: " + currentPack)
                        renderPackDisplay();
                    }
                }
            }
        })
    }
}

function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
    window.location.href = `./login.html`;
}

const handleClick = e => {
    e.preventDefault();
    console.log(e.currentTarget.getAttribute("beerId"));
    let beerId = e.currentTarget.getAttribute("beerId");
    axios.post(`${baseUrl}/packs/addbeer/${currentPack}/${beerId}`)
    .then(() => {
        console.log("beer added")
        increaseRenderDisplay(beerId);
    })
}

const handleRemove = e => {
    console.log(e.currentTarget.getAttribute("beerId"))
    let beerId = e.currentTarget.getAttribute("beerId");
    let beerIcon = e.currentTarget;
    console.log("beerIcon here:")
    console.log(beerIcon);
    axios.delete(`${baseUrl}/packs/removebeer/${currentPack}/${beerId}`)
        .then(() => {
            console.log("beer removed")
            console.log("beerIcon there:")
            console.log(beerIcon)
            decreaseRenderDisplay(beerIcon);
        })
}

function populateBeers(){
    axios.get(`${baseUrl}/beers/getbeers`)
    .then(res => {
        for (let i = 0; i < res.data.length; i++){
                let containerPageWrapper = document.createElement("div");
                cardsWrapper.appendChild(containerPageWrapper);
                let pageInner = document.createElement("div");
                pageInner.classList.add("page-inner");
                containerPageWrapper.appendChild(pageInner);
                let row = document.createElement("div");
                row.classList.add("row");
                pageInner.appendChild(row);
                let elWrapper = document.createElement("div");
                elWrapper.classList.add("el-wrapper");
                row.appendChild(elWrapper);
                let boxUp = document.createElement("div");
                boxUp.classList.add("box-up");
                elWrapper.appendChild(boxUp);
                let img = document.createElement("img");
                img.classList.add("img");
                img.src = res.data[i].image;
                img.alt = "";
                boxUp.appendChild(img);
                let imgInfo = document.createElement("div");
                imgInfo.classList.add("img-info");
                boxUp.appendChild(imgInfo);
                let infoInner = document.createElement("div");
                infoInner.classList.add("info-inner");
                imgInfo.appendChild(infoInner);
                let pName = document.createElement("span");
                pName.classList.add("p-name");
                pName.textContent = res.data[i].name;
                infoInner.appendChild(pName);
                let boxDown = document.createElement("div");
                boxDown.classList.add("box-down");
                elWrapper.appendChild(boxDown);
                let hBg = document.createElement("div");
                hBg.classList.add("h-bg");
                boxDown.appendChild(hBg);
                let hBgInner = document.createElement("div");
                hBgInner.classList.add("h-bg-inner");
                hBg.appendChild(hBgInner);
                let cart = document.createElement("a");
                cart.classList.add("cart");
                cart.setAttribute("beerId", res.data[i].id);
                cart.addEventListener("click", handleClick);
                boxDown.appendChild(cart);
                let price = document.createElement("span");
                price.classList.add("price");
                price.textContent = res.data[i].price;
                cart.appendChild(price);
                let addToCart = document.createElement("span");
                addToCart.classList.add("add-to-cart");
                cart.appendChild(addToCart);
                let txt = document.createElement("span");
                txt.classList.add("txt");
                txt.textContent = "Add to pack";
                addToCart.appendChild(txt);
            }
    })
}

checkAuth();
populateBeers();

logoutButton.addEventListener(`click`, handleLogout)