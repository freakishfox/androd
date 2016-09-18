
#include "NativeUtil.h"

/*
 * Class:     com_freakishfox_xxq_NativeUtil_NativeUtil
 * Method:    add
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_com_freakishfox_xxq_NativeUtil_NativeUtil_add
  (JNIEnv * jniEnv, jobject nativeUtil, jint a, jint b){
    return a + b;
}