package com.lishijie.zoujuequn.statusManager;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lishijie.zoujuequn.R;


public class StatusLayoutManager {

    /**
     * 三种默认布局 ID
     */
    private static final int DEFAULT_LOADING_LAYOUT_ID = R.layout.layout_status_layout_manager_loading;
    private static final int DEFAULT_EMPTY_LAYOUT_ID = R.layout.layout_status_layout_manager_empty;
    private static final int DEFAULT_ERROR_LAYOUT_ID = R.layout.layout_status_layout_manager_error;
    private static final int DEFAULT_UNLOGIN_LAYOUT_ID = R.layout.layout_status_layout_manager_unlogin;

    /**
     * 默认布局中可点击的 view ID
     */
    private static final int DEFAULT_LOADING_CLICKED_ID = R.id.parent_status_loading_click;
    private static final int DEFAULT_EMPTY_CLICKED_ID = R.id.parent_status_empty_click;
    private static final int DEFAULT_ERROR_CLICKED_ID = R.id.parent_status_error_click;
    private static final int DEFAULT_UNLOGIN_CLICKED_ID = R.id.parent_status_unlogin_click;

    /**
     * 默认文字颜色
     */
    private static final int DEFAULT_ERROR_TEXT_COLOR = android.R.color.white;
    private static final int DEFAULT_LOADING_TEXT_COLOR = android.R.color.white;
    private static final int DEFAULT_EMPTY_TEXT_COLOR = android.R.color.white;
    private static final int DEFAULT_UNLOGIN_TEXT_COLOR = android.R.color.white;

    /**
     * 默认背景颜色
     */
    private static final int DEFAULT_ERROR_BACKGROUND_COLOR = android.R.color.white;
    private static final int DEFAULT_EMPTY_BACKGROUND_COLOR = android.R.color.white;
    private static final int DEFAULT_LOADING_BACKGROUND_COLOR = android.R.color.white;
    private static final int DEFAULT_UNLOGIN_BACKGROUND_COLOR = android.R.color.white;
    private static final int DEFAULT_DRAWABLE = android.R.drawable.screen_background_dark;

    private View contentLayout;


    private AnimationDrawable animationDrawable;
    @LayoutRes
    private int loadingLayoutID;
    private View loadingLayout;
    private String loadingText;

    @IdRes
    private int emptyClickViewId;
    @LayoutRes
    private int emptyLayoutID;
    private View emptyLayout;
    private String emptyText;
    private String emptyClickViewText;
    private int emptyClickViewTextColor;
    private boolean isEmptyClickViewVisible;
    @DrawableRes
    private int emptyImgID;


    @IdRes
    private int unLoginClickViewId;
    @LayoutRes
    private int unLoginLayoutID;
    private View unLoginLayout;
    private String unLoginText;
    private String unLoginClickViewText;
    private int unLoginClickViewTextColor;
    private boolean isUnLoginClickViewVisible;
    @DrawableRes
    private int unLoginImgID;


    @IdRes
    private int errorClickViewId;
    @LayoutRes
    private int errorLayoutID;
    private View errorLayout;
    private String errorText;
    private String errorClickViewText;
    private int errorClickViewTextColor;
    private boolean isErrorClickViewVisible;
    @DrawableRes
    private int errorImgID;


    private String loadingClickViewText;
    private int loadingClickViewTextColor;
    private boolean isLoadingClickViewVisible;

    private int defaultBackgroundErrorColor;
    private int defaultBackgroundEmptyColor;
    private int defaultBackgroundLoadingColor;
    private int defaultBackgroundUnLoginColor;
    private boolean isShowErrorBgColor;
    private boolean isShowEmptyBgColor;
    private boolean isShowUnLoginBgColor;
    private Drawable defaultBackgroundErrorDrawable;
    private Drawable defaultBackgroundEmptyDrawable;
    private Drawable defaultBackgroundUnLoginDrawable;
    private boolean isShowErrorBgDrawable;
    private boolean isShowEmptyBgDrawable;
    private boolean isShowUnLoginBgDrawable;

    private OnStatusChildClickListener onStatusChildClickListener;

    private ReplaceLayoutHelper replaceLayoutHelper;

    private LayoutInflater inflater;

