package com.aliendroid.alienads;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.aliendroid.alienads.interfaces.natives.OnLoadMediumNativesAdmob;
import com.aliendroid.alienads.interfaces.natives.OnLoadMediumNativesAlien;
import com.aliendroid.alienads.interfaces.natives.OnLoadMediumNativesApplovinMax;
import com.aliendroid.alienads.interfaces.natives.OnLoadMediumNativesFacebook;
import com.aliendroid.alienads.interfaces.natives.OnLoadMediumNativesStartApp;
import com.aliendroid.alienads.interfaces.natives.OnLoadSmallNativesAdmob;
import com.aliendroid.alienads.interfaces.natives.OnLoadSmallNativesAlien;
import com.aliendroid.alienads.interfaces.natives.OnLoadSmallNativesApplovinMax;
import com.aliendroid.alienads.interfaces.natives.OnLoadSmallNativesFacebook;
import com.aliendroid.alienads.interfaces.natives.OnLoadSmallNativesStartApp;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.props.adsmanager.PropsAdsManagement;

public class AliendroidNative {
    private static NativeAd nativeAd;
    private static NativeAd nativeAdPropf;
    public static OnLoadSmallNativesAdmob onLoadSmallNativesAdmob;
    public static OnLoadSmallNativesApplovinMax onLoadSmallNativesApplovinMax;
    public static OnLoadSmallNativesFacebook onLoadSmallNativesFacebook;
    public static OnLoadSmallNativesStartApp onLoadSmallNativesStartApp;
    public static OnLoadSmallNativesAlien onLoadSmallNativesAlien;

    public static OnLoadMediumNativesAdmob onLoadMediumNativesAdmob;
    public static OnLoadMediumNativesApplovinMax onLoadMediumNativesApplovinMax;
    public static OnLoadMediumNativesFacebook onLoadMediumNativesFacebook;
    public static OnLoadMediumNativesStartApp onLoadMediumNativesStartApp;
    public static OnLoadMediumNativesAlien onLoadMediumNativesAlien;

