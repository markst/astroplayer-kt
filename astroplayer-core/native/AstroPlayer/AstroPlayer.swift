import Combine
import Foundation
import AVFoundation

@objc public protocol AstroListener { }
@objc public protocol AstroMediaItem  { }
@objc public protocol EqualizerValues { }

@objc public enum RepeatMode: Int {
    case off
    case all
    case one
}

@objc public class iOSAstroPlayer : NSObject {
    let player = AVQueuePlayer(items: [])

    @objc var mediaItemCount: Int32 {
        Int32(player.items().count)
    }

    @objc var contentDuration: Int64 = 0
    @objc var currentEqualizerValues: EqualizerValues? = nil
    @objc var currentMediaItem: AstroMediaItem? = nil
    @objc var currentMediaItemIndex: Int32 = 0
    @objc var currentPosition: Int64 = 0

    @objc var isEqualizerEnabled: Bool = false
    @objc var isMuted: Bool = false
    @objc var isPaused: Bool = false
    @objc var isPlaying: Bool = false
    @objc var isSmartEqualizerEnabled: Bool = false

    @objc var volume: Float = 0.0

    @objc var playBackSpeed: Float = 0.0
    @objc var repeatMode: RepeatMode = .off

    @objc var seekBackIncrement: Int64 = 0
    @objc var seekForwardIncrement: Int64 = 0
    @objc var shuffleModeEnabled: Bool = false
    @objc var smartEqualizerPicker: ((String) -> EqualizerValues)?

    // MARK: -

    @objc public func prepare() {
        debugPrint(#function)
    }

    // MARK: -

    @objc public func play() {
        debugPrint(#function)
    }

    @objc public func pause() {
        debugPrint(#function)
    }

    @objc public func seekTo(milliseconds: Int64) {
        debugPrint(#function)
    }

    @objc public func seekToMediaItem(index: Int32) {
        debugPrint(#function)
    }

    // MARK: -

    @objc public func registerNativeListenerForAstro() {
        debugPrint(#function)
    }

    @objc public func deregisterNativeListenerForAstro() {
        debugPrint(#function)
    }

    // MARK: -

    @objc public func mute() {
        debugPrint(#function)
    }

    @objc public func unMute() {
        debugPrint(#function)
    }

    @objc public func increaseVolume() {
        debugPrint(#function)
    }

    @objc public func decreaseVolume() {
        debugPrint(#function)
    }

    @objc public func decreaseVolumeBy(offset: Float) {
        debugPrint(#function)
    }

    @objc public func increaseVolumeBy(offset: Float) {
        debugPrint(#function)
    }

    // MARK: -

    @objc public func addMediaItem(item: AstroMediaItem) {
        debugPrint(#function)
    }

    @objc public func addMediaItem(index: Int32, item: AstroMediaItem) {
        debugPrint(#function)
    }

    @objc public func addMediaItems(items: [AstroMediaItem]) {
        debugPrint(#function)
    }

    @objc public func addMediaItems(index: Int32, items: [AstroMediaItem]) {
        debugPrint(#function)
    }

    @objc public func allMediaItems() -> [AstroMediaItem] {
        debugPrint(#function)
        return []
    }

    @objc public func clearMediaItems() {
        debugPrint(#function)
    }

    @objc public func mapMediaItems(transform: @escaping (AstroMediaItem) -> Any?) -> [Any] {
        debugPrint(#function)
        return []
    }

    @objc public func moveMediaItem(currentIndex: Int32, newIndex: Int32) {
        debugPrint(#function)
    }

    @objc public func moveMediaItems(fromIndex: Int32, toIndex: Int32, newIndex: Int32) {
        debugPrint(#function)
    }

    @objc public func removeMediaItem(index: Int32) {
        debugPrint(#function)
    }

    @objc public func removeMediaItems(fromIndex: Int32, toIndex: Int32) {
        debugPrint(#function)
    }

    @objc public func replaceMediaItem(index: Int32, mediaItem: AstroMediaItem) {
        debugPrint(#function)
    }

    @objc public func replaceMediaItems(fromIndex: Int32, toIndex: Int32, mediaItems: [AstroMediaItem]) {
        debugPrint(#function)
    }
}
