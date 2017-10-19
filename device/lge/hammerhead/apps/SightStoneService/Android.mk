LOCAL_PATH:= $(call my-dir)

#googleplay_dir := Library/playservice
#firebase_dir := Library/firebase

include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional
LOCAL_SRC_FILES := $(call all-java-files-under,src)
LOCAL_REQUIRED_MODULES := com.sightstone.android.services
LOCAL_JAVA_LIBRARIES := com.sightstone.android.services
LOCAL_JAVA_LIBRARIES += framework
LOCAL_JAVA_LIBRARIES += core
LOCAL_JAVA_LIBRARIES += ext
LOCAL_JAVA_LIBRARIES += android-common

#LOCAL_STATIC_JAVA_AAR_LIBRARIES := firebaseanalytics 
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += firebaseanalyticsimpl
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += firebaseauth
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += firebaseauthcommon
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += firebaseauthimpl 
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += firebaseauthmodule 
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += firebasecommon 
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += firebaseconfig
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += firebasecrash 
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += firebasedatabase
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += firebasedatabaseconnection
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += firebasedynamiclinks
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += firebaseiid
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += firebasemessaging
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += firebaseperf 
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += firebasestorage
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += firebasestoragecommon

#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicesanalytics
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicesanalyticsimpl
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicesappindexing
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicesappinvite
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicesappstate
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicesauth
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicesauthapiphone
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicesauthbase
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicesawareness
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicesbase
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicesbasement
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicesclearcut
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicescontextmanager
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicesdrive
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicesgass
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicesgcm
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicesidentity
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicesiid
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicesinstantapps
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playserviceslocation
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicesnearby
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicesosslicenses
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicesplaces
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicesplus
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicessafetynet
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicestagmanager
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicestagmanagerapi
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicestagmanagerv4impl
#LOCAL_STATIC_JAVA_AAR_LIBRARIES += playservicestasks

#LOCAL_AAPT_FLAGS := --auto-add-overlay
#LOCAL_AAPT_FLAGS += --extra-packages firebaseanalytics:firebaseanalyticsimpl:firebaseauth:firebaseauthcommon:firebaseauthimpl:firebaseauthmodule:firebasecommon:firebaseconfig:firebasecrash:firebasedatabase:firebasedatabaseconnection:firebasedynamiclinks:firebaseiid:firebasemessaging:firebaseperf:firebasestorage:firebasestoragecommon:playservicestasks:playservicestagmanagerv4impl:playservicestagmanagerapi:playservicestagmanager:playservicessafetynet:playservicesplus:playservicesplaces:playservicesosslicenses:playservicesnearby:playserviceslocation:playservicesinstantapps:playservicesiid:playservicesidentity:playservicesgcm:playservicesgass:playservicesdrive:playservicescontextmanager:playservicesclearcut:playservicesbasement:playservicesbase:playservicesawareness:playservicesauthbase:playservicesauthapiphone:playservicesauth:playservicesappstate:playservicesappinvite:playservicesappindexing:playservicesanalyticsimpl:playservicesanalytics

LOCAL_PACKAGE_NAME := SightStoneService
LOCAL_PROGUARD_ENABLED := disabled
LOCAL_SDK_VERSION := current
LOCAL_CERTIFICATE := platform
include $(BUILD_PACKAGE)

#include $(CLEAR_VARS)

#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES := firebaseanalytics:$(firebase_dir)/firebase-analytics-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += firebaseanalyticsimpl:$(firebase_dir)/firebase-analytics-impl-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += firebaseauth:$(firebase_dir)/firebase-auth-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += firebaseauthcommon:$(firebase_dir)/firebase-auth-common-9.8.0.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += firebaseauthimpl:$(firebase_dir)/firebase-auth-impl-11.0.0.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += firebaseauthmodule:$(firebase_dir)/firebase-auth-module-9.8.0.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += firebasecommon:$(firebase_dir)/firebase-common-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += firebaseconfig:$(firebase_dir)/firebase-config-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += firebasecrash:$(firebase_dir)/firebase-crash-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += firebasedatabase:$(firebase_dir)/firebase-database-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += firebasedatabaseconnection:$(firebase_dir)/firebase-database-connection-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += firebasedynamiclinks:$(firebase_dir)/firebase-dynamic-links-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += firebaseiid:$(firebase_dir)/firebase-iid-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += firebasemessaging:$(firebase_dir)/firebase-messaging-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += firebaseperf:$(firebase_dir)/firebase-perf-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += firebasestorage:$(firebase_dir)/firebase-storage-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += firebasestoragecommon:$(firebase_dir)/firebase-storage-common-11.0.4.aar

#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicesanalytics:$(googleplay_dir)/play-services-analytics-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicesanalyticsimpl:$(googleplay_dir)/play-services-analytics-impl-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicesappindexing:$(googleplay_dir)/play-services-appindexing-9.8.0.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicesappinvite:$(googleplay_dir)/play-services-appinvite-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicesappstate:$(googleplay_dir)/play-services-appstate-8.4.0.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicesauth:$(googleplay_dir)/play-services-auth-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicesauthapiphone:$(googleplay_dir)/play-services-auth-api-phone-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicesauthbase:$(googleplay_dir)/play-services-auth-base-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicesawareness:$(googleplay_dir)/play-services-awareness-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicesbase:$(googleplay_dir)/play-services-base-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicesbasement:$(googleplay_dir)/play-services-basement-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicesclearcut:$(googleplay_dir)/play-services-clearcut-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicescontextmanager:$(googleplay_dir)/play-services-contextmanager-9.4.0.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicesdrive:$(googleplay_dir)/play-services-drive-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicesgass:$(googleplay_dir)/play-services-gass-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicesgcm:$(googleplay_dir)/play-services-gcm-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicesidentity:$(googleplay_dir)/play-services-identity-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicesiid:$(googleplay_dir)/play-services-iid-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicesinstantapps:$(googleplay_dir)/play-services-instantapps-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playserviceslocation:$(googleplay_dir)/play-services-location-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicesnearby:$(googleplay_dir)/play-services-nearby-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicesosslicenses:$(googleplay_dir)/play-services-oss-licenses-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicesplaces:$(googleplay_dir)/play-services-places-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicesplus:$(googleplay_dir)/play-services-plus-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicessafetynet:$(googleplay_dir)/play-services-safetynet-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicestagmanager:$(googleplay_dir)/play-services-tagmanager-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicestagmanagerapi:$(googleplay_dir)/play-services-tagmanager-api-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicestagmanagerv4impl:$(googleplay_dir)/play-services-tagmanager-v4-impl-11.0.4.aar
#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES += playservicestasks:$(googleplay_dir)/play-services-tasks-11.0.4.aar

#include $(BUILD_MULTI_PREBUILT)
