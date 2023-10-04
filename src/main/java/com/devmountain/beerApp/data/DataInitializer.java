package com.devmountain.beerApp.data;

import com.devmountain.beerApp.entities.Beer;
import com.devmountain.beerApp.repositories.BeerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    @Autowired
    BeerRepository beerRepository;

    @PostConstruct
    public void initializeData(){
        Beer beer1 = new Beer();
        beer1.setName("Pabst Blue Ribbon");
        beer1.setImage("https://www.luekensliquors.com/wp-content/uploads/2018/10/175958-PABST-BLUE-RIBBON-16OZ-4PK-CN.png");
        beer1.setPrice("$5");
        beerRepository.save(beer1);

        Beer beer2 = new Beer();
        beer2.setName("Coors Banquet");
        beer2.setImage("https://www.coors.com/sites/coorsbanquetus/files/2022-05/stubby-min.png");
        beer2.setPrice("$5");
        beerRepository.save(beer2);

        Beer beer3 = new Beer();
        beer3.setName("Heineken");
        beer3.setImage("https://static.wixstatic.com/media/e3be16_9e991b2ac6324d75a84785251e584924~mv2.png/v1/fill/w_550,h_1550,al_c,q_90,enc_auto/e3be16_9e991b2ac6324d75a84785251e584924~mv2.png");
        beer3.setPrice("$4");
        beerRepository.save(beer3);

        Beer beer4 = new Beer();
        beer4.setName("Budweiser");
        beer4.setImage("https://www.pngmart.com/files/23/Budweiser-PNG-Photo.png");
        beer4.setPrice("$4");
        beerRepository.save(beer4);

        Beer beer5 = new Beer();
        beer5.setName("Miller High Life");
        beer5.setImage("https://www.millerhighlife.com/sites/millerhighlife/files/2019-11/MHL_beer.png");
        beer5.setPrice("$4");
        beerRepository.save(beer5);

        Beer beer6 = new Beer();
        beer6.setName("Corona Extra");
        beer6.setImage("https://www.coronausa.com/cdn/shop/files/corona-extra-menu_300x.png?v=1614355250");
        beer6.setPrice("$5");
        beerRepository.save(beer6);

        Beer beer7 = new Beer();
        beer7.setName("Blue Moon");
        beer7.setImage("https://www.bluemoonbrewingcompany.com/sites/bluemoon/files/styles/beers/public/beers/2022-03/BMBW_V2_320x464.png?itok=VcLof-Ky");
        beer7.setPrice("$6");
        beerRepository.save(beer7);

        Beer beer8 = new Beer();
        beer8.setName("Guinness Draught");
        beer8.setImage("https://gulp-project-assets.imgix.net/3208194983-guinness-btl-beer-import.png?fit=clip&w=595&h=935");
        beer8.setPrice("$6");
        beerRepository.save(beer8);

        Beer beer9 = new Beer();
        beer9.setName("Yuengling");
        beer9.setImage("https://www.decrescente.com/wp-content/uploads/2022/05/lager-bottle-lg-1.png");
        beer9.setPrice("$5");
        beerRepository.save(beer9);

        Beer beer10 = new Beer();
        beer10.setName("Rolling Rock");
        beer10.setImage("https://www.brewmuseum.com/wp-content/uploads/rolling-rock.png");
        beer10.setPrice("$4");
        beerRepository.save(beer10);

        Beer beer11 = new Beer();
        beer11.setName("Modelo Especial");
        beer11.setImage("https://www.missionliquor.com/cdn/shop/products/Modelo_Especial_32Oz_600x.png?v=1578347090");
        beer11.setPrice("$6");
        beerRepository.save(beer11);

        Beer beer12 = new Beer();
        beer12.setName("Guinness Extra Stout");
        beer12.setImage("https://www.luekensliquors.com/wp-content/uploads/2018/10/552-GUINNESS-EXTRA-STOUT.png");
        beer12.setPrice("$6");
        beerRepository.save(beer12);

        Beer beer13 = new Beer();
        beer13.setName("Dos Equis");
        beer13.setImage("https://dosequis.com/wp-content/uploads/dos-equis-lager-especial-bottle-001-1.png");
        beer13.setPrice("$5");
        beerRepository.save(beer13);

        Beer beer14 = new Beer();
        beer14.setName("Stella Artois");
        beer14.setImage("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/StellaGlobalBottle-NoReflection-master-cerveza-bavaria.png/800px-StellaGlobalBottle-NoReflection-master-cerveza-bavaria.png");
        beer14.setPrice("$4");
        beerRepository.save(beer14);

        Beer beer15 = new Beer();
        beer15.setName("Modelo Negra");
        beer15.setImage("https://www.billsdist.com/images/products/negromodelo-3.png?1474388545");
        beer15.setPrice("$6");
        beerRepository.save(beer15);

        Beer beer16 = new Beer();
        beer16.setName("Samuel Adams Boston Lager");
        beer16.setImage("https://149474836.v2.pressablecdn.com/wp-content/uploads/2020/08/bev-bottle-sam-adams.png");
        beer16.setPrice("$5");
        beerRepository.save(beer16);

        Beer beer17 = new Beer();
        beer17.setName("Shiner Bock");
        beer17.setImage("https://www.decrescente.com/wp-content/uploads/2022/04/bock-bottle-lg-5.png");
        beer17.setPrice("$5");
        beerRepository.save(beer17);

        Beer beer18 = new Beer();
        beer18.setName("Foster's Lager");
        beer18.setImage("https://www.totalwine.com/dynamic/490x/media/sys_master/twmmedia/h2a/h22/11941480988702.png");
        beer18.setPrice("$4");
        beerRepository.save(beer18);

        Beer beer19 = new Beer();
        beer19.setName("Kirin");
        beer19.setImage("https://www.coors.com/sites/coorsbanquetus/files/2022-05/stubby-min.png");
        beer19.setPrice("$5");
        beerRepository.save(beer19);

        Beer beer20 = new Beer();
        beer20.setName("St. Pauli Girl");
        beer20.setImage("https://www.decrescente.com/wp-content/uploads/2022/04/st-pauli-girl-bottle-lg-5.png");
        beer20.setPrice("$6");
        beerRepository.save(beer20);

        Beer beer21 = new Beer();
        beer21.setName("Hoegaarden");
        beer21.setImage("https://www.africaneasternauh.com/media/catalog/product/9/0/90220034_1.png");
        beer21.setPrice("$6");
        beerRepository.save(beer21);

        Beer beer22 = new Beer();
        beer22.setName("Foster's Ale");
        beer22.setImage("https://bonddist.com/wp-content/uploads/2017/12/0_26404627__cg_png.png");
        beer22.setPrice("$4");
        beerRepository.save(beer22);

        Beer beer23 = new Beer();
        beer23.setName("Fat Tire");
        beer23.setImage("https://d3czfiwbzom72b.cloudfront.net/wp-content/uploads/2018/06/NEW-BELGIUM-FAT-TIRE-22OZ-NR-22OZ-Beer.png");
        beer23.setPrice("$6");
        beerRepository.save(beer23);

        Beer beer24 = new Beer();
        beer24.setName("Beck's");
        beer24.setImage("https://bellbeverage.com/wp-content/uploads/2020/02/Screen-Shot-2020-05-22-at-4.54.20-PM.png");
        beer24.setPrice("$5");
        beerRepository.save(beer24);

        Beer beer25 = new Beer();
        beer25.setName("Amstel");
        beer25.setImage("https://www.pngkey.com/png/full/835-8351191_amstel-beer-bottle-330ml-x24-amstel-beer-bottle.png");
        beer25.setPrice("$5");
        beerRepository.save(beer25);

        Beer beer26 = new Beer();
        beer26.setName("Peroni");
        beer26.setImage("https://www.luekensliquors.com/wp-content/uploads/2018/10/58283-PERONI-NASTRO-AZZURRO.png");
        beer26.setPrice("$4");
        beerRepository.save(beer26);

        Beer beer27 = new Beer();
        beer27.setName("Sapporo");
        beer27.setImage("https://sapporobeer.com/assets/Uploads/product-premiumbeer12oz-bottle.png");
        beer27.setPrice("$5");
        beerRepository.save(beer27);

        Beer beer28 = new Beer();
        beer28.setName("Grolsch");
        beer28.setImage("https://www.birraperoni.it/wp-content/uploads/2021/06/Grolsch.png");
        beer28.setPrice("$6");
        beerRepository.save(beer28);

        Beer beer29 = new Beer();
        beer29.setName("Pilsner Urquell");
        beer29.setImage("https://www.luekensliquors.com/wp-content/uploads/2018/10/2169-PILSNER-URQUELL.png");
        beer29.setPrice("$6");
        beerRepository.save(beer29);

        Beer beer30 = new Beer();
        beer30.setName("Weihenstephaner");
        beer30.setImage("https://www.luekensliquors.com/wp-content/uploads/2018/10/588-WEIHENSTEPHANER-HEFE-WEISSBIER-w.png");
        beer30.setPrice("$6");
        beerRepository.save(beer30);
    }
}