    public static void SmallNativeAdmob(Activity activity, RelativeLayout layNative, String selectAdsBackup, String nativeId, String idNativeBackup, String Hpk1,
                                        String Hpk2, String Hpk3, String Hpk4, String Hpk5) {
        AdLoader.Builder builder = new AdLoader.Builder(activity, nativeId);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            @Override
            public void onNativeAdLoaded(@NonNull NativeAd nativeAds) {
                if (onLoadSmallNativesAdmob !=null){
                    onLoadSmallNativesAdmob.onNativeAdLoaded();
                }
                if (nativeAd != null) {
                    nativeAd.destroy();
                }

                nativeAd = nativeAds;
                NativeAdView adView = (NativeAdView) activity.getLayoutInflater()
                        .inflate(R.layout.admob_small_native, null);
                populateNativeAdView(nativeAds, adView);
                layNative.removeAllViews();
                layNative.addView(adView);
            }

        });

        VideoOptions videoOptions = new VideoOptions.Builder()
                .build();
        NativeAdOptions adOptions = new NativeAdOptions.Builder()
                .setVideoOptions(videoOptions)
                .build();
        builder.withNativeAdOptions(adOptions);

        AdRequest request = new AdRequest.Builder().addKeyword(Hpk1).addKeyword(Hpk2)
                .addKeyword(Hpk3).addKeyword(Hpk4).addKeyword(Hpk5)
                .build();
        AdLoader adLoader =
                builder
                        .withAdListener(
                                new AdListener() {
                                    @Override
                                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                                        if (onLoadSmallNativesAdmob !=null){
                                            onLoadSmallNativesAdmob.onAdFailedToLoad("");
                                        }
                                        if (selectAdsBackup.equals("ALIEN-M")){
                                            String getNativeId = PropsAdsManagement.getNativeAdsId(idNativeBackup);
                                            AdLoader.Builder builder3 = new AdLoader.Builder(activity, getNativeId);
                                            builder3.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                                                @Override
                                                public void onNativeAdLoaded(@NonNull NativeAd nativeAds) {
                                                    if (nativeAdPropf != null) {
                                                        nativeAdPropf.destroy();
                                                    }
                                                    nativeAdPropf = nativeAds;
                                                    NativeAdView adView = (NativeAdView) activity.getLayoutInflater()
                                                            .inflate(R.layout.admob_small_native, null);
                                                    populateNativeAdViewProps(nativeAds, adView);
                                                    layNative.removeAllViews();
                                                    layNative.addView(adView);
                                                }
                                            });
                                            VideoOptions videoOptions2 = new VideoOptions.Builder()
                                                    .build();
                                            NativeAdOptions adOptions2 = new NativeAdOptions.Builder()
                                                    .setVideoOptions(videoOptions2)
                                                    .build();
                                            builder3.withNativeAdOptions(adOptions2);
                                            AdRequest request2 = new AdRequest.Builder()
                                                    .build();
                                            AdLoader adLoader2 =
                                                    builder3
                                                            .withAdListener(
                                                                    new AdListener() {
                                                                        @Override
                                                                        public void onAdFailedToLoad(LoadAdError loadAdError) {

                                                                        }
                                                                    })
                                                            .build();
                                            adLoader2.loadAd(request2);
                                        }
                                    }
                                })
                        .build();
        adLoader.loadAd(request);

    }

    public static void SmallNativeMax(Activity activity, RelativeLayout layNative, String selectAdsBackup, String nativeId, String idNativeBackup) {

    }


    public static void SmallNativeFan(Activity activity, RelativeLayout layNative, String selectAdsBackup, String nativeId, String idNativeBackup) {

    }


    public static void SmallNativeStartApp(Activity activity, RelativeLayout layNative, String selectAdsBackup, String nativeId, String idNativeBackup) {
    }

    public static void MediumNativeStartApp(Activity activity, RelativeLayout layNative, String selectAdsBackup, String nativeId, String idNativeBackup) {

    }

    public static void MediumNativeAdmob(Activity activity, RelativeLayout layNative, String selectAdsBackup, String nativeId, String idNativeBackup, String Hpk1,
                                         String Hpk2, String Hpk3, String Hpk4, String Hpk5) {

        AdLoader.Builder builder = new AdLoader.Builder(activity, nativeId);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            @Override
            public void onNativeAdLoaded(@NonNull NativeAd nativeAds) {
                if (onLoadMediumNativesAdmob!=null){
                    onLoadMediumNativesAdmob.onNativeAdLoaded();
                }
                if (nativeAd != null) {
                    nativeAd.destroy();
                }
                nativeAd = nativeAds;
                NativeAdView adView = (NativeAdView) activity.getLayoutInflater()
                        .inflate(R.layout.admob_big_native, null);
                populateNativeAdView(nativeAds, adView);
                layNative.removeAllViews();
                layNative.addView(adView);
            }


        });

        VideoOptions videoOptions = new VideoOptions.Builder()
                .build();

        NativeAdOptions adOptions = new NativeAdOptions.Builder()
                .setVideoOptions(videoOptions)
                .build();

        builder.withNativeAdOptions(adOptions);

        AdRequest request = new AdRequest.Builder().addKeyword(Hpk1).addKeyword(Hpk2)
                .addKeyword(Hpk3).addKeyword(Hpk4).addKeyword(Hpk5)
                .build();
        AdLoader adLoader =
                builder
                        .withAdListener(
                                new AdListener() {
                                    @Override
                                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                                        if (onLoadMediumNativesAdmob!=null){
                                            onLoadMediumNativesAdmob.onAdFailedToLoad("");
                                        }
                                        if (selectAdsBackup.equals("ALIEN-M")){
                                            String getNativeId = PropsAdsManagement.getNativeAdsId(idNativeBackup);
                                            AdLoader.Builder builder3 = new AdLoader.Builder(activity, getNativeId);
                                            builder3.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                                                @Override
                                                public void onNativeAdLoaded(@NonNull NativeAd nativeAds) {
                                                    if (nativeAdPropf != null) {
                                                        nativeAdPropf.destroy();
                                                    }
                                                    nativeAdPropf = nativeAds;
                                                    NativeAdView adView = (NativeAdView) activity.getLayoutInflater()
                                                            .inflate(R.layout.admob_big_native, null);
                                                    populateNativeAdViewProps(nativeAds, adView);
                                                    layNative.removeAllViews();
                                                    layNative.addView(adView);
                                                }
                                            });
                                            VideoOptions videoOptions2 = new VideoOptions.Builder()
                                                    .build();
                                            NativeAdOptions adOptions2 = new NativeAdOptions.Builder()
                                                    .setVideoOptions(videoOptions2)
                                                    .build();
                                            builder3.withNativeAdOptions(adOptions2);
                                            AdRequest request2 = new AdRequest.Builder()
                                                    .build();
                                            AdLoader adLoader2 =
                                                    builder3
                                                            .withAdListener(
                                                                    new AdListener() {
                                                                        @Override
                                                                        public void onAdFailedToLoad(LoadAdError loadAdError) {
                                                                        }
                                                                    })
                                                            .build();
                                            adLoader2.loadAd(request2);
                                        }
                                    }
                                })
                        .build();
        adLoader.loadAd(request);
    }

    public static void MediumNativeMax(Activity activity, RelativeLayout layNative, String selectAdsBackup, String nativeId, String idNativeBackup) {

    }

    public static void MediumNativeFan(Activity activity, RelativeLayout layNative, String selectAdsBackup, String nativeId, String idNativeBackup) {

    }

    public static void MediumNativeAlien(Activity activity, RelativeLayout layNative, String selectAdsBackup, String nativeId, String idNativeBackup) {
        String getNativeId = PropsAdsManagement.getNativeAdsId(nativeId);
        AdLoader.Builder builder3 = new AdLoader.Builder(activity, getNativeId);
        builder3.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            @Override
            public void onNativeAdLoaded(@NonNull NativeAd nativeAds) {
                if (nativeAdPropf != null) {
                    nativeAdPropf.destroy();
                }
                nativeAdPropf = nativeAds;
                NativeAdView adView = (NativeAdView) activity.getLayoutInflater()
                        .inflate(R.layout.admob_big_native, null);
                populateNativeAdViewProps(nativeAds, adView);
                layNative.removeAllViews();
                layNative.addView(adView);
            }
        });
        VideoOptions videoOptions2 = new VideoOptions.Builder()
                .build();
        NativeAdOptions adOptions2 = new NativeAdOptions.Builder()
                .setVideoOptions(videoOptions2)
                .build();
        builder3.withNativeAdOptions(adOptions2);
        AdRequest request2 = new AdRequest.Builder()
                .build();
        AdLoader adLoader2 =
                builder3
                        .withAdListener(
                                new AdListener() {
                                    @Override
                                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                                        if (selectAdsBackup.equals("ADMOB")) {
                                            AdLoader.Builder builder2 = new AdLoader.Builder(activity, idNativeBackup);
                                            builder2.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                                                @Override
                                                public void onNativeAdLoaded(@NonNull NativeAd nativeAds) {
                                                    if (nativeAd != null) {
                                                        nativeAd.destroy();
                                                    }
                                                    nativeAd = nativeAds;
                                                    NativeAdView adView = (NativeAdView) activity.getLayoutInflater()
                                                            .inflate(R.layout.admob_big_native, null);
                                                    populateNativeAdView(nativeAds, adView);
                                                    layNative.removeAllViews();
                                                    layNative.addView(adView);
                                                }


                                            });

                                            VideoOptions videoOptions = new VideoOptions.Builder()
                                                    .build();

                                            NativeAdOptions adOptions = new NativeAdOptions.Builder()
                                                    .setVideoOptions(videoOptions)
                                                    .build();

                                            builder2.withNativeAdOptions(adOptions);


                                            AdRequest request = new AdRequest.Builder()
                                                    .build();
                                            AdLoader adLoader =
                                                    builder2
                                                            .withAdListener(
                                                                    new AdListener() {
                                                                        @Override
                                                                        public void onAdFailedToLoad(LoadAdError loadAdError) {

                                                                        }
                                                                    })
                                                            .build();
                                            adLoader.loadAd(request);
                                        }
                                    }
                                })
                        .build();
        adLoader2.loadAd(request2);
    }

    public static void SmallNativeAlien(Activity activity, RelativeLayout layNative, String selectAdsBackup, String nativeId, String idNativeBackup) {
        String getNativeId = PropsAdsManagement.getNativeAdsId(nativeId);
        AdLoader.Builder builder3 = new AdLoader.Builder(activity, getNativeId);
        builder3.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            @Override
            public void onNativeAdLoaded(@NonNull NativeAd nativeAds) {
                if (nativeAdPropf != null) {
                    nativeAdPropf.destroy();
                }
                nativeAdPropf = nativeAds;
                NativeAdView adView = (NativeAdView) activity.getLayoutInflater()
                        .inflate(R.layout.admob_small_rectangle_native, null);
                populateNativeAdViewProps(nativeAds, adView);
                layNative.removeAllViews();
                layNative.addView(adView);
            }
        });
        VideoOptions videoOptions2 = new VideoOptions.Builder()
                .build();
        NativeAdOptions adOptions2 = new NativeAdOptions.Builder()
                .setVideoOptions(videoOptions2)
                .build();
        builder3.withNativeAdOptions(adOptions2);
        AdRequest request2 = new AdRequest.Builder()
                .build();
        AdLoader adLoader2 =
                builder3
                        .withAdListener(
                                new AdListener() {
                                    @Override
                                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                                        if (selectAdsBackup.equals("ADMOB")) {
                                            AdLoader.Builder builder2 = new AdLoader.Builder(activity, idNativeBackup);
                                            builder2.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                                                @Override
                                                public void onNativeAdLoaded(@NonNull NativeAd nativeAds) {
                                                    if (nativeAd != null) {
                                                        nativeAd.destroy();
                                                    }
                                                    nativeAd = nativeAds;
                                                    NativeAdView adView = (NativeAdView) activity.getLayoutInflater()
                                                            .inflate(R.layout.admob_small_rectangle_native, null);
                                                    populateNativeAdView(nativeAds, adView);
                                                    layNative.removeAllViews();
                                                    layNative.addView(adView);
                                                }


                                            });

                                            VideoOptions videoOptions = new VideoOptions.Builder()
                                                    .build();

                                            NativeAdOptions adOptions = new NativeAdOptions.Builder()
                                                    .setVideoOptions(videoOptions)
                                                    .build();

                                            builder2.withNativeAdOptions(adOptions);


                                            AdRequest request = new AdRequest.Builder()
                                                    .build();
                                            AdLoader adLoader =
                                                    builder2
                                                            .withAdListener(
                                                                    new AdListener() {
                                                                        @Override
                                                                        public void onAdFailedToLoad(LoadAdError loadAdError) {

                                                                        }
                                                                    })
                                                            .build();
                                            adLoader.loadAd(request);
                                        }
                                    }
                                })
                        .build();
        adLoader2.loadAd(request2);
    }

    public static void SmallNativeAdmobRectangle(Activity activity, RelativeLayout layNative, String selectAdsBackup, String nativeId, String idNativeBackup, String Hpk1,
                                                 String Hpk2, String Hpk3, String Hpk4, String Hpk5) {

        AdLoader.Builder builder = new AdLoader.Builder(activity, nativeId);
        builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            @Override
            public void onNativeAdLoaded(@NonNull NativeAd nativeAds) {
                if (onLoadMediumNativesAdmob!=null){
                    onLoadMediumNativesAdmob.onNativeAdLoaded();
                }
                if (nativeAd != null) {
                    nativeAd.destroy();
                }
                nativeAd = nativeAds;
                NativeAdView adView = (NativeAdView) activity.getLayoutInflater()
                        .inflate(R.layout.admob_small_rectangle_native, null);
                populateNativeAdView(nativeAds, adView);
                layNative.removeAllViews();
                layNative.addView(adView);
            }


        });

        VideoOptions videoOptions = new VideoOptions.Builder()
                .build();

        NativeAdOptions adOptions = new NativeAdOptions.Builder()
                .setVideoOptions(videoOptions)
                .build();

        builder.withNativeAdOptions(adOptions);

        AdRequest request = new AdRequest.Builder().addKeyword(Hpk1).addKeyword(Hpk2)
                .addKeyword(Hpk3).addKeyword(Hpk4).addKeyword(Hpk5)
                .build();
        AdLoader adLoader =
                builder
                        .withAdListener(
                                new AdListener() {
                                    @Override
                                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                                        if (onLoadMediumNativesAdmob!=null){
                                            onLoadMediumNativesAdmob.onAdFailedToLoad("");
                                        }
                                    if (selectAdsBackup.equals("ALIEN-M")){
                                        String getNativeId = PropsAdsManagement.getNativeAdsId(idNativeBackup);
                                        AdLoader.Builder builder3 = new AdLoader.Builder(activity, getNativeId);
                                        builder3.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                                            @Override
                                            public void onNativeAdLoaded(@NonNull NativeAd nativeAds) {
                                                if (nativeAdPropf != null) {
                                                    nativeAdPropf.destroy();
                                                }
                                                nativeAdPropf = nativeAds;
                                                NativeAdView adView = (NativeAdView) activity.getLayoutInflater()
                                                        .inflate(R.layout.admob_small_rectangle_native, null);
                                                populateNativeAdViewProps(nativeAds, adView);
                                                layNative.removeAllViews();
                                                layNative.addView(adView);
                                            }
                                        });
                                        VideoOptions videoOptions2 = new VideoOptions.Builder()
                                                .build();
                                        NativeAdOptions adOptions2 = new NativeAdOptions.Builder()
                                                .setVideoOptions(videoOptions2)
                                                .build();
                                        builder3.withNativeAdOptions(adOptions2);
                                        AdRequest request2 = new AdRequest.Builder()
                                                .build();
                                        AdLoader adLoader2 =
                                                builder3
                                                        .withAdListener(
                                                                new AdListener() {
                                                                    @Override
                                                                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                                                                    }
                                                                })
                                                        .build();
                                        adLoader2.loadAd(request2);
                                    }
                                    }
                                })
                        .build();
        adLoader.loadAd(request);
    }

    public static void SmallNativeMaxRectangle(Activity activity, RelativeLayout layNative, String selectAdsBackup, String nativeId, String idNativeBackup) {



    }

    public static void SmallNativeFanRectangle(Activity activity, RelativeLayout layNative, String selectAdsBackup, String nativeId, String idNativeBackup) {
    }


    public static void SmallNativeAlienRectangle(Activity activity, RelativeLayout layNative, String selectAdsBackup, String nativeId, String idNativeBackup) {

        String getNativeId = PropsAdsManagement.getNativeAdsId(nativeId);
        AdLoader.Builder builder3 = new AdLoader.Builder(activity, getNativeId);
        builder3.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            @Override
            public void onNativeAdLoaded(@NonNull NativeAd nativeAds) {
                if (nativeAdPropf != null) {
                    nativeAdPropf.destroy();
                }
                nativeAdPropf = nativeAds;
                NativeAdView adView = (NativeAdView) activity.getLayoutInflater()
                        .inflate(R.layout.admob_small_rectangle_native, null);
                populateNativeAdViewProps(nativeAds, adView);
                layNative.removeAllViews();
                layNative.addView(adView);
            }
        });
        VideoOptions videoOptions2 = new VideoOptions.Builder()
                .build();
        NativeAdOptions adOptions2 = new NativeAdOptions.Builder()
                .setVideoOptions(videoOptions2)
                .build();
        builder3.withNativeAdOptions(adOptions2);
        AdRequest request2 = new AdRequest.Builder()
                .build();
        AdLoader adLoader2 =
                builder3
                        .withAdListener(
                                new AdListener() {
                                    @Override
                                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                                        if (selectAdsBackup.equals("ADMOB")) {
                                            AdLoader.Builder builder2 = new AdLoader.Builder(activity, idNativeBackup);
                                            builder2.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                                                @Override
                                                public void onNativeAdLoaded(@NonNull NativeAd nativeAds) {
                                                    if (nativeAd != null) {
                                                        nativeAd.destroy();
                                                    }
                                                    nativeAd = nativeAds;
                                                    NativeAdView adView = (NativeAdView) activity.getLayoutInflater()
                                                            .inflate(R.layout.admob_small_rectangle_native, null);
                                                    populateNativeAdView(nativeAds, adView);
                                                    layNative.removeAllViews();
                                                    layNative.addView(adView);
                                                }


                                            });

                                            VideoOptions videoOptions = new VideoOptions.Builder()
                                                    .build();

                                            NativeAdOptions adOptions = new NativeAdOptions.Builder()
                                                    .setVideoOptions(videoOptions)
                                                    .build();

                                            builder2.withNativeAdOptions(adOptions);


                                            AdRequest request = new AdRequest.Builder()
                                                    .build();
                                            AdLoader adLoader =
                                                    builder2
                                                            .withAdListener(
                                                                    new AdListener() {
                                                                        @Override
                                                                        public void onAdFailedToLoad(LoadAdError loadAdError) {

                                                                        }
                                                                    })
                                                            .build();
                                            adLoader.loadAd(request);
                                        }
                                    }
                                })
                        .build();
        adLoader2.loadAd(request2);

    }

    //Rectangle
    public static void SmallNativeStartAppRectangle(Activity activity, RelativeLayout layNative, String selectAdsBackup, String nativeId, String idNativeBackup) {

    }

    public static void SmallNativeWortise(Activity activity, RelativeLayout layNative, String selectAdsBackup, String nativeId, String idNativeBackup
    ) {

    }
    public static void MediumNativeWortise(Activity activity, RelativeLayout layNative, String selectAdsBackup, String nativeId, String idNativeBackup) {

    }

    public static void SmallNativeWortiseRectangle(Activity activity, RelativeLayout layNative, String selectAdsBackup, String nativeId, String idNativeBackup) {

    }

    private static void populateNativeAdView(NativeAd nativeAd, NativeAdView adView) {
        adView.setMediaView((MediaView) adView.findViewById(R.id.ad_media));
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
        adView.setPriceView(adView.findViewById(R.id.ad_price));
        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
        adView.setStoreView(adView.findViewById(R.id.ad_store));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }

        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }

        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(
                    nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getPrice() == null) {
            adView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
        }

        if (nativeAd.getStore() == null) {
            adView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
        }

        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView())
                    .setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.GONE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.GONE);
        }
        adView.setNativeAd(nativeAd);
    }
    private static void populateNativeAdViewProps(NativeAd nativeAd, NativeAdView adView) {
        adView.setMediaView((MediaView) adView.findViewById(R.id.ad_media));
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
        adView.setPriceView(adView.findViewById(R.id.ad_price));
        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
        adView.setStoreView(adView.findViewById(R.id.ad_store));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }

        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }

        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(
                    nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getPrice() == null) {
            adView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
        }

        if (nativeAd.getStore() == null) {
            adView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
        }

        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView())
                    .setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.GONE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.GONE);
        }
        adView.setNativeAd(nativeAd);
    }

}
