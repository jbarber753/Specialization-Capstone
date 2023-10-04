const cookieArr = document.cookie.split("=");
const userId = cookieArr[1];
const loginButton = document.getElementById(`login-nav`);
const logoutButton = document.getElementById(`logout-nav`);
const profileButton = document.getElementById(`profile-nav`);
const topWrapper = document.getElementById(`top-wrapper`);

const baseUrl = "http://localhost:8080/api/v1"

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
    }
}

function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
    window.location.href = `./login.html`;
}

function populatePastPacks(){
    console.log("i'll be your roundabout")
    axios.get(`${baseUrl}/packs/getpacks/${userId}`)
    .then(res => {
        console.log(res)
        for (let i = 0; i < res.data.length; i++){
            if (res.data[i].active === "false"){
                let subHeader = document.createElement("h1");
                subHeader.textContent = `Order #${res.data[i].id}`;
                subHeader.classList.add("sub-header");
                topWrapper.appendChild(subHeader);
                let cardsWrapper = document.createElement("div");
                cardsWrapper.classList.add("cards-wrapper");
                topWrapper.appendChild(cardsWrapper);
                axios.get(`${baseUrl}/beers/getbeersbypack/${res.data[i].id}`)
                .then(res2 => {
                    console.log(res2)
                    for (let j = 0; j < res2.data.length; j++){
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
                        img.src = res2.data[j].image;
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
                        pName.textContent = res2.data[j].name;
                        infoInner.appendChild(pName);
//                        let boxDown = document.createElement("div");
//                        boxDown.classList.add("box-down");
//                        elWrapper.appendChild(boxDown);
//                        let hBg = document.createElement("div");
//                        hBg.classList.add("h-bg");
//                        boxDown.appendChild(hBg);
//                        let hBgInner = document.createElement("div");
//                        hBgInner.classList.add("h-bg-inner");
//                        hBg.appendChild(hBgInner);
//                        let cart = document.createElement("a");
//                        cart.classList.add("cart");
//                        cart.setAttribute("beerId", res2.data[i].id);
//                        cart.setAttribute("beerName", res2.data[i].name);
//                        boxDown.appendChild(cart);
//                        let price = document.createElement("span");
//                        price.classList.add("price");
//                        price.textContent = res2.data[i].price;
//                        cart.appendChild(price);
//                        let addToCart = document.createElement("span");
//                        addToCart.classList.add("add-to-cart");
//                        cart.appendChild(addToCart);
//                        let txt = document.createElement("span");
//                        txt.classList.add("txt");
//                        txt.textContent = "Add to pack";
//                        addToCart.appendChild(txt);
                    }
                })
            }
        }
    })
}

checkAuth();
populatePastPacks();

logoutButton.addEventListener(`click`, handleLogout)