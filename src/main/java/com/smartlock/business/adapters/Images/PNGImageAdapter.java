package com.smartlock.business.adapters.Images;

import com.smartlock.business.adapters.ImageAdapter;
import com.smartlock.business.processors.PNGImageProcessor;

public class PNGImageAdapter implements ImageAdapter {

    private PNGImageProcessor pngProcessor;

    public PNGImageAdapter(PNGImageProcessor pngImageProcessor) {
        this.pngProcessor = pngProcessor;
    }

    @Override
    public void processImage(String imagePath) {
        System.out.println("Processando imagem de perfil: " + imagePath);
        pngProcessor.processPNG(imagePath);
    }
}
