# Changelog

## [1.3.0] - 2022-05-05

### Changed

- `io.github.daemon369:annotation`升级为`1.0.0`

## [1.2.0] - 2022-04-29

### Changed

- 更新`android-version-catalog`到`1.2.0`，使用最新的依赖库及`Kotlin 1.6.21`

## [1.1.0] - 2021-12-27

### Changed

- 设置`InfrastructureApp`为默认`Application`

## [1.0.0] - 2021-12-24

### Added

- 增加顶层方法`minSdkVersion`、`compileSdkVersion`、`targetSdkVersion`及扩展方法`Context.minSdkVersion`、`Context.compileSdkVersion`、`Context.targetSdkVersion`

### Changed

- `compileSdkVersion`升级为`31`，`buildToolsVersion`升级为`31.0.0`

### Removed

- 移除顶层方法`versionCode`及扩展方法`Context.versionCode`

## [0.1.1] - 2021-09-08

### Changed

- 移除扩展方法`Context.longVersionCode`与顶层方法`longVersionCode`的API限制
- 废弃扩展方法`Context.versionCode`及顶层方法`versionCode`

## [0.1.0] - 2021-09-04

### Added

- 增加`InfrastructureApp`，用于简化工具基础库的使用
