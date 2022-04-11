package com.example.shoe.ui.activity

import android.animation.Animator
import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.shoe.R
import com.example.shoe.databinding.DetailActivityBinding
import com.example.shoe.viewmodel.CustomViewModelProvider
import com.example.shoe.viewmodel.DetailModel
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import com.wj.common.constant.BaseConstant
import com.wj.common.constant.BaseConstant.CUS_TRANSITION_NAME
import com.wj.common.constant.UrlConstant
import com.wj.common.util.AppPrefsUtils

/**
 * 展示鞋子细节的界面
 */
@Route(path = UrlConstant.DETAIL_URL)
class DetailActivity : AppCompatActivity() {

    @JvmField
    @Autowired(name = BaseConstant.DETAIL_SHOE_ID)
    var shoeId: Long = 0L

    @JvmField
    @Autowired(name = BaseConstant.CUS_TRANSITION_NAME)
    var transitionName: String = ""

    companion object {
        fun start(context: Context, id: Long, imageView: ConstraintLayout, transitionName: String){
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(BaseConstant.DETAIL_SHOE_ID, id)
            intent.putExtra(CUS_TRANSITION_NAME, transitionName)
            if(context is Activity){
                context.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(context, imageView, transitionName).toBundle())
            }else {
                context.startActivity(intent)
            }
        }
    }

    private val detailModel: DetailModel by viewModels {
        CustomViewModelProvider.providerDetailModel(
            intent.getLongExtra(BaseConstant.DETAIL_SHOE_ID, 1L),
            AppPrefsUtils.getLong(BaseConstant.SP_USER_ID)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // 1. 设置动画
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())

        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<DetailActivityBinding>(this, R.layout.detail_activity)
        binding.model = detailModel
        initListener(binding, detailModel)

        // 2. 设置transitionName
        binding.mainContent.transitionName = intent.getStringExtra(CUS_TRANSITION_NAME)
        // 3. 设置具体的动画
        window.sharedElementEnterTransition = MaterialContainerTransform().apply {
            addTarget(binding.mainContent)
            duration = 300L
        }
        window.sharedElementExitTransition = MaterialContainerTransform().apply {
            addTarget(binding.mainContent)
            duration = 300L
        }
    }

    private fun initListener(binding: DetailActivityBinding, detailModel: DetailModel) {
        binding.lifecycleOwner = this

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }

        val transitionName = "${detailModel.shoe?.value?.id}${detailModel.shoe?.value?.imageUrl}"
        binding.ivShoe.transitionName = transitionName
        binding.ivShoe.setOnClickListener {
            detailModel.shoe?.value?.imageUrl?.let {
                val options = ActivityOptions.makeSceneTransitionAnimation(this, binding.ivShoe, transitionName)
                ImageGalleryActivity.start(this, it, options.toBundle(), transitionName)
            }
        }

        // 设置点击动画
        binding.fbFavourite.setOnClickListener {
            binding.fbFavourite.animate()
                .rotation(360.0f)
                .scaleX(0.0f)
                .scaleY(0.0f)
                .setListener(object : Animator.AnimatorListener {
                    override fun onAnimationRepeat(animation: Animator?) {

                    }

                    override fun onAnimationCancel(animation: Animator?) {
                    }

                    override fun onAnimationStart(animation: Animator?) {
                    }

                    override fun onAnimationEnd(animation: Animator?) {
                        detailModel.favourite()
                    }

                })
                .setDuration(200)
                .start()
        }
    }
}
