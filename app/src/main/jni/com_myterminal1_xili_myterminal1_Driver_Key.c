//
// Created by WangTao on 2016/5/4.
//

#include "com_myterminal1_xili_myterminal1_Driver_Key.h"
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <android/log.h>

#define LOG_TAG         "JNI_KEY"
#define KEY_0_NODE      "/sys/devices/platform/buttons_irq_wang/key0_onoff"
#define KEY_1_NODE      "/sys/devices/platform/buttons_irq_wang/key1_onoff"
#define KEY_2_NODE      "/sys/devices/platform/buttons_irq_wang/key2_onoff"
#define KEY_3_NODE      "/sys/devices/platform/buttons_irq_wang/key3_onoff"

/*
 * Class:     com_myterminal1_xili_myterminal1_Driver_Key
 * Method:    readKey0Status
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_myterminal1_xili_myterminal1_Driver_Key_readKey0Status
        (JNIEnv *env, jclass cls){
    int fd, ret;
    char buf[2];

    if((fd = open(KEY_0_NODE, O_RDONLY)) < 0){
        __android_log_print(ANDROID_LOG_INFO, LOG_TAG, "Fail to open KEY_0_NODE!\n");
        return -1;
    }

    //读取节点的当前值,0表示按下，1表示松开
    memset((void *)buf, 0x00, sizeof(buf));
    ssize_t count = read(fd, &buf, 1);
    if(count == 1) {
        buf[count] = '\0';
        ret = atoi(buf);
    } else
        buf[0] = '\0';
    close(fd);

//    __android_log_print(ANDROID_LOG_INFO, LOG_TAG, "%s ret=%d\n",__func__, ret);
    return ret;
}

/*
 * Class:     com_myterminal1_xili_myterminal1_Driver_Key
 * Method:    readKey1Status
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_myterminal1_xili_myterminal1_Driver_Key_readKey1Status
        (JNIEnv *env, jclass cls){
    int fd, ret;
    char buf[2];

    if((fd = open(KEY_1_NODE, O_RDONLY)) < 0){
        __android_log_print(ANDROID_LOG_INFO, LOG_TAG, "Fail to open KEY_0_NODE!\n");
        return -1;
    }

    //读取节点的当前值,0表示按下，1表示松开
    memset((void *)buf, 0x00, sizeof(buf));
    ssize_t count = read(fd, &buf, 1);
    if(count == 1) {
        buf[count] = '\0';
        ret = atoi(buf);
    } else
        buf[0] = '\0';
    close(fd);

//    __android_log_print(ANDROID_LOG_INFO, LOG_TAG, "%s ret=%d\n",__func__, ret);
    return ret;
}

/*
 * Class:     com_myterminal1_xili_myter
 * minal1_Driver_Key
 * Method:    readKey2Status
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_myterminal1_xili_myterminal1_Driver_Key_readKey2Status
        (JNIEnv *env, jclass cls){
    int fd, ret;
    char buf[2];

    if((fd = open(KEY_2_NODE, O_RDONLY)) < 0){
        __android_log_print(ANDROID_LOG_INFO, LOG_TAG, "Fail to open KEY_0_NODE!\n");
        return -1;
    }

    //读取节点的当前值,0表示按下，1表示松开
    memset((void *)buf, 0x00, sizeof(buf));
    ssize_t count = read(fd, &buf, 1);
    if(count == 1) {
        buf[count] = '\0';
        ret = atoi(buf);
    } else
        buf[0] = '\0';
    close(fd);

//    __android_log_print(ANDROID_LOG_INFO, LOG_TAG, "%s ret=%d\n",__func__, ret);
    return ret;
}

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
               (JNIEnv *env, jclass cls, jint status){
}

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