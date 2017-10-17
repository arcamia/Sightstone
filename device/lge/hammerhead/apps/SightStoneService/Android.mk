LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE_TAGS := optional
LOCAL_SRC_FILES := $(call all-java-files-under,src)
LOCAL_REQUIRED_MODULES := com.sightstone.android.services
LOCAL_JAVA_LIBRARIES := com.sightstone.android.services
LOCAL_JAVA_LIBRARIES += framework
LOCAL_JAVA_LIBRARIES += core

LOCAL_PACKAGE_NAME := SightStoneService
LOCAL_PROGUARD_ENABLED := disabled
LOCAL_SDK_VERSION := current
LOCAL_CERTIFICATE := platform
include $(BUILD_PACKAGE)
