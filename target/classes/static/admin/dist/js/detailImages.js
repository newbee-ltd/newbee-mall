
var index = 0;

function showImages(leftOrRight) {
	var oImages = document.getElementsByClassName("js-gallery-thumbnails")[0];
	var oLeft = document.getElementById("left");
	var oRight = document.getElementById("right");
	var page1 = document.getElementById("page1");
	var page2 = document.getElementById("page2");
	var eles = document.getElementsByClassName("swiper-slide");
	var length = eles.length;
	var oCurrentX;
	if (leftOrRight === 'left') {
		index--;
		if (index === -1) {
			index = 0;
			oCurrentX = -410 * index;
			oImages.style.transform = "translate3d(" + oCurrentX + "px,0px,0px)";
			oLeft.className = "p-gallery_btn p-gallery_prev swiper-button-disabled";
			oRight.className = "p-gallery_btn p-gallery_next";
			page1.className = "swiper-pagination-bullet swiper-pagination-bullet-active";
			page2.className = "swiper-pagination-bullet";
		}
	} else {
		index++;
		if (index < length) {
			oCurrentX = -410 * index;
			oImages.style.transform = "translate3d(" + oCurrentX + "px,0px,0px)";
			oLeft.className = "p-gallery_btn p-gallery_prev";
			oRight.className = "p-gallery_btn p-gallery_next swiper-button-disabled";
			page1.className = "swiper-pagination-bullet";
			page2.className = "swiper-pagination-bullet swiper-pagination-bullet-active";
		}else {
			index = length - 1;
			oCurrentX = -410 * index;
			oImages.style.transform = "translate3d(" + oCurrentX + "px,0px,0px)";
			oLeft.className = "p-gallery_btn p-gallery_prev";
			oRight.className = "p-gallery_btn p-gallery_next swiper-button-disabled";
			page1.className = "swiper-pagination-bullet";
			page2.className = "swiper-pagination-bullet swiper-pagination-bullet-active";

		}

	}

}