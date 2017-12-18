package com.example.jim.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        private TextView mAScoreText, mBScoreText; //显示两队分数
        private Button mAAddThreeBtn, mAAddTwoBtn ; //A对加分按钮 mAAddOneBtn
        private Button mBAddThreeBtn, mBAddTwoBtn ; //B对加分按钮 mBAddOneBtn
        private Button mResetBtn;
        private int mAScore, mBScore; //记录两队的分数

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            initView();
        }

        /**
         * 初始化组件
         */
        private void initView() {
            mAScoreText = (TextView) findViewById(R.id.aScoreText);
            mBScoreText = (TextView) findViewById(R.id.bScoreText);
            mAAddThreeBtn = (Button) findViewById(R.id.aAddThreeBtn);
            mAAddTwoBtn = (Button) findViewById(R.id.aAddTwoBtn);
            //mAAddOneBtn = (Button) findViewById(R.id.aAddOneBtn);
            mBAddThreeBtn = (Button) findViewById(R.id.bAddThreeBtn);
            mBAddTwoBtn = (Button) findViewById(R.id.bAddTwoBtn);
            //mBAddOneBtn = (Button) findViewById(R.id.bAddOneBtn);
            mResetBtn = (Button) findViewById(R.id.resetBtn);

            mAAddThreeBtn.setOnClickListener(this);
            mAAddTwoBtn.setOnClickListener(this);
            //mAAddOneBtn.setOnClickListener(this);
            mBAddThreeBtn.setOnClickListener(this);
            mBAddTwoBtn.setOnClickListener(this);
            //mBAddOneBtn.setOnClickListener(this);
            mResetBtn.setOnClickListener(this);
        }

        /**
         * 实现按钮点击回调
         *
         * @param view
         */
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.aAddThreeBtn:
                    aAddScore(1);
                    break;
                case R.id.aAddTwoBtn:
                    aAddScore(-1);
                    break;
                //case R.id.aAddOneBtn:

                //    aAddScore(1);
                //    break;
                case R.id.bAddThreeBtn:
                    bAddScore(1);
                    break;
                case R.id.bAddTwoBtn:
                    bAddScore(-1);
                    break;
               // case R.id.bAddOneBtn:
               //     bAddScore(1);
               //     break;
                case R.id.resetBtn:
                    showResetDialog();
                    break;
            }
        }

        /**
         * A队加分
         *
         * @param score 要加的分数
         */
        private void aAddScore(int score) {
            mAScore = mAScore + score;
            displayAScore(mAScore);
        }

        /**
         * A队加分
         *
         * @param score 要加的分数
         */
        private void bAddScore(int score) {
            mBScore = mBScore + score;
            displayBScore(mBScore);
        }

        /**
         * 显示清空得分的弹框
         */
        private void showResetDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setTitle("提示")
                    .setMessage("確認要清除兩隊的得分嗎？")
                    .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            resetScore();  //确定清空
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            // ignore
                        }
                    });
            builder.show();
        }

        /**
         * 重置两队分数
         */
        private void resetScore() {
            mAScore = 0;
            mBScore = 0;
            displayAScore(mAScore);
            displayBScore(mBScore);
        }

        /**
         * 显示A队得分
         *
         * @param score 分数
         */
        private void displayAScore(int score) {
            mAScoreText.setText(String.valueOf(score));
        }

        /**
         * 显示B队得分
         *
         * @param score 分数
         */
        private void displayBScore(int score) {
            mBScoreText.setText(String.valueOf(score));
        }
    }

