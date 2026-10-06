package com.kuruhu.biometrics;

import java.util.List;

public interface BiometricService {
    Object enrollProfile(Object param);
    Object matchFace(Object param);
    Object matchFingerprint(Object param);
    Object matchVoice(Object param);
}
