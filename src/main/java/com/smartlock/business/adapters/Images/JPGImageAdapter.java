package com.smartlock.business.adapters.Images;

import com.smartlock.business.adapters.ImageAdapter;
import com.smartlock.business.processors.JPGImageProcessor;

public class JPGImageAdapter implements ImageAdapter {

    private JPGImageProcessor jpgImageProcessor;

    public JPGImageAdapter(JPGImageProcessor jpgImageProcessor) {
        this.jpgImageProcessor = jpgImageProcessor;
    }

    @Override
    public void processImage(String imagePath) {
        System.out.println("Processando imagem de perfil: " + imagePath);
        jpgImageProcessor.processJPG(imagePath);
    }
}
