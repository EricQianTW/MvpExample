package com.joker.example.enums;

import com.ToxicBakery.viewpager.transforms.AccordionTransformer;
import com.ToxicBakery.viewpager.transforms.BackgroundToForegroundTransformer;
import com.ToxicBakery.viewpager.transforms.CubeInTransformer;
import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.ToxicBakery.viewpager.transforms.DefaultTransformer;
import com.ToxicBakery.viewpager.transforms.DepthPageTransformer;
import com.ToxicBakery.viewpager.transforms.FlipHorizontalTransformer;
import com.ToxicBakery.viewpager.transforms.FlipVerticalTransformer;
import com.ToxicBakery.viewpager.transforms.ForegroundToBackgroundTransformer;
import com.ToxicBakery.viewpager.transforms.RotateDownTransformer;
import com.ToxicBakery.viewpager.transforms.RotateUpTransformer;
import com.ToxicBakery.viewpager.transforms.StackTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomInTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomOutTranformer;

/**
 * Created by eric_qiantw on 16/4/22.
 */
public enum TransformerEnum {
    Default(DefaultTransformer.class.getSimpleName()),

    Accordion(AccordionTransformer.class.getSimpleName()),
    BackgroundToForeground(BackgroundToForegroundTransformer.class.getSimpleName()),
    CubeIn(CubeInTransformer.class.getSimpleName()),
    CubeOut(CubeOutTransformer.class.getSimpleName()),
    DepthPage(DepthPageTransformer.class.getSimpleName()),
    FlipHorizontal(FlipHorizontalTransformer.class.getSimpleName()),
    FlipVertical(FlipVerticalTransformer.class.getSimpleName()),
    ForegroundToBackground(ForegroundToBackgroundTransformer.class.getSimpleName()),
    RotateDown(RotateDownTransformer.class.getSimpleName()),
    RotateUp(RotateUpTransformer.class.getSimpleName()),
    Stack(StackTransformer.class.getSimpleName()),
    ZoomIn(ZoomInTransformer.class.getSimpleName()),
    ZoomOut(ZoomOutTranformer.class.getSimpleName());

    private String transformerName;

    TransformerEnum(String transformerName) {
        this.transformerName = transformerName;
    }
}