    private StatusLayoutManager(Builder builder) {
        this.contentLayout = builder.contentLayout;

        this.loadingLayoutID = builder.loadingLayoutID;
        this.loadingLayout = builder.loadingLayout;
        this.loadingText = builder.loadingText;

        this.unLoginClickViewId = builder.unLoginClickViewId;
        this.unLoginLayoutID = builder.unLoginLayoutID;
        this.unLoginLayout = builder.unLoginLayout;
        this.unLoginText = builder.unLoginText;
        this.unLoginClickViewText = builder.unLoginClickViewText;
        this.unLoginClickViewTextColor = builder.unLoginClickViewTextColor;
        this.isUnLoginClickViewVisible = builder.isUnLoginClickViewVisible;
        this.unLoginImgID = builder.unLoginImgID;


        this.emptyClickViewId = builder.emptyClickViewId;
        this.emptyLayoutID = builder.emptyLayoutID;
        this.emptyLayout = builder.emptyLayout;
        this.emptyText = builder.emptyText;
        this.emptyClickViewText = builder.emptyClickViewText;
        this.emptyClickViewTextColor = builder.emptyClickViewTextColor;
        this.isEmptyClickViewVisible = builder.isEmptyClickViewVisible;
        this.emptyImgID = builder.emptyImgID;


        this.errorClickViewId = builder.errorClickViewId;
        this.errorLayoutID = builder.errorLayoutID;
        this.errorLayout = builder.errorLayout;
        this.errorText = builder.errorText;
        this.errorClickViewText = builder.errorClickViewText;
        this.errorClickViewTextColor = builder.errorClickViewTextColor;
        this.isErrorClickViewVisible = builder.isErrorClickViewVisible;
        this.errorImgID = builder.errorImgID;

        this.loadingText = builder.loadingText;
        this.loadingClickViewText = builder.loadingClickViewText;
        this.loadingClickViewTextColor = builder.loadingClickViewTextColor;
        this.isLoadingClickViewVisible = builder.isLoadingClickViewVisible;

        this.defaultBackgroundErrorColor = builder.defaultBackgroundErrorColor;
        this.defaultBackgroundEmptyColor = builder.defaultBackgroundEmptyColor;
        this.defaultBackgroundLoadingColor = builder.defaultBackgroundLoadingColor;
        this.defaultBackgroundUnLoginColor = builder.defaultBackgroundUnLoginColor;

        this.defaultBackgroundErrorDrawable = builder.defaultBackgroundErrorDrawable;
        this.defaultBackgroundEmptyDrawable = builder.defaultBackgroundEmptyDrawable;
        this.defaultBackgroundUnLoginDrawable = builder.defaultBackgroundUnLoginDrawable;


        this.isShowErrorBgColor = builder.isShowErrorBgColor;
        this.isShowEmptyBgColor = builder.isShowEmptyBgColor;
        this.isShowUnLoginBgColor = builder.isShowUnLoginBgColor;
        this.isShowErrorBgDrawable = builder.isShowErrorBgDrawable;
        this.isShowEmptyBgDrawable = builder.isShowEmptyBgDrawable;
        this.isShowUnLoginBgDrawable = builder.isShowUnLoginBgDrawable;

        this.onStatusChildClickListener = builder.onStatusChildClickListener;

        this.replaceLayoutHelper = new ReplaceLayoutHelper(contentLayout);
    }

    private View inflate(@LayoutRes int resource) {
        if (inflater == null) {
            inflater = LayoutInflater.from(contentLayout.getContext());
        }
        return inflater.inflate(resource, null);
    }


    //------------------原有布局------------------

    /**
     * 显示原有布局
     */
    public void showSuccessLayout() {
        replaceLayoutHelper.restoreLayout();
    }


    //------------------加载中布局------------------

    /**
     * 创建加载中布局
     */
    private void createLoadingLayout() {
        if (loadingLayout == null) {
            loadingLayout = inflate(loadingLayoutID);
        }
        if (loadingLayoutID == DEFAULT_LOADING_LAYOUT_ID) {
            loadingLayout.setBackgroundColor(defaultBackgroundLoadingColor);
        }
        TextView loadingTextView = loadingLayout.findViewById(R.id.tv_status_loading_content);
        if (!TextUtils.isEmpty(loadingText)) {
            if (loadingTextView != null) {
                loadingTextView.setText(loadingText);
            }
        }

        if (loadingTextView != null) {
            // 设置点击按钮的文本和可见性
            if (isLoadingClickViewVisible) {
                loadingTextView.setVisibility(View.VISIBLE);
                if (!TextUtils.isEmpty(loadingClickViewText)) {
                    loadingTextView.setText(loadingClickViewText);
                }
                loadingTextView.setTextColor(loadingClickViewTextColor);
            } else {
                loadingTextView.setVisibility(View.GONE);
            }
        }

        ImageView loadingImageView = loadingLayout.findViewById(R.id.iv_status_loading_img);
        loadingImageView.setBackgroundResource(R.drawable.loading_animation);
        animationDrawable = (AnimationDrawable) loadingImageView.getBackground();
        if (animationDrawable == null) {
            animationDrawable = (AnimationDrawable) loadingImageView.getDrawable();
        }
        animationDrawable.start();
    }

