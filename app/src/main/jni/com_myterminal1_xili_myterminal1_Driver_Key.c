//
// Created by WangTao on 2016/5/4.
//

#include "com_myterminal1_xili_myterminal1_Driver_Key.h"
#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/ioctl.h>
#include <android/log.h>
#include <android/log.h>

#define LOG_TAG "KEY"       //android logcat
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__    )
#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS_    _)

/*
 * Class:     com_myterminal1_xili_myterminal1_Driver_Key
 * Method:    readKey0Status
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_myterminal1_xili_myterminal1_Driver_Key_readKey0Status
        (JNIEnv *, jclass);

/*
 * Class:     com_myterminal1_xili_myterminal1_Driver_Key
 * Method:    readKey1Status
 * Signature: ()I
 */
               JNIEXPORT jint JNICALL Java_com_myterminal1_xili_myterminal1_Driver_Key_readKey1Status
        (JNIEnv *, jclass);

/*
 * Class:     com_myterminal1_xili_myterminal1_Driver_Key
 * Method:    readKey2Status
 * Signature: ()I
 */
               JNIEXPORT jint JNICALL Java_com_myterminal1_xili_myterminal1_Driver_Key_readKey2Status
        (JNIEnv *, jclass);

/*
 * Class:     com_myterminal1_xili_myterminal1_Driver_Key
 * Method:    readKey3Status
 * Signature: ()I
 */
               JNIEXPORT jint JNICALL Java_com_myterminal1_xili_myterminal1_Driver_Key_readKey3Status
        (JNIEnv *, jclass);

/*
 * Class:     com_myterminal1_xili_myterminal1_Driver_Key
 * Method:    setKey0Status
 * Signature: (I)V
 */
               JNIEXPORT void JNICALL Java_com_myterminal1_xili_myterminal1_Driver_Key_setKey0Status
               (JNIEnv *, jclass, jint);

/*
 * Class:     com_myterminal1_xili_myterminal1_Driver_Key
 * Method:    setKey1Status
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_myterminal1_xili_myterminal1_Driver_Key_setKey1Status
(JNIEnv *, jclass, jint);

/*
 * Class:     com_myterminal1_xili_myterminal1_Driver_Key
 * Method:    setKey2Status
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_myterminal1_xili_myterminal1_Driver_Key_setKey2Status
(JNIEnv *, jclass, jint);

/*
 * Class:     com_myterminal1_xili_myterminal1_Driver_Key
 * Method:    setKey3Status
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_myterminal1_xili_myterminal1_Driver_Key_setKey3Status
(JNIEnv *, jclass, jint);