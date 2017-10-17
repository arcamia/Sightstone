LOCAL_PATH := $(call my-dir)

#Build the library
include $(CLEAR_VARS)
LOCAL_MODULE_TAGS := optional
LOCAL_MODULE := com.sightstone.android.services
LOCAL_SRC_FILES := $(call all-subdir-java-files)
LOCAL_SRC_FILES += com/sightstone/android/services/ISightStone.aidl
LOCAL_STATIC_JAVA_LIBRARIES := android-common
#LOCAL_JAVA_LIBRARIES := core-sentinel
include $(BUILD_JAVA_LIBRARY)

#Build the documentation
include $(CLEAR_VARS)
LOCAL_SRC_FILES := $(call all-subdir-java-files) $(call all-subdir-html-files)
LOCAL_MODULE := com.sightstone.android.services_doc
LOCAL_DROIDDOC_OPTIONS := com.sightstone.android.services
LOCAL_MODULE_CLASS := JAVA_LIBRARIES
LOCAL_DROIDDOC_USE_STANDARD_DOCLET := true
include $(BUILD_DROIDDOC)
