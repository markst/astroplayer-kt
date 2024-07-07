package com.deathsdoor.astroplayer.core

import com.deathsdoor.astroplayer.core.equalizer.EqualizerValues
import com.deathsdoor.astroplayer.core.listeners.AstroListener
import platform.AVFoundation.AVPlayer
import com.deathsdoor.astroplayerswift.*
import kotlinx.cinterop.ExperimentalForeignApi

/**
 * An class representing the underlying native media player implementation.
 **/
actual typealias NativeMediaPLayer = AVPlayer


// TODO : Implement IOS Media Player
@OptIn(ExperimentalForeignApi::class)
@Suppress("UNUSED")
actual open class AstroPlayer actual constructor(nativeMediaPlayer: NativeMediaPLayer) : iOSAstroPlayer() {
    /**
     * Releases the player resources. This should be called when the player is no longer needed.
     */
    actual open fun release() {
    }
}