    /**
     * 获取加载中布局
     *
     * @return 加载中布局
     */
    public View getLoadingLayout() {
        createLoadingLayout();
        return loadingLayout;
    }

    /**
     * 显示加载中布局
     */
    public void showLoadingLayout() {
        createLoadingLayout();
        replaceLayoutHelper.showStatusLayout(loadingLayout);
    }


    /**
     * 隐藏加载中布局
     */
    public void hideLoadingLayout() {
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }


    //------------------未登陆布局------------------


    /**
     * 创建未登陆布局
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void createUnLoginLayout() {
        if (unLoginLayout == null) {
            unLoginLayout = inflate(unLoginLayoutID);
        }
        if (unLoginLayoutID == DEFAULT_UNLOGIN_LAYOUT_ID && isShowUnLoginBgColor) {
            unLoginLayout.setBackgroundColor(defaultBackgroundUnLoginColor);
        }

        if (unLoginLayoutID == DEFAULT_UNLOGIN_LAYOUT_ID && isShowUnLoginBgDrawable) {
            unLoginLayout.setBackground(defaultBackgroundUnLoginDrawable);
        }

        // 点击事件回调
        View view = unLoginLayout.findViewById(unLoginClickViewId);
        if (view != null && onStatusChildClickListener != null) {
            // 设置点击按钮点击时事件回调
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onStatusChildClickListener.onUnLoginChildClick(view);
                }
            });
        }
        TextView unLoginTextView = unLoginLayout.findViewById(R.id.tv_status_empty_content);
        // 设置未登陆布局的提示文本
        if (!TextUtils.isEmpty(unLoginText)) {
            if (unLoginTextView != null) {
                unLoginTextView.setText(unLoginText);
            }
        }

        // 设置未登陆布局的图片
        if (unLoginImgID > 0) {
            ImageView unLoginImageView = unLoginLayout.findViewById(R.id.iv_status_unlogin_img);
            if (unLoginImageView != null) {
                unLoginImageView.setImageResource(unLoginImgID);
            }
        }

        if (unLoginTextView != null) {
            // 设置点击按钮的文本和可见性
            if (isUnLoginClickViewVisible) {
                unLoginTextView.setVisibility(View.VISIBLE);
                if (!TextUtils.isEmpty(unLoginClickViewText)) {
                    unLoginTextView.setText(unLoginClickViewText);
                }
                unLoginTextView.setTextColor(unLoginClickViewTextColor);
            } else {
                unLoginTextView.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 获取未登陆布局
     *
     * @return 未登陆布局
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public View getUnLoginLayout() {
        createUnLoginLayout();
        return unLoginLayout;
    }

    /**
     * 显示未登陆布局
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void showUnLoginLayout() {
        createUnLoginLayout();
        replaceLayoutHelper.showStatusLayout(unLoginLayout);
    }


    //------------------空数据布局------------------


    /**
     * 创建空数据布局
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void createEmptyLayout() {
        if (emptyLayout == null) {
            emptyLayout = inflate(emptyLayoutID);
        }
        if (emptyLayoutID == DEFAULT_EMPTY_LAYOUT_ID && isShowEmptyBgColor) {
            emptyLayout.setBackgroundColor(defaultBackgroundEmptyColor);
        }

        if (emptyLayoutID == DEFAULT_EMPTY_LAYOUT_ID && isShowEmptyBgDrawable) {
            emptyLayout.setBackground(defaultBackgroundEmptyDrawable);
        }

        // 点击事件回调
        View view = emptyLayout.findViewById(emptyClickViewId);
        if (view != null && onStatusChildClickListener != null) {
            // 设置点击按钮点击时事件回调
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onStatusChildClickListener.onEmptyChildClick(view);
                }
            });
        }
        TextView emptyTextView = emptyLayout.findViewById(R.id.tv_status_empty_content);
        // 设置默认空数据布局的提示文本
        if (!TextUtils.isEmpty(emptyText)) {
            if (emptyTextView != null) {
                emptyTextView.setText(emptyText);
            }
        }

        // 设置默认空数据布局的图片
        if (emptyImgID > 0) {
            ImageView emptyImageView = emptyLayout.findViewById(R.id.iv_status_empty_img);
            if (emptyImageView != null) {
                emptyImageView.setImageResource(emptyImgID);
            }
        }

        if (emptyTextView != null) {
            // 设置点击按钮的文本和可见性
            if (isEmptyClickViewVisible) {
                emptyTextView.setVisibility(View.VISIBLE);
                if (!TextUtils.isEmpty(emptyClickViewText)) {
                    emptyTextView.setText(emptyClickViewText);
                }
                emptyTextView.setTextColor(emptyClickViewTextColor);
            } else {
                emptyTextView.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 获取空数据布局
     *
     * @return 空数据布局
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public View getEmptyLayout() {
        createEmptyLayout();
        return emptyLayout;
    }

    /**
     * 显示空数据布局
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void showEmptyLayout() {
        createEmptyLayout();
        replaceLayoutHelper.showStatusLayout(emptyLayout);
    }


    //------------------出错布局------------------


    /**
     * 创建出错布局
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void createErrorLayout() {
        if (errorLayout == null) {
            errorLayout = inflate(errorLayoutID);
        }
        if (errorLayoutID == DEFAULT_ERROR_LAYOUT_ID && isShowErrorBgColor) {
            errorLayout.setBackgroundColor(defaultBackgroundErrorColor);
        }

        if (errorLayoutID == DEFAULT_ERROR_LAYOUT_ID && isShowErrorBgDrawable) {
            errorLayout.setBackground(defaultBackgroundErrorDrawable);
        }

        View view = errorLayout.findViewById(errorClickViewId);
        if (view != null && onStatusChildClickListener != null) {
            // 设置点击按钮点击时事件回调
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onStatusChildClickListener.onErrorChildClick(view);
                }
            });
        }
        TextView errorTextView = errorLayout.findViewById(R.id.tv_status_error_content);
        // 设置默认出错布局的提示文本
        if (!TextUtils.isEmpty(errorText)) {

            if (errorTextView != null) {
                errorTextView.setText(errorText);
            }
        }

        // 设置默认出错布局的图片
        if (errorImgID > 0) {
            ImageView errorImageView = errorLayout.findViewById(R.id.iv_status_error_img);
            if (errorImageView != null) {
                errorImageView.setImageResource(errorImgID);
            }
        }

        if (errorTextView != null) {
            // 设置点击按钮的文本和可见性
            if (isErrorClickViewVisible) {
                errorTextView.setVisibility(View.VISIBLE);
                if (!TextUtils.isEmpty(errorClickViewText)) {
                    errorTextView.setText(errorClickViewText);
                }
                errorTextView.setTextColor(errorClickViewTextColor);
            } else {
                errorTextView.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 获取出错布局
     *
     * @return 出错布局
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public View getErrorLayout() {
        createErrorLayout();
        return errorLayout;
    }

    /**
     * 显示出错布局
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void showErrorLayout() {
        createErrorLayout();
        replaceLayoutHelper.showStatusLayout(errorLayout);
    }


    public static final class Builder {

        private View contentLayout;

        @LayoutRes
        private int loadingLayoutID;
        private View loadingLayout;
        private String loadingText;

        @IdRes
        private int emptyClickViewId;
        @LayoutRes
        private int emptyLayoutID;
        private View emptyLayout;
        private String emptyText;
        private String emptyClickViewText;
        private int emptyClickViewTextColor;
        private boolean isEmptyClickViewVisible;
        @DrawableRes
        private int emptyImgID;


        @IdRes
        private int unLoginClickViewId;
        @LayoutRes
        private int unLoginLayoutID;
        private View unLoginLayout;
        private String unLoginText;
        private String unLoginClickViewText;
        private int unLoginClickViewTextColor;
        private boolean isUnLoginClickViewVisible;
        @DrawableRes
        private int unLoginImgID;

        @IdRes
        private int errorClickViewId;
        @LayoutRes
        private int errorLayoutID;
        private View errorLayout;
        private String errorText;
        private String errorClickViewText;
        private int errorClickViewTextColor;
        private boolean isErrorClickViewVisible;
        @DrawableRes
        private int errorImgID;

        private String loadingClickViewText;
        private int loadingClickViewTextColor;
        private boolean isLoadingClickViewVisible;

        private int defaultBackgroundLoadingColor;
        private int defaultBackgroundErrorColor;
        private int defaultBackgroundEmptyColor;
        private int defaultBackgroundUnLoginColor;

        private Drawable defaultBackgroundErrorDrawable;
        private Drawable defaultBackgroundEmptyDrawable;
        private Drawable defaultBackgroundUnLoginDrawable;

        private boolean isShowErrorBgColor;
        private boolean isShowEmptyBgColor;
        private boolean isShowUnLoginBgColor;

        private boolean isShowErrorBgDrawable;
        private boolean isShowEmptyBgDrawable;
        private boolean isShowUnLoginBgDrawable;


        private OnStatusChildClickListener onStatusChildClickListener;

        /**
         * 创建状态布局 Build 对象
         *
         * @param contentLayout 原有布局，内容布局(注意：传入的View控件必须是非原始根布局的View)
         */
        public Builder(@NonNull View contentLayout) {
            this.contentLayout = contentLayout;
            // 设置默认布局
            this.loadingLayoutID = DEFAULT_LOADING_LAYOUT_ID;
            this.emptyLayoutID = DEFAULT_EMPTY_LAYOUT_ID;
            this.unLoginLayoutID = DEFAULT_UNLOGIN_LAYOUT_ID;
            this.errorLayoutID = DEFAULT_ERROR_LAYOUT_ID;
            // 设置默认点击点击view id
            this.emptyClickViewId = DEFAULT_EMPTY_CLICKED_ID;
            this.unLoginClickViewId = DEFAULT_UNLOGIN_CLICKED_ID;
            this.errorClickViewId = DEFAULT_ERROR_CLICKED_ID;
            // 设置默认点击按钮属性
            this.isEmptyClickViewVisible = true;
            this.emptyClickViewTextColor = contentLayout.getContext().getResources().getColor(DEFAULT_EMPTY_TEXT_COLOR);
            this.isUnLoginClickViewVisible = true;
            this.unLoginClickViewTextColor = contentLayout.getContext().getResources().getColor(DEFAULT_UNLOGIN_TEXT_COLOR);
            this.isErrorClickViewVisible = true;
            this.errorClickViewTextColor = contentLayout.getContext().getResources().getColor(DEFAULT_ERROR_TEXT_COLOR);
            this.isLoadingClickViewVisible = true;
            this.loadingClickViewTextColor = contentLayout.getContext().getResources().getColor(DEFAULT_LOADING_TEXT_COLOR);
            // 设置默认背景色
            this.defaultBackgroundLoadingColor = contentLayout.getContext().getResources().getColor(DEFAULT_LOADING_BACKGROUND_COLOR);
            this.defaultBackgroundErrorColor = contentLayout.getContext().getResources().getColor(DEFAULT_ERROR_BACKGROUND_COLOR);
            this.defaultBackgroundEmptyColor = contentLayout.getContext().getResources().getColor(DEFAULT_EMPTY_BACKGROUND_COLOR);
            this.defaultBackgroundUnLoginColor = contentLayout.getContext().getResources().getColor(DEFAULT_UNLOGIN_BACKGROUND_COLOR);

            this.defaultBackgroundErrorDrawable = ContextCompat.getDrawable(contentLayout.getContext(), DEFAULT_DRAWABLE);
            this.defaultBackgroundEmptyDrawable = ContextCompat.getDrawable(contentLayout.getContext(), DEFAULT_DRAWABLE);
            this.defaultBackgroundUnLoginDrawable = ContextCompat.getDrawable(contentLayout.getContext(), DEFAULT_DRAWABLE);


        }


