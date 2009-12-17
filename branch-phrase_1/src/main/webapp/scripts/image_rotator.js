
/* This script and many more are available free online at
The JavaScript Source :: http://javascript.internet.com
Created by: Lee Underwood :: http://javascript.internet.com/ */

var bannerImg = new Array();
	  // Enter the names of the images below
	bannerImg[0]="/images/store_photo/DSCN0211.JPG";
	bannerImg[1]="/images/store_photo/DSCN0216.JPG";
	bannerImg[2]="/images/store_photo/DSCN0219.JPG";
	bannerImg[3]="/images/store_photo/DSCN0223.JPG";
	bannerImg[4]="/images/store_photo/DSCN0228.JPG";
	bannerImg[5]="/images/store_photo/DSCN0229.JPG";

var newBanner = 0;
var totalBan = bannerImg.length;

function cycleBan() {
  newBanner++;
  if (newBanner == totalBan) {
    newBanner = 0;
  }
  document.banner.src=bannerImg[newBanner];
  // set the time below for length of image display
  // i.e., "4*1000" is 4 seconds
  setTimeout("cycleBan()", 4*600);
}
window.onload=cycleBan;


