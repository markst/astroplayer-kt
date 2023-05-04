package com.deathsdoor.astroplayer

import com.deathsdoor.astroplayer.dataclasses.MediaItem
import com.deathsdoor.astroplayer.enums.RepeatMode
import com.deathsdoor.astroplayer.equalizer.Equalizer
import com.deathsdoor.astroplayer.equalizer.EqualizerValues
import com.deathsdoor.astroplayer.platfromCommonFunctions.currentMediaItem

@Suppress("UNUSED")
actual class AstroPlayer private actual constructor() {
    companion object {
        fun create() = AstroPlayer()
    }

    private val mediaPlayer : dynamic = js("new MediaElement('audio',{features: [],success: function (media, node, instance) {media.load();}})")
    internal actual val mediaItems: MutableList<MediaItem> = mutableListOf()
    /**
     * Playback
     * */
    actual fun play() = mediaPlayer.play()
    actual fun pause() = mediaPlayer.pause()
    actual fun stop() = mediaPlayer.stop()

    actual val isPlaying: Boolean get() = mediaPlayer.paused == false && mediaPlayer.ended == false
    actual val isPaused: Boolean get() = mediaPlayer.paused == true && mediaPlayer.ended == false

    actual var playBackSpeed: Float = 1f
        set(value){
            field = value
            mediaPlayer.playbackRate = field
        }

    /**
     * Volume
     * */
    actual var volume: Float = 1f
        set(value){
            if(value !in 0.0f..1.0f) throw IllegalArgumentException("Volume has to be between 0 and 1")
            field = value
            mediaPlayer.setVolume(value.toDouble())
        }
    internal actual var previousUnMutedVolume: Float = volume

    /**
     * Seeking
     * **/
    actual fun seekTo(milliseconds: Long) = mediaPlayer.setCurrentTime(milliseconds.toDouble() / 1000.0)

    actual fun seekToNextMediaItem(){
        if(_currentMediaItemIndex >= mediaItems.size - 1) return
        _currentMediaItemIndex++
        mediaPlayer.setSrc(currentMediaItem.mediaSource)
        mediaPlayer.load()
        this.play()
    }

    actual fun seekToPreviousMediaItem() {
        if(_currentMediaItemIndex <= 0) return
        _currentMediaItemIndex--
        mediaPlayer.setSrc(currentMediaItem.mediaSource)
        mediaPlayer.load()
        this.play()
    }

    /**
     *  MediaItem
     * **/
    private var _currentMediaItemIndex : Int = -1
    actual val currentMediaItemIndex: Int get() = _currentMediaItemIndex
    actual val currentMediaItemPosition: Long get() = (mediaPlayer.currentTime * 1000) as Long

    internal actual fun updatePlayerAfterClear() {
    }

    internal actual fun updatePlayerAfterAddMediaItem(){
        //TODO give actual implementation
        mediaPlayer.setSrc(mediaItems.first())
        mediaPlayer.load()
        this.play()
    }

    internal actual fun updatePlayerAfterAddMediaItem(
        index: Int,
        mediaItem: MediaItem
    ) {
    }

    internal actual fun updatePlayerAfterAddMediaItems(mediaItems: List<MediaItem>) {
    }

    internal actual fun updatePlayerAfterAddMediaItems(
        index: Int,
        mediaItems: List<MediaItem>
    ) {
    }

    internal actual fun updatePlayerAfterRemoveAt(index: Int) {
    }

    internal actual fun updatePlayerAfterRearrange(from: Int, to: Int) {
    }

    /**
     * Repeat Modes
     * */
    @ExperimentalMultiplatform
    internal actual var repeatedRange: Pair<Int, Int> get() = TODO("Not yet implemented") ;set(value) {}
    @ExperimentalMultiplatform
    actual var repeatMode: RepeatMode get() = TODO("Not yet implemented"); set(value) {}
    @ExperimentalMultiplatform
    actual val shuffleModeEnabled: Boolean get() = TODO("Not yet implemented")
    @ExperimentalMultiplatform
    actual fun repeatByGroup(startIndex: Int, endIndex: Int) {}

    /**
     * Equalizer
     * **/
    @ExperimentalMultiplatform
    actual var isEqualizerEnabled: Boolean = false
    @ExperimentalMultiplatform
    actual var isSmartEqualizerEnabled: Boolean = false
    @ExperimentalMultiplatform
    actual var currentEqualizerValues: EqualizerValues = Equalizer.Default

    /**
     * PlayBackListener
     * */
    @ExperimentalMultiplatform
    //TODO add it to mediaPlayer
    actual var mediaEventListener : MediaEventListener? = null
}