        //------------------加载中布局------------------


        /**
         * 设置默认加载中布局提示文本
         *
         * @param loadingText 加载中布局提示文本
         * @return 状态布局 Build 对象
         */
        public Builder setDefaultLoadingText(String loadingText) {
            this.loadingText = loadingText;
            return this;
        }

        /**
         * 设置默认加载中布局提示文本
         *
         * @param loadingTextStrID 加载中布局提示文本 ID
         * @return 状态布局 Build 对象
         */
        public Builder setDefaultLoadingText(@StringRes int loadingTextStrID) {
            this.loadingText = contentLayout.getContext().getResources().getString(loadingTextStrID);
            return this;
        }


        /**
         * 设置加载中布局
         *
         * @param loadingLayoutID 加载中布局 ID
         * @return 状态布局 Build 对象
         */
        public Builder setLoadingLayout(@LayoutRes int loadingLayoutID) {
            this.loadingLayoutID = loadingLayoutID;
            return this;
        }

        /**
         * 设置加载中布局
         *
         * @param loadingLayout 加载中布局
         * @return 状态布局 Build 对象
         */
        public Builder setLoadingLayout(@NonNull View loadingLayout) {
            this.loadingLayout = loadingLayout;
            return this;
        }


        /**
         * 设置加载中布局的背景颜色
         *
         * @param defaultLoadingBackgroundColor 默认布局的背景颜色
         * @return 状态布局 Build 对象
         */
        public Builder setLoadingBackgroundColor(int defaultLoadingBackgroundColor) {
            this.defaultBackgroundLoadingColor = defaultLoadingBackgroundColor;
            return this;
        }


