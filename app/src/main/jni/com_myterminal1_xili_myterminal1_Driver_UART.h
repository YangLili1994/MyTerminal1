/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_myterminal1_xili_myterminal1_Driver_UART */

#ifndef _Included_com_myterminal1_xili_myterminal1_Driver_UART
#define _Included_com_myterminal1_xili_myterminal1_Driver_UART
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_myterminal1_xili_myterminal1_Driver_UART
 * Method:    Open
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_com_myterminal1_xili_myterminal1_Driver_UART_Open
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     com_myterminal1_xili_myterminal1_Driver_UART
 * Method:    Close
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_myterminal1_xili_myterminal1_Driver_UART_Close
  (JNIEnv *, jobject);

/*
 * Class:     com_myterminal1_xili_myterminal1_Driver_UART
 * Method:    Read
 * Signature: ()[I
 */
JNIEXPORT jintArray JNICALL Java_com_myterminal1_xili_myterminal1_Driver_UART_Read
  (JNIEnv *, jobject);

/*
 * Class:     com_myterminal1_xili_myterminal1_Driver_UART
 * Method:    Write
 * Signature: ([II)I
 */
JNIEXPORT jint JNICALL Java_com_myterminal1_xili_myterminal1_Driver_UART_Write
  (JNIEnv *, jobject, jintArray, jint);

#ifdef __cplusplus
}
#endif
#endif
