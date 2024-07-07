// swift-tools-version: 5.7
// The swift-tools-version declares the minimum version of Swift required to build this package.

import PackageDescription

let package = Package(
    name: "AstroPlayer",
    products: [
        .library(
            name: "AstroPlayer",
            targets: ["AstroPlayer"]
        )
    ],
    targets: [
        .target(
            name: "AstroPlayer",
            path: "./astroplayer-core/native/AstroPlayer"
        )
    ]
)