        /**
         * 设置默认空数据布局点击按钮文本颜色
         *
         * @param loadingClickViewTextColor 点击按钮文本颜色
         * @return 状态布局 Build 对象
         */
        public Builder setLoadingViewTextColor(int loadingClickViewTextColor) {
            this.loadingClickViewTextColor = loadingClickViewTextColor;
            return this;
        }


        /**
         * 设置默认出错布局点击按钮文本
         *
         * @param loadingClickViewText 点击按钮文本
         * @return 状态布局 Build 对象
         */
        public Builder setLoadingViewText(String loadingClickViewText) {
            this.loadingClickViewText = loadingClickViewText;
            return this;
        }


        //------------------空数据布局----------------------


        /**
         * 设置空数据布局提示文本
         *
         * @param emptyText 空数据布局提示文本
         * @return 状态布局 Build 对象
         */
        public Builder setDefaultEmptyText(String emptyText) {
            this.emptyText = emptyText;
            return this;
        }

        /**
         * 设置空数据布局提示文本
         *
         * @param emptyTextStrID 空数据布局提示文本 ID
         * @return 状态布局 Build 对象
         */
        public Builder setDefaultEmptyText(@StringRes int emptyTextStrID) {
            this.emptyText = contentLayout.getContext().getResources().getString(emptyTextStrID);
            return this;
        }


