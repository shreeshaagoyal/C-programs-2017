window.onload = function() {

    var imageUrls = getImageUrls();

    var currIndex;

    var slideshowButton = document.getElementById("slideShowButton");

    var slideshowHandle;

    PhotoGalleryLib.onSizeClassChange(sizeChangeArg);

    function sizeChangeArg(size) {
        console.log(size);
        var parent = deleteImagesGrid();
        var imagesGrid = PhotoGalleryLib.generateGrid(imageUrls, size);
        insertImagesGrid(parent, imagesGrid);
    }

    function deleteImagesGrid() {
        var imagesGrid = document.getElementById("imagesGrid");
        var parent = imagesGrid.parentNode;
        if (imagesGrid) {
            imagesGrid.parentNode.removeChild(imagesGrid);
        }
        return parent;
    }

    function insertImagesGrid(parent, imagesGrid) {
        parent.appendChild(imagesGrid);
    }

    function getImageUrls() {
        var urls = [src="./images/image1.jpg",
                    src="./images/image2.jpg",
                    src="./images/image3.jpg",
                    src="./images/image4.jpg",
                    src="./images/image5.jpg",
                    src="./images/image6.jpg",
                    src="./images/image7.jpg",
                    src="./images/image8.jpg"];
        return urls;
    }

    PhotoGalleryLib.addImageClickHandlers(function(index) {
        currIndex = index;
        PhotoGalleryLib.openPresentationModal();
        PhotoGalleryLib.setModalImgSrc(imageUrls[currIndex]);
    });

    PhotoGalleryLib.createModal();

    PhotoGalleryLib.initModal(function() {
        // Close button handler
        PhotoGalleryLib.closePresentationModal();
        clearInterval(slideshowHandle);
    }, function() {
        // Previous button handler
        decrementIndex();
        PhotoGalleryLib.setModalImgSrc(imageUrls[currIndex]);
        clearInterval(slideshowHandle);
    }, function() {
        // Next button handler
        incrementIndex();
        PhotoGalleryLib.setModalImgSrc(imageUrls[currIndex]);
        clearInterval(slideshowHandle);
    });

    function incrementIndex() {
        if (currIndex < imageUrls.length - 1) {
            currIndex++;
        }
    }

    function decrementIndex() {
        if (currIndex > 0) {
            currIndex--;
        }
    }

    function incrementIndexPresentation() {
        if(currIndex == imageUrls.length - 1) { currIndex = 0; }
        else { currIndex++; }
    }

    slideshowButton.onclick = function() {
        // Initializes slideshow
        PhotoGalleryLib.openPresentationModal();
        startSlideShow();
    }

    function startSlideShow() {
        currIndex = 0;
        console.log("Slideshow started");
        function showNextImage() {
            console.log("currIndex: " + currIndex);
            PhotoGalleryLib.setModalImgSrc(imageUrls[currIndex]);
            incrementIndexPresentation();
            slideshowHandle = setTimeout(showNextImage, 1000);
        }
        showNextImage();
    }
}