        /**
         * 设置空数据布局
         *
         * @param emptyLayoutResId 空数据布局 ID
         * @return 状态布局 Build 对象
         */
        public Builder setEmptyLayout(@LayoutRes int emptyLayoutResId) {
            this.emptyLayoutID = emptyLayoutResId;
            return this;
        }

        /**
         * 设置空数据布局
         *
         * @param emptyLayout 空数据布局
         * @return 状态布局 Build 对象
         */
        public Builder setEmptyLayout(@NonNull View emptyLayout) {
            this.emptyLayout = emptyLayout;
            return this;
        }

        /**
         * 设置空数据布局点击按钮 ID
         *
         * @param emptyClickViewResId 空数据布局点击按钮 ID
         * @return 状态布局 Build 对象
         */
        public Builder setEmptyClickViewID(@IdRes int emptyClickViewResId) {
            this.emptyClickViewId = emptyClickViewResId;
            return this;
        }

        /**
         * 设置默认空数据布局点击按钮文本
         *
         * @param emptyClickViewText 点击按钮文本
         * @return 状态布局 Build 对象
         */
        public Builder setDefaultEmptyClickViewText(String emptyClickViewText) {
            this.emptyClickViewText = emptyClickViewText;
            return this;
        }

        /**
         * 设置默认空数据布局点击按钮文本
         *
         * @param emptyClickViewTextID 点击按钮文本 ID
         * @return 状态布局 Build 对象
         */
        public Builder setDefaultEmptyClickViewText(@StringRes int emptyClickViewTextID) {
            this.emptyClickViewText = contentLayout.getContext().getResources().getString(emptyClickViewTextID);
            return this;
        }

        /**
         * 设置默认空数据布局点击按钮文本颜色
         *
         * @param emptyClickViewTextColor 点击按钮文本颜色
         * @return 状态布局 Build 对象
         */
        public Builder setEmptyViewTextColor(int emptyClickViewTextColor) {
            this.emptyClickViewTextColor = emptyClickViewTextColor;
            return this;
        }

        /**
         * 设置默认空数据布局点击按钮是否可见
         *
         * @param isEmptyClickViewVisible true：可见 false：不可见
         * @return 状态布局 Build 对象
         */
        public Builder setDefaultEmptyClickViewVisible(boolean isEmptyClickViewVisible) {
            this.isEmptyClickViewVisible = isEmptyClickViewVisible;
            return this;
        }

        /**
         * 设置空数据布局图片
         *
         * @param emptyImgID 空数据布局图片 ID
         * @return 状态布局 Build 对象
         */
        public Builder setDefaultEmptyImg(@DrawableRes int emptyImgID) {
            this.emptyImgID = emptyImgID;
            return this;
        }


        /**
         * 设置空数据布局的背景颜色，包括加载中、空数据和出错布局
         *
         * @param defaultEmptyBackgroundColor 默认布局的背景颜色
         * @return 状态布局 Build 对象
         */
        public Builder setEmptyBackgroundColor(int defaultEmptyBackgroundColor) {
            this.defaultBackgroundEmptyColor = defaultEmptyBackgroundColor;
            this.isShowEmptyBgColor = true;
            this.isShowEmptyBgDrawable = false;
            return this;
        }


        /**
         * 设置出错布局的背景颜色
         *
         * @param defaultBackgroundEmptyDrawable 默认布局的背景颜色
         * @return 状态布局 Build 对象
         */
        public Builder setEmptyBackgroundDrawable(Drawable defaultBackgroundEmptyDrawable) {
            this.defaultBackgroundEmptyDrawable = defaultBackgroundEmptyDrawable;
            this.isShowEmptyBgDrawable = true;
            this.isShowEmptyBgColor = false;
            return this;
        }


        //------------------未登录布局----------------------


        /**
         * 设置未登录布局提示文本
         *
         * @param unLoginText 空数据布局提示文本
         * @return 状态布局 Build 对象
         */
        public Builder setUnLoginText(String unLoginText) {
            this.unLoginText = unLoginText;
            return this;
        }

        /**
         * 设置未登录布局提示文本
         *
         * @param unLoginTextStrID 空数据布局提示文本 ID
         * @return 状态布局 Build 对象
         */
        public Builder setUnLoginText(@StringRes int unLoginTextStrID) {
            this.unLoginText = contentLayout.getContext().getResources().getString(unLoginTextStrID);
            return this;
        }


        /**
         * 设置未登录布局
         *
         * @param unLoginLayoutResId 空数据布局 ID
         * @return 状态布局 Build 对象
         */
        public Builder setUnLoginLayout(@LayoutRes int unLoginLayoutResId) {
            this.unLoginLayoutID = unLoginLayoutResId;
            return this;
        }

        /**
         * 设置未登录布局
         *
         * @param unLoginLayout 空数据布局
         * @return 状态布局 Build 对象
         */
        public Builder setUnLoginLayout(@NonNull View unLoginLayout) {
            this.unLoginLayout = unLoginLayout;
            return this;
        }

        /**
         * 设置未登录布局点击按钮 ID
         *
         * @param unLoginClickViewResId 空数据布局点击按钮 ID
         * @return 状态布局 Build 对象
         */
        public Builder setUnLoginClickViewID(@IdRes int unLoginClickViewResId) {
            this.unLoginClickViewId = unLoginClickViewResId;
            return this;
        }

        /**
         * 设置默未登录布局点击按钮文本
         *
         * @param unLoginClickViewText 点击按钮文本
         * @return 状态布局 Build 对象
         */
        public Builder setUnLoginClickViewText(String unLoginClickViewText) {
            this.unLoginClickViewText = unLoginClickViewText;
            return this;
        }

        /**
         * 设置未登录布局点击按钮文本
         *
         * @param unLoginClickViewTextID 点击按钮文本 ID
         * @return 状态布局 Build 对象
         */
        public Builder setUnLoginClickViewText(@StringRes int unLoginClickViewTextID) {
            this.unLoginClickViewText = contentLayout.getContext().getResources().getString(unLoginClickViewTextID);
            return this;
        }

        /**
         * 设置未登录布局点击按钮文本颜色
         *
         * @param unLoginClickViewTextColor 点击按钮文本颜色
         * @return 状态布局 Build 对象
         */
        public Builder setUnLoginTextViewColor(int unLoginClickViewTextColor) {
            this.unLoginClickViewTextColor = unLoginClickViewTextColor;
            return this;
        }


        /**
         * 设置未登录布局点击按钮是否可见
         *
         * @param isUnLoginClickViewVisible true：可见 false：不可见
         * @return 状态布局 Build 对象
         */
        public Builder setUnLoginClickViewVisible(boolean isUnLoginClickViewVisible) {
            this.isUnLoginClickViewVisible = isUnLoginClickViewVisible;
            return this;
        }

        /**
         * 设置未登录布局图片
         *
         * @param unLoginImgID 空数据布局图片 ID
         * @return 状态布局 Build 对象
         */
        public Builder setUnLoginImg(@DrawableRes int unLoginImgID) {
            this.unLoginImgID = unLoginImgID;
            return this;
        }


        /**
         * 设置未登录布局的背景颜色，包括加载中、空数据和出错布局
         *
         * @param defaultUnLoginBackgroundColor 默认布局的背景颜色
         * @return 状态布局 Build 对象
         */
        public Builder setUnLoginBackgroundColor(int defaultUnLoginBackgroundColor) {
            this.defaultBackgroundUnLoginColor = defaultUnLoginBackgroundColor;
            this.isShowUnLoginBgColor = true;
            this.isShowUnLoginBgDrawable = false;
            return this;
        }


        /**
         * 设置出错布局的背景颜色
         *
         * @param defaultBackgroundUnLoginDrawable 默认布局的背景颜色
         * @return 状态布局 Build 对象
         */
        public Builder setUnLoginBackgroundDrawable(Drawable defaultBackgroundUnLoginDrawable) {
            this.defaultBackgroundUnLoginDrawable = defaultBackgroundUnLoginDrawable;
            this.isShowUnLoginBgDrawable = true;
            this.isShowUnLoginBgColor = false;
            return this;
        }


        //------------------出错布局------------------


        /**
         * 设置错误数据布局点击按钮文本颜色
         *
         * @param errorLayoutViewTextColor 点击按钮文本颜色
         * @return 状态布局 Build 对象
         */
        public Builder setErrorViewTextColor(int errorLayoutViewTextColor) {
            this.errorClickViewTextColor = errorLayoutViewTextColor;
            return this;
        }


        /**
         * 设置出错布局
         *
         * @param errorLayoutResId 出错布局 ID
         * @return 状态布局 Build 对象
         */
        public Builder setErrorLayout(@LayoutRes int errorLayoutResId) {
            this.errorLayoutID = errorLayoutResId;
            return this;
        }

        /**
         * 设置出错布局
         *
         * @param errorLayout 出错布局
         * @return 状态布局 Build 对象
         */
        public Builder setErrorLayout(@NonNull View errorLayout) {
            this.errorLayout = errorLayout;
            return this;
        }

        /**
         * 设置出错布局点击按钮 ID
         *
         * @param errorClickViewResId 出错布局点击按钮 ID
         * @return 状态布局 Build 对象
         */
        public Builder setErrorClickViewID(@IdRes int errorClickViewResId) {
            this.errorClickViewId = errorClickViewResId;
            return this;
        }

        /**
         * 设置出错布局提示文本
         *
         * @param errorText 出错布局提示文本
         * @return 状态布局 Build 对象
         */
        public Builder setDefaultErrorText(String errorText) {
            this.errorText = errorText;
            return this;
        }

        /**
         * 设置出错布局提示文本
         *
         * @param errorTextStrID 出错布局提示文本 ID
         * @return 状态布局 Build 对象
         */
        public Builder setDefaultErrorText(@StringRes int errorTextStrID) {
            this.errorText = contentLayout.getContext().getResources().getString(errorTextStrID);
            return this;
        }

        /**
         * 设置默认出错布局点击按钮文本
         *
         * @param errorClickViewText 点击按钮文本
         * @return 状态布局 Build 对象
         */
        public Builder setDefaultErrorClickViewText(String errorClickViewText) {
            this.errorClickViewText = errorClickViewText;
            return this;
        }

        /**
         * 设置默认出错布局点击按钮文本
         *
         * @param errorClickViewTextID 点击按钮文本 ID
         * @return 状态布局 Build 对象
         */
        public Builder setDefaultErrorClickViewText(@StringRes int errorClickViewTextID) {
            this.errorClickViewText = contentLayout.getContext().getResources().getString(errorClickViewTextID);
            return this;
        }

        /**
         * 设置默认出错布局点击按钮文本颜色
         *
         * @param errorClickViewTextColor 点击按钮文本颜色
         * @return 状态布局 Build 对象
         */
        public Builder setDefaultErrorClickViewTextColor(int errorClickViewTextColor) {
            this.errorClickViewTextColor = errorClickViewTextColor;
            return this;
        }

        /**
         * 设置出错布局点击按钮可见行
         *
         * @param isErrorClickViewVisible true：可见 false：不可见
         * @return 状态布局 Build 对象
         */
        public Builder setDefaultErrorClickViewVisible(boolean isErrorClickViewVisible) {
            this.isErrorClickViewVisible = isErrorClickViewVisible;
            return this;
        }

        /**
         * 设置出错布局图片
         *
         * @param errorImgID 出错布局图片 ID
         * @return 状态布局 Build 对象
         */
        public Builder setDefaultErrorImg(@DrawableRes int errorImgID) {
            this.errorImgID = errorImgID;
            return this;
        }


        /**
         * 设置点击事件监听器
         *
         * @param listener 点击事件监听器
         * @return 状态布局 Build 对象
         */
        public Builder setOnStatusChildClickListener(OnStatusChildClickListener listener) {
            this.onStatusChildClickListener = listener;
            return this;
        }


        /**
         * 设置出错布局的背景颜色
         *
         * @param defaultErrorBackgroundColor 默认布局的背景颜色
         * @return 状态布局 Build 对象
         */
        public Builder setErrorBackgroundColor(int defaultErrorBackgroundColor) {
            this.defaultBackgroundErrorColor = defaultErrorBackgroundColor;
            this.isShowErrorBgColor = true;
            this.isShowErrorBgDrawable = false;
            return this;
        }


        /**
         * 设置出错布局的背景颜色
         *
         * @param defaultBackgroundErrorDrawable 默认布局的背景颜色
         * @return 状态布局 Build 对象
         */
        public Builder setErrorBackgroundDrawable(Drawable defaultBackgroundErrorDrawable) {
            this.defaultBackgroundErrorDrawable = defaultBackgroundErrorDrawable;
            this.isShowErrorBgDrawable = true;
            this.isShowErrorBgColor = false;
            return this;
        }


        /**
         * 创建状态布局管理器
         *
         * @return 状态布局管理器
         */
        @NonNull
        public StatusLayoutManager build() {
            return new StatusLayoutManager(this);
        }

    }